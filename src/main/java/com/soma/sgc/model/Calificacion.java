/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soma.sgc.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "calificacion")
public class Calificacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer calificacionid;
     
    @Column(name = "calif1")
    private Double calif1;
    
    @Column(name = "calif2")
    private Double calif2;
    
    @Column(name = "calif3")
    private Double calif3;
    
    @Column(name = "calif4")
    private Double calif4;
    
     @Column(name = "califfinal")
    private Double califfinal;
    
   @Column(name = "anio")
    private Date anio;
   
    //Establece relacion con RolUsuario
    @ManyToOne
    @ForeignKey(name = "periodo_fk")
    private Periodo periodo;
    
     //Establece relacion con RolUsuario
    @ManyToOne
    @ForeignKey(name = "materia_fk")
    private Materia materia;
    
     //Establece relacion con RolUsuario
    @ManyToOne
    @ForeignKey(name = "alumno_fk")
    private Alumno alumno;

    public Integer getCalificacionid() {
        return calificacionid;
    }

    public void setCalificacionid(Integer calificacionid) {
        this.calificacionid = calificacionid;
    }

    public Double getCalif1() {
        return calif1;
    }

    public void setCalif1(Double calif1) {
        this.calif1 = calif1;
    }

    public Double getCalif2() {
        return calif2;
    }

    public void setCalif2(Double calif2) {
        this.calif2 = calif2;
    }

    public Double getCalif3() {
        return calif3;
    }

    public void setCalif3(Double calif3) {
        this.calif3 = calif3;
    }

    public Double getCalif4() {
        return calif4;
    }

    public void setCalif4(Double calif4) {
        this.calif4 = calif4;
    }

    public Double getCaliffinal() {
        return califfinal;
    }

    public void setCaliffinal(Double califfinal) {
        this.califfinal = califfinal;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "calificacionid=" + calificacionid + ", calif1=" + calif1 + ", calif2=" + calif2 + ", calif3=" + calif3 + ", calif4=" + calif4 + ", califfinal=" + califfinal + ", anio=" + anio + ", periodo=" + periodo + ", materia=" + materia + ", alumno=" + alumno + '}';
    }
    
   
}
