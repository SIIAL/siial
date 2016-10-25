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
public class Cuenta_EN {
    
     private String Num_Cuenta;
     private long Soldado;
     private Boolean Habiltado; 
     private long Banco; 

    public Cuenta_EN() {
    }

    public Cuenta_EN(String Num_Cuenta, Boolean Habiltado, long Banco) {
        this.Num_Cuenta = Num_Cuenta;
        this.Habiltado = Habiltado;
        this.Banco = Banco;
    }

    public String getNum_Cuenta() {
        return Num_Cuenta;
    }

    public long getSoldado() {
        return Soldado;
    }

    public Boolean getHabiltado() {
        return Habiltado;
    }

    public long getBanco() {
        return Banco;
    }

    public void setNum_Cuenta(String Num_Cuenta) {
        this.Num_Cuenta = Num_Cuenta;
    }

    public void setSoldado(long Soldado) {
        this.Soldado = Soldado;
    }

    public void setHabiltado(Boolean Habiltado) {
        this.Habiltado = Habiltado;
    }

    public void setBanco(long Banco) {
        this.Banco = Banco;
    }
}
