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
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author DANIEL
 */

@Entity
@Table(name = "cuatrimestre")
public class Cuatrimestre implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuatrimestreid;

    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    public Integer getCuatrimestreid() {
        return cuatrimestreid;
    }

    public void setCuatrimestreid(Integer cuatrimestreid) {
        this.cuatrimestreid = cuatrimestreid;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cuatrimestre{" + "cuatrimestreid=" + cuatrimestreid + ", nombre=" + nombre + '}';
    }
    
}
