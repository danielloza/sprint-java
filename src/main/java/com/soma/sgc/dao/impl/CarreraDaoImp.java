/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.dao.impl;

import com.soma.sgc.dao.CarreraDao;
import com.soma.sgc.dao.HibernateDao;
import com.soma.sgc.model.Carrera;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DANIEL
 */
@Repository("carreraDao")
public class CarreraDaoImp extends HibernateDao<Integer, Carrera> implements CarreraDao {

    @Override
    public List<Carrera> showCarrera() {
        Criteria criteria = creaCriteria();
        //indicar que no traiga datos repetidos
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        //lista los roles sin repetir algun dato
        List<Carrera> lCarrera = criteria.list();
        return lCarrera;
    }

    @Override
    public Carrera buscarNombre(int carreraid) {
        Criteria criteria = creaCriteria();

        criteria.add(Restrictions.eq("carreraid", carreraid));

        System.out.println(RolDaoImpl.class + "\nBuscando Carrera por idcarrera: " + carreraid);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (Carrera) criteria.uniqueResult();
    }
}
