/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.service.impl;
import com.soma.sgc.dao.AlumnoDao;
import com.soma.sgc.model.Alumno;
import com.soma.sgc.service.AlumnoService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;


@Service("alumnoService")
@Transactional
public class AlumnoServiceImpl  implements AlumnoService{
    
    @Autowired
    AlumnoDao alumnoDao;

    @Override
    public List<Alumno> showAlumno() {
       return alumnoDao.showAlumno();
    }

    @Override
    public Alumno buscarNombre(int alumnoid) {
       return alumnoDao.buscarNombre(alumnoid);
    }
    
}
