/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.controller;

import com.soma.sgc.model.Materia;
import com.soma.sgc.model.Carrera;


import com.soma.sgc.service.CarreraService;
import com.soma.sgc.service.MateriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DANIEL
 */
@Controller
@RequestMapping("/")
public class ControllerMateria {

    @Autowired
    MateriaService materiaService;

    @Autowired
    CarreraService carreraService;

    @RequestMapping(value = {"/materia"}, method = RequestMethod.GET)
    public String materia(ModelMap model) {
        model.addAttribute("user", usuarioEnSesion());
        if (!estaUsuarioAnonimo()) {
            List<Carrera> lcarrera = carreraService.showCarrera();
           
            // enviar los datos JSP
            model.addAttribute("lcarrera", lcarrera);
              List<Materia> lmateria = materiaService.showMateria();
           
            // enviar los datos JSP
            model.addAttribute("lmateria", lmateria);
            
            

            return "materia";
        }
        return "login";
    }

    public String usuarioEnSesion() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nicknamePrincipal = null;
        String pass = null;

        if (principal instanceof UserDetails) {
            //Es igual al usuario que esta en sesion
            return nicknamePrincipal = ((UserDetails) principal).getUsername();
        } else {
            //Es igual a usuario anonimo
            return nicknamePrincipal = principal.toString();
        }
    }

    /**
     * Este metodo verificara que un usuario este autenticado correctamente
     */
    private boolean estaUsuarioAnonimo() {
        final Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
        AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
        return authenticationTrustResolver.isAnonymous(autenticacion);
    }
    
    /**
     * Metodo para Agregar Usuarios
     *
     * @param datos
     * @return usuario
     */
    @RequestMapping(value = "/materia/agregarMateria", method = RequestMethod.POST)
    public @ResponseBody
    String agregarUsuario(@RequestParam(value = "datos[]") String datos[]) {
        if (!estaUsuarioAnonimo()) {
            for (String dato : datos) {
                if (dato.equals("")) {
                    // si hay datos vacios
                    return "errorDato";
                }
            }
            
            Carrera lCarrera = carreraService.buscarNombre(Integer.parseInt(datos[2]));
         
            // creacion de objeto usuario
            Materia materia = new Materia();
            materia.setMaterianame(datos[0]);
            materia.setCuatrimestre(datos[1]);
            materia.setCarrera(lCarrera);
           
        
            if (materiaService.save(materia)) {
                return "exito";
            } else {
                return "error";
            }
        }
        return "errorAcceso";
    }
    
    
    
    //Metodo para eliminar un Usuario no puede ser eliminado por las acciones
    @RequestMapping(value = "/materia/eliminarMateria", method = RequestMethod.POST)
    public @ResponseBody
    String eliminarUsuario(@RequestParam(value = "datos[]") String datos[]) {
        if (!estaUsuarioAnonimo()) {
            for (String dato : datos) {
                if (dato.equals("")) {
                    // si hay datos vacios
                    return "errorDato";
                }
            }//termina de recorrer el arreglo

           
            List<Materia> lmateria = materiaService.showMateria();

            if (!lmateria.isEmpty()) {
                for (Materia materia : lmateria) {
                    //obtiene el id del delitoa a eliminar
                    int Id = Integer.parseInt(datos[0]);
                    if (materia.getMateriaid()== Integer.parseInt(datos[0])) {
//                        usuario.setNickname(datos[0]);
//                        usuario.setPass(datos[1]);
//                        usuario.setCorreoelectronico(datos[2]);
//                        RolUsuario lRolUsuario = rolService.buscarNombre(Integer.parseInt(datos[3]));
//                        usuario.setRol(lRolUsuario);

                        if (materiaService.delete(Id)) {

                            //bitacoraUsuarioDaoAux.bitacoraUsuario("Eliminar ", usuarioEnSesion(), estaUsuarioAnonimo());
                            return "exito";
                        } else {
                            return "error";
                        }
                    }
                }//end for|
            }//si no esta vacia la lista de delitos

        }//el usuario es anonimo

        return "errorAcceso";

    }
    
    
     //Metodo para actualizar Usuario

    @RequestMapping(value = "/materia/actualizarMateria", method = RequestMethod.POST)
    public @ResponseBody
    String actualizarUsuario(@RequestParam(value = "datos[]") String datos[]) {
        if (!estaUsuarioAnonimo()) {
            for (String dato : datos) {
                if (dato.equals("")) {
                    // si hay datos vacios
                    return "errorDato";
                }
            }//termina de recorrer el arreglo

            List<Materia> lMateria = materiaService.showMateria();
            if (!lMateria.isEmpty()) {
                for (Materia materia : lMateria) {
                    if (materia.getMateriaid()== Integer.parseInt(datos[3])) {
                        materia.setMaterianame(datos[0]);
                        materia.setCuatrimestre(datos[1]);
                        Carrera lCarrera = carreraService.buscarNombre(Integer.parseInt(datos[2]));
                        materia.setCarrera(lCarrera);

                        if (materiaService.update(materia)) {
                          //bitacoraUsuarioDaoAux.bitacoraUsuario("Modificar Usuario", usuarioEnSesion(), estaUsuarioAnonimo());
                            return "exito";
                        } else {
                            return "error";
                        }
                    }
                }//end for
            }//si no esta vacia la lista 
        }//el usuario es anonimo

        return "errorAcceso";

    }

}
