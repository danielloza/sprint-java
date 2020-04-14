/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.dao;

import com.soma.sgc.model.Materia;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface MateriaDao {
    void save(Materia Materia);
    void update(Materia materia);
    void delete(int materiaid);

    List<Materia> showMateria();
    Materia busquedaId(int materiaid);
    Materia busquedaMaterianame(String materianame);
}
