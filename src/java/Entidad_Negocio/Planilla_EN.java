/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

import java.util.Date;
import java.util.logging.Logger;

/**
CREATE TABLE "Planilla"
(

   "Id_Planilla" serial NOT NULL,
  "Cod_Planilla" bigint,
  "Estado_Plan" character varying(30),
  "Estancia" integer,
  "Periodo" integer,
  "Compania" bigint,
  "Fecha_Reg" date,
  "Secos" numeric(10,2),
  "Frescos" numeric(10,2),
  "Tipo_Modalidad" integer,
  "Unidad" bigint,
  "Sl_Abas" integer,
  "Dias_Abas" integer,
  "Val_Estancia" numeric(10,2),
  "Sl_Rac" integer,
  "Dias_Rac" integer,
  * 
 */
public class Planilla_EN{
    
    public long Id_Planilla;
    public long Cod_Planilla;
    public Integer Tipo_Modalidad;
    public String Estado_Plan;
    public Integer  Estancia;
    public Integer  Periodo;
    public long  Compania;
    public String Fecha_Reg;
    public Number Secos;
    public Number Frescos;
    public Integer Unidad;
    public Integer Sl_Abas;
    public Integer Dias_Abas;
    public Number Val_Estancia;
    public Integer Sl_Rac;
    public Integer Dias_Rac;

    public void setSl_Abas(Integer Sl_Abas) {
        this.Sl_Abas = Sl_Abas;
    }

    public void setDias_Abas(Integer Dias_Abas) {
        this.Dias_Abas = Dias_Abas;
    }

    public void setVal_Estancia(Number Val_Estancia) {
        this.Val_Estancia = Val_Estancia;
    }

    public void setSl_Rac(Integer Sl_Rac) {
        this.Sl_Rac = Sl_Rac;
    }

    public void setDias_Rac(Integer Dias_Rac) {
        this.Dias_Rac = Dias_Rac;
    }

    public Integer getSl_Abas() {
        return Sl_Abas;
    }

    public Integer getDias_Abas() {
        return Dias_Abas;
    }

    public Number getVal_Estancia() {
        return Val_Estancia;
    }

    public Integer getSl_Rac() {
        return Sl_Rac;
    }

    public Integer getDias_Rac() {
        return Dias_Rac;
    }

    public Planilla_EN(long Id_Planilla, long Cod_Planilla, Integer Tipo_Modalidad, String Estado_Plan, Integer Estancia, Integer Periodo, long Compania, String Fecha_Reg, Number Secos, Number Frescos, Integer Unidad, Integer Sl_Abas, Integer Dias_Abas, Number Val_Estancia, Integer Sl_Rac, Integer Dias_Rac) {
        this.Id_Planilla = Id_Planilla;
        this.Cod_Planilla = Cod_Planilla;
        this.Tipo_Modalidad = Tipo_Modalidad;
        this.Estado_Plan = Estado_Plan;
        this.Estancia = Estancia;
        this.Periodo = Periodo;
        this.Compania = Compania;
        this.Fecha_Reg = Fecha_Reg;
        this.Secos = Secos;
        this.Frescos = Frescos;
        this.Unidad = Unidad;
        this.Sl_Abas = Sl_Abas;
        this.Dias_Abas = Dias_Abas;
        this.Val_Estancia = Val_Estancia;
        this.Sl_Rac = Sl_Rac;
        this.Dias_Rac = Dias_Rac;
    }

    
    

  

    public void setUnidad(Integer Unidad) {
        this.Unidad = Unidad;
    }

    public Integer getUnidad() {
        return Unidad;
    }

    public void setId_Planilla(long Id_Planilla) {
        this.Id_Planilla = Id_Planilla;
    }

    public void setCod_Planilla(long Cod_Planilla) {
        this.Cod_Planilla = Cod_Planilla;
    }

    public void setEstado_Plan(String Estado_Plan) {
        this.Estado_Plan = Estado_Plan;
    }

    public void setEstancia(Integer Estancia) {
        this.Estancia = Estancia;
    }

    public void setPeriodo(Integer Periodo) {
        this.Periodo = Periodo;
    }

    public void setCompania(long Compania) {
        this.Compania = Compania;
    }

    public void setFecha_Reg(String Fecha_Reg) {
        this.Fecha_Reg = Fecha_Reg;
    }

    public void setSecos(Number Secos) {
        this.Secos = Secos;
    }

    public void setFrescos(Number Frescos) {
        this.Frescos = Frescos;
    }

    public long getId_Planilla() {
        return Id_Planilla;
    }

    public long getCod_Planilla() {
        return Cod_Planilla;
    }

    public Integer getTipo_Modalidad() {
        return Tipo_Modalidad;
    }

    public String getEstado_Plan() {
        return Estado_Plan;
    }

    public Integer getEstancia() {
        return Estancia;
    }

    public Integer getPeriodo() {
        return Periodo;
    }

    public long getCompania() {
        return Compania;
    }

    public String getFecha_Reg() {
        return Fecha_Reg;
    }

    public Number getSecos() {
        return Secos;
    }

    public Number getFrescos() {
        return Frescos;
    }

    public void setTipo_Modalidad(Integer Tipo_Modalidad) {
        this.Tipo_Modalidad = Tipo_Modalidad;
    }

    
   
    public Planilla_EN() {
        
        
    }
    
    
    
     
      
    
    
    
    
    
    
    
    
    
}
