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
@Table(name = "grupo")
public class GrupoAlumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grupoid;

    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    public Integer getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(Integer grupoid) {
        this.grupoid = grupoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "GrupoAlumno{" + "grupoid=" + grupoid + ", nombre=" + nombre + '}';
    }
    
}
