/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

/**
 *
 * @author WILSON
 */
public class Compania_EN {
    
  private Integer Codigo_Comp;
  private String Nomb_Comp; 
  private Integer Unidad; 

    public Compania_EN() {
    }

    public Compania_EN(Integer Codigo_Comp, String Nomb_Comp, Integer Unidad) {
        this.Codigo_Comp = Codigo_Comp;
        this.Nomb_Comp = Nomb_Comp;
        this.Unidad = Unidad;
    }

    public Integer getCodigo_Comp() {
        return Codigo_Comp;
    }

    public String getNomb_Comp() {
        return Nomb_Comp;
    }

    public Integer getUnidad() {
        return Unidad;
    }

    public void setCodigo_Comp(Integer Codigo_Comp) {
        this.Codigo_Comp = Codigo_Comp;
    }

    public void setNomb_Comp(String Nomb_Comp) {
        this.Nomb_Comp = Nomb_Comp;
    }

    public void setUnidad(Integer Unidad) {
        this.Unidad = Unidad;
    }


    
    
    
    
    
    
    
}
