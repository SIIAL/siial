/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

import java.util.Date;

/**
CREATE TABLE "Consolidado"
(
  "Id_Consolidado" serial NOT NULL,
  "fecha_Cons" date,
  "Unidad" bigint,
  "Cant_Sold" integer,
  "Cant_Dias" integer,
  "Val_Estancia" numeric(10,2),
  "Val_Total" numeric(10,2),
  "Val_Racion" numeric(10,2),
 */
public class Consolidado_EN {
    
   public  Integer Id_Consolidado;
   public  String  fecha_Cons;
   public  Long Unidad;
   public  Integer Cant_Sold;
   public  Integer Cant_Dias;
   public  Number Val_Estancia;
   public  Number Val_Total;
   public  Number Val_Racion;
   public  String  Estado_Cons;

    public void setEstado_Cons(String Estado_Cons) {
        this.Estado_Cons = Estado_Cons;
    }

    public String getEstado_Cons() {
        return Estado_Cons;
    }
   
   

    public void setId_Consolidado(Integer Id_Consolidado) {
        this.Id_Consolidado = Id_Consolidado;
    }

    public void setFecha_Cons(String fecha_Cons) {
        this.fecha_Cons = fecha_Cons;
    }

    public void setUnidad(Long Unidad) {
        this.Unidad = Unidad;
    }

    public void setCant_Sold(Integer Cant_Sold) {
        this.Cant_Sold = Cant_Sold;
    }

    public void setCant_Dias(Integer Cant_Dias) {
        this.Cant_Dias = Cant_Dias;
    }

    public void setVal_Estancia(Number Val_Estancia) {
        this.Val_Estancia = Val_Estancia;
    }

    public void setVal_Total(Number Val_Total) {
        this.Val_Total = Val_Total;
    }

    public void setVal_Racion(Number Val_Racion) {
        this.Val_Racion = Val_Racion;
    }

    public Integer getId_Consolidado() {
        return Id_Consolidado;
    }

    public String getFecha_Cons() {
        return fecha_Cons;
    }

    public Long getUnidad() {
        return Unidad;
    }

    public Integer getCant_Sold() {
        return Cant_Sold;
    }

    public Integer getCant_Dias() {
        return Cant_Dias;
    }

    public Number getVal_Estancia() {
        return Val_Estancia;
    }

    public Number getVal_Total() {
        return Val_Total;
    }

    public Number getVal_Racion() {
        return Val_Racion;
    }

    public Consolidado_EN() {
    }

 
    
    
}
