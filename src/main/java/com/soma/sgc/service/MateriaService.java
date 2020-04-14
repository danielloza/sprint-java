/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.service;

import com.soma.sgc.model.Materia;
import com.soma.sgc.model.Usuario;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface MateriaService {

    boolean save(Materia materia);

    boolean update(Materia materia);

    boolean delete(int materiaid);

    List<Materia> showMateria();

    Materia busquedaId(int materiaid);

    Materia busquedaMaterianame(String materianame);
}
