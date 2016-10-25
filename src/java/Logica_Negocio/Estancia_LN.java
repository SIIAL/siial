/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import java.sql.ResultSet;
import java.util.ArrayList;
import Acceso_Datos.Estancia_AD;
import Entidad_Negocio.Estancia_EN;

/**
 *
 * @author WILSON
 */
public class Estancia_LN {
    
  Estancia_EN Est_EN= new Estancia_EN();
    Estancia_AD Est_AD= new Estancia_AD();
 
  ResultSet Res=null;
    
  
 public Estancia_EN Listar_Estancia_Activa(){
           
      try{
    Res= Est_AD.Listar_Estancia_Activa();
  while(Res.next()){
      Est_EN.setId_Estancia(Res.getInt("Id_Estancia"));
      Est_EN.setValor(Res.getInt("Valor"));  
        }
    }catch( Exception x ) {}
         return Est_EN; 
         
         
     }
    
      
    
    
    
    
    
    
    
}
