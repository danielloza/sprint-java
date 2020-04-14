/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.service.impl;

import com.soma.sgc.dao.MateriaDao;
import com.soma.sgc.model.Materia;

import com.soma.sgc.service.MateriaService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("materiaService")
@Transactional
public class MateriaServiceImpl implements MateriaService{
    
     private boolean estadoMetodo = false;
    @Autowired
    MateriaDao materiaDao;

    @Override
    public boolean save(Materia materia) {
      materiaDao.save(materia);
      return estadoMetodo = true;
    }

    @Override
    public boolean update(Materia materia) {
        materiaDao.update(materia);
        return estadoMetodo = true;
    }

    @Override
    public boolean delete(int materiaid) {
        materiaDao.delete(materiaid);
        return estadoMetodo = true;
    }

    @Override
    public List<Materia> showMateria() {
       return materiaDao.showMateria();
    }

    @Override
    public Materia busquedaId(int materiaid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Materia busquedaMaterianame(String materianame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
