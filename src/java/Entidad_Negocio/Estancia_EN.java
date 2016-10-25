/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

/**
CREATE TABLE "Estancia"
(
  "Id_Estancia" serial NOT NULL,
  "Anio" integer,
  "Habilitado" boolean,
  "Valor" numeric,
  CONSTRAINT "Pk_IdSerial" PRIMARY KEY ("Id_Estancia")
)
 */
public class Estancia_EN {

 public int Id_Estancia;
 public int Anio;
 public int Habilitado;
 public Number Valor; 

    public void setId_Estancia(int Id_Estancia) {
        this.Id_Estancia = Id_Estancia;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public void setHabilitado(int Habilitado) {
        this.Habilitado = Habilitado;
    }

    public void setValor(Number Valor) {
        this.Valor = Valor;
    }
    
      
    public int getId_Estancia() {
        return Id_Estancia;
    }

    public int getAnio() {
        return Anio;
    }

    public int getHabilitado() {
        return Habilitado;
    }

    public Number getValor() {
        return Valor;
    }

  
        public Estancia_EN() {
    }
    
      public Estancia_EN(int Id_Estancia, int Anio, int Habilitado, Number Valor) {
        this.Id_Estancia = Id_Estancia;
        this.Anio = Anio;
        this.Habilitado = Habilitado;
        this.Valor = Valor;
    }  
    
    
  
      
    
    
}
