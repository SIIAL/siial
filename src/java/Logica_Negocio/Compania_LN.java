/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica_Negocio;
import Entidad_Negocio.Compania_EN;
import Acceso_Datos.Compania_AD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WILSON
 */
public class Compania_LN {

    public Compania_LN() {
    }
    
    
    Compania_AD Comp_AD= new Compania_AD();
    Compania_EN Comp_EN = new Compania_EN();
    ResultSet Res=null;
    
    
    
    
 public ArrayList<Compania_EN> Lista_Compania(){
           ArrayList<Compania_EN> Lista_Companias = new ArrayList<Compania_EN>();
      try{
    Res= Comp_AD.Listar_Companias();
  
  while(Res.next()){
      Comp_EN= new Compania_EN();
      Comp_EN.setCodigo_Comp(Res.getInt("Codigo_Comp"));
      Comp_EN.setNomb_Comp(Res.getString("Nomb_Comp"));
      Comp_EN.setUnidad(Res.getInt("Unidad"));  
      Lista_Companias.add(Comp_EN); 
      Comp_EN = null;
      
      
        }
    }catch( Exception x ) {}
         return Lista_Companias; 
         
         
     }
    
    
       
 public ResultSet Listar_Companias_Unnidad(String Cod_Unidad){
         
      try{
            Res= Comp_AD.Listar_Companias_Unnidad(Cod_Unidad);
        
        }catch( Exception x ) {}
         return Res; 
         
         
     }
    
     
    
    
    
    
    
    
    
    
    
}
