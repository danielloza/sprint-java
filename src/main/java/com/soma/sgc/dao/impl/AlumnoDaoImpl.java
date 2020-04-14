/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.dao.impl;

import com.soma.sgc.dao.HibernateDao;
import com.soma.sgc.dao.AlumnoDao;
import com.soma.sgc.model.Alumno;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DANIEL
 */
@Repository("alumnoDao")
public class AlumnoDaoImpl extends HibernateDao<Integer, Alumno> implements AlumnoDao {

    @Override
    public List<Alumno> showAlumno() {
        Criteria criteria = creaCriteria();
        //indicar que no traiga datos repetidos
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        //lista los roles sin repetir algun dato
        List<Alumno> lAlum = criteria.list();
        return lAlum;
    }

    @Override
    public Alumno buscarNombre(int alumnoid) {
        Criteria criteria = creaCriteria();

        criteria.add(Restrictions.eq("alumnoid", alumnoid));

        System.out.println(AlumnoDaoImpl.class + "\nBuscando Usuario por alumnoid: " + alumnoid);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (Alumno) criteria.uniqueResult();

    }
}
