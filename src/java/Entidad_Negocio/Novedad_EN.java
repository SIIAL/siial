/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 "Id_Novedad" serial NOT NULL,
  "Nomb_Novedad" character varying(50)
 */
package Entidad_Negocio;

/**
 *
 * @author WILSON
 */
public class Novedad_EN {
    
 public long Id_Novedad;
 public String Nomb_Novedad; 

    public Novedad_EN() {
    }

    public Novedad_EN(long Id_Novedad, String Nomb_Novedad) {
        this.Id_Novedad = Id_Novedad;
        this.Nomb_Novedad = Nomb_Novedad;
    }

    public long getId_Novedad() {
        return Id_Novedad;
    }

    public String getNomb_Novedad() {
        return Nomb_Novedad;
    }

    public void setId_Novedad(long Id_Novedad) {
        this.Id_Novedad = Id_Novedad;
    }

    public void setNomb_Novedad(String Nomb_Novedad) {
        this.Nomb_Novedad = Nomb_Novedad;
    }
    
    
    
    
}
