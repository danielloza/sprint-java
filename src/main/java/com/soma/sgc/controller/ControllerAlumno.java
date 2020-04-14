/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.controller;

import java.net.UnknownHostException;

import com.soma.sgc.model.Alumno;
import com.soma.sgc.model.Usuario;

import com.soma.sgc.service.AlumnoService;
import com.soma.sgc.service.UsuarioService;
import java.net.InetAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * /**
 *
 * @author DANIEL
 */
@Controller
@RequestMapping("/")
public class ControllerAlumno {

    @Autowired
    AlumnoService alumnoService;
    
     @Autowired
    UsuarioService usuarioService;
    
   
    @RequestMapping(value = {"/alumno"}, method = RequestMethod.GET)
    public String usuario(ModelMap model) {
        model.addAttribute("user", usuarioEnSesion());
        if (!estaUsuarioAnonimo()) {
            List<Alumno> lalumno = alumnoService.showAlumno();
            // enviar los datos JSP
            model.addAttribute("lalumno", lalumno);
            Usuario lusuarioS = usuarioService.busquedaNinckname(usuarioEnSesion());
            model.addAttribute("lusuarioS", lusuarioS);

            return "alumno";
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

}
