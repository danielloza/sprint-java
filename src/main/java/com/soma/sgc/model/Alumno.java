/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "alumno")

/**
 *
 * @author DANIEL
 */
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumnoid")
    private Integer alumnoid;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "app")
    private String app;

    @Column(name = "apm")
    private String apm;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "fechaNac")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;

    @Column(name = "prom1")
    private Double prom1;

    @Column(name = "prom2")
    private Double prom2;

    @Column(name = "prom3")
    private Double prom3;

    @Column(name = "prom4")
    private Double prom4;

    @Column(name = "prom5")
    private Double prom5;
    
    //Establece relacion con GrupoAlumno
    @ManyToOne
    @ForeignKey(name = "grupo_fk")
    private GrupoAlumno grupoAlumno;

    //Establece relacion con GrupoAlumno
    @ManyToOne
    @ForeignKey(name = "carrera_fk")
    private Carrera carrera;

    //Establece relacion con RolUsuario
    @ManyToOne
    @ForeignKey(name = "materiad_fk")
    private Materia materia;

    //Establece relacion con RolUsuario
    @ManyToOne
    @ForeignKey(name = "cuatrimestreid_fk")
    private Cuatrimestre cuatrimestre;

    public Integer getAlumnoid() {
        return alumnoid;
    }

    public void setAlumnoid(Integer alumnoid) {
        this.alumnoid = alumnoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Double getProm1() {
        return prom1;
    }

    public void setProm1(Double prom1) {
        this.prom1 = prom1;
    }

    public Double getProm2() {
        return prom2;
    }

    public void setProm2(Double prom2) {
        this.prom2 = prom2;
    }

    public Double getProm3() {
        return prom3;
    }

    public void setProm3(Double prom3) {
        this.prom3 = prom3;
    }

    public Double getProm4() {
        return prom4;
    }

    public void setProm4(Double prom4) {
        this.prom4 = prom4;
    }

    public Double getProm5() {
        return prom5;
    }

    public void setProm5(Double prom5) {
        this.prom5 = prom5;
    }

    public GrupoAlumno getGrupoAlumno() {
        return grupoAlumno;
    }

    public void setGrupoAlumno(GrupoAlumno grupoAlumno) {
        this.grupoAlumno = grupoAlumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Cuatrimestre getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Cuatrimestre cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "alumnoid=" + alumnoid + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", sexo=" + sexo + ", fechaNac=" + fechaNac + ", prom1=" + prom1 + ", prom2=" + prom2 + ", prom3=" + prom3 + ", prom4=" + prom4 + ", prom5=" + prom5 + ", grupoAlumno=" + grupoAlumno + ", carrera=" + carrera + ", materia=" + materia + ", cuatrimestre=" + cuatrimestre + '}';
    }

   
  
}
