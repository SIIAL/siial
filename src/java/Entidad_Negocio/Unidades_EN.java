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
public class Unidades_EN {
    private Integer Cod_Unidad;
  private String Nomb_Unidad; 
  private String Sigla; 

    public Unidades_EN() {
    }

    public Unidades_EN(Integer Cod_Unidad, String Nomb_Unidad, String Sigla) {
        this.Cod_Unidad = Cod_Unidad;
        this.Nomb_Unidad = Nomb_Unidad;
        this.Sigla = Sigla;
    }

  

    public Integer getCod_Unidad() {
        return Cod_Unidad;
    }

    public String getNomb_Unidad() {
        return Nomb_Unidad;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setCod_Unidad(Integer Cod_Unidad) {
        this.Cod_Unidad = Cod_Unidad;
    }

    public void setNomb_Unidad(String Nomb_Unidad) {
        this.Nomb_Unidad = Nomb_Unidad;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }
    
}
