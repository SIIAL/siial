/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

/**
CREATE TABLE "Periodo"
(
  "Id_Periodo" serial NOT NULL,
  "Mes" integer,
  "Anio" integer,
  "Estado_Periodo" boolean,
  CONSTRAINT "Pk_Id_Periodo" PRIMARY KEY ("Id_Periodo")
)
 */
public class Periodo_EN {

  
    
 public long Id_Periodo;

 
 public String   Mes;
 public int Anio;
 public Boolean Estado_Periodo;
 
    public Periodo_EN() {
    }  

    public Periodo_EN(long Id_Periodo, String Mes, int Anio, Boolean Estado_Periodo) {
        this.Id_Periodo = Id_Periodo;
        this.Mes = Mes;
        this.Anio = Anio;
        this.Estado_Periodo = Estado_Periodo;
    }

    
       public String getMes() {
        return Mes;
    }

       
    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public long getId_Periodo() {
        return Id_Periodo;
    }

  

    public int getAnio() {
        return Anio;
    }

    public Boolean getEstado_Periodo() {
        return Estado_Periodo;
    }

    public void setId_Periodo(long Id_Periodo) {
        this.Id_Periodo = Id_Periodo;
    }

 

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public void setEstado_Periodo(Boolean Estado_Periodo) {
        this.Estado_Periodo = Estado_Periodo;
    }
    
    
    
    
}
