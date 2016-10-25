/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

import java.util.Date;

/**

CREATE TABLE "Ciclo"
(
  "Id_Ciclo" integer NOT NULL,
  "Fech_Inicio" date,
  "Fech_Fin" date,
  "Numb_Dias" integer,
  "Tipo_Ciclo" character varying(20),
  "Planilla" bigint,
  CONSTRAINT "Pk_Id_Cilco" PRIMARY KEY ("Id_Ciclo"),
  CONSTRAINT "fk_Planilla" FOREIGN KEY ("Planilla")
      REFERENCES "Planilla" ("Id_Planilla") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

 */
public class Ciclo_EN {
   
  public   Integer Id_Ciclo ;
  public   String Fech_Inicio ;
  public   String Fech_Fin ;
  public   Integer Numb_Dias ;
  public   String Tipo_Ciclo ;
  public   Integer Planilla;

    public Ciclo_EN() {
    }

    public void setId_Ciclo(Integer Id_Ciclo) {
        this.Id_Ciclo = Id_Ciclo;
    }

    public void setFech_Inicio(String Fech_Inicio) {
        this.Fech_Inicio = Fech_Inicio;
    }

    public void setFech_Fin(String Fech_Fin) {
        this.Fech_Fin = Fech_Fin;
    }

    public void setNumb_Dias(Integer Numb_Dias) {
        this.Numb_Dias = Numb_Dias;
    }

    public void setTipo_Ciclo(String Tipo_Ciclo) {
        this.Tipo_Ciclo = Tipo_Ciclo;
    }

    public void setPlanilla(Integer Planilla) {
        this.Planilla = Planilla;
    }

    public Integer getId_Ciclo() {
        return Id_Ciclo;
    }

    public String getFech_Inicio() {
        return Fech_Inicio;
    }

    public String getFech_Fin() {
        return Fech_Fin;
    }

    public Integer getNumb_Dias() {
        return Numb_Dias;
    }

    public String getTipo_Ciclo() {
        return Tipo_Ciclo;
    }

    public Integer getPlanilla() {
        return Planilla;
    }
  
  
    
    
    
    
}
