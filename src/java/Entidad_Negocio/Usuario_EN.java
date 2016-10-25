/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

/**
"Identificacion" bigint NOT NULL,
  "Login" character varying(25),
  "Password" character varying(15),
  "Tipo" character varying(20),
  "Unidad" bigint,
 */


public class Usuario_EN {
    
    
    public Long Identificacion;
    public String Login;
    public String Password;
    public String Tipo;
    public Long Unidad            ;

    public void setIdentificacion(Long Identificacion) {
        this.Identificacion = Identificacion;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setUnidad(Long Unidad) {
        this.Unidad = Unidad;
    }

    public Long getIdentificacion() {
        return Identificacion;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getTipo() {
        return Tipo;
    }

    public Long getUnidad() {
        return Unidad;
    }

    public Usuario_EN() {
    }
    
    public Usuario_EN(String Login, String Password, String Tipo, Long Compania) {
        this.Login = Login;
        this.Password = Password;
        this.Tipo = Tipo;
        this.Unidad = Compania;
    }
    
    
    
           
        
    
    
    
    
    
}
