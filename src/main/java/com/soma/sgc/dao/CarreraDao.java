/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.dao;

import com.soma.sgc.model.Carrera;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public interface CarreraDao {
    List<Carrera> showCarrera();
    Carrera buscarNombre(int carreraid);
}
