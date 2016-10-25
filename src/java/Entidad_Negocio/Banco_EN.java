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
public class Banco_EN {
 public long Cod_Banco;
 public String Nomb_Banco; 

    public Banco_EN() {
    }

    public Banco_EN(long Cod_Banco, String Nomb_Banco) {
        this.Cod_Banco = Cod_Banco;
        this.Nomb_Banco = Nomb_Banco;
    }

    public long getCod_Banco() {
        return Cod_Banco;
    }

    public String getNomb_Banco() {
        return Nomb_Banco;
    }

    public void setCod_Banco(long Cod_Banco) {
        this.Cod_Banco = Cod_Banco;
    }

    public void setNomb_Banco(String Nomb_Banco) {
        this.Nomb_Banco = Nomb_Banco;
    }
    
    
    
    
}
