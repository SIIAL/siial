/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidad_Negocio.Cuenta_EN;
import Acceso_Datos.Cuenta_AD;

/**
 *
 * @author WILSON
 */
public class Cuenta_LN {
    
    
    Cuenta_EN Cta_EN = new Cuenta_EN();
    Cuenta_AD Cta_AD= new Cuenta_AD();
    
    public Boolean Registrar_Cuenta(Cuenta_EN Cta){
    return  Cta_AD.Registrar_Cuenta(Cta);
    }
    
    
     public Boolean Regitrar_Lista_Cuentas(Cuenta_EN Cta){
    return  Cta_AD.Registrar_Cuenta(Cta);
    }
    
    
    
    
    
}
