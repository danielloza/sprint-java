/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.service.impl;

import com.soma.sgc.dao.CarreraDao;
import com.soma.sgc.model.Carrera;
import com.soma.sgc.service.CarreraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DANIEL
 */
@Service("carreraService")
@Transactional
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    CarreraDao carreraDao;

    @Override
    public List<Carrera> showCarrera() {
        return carreraDao.showCarrera();
    }

    @Override
    public Carrera buscarNombre(int carreraid) {
        return carreraDao.buscarNombre(carreraid);
    }

}
