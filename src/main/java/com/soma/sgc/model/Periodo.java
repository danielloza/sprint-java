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

/**
 *
 * @author DANIEL
 */
@Entity
@Table(name = "periodo")
public class Periodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periodoid")
    private Integer periodoid;

    @Column(name = "nombre")
    private String nombre;

    public Integer getPeriodoid() {
        return periodoid;
    }

    public void setPeriodoid(Integer periodoid) {
        this.periodoid = periodoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Periodo{" + "periodoid=" + periodoid + ", nombre=" + nombre + '}';
    }

   
}
