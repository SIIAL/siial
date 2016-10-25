/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Banco_EN;
import Acceso_Datos.Banco_AD;
import Entidad_Negocio.Banco_EN;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WILSON
 */
public class Banco_LN {
    
    Banco_AD Banc_AD= new Banco_AD();
    Banco_EN Banc_EN= new Banco_EN();
     ResultSet Res=null;
    
    
 public ArrayList<Banco_EN> Lista_Bancos(){
           ArrayList<Banco_EN> Lista_Bancos = new ArrayList<Banco_EN>();
      try{
    Res= Banc_AD.Listar_Bancos();
  
  while(Res.next()){
      Banc_EN= new Banco_EN();
      
      Banc_EN.setCod_Banco(Res.getInt("Cod_Banco"));
      Banc_EN.setNomb_Banco(Res.getString("Nomb_Banco"));
      Lista_Bancos.add(Banc_EN);
      Banc_EN = null;
        }
    }catch( Exception x ) {}
         return Lista_Bancos; 
         
         
     }
    
    
    
    
    
    
    
    
    
    
}
