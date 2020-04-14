/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author DANIEL
 */

@Entity
@Table(name = "materia")
public class Materia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "materiaid")
    private Integer materiaid;
    
    @Column(name = "materianame")
    private String materianame;
    
    @Column(name = "cuatrimestre")
    private String cuatrimestre;
    
 
    //Establece relacion con RolUsuario
    @ManyToOne
    @ForeignKey(name = "carreraid_fk")
    private Carrera carrera;
    
  
    
    public Integer getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(Integer materiaid) {
        this.materiaid = materiaid;
    }

    public String getMaterianame() {
        return materianame;
    }

    public void setMaterianame(String materianame) {
        this.materianame = materianame;
    }


    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    @Override
    public String toString() {
        return "Materia{" + "materiaid=" + materiaid + ", materianame=" + materianame + ", cuatrimestre=" + cuatrimestre + ", carrera=" + carrera + '}';
    }

   
}
