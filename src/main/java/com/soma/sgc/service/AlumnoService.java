/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.service;
import com.soma.sgc.model.Alumno;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface AlumnoService {
      List<Alumno> showAlumno();
    Alumno buscarNombre(int alumnoid);
    
}
