/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.dao.impl;


import com.soma.sgc.dao.HibernateDao;
import com.soma.sgc.dao.MateriaDao;
import com.soma.sgc.model.Materia;
import com.soma.sgc.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DANIEL
 */
@Repository("materiaDao")
public class MateriaDaoImpl  extends HibernateDao<Integer, Materia> implements MateriaDao{

    @Override
    public void save(Materia Materia) {
        guardar(Materia);
    }

    @Override
    public void update(Materia materia) {
        actualizar(materia);
    }

    @Override
    public void delete(int materiaid) {
        System.out.println("Entra");
        Criteria crit = creaCriteria();
        crit.add(Restrictions.eq("materiaid", materiaid));
        Materia materia = (Materia) crit.uniqueResult();
        eliminar(materia);
        System.out.print(UsuarioDaoImpl.class + "Se ha eliminado correctamente el banco" + materiaid);
    }

    @Override
    public List<Materia> showMateria() {
        Criteria criteria = creaCriteria();
        //indicar que no traiga datos repetidos
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        //lista los roles sin repetir algun dato
        List<Materia> lmateria = criteria.list();
        return lmateria;
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
