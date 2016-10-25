/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Usuario_EN;
import Acceso_Datos.Usuario_AD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WILSON
 */
public class Usuario_LN {
    Usuario_EN Usu_EN = new Usuario_EN();
    Usuario_AD Usu_AD = new Usuario_AD();
    ResultSet Res=null;
     
     
    public ResultSet Validadar_Usuario(Usuario_EN Us_EN){
    
      try{
    Res= Usu_AD.Validar_Usuario(Us_EN);
          
   
    }catch( Exception x ) {}
         return Res; 
       
        
 
    }
    
    
    
    
}
