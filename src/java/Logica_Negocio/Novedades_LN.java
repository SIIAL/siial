/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Novedad_EN;
import Acceso_Datos.Novedad_AD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WILSON
 */
public class Novedades_LN {
    
    Novedad_EN Nov_EN = new Novedad_EN();
    Novedad_AD Nov_AD= new Novedad_AD();
     ResultSet Res=null;
    
 public ArrayList<Novedad_EN> Lista_Novedades(){
           ArrayList<Novedad_EN> Lista_Novedades = new ArrayList<Novedad_EN>();
      try{
    Res= Nov_AD.Listar_Novedades();
  
  while(Res.next()){
        Nov_EN = new Novedad_EN();
        Nov_EN.setId_Novedad(Res.getInt("Id_Novedad"));
        Nov_EN.setNomb_Novedad(Res.getString("Nomb_Novedad"));
        Lista_Novedades.add(Nov_EN); 
        Nov_EN = null;
        }
    }catch( Exception x ) {}
         return Lista_Novedades; 
         
         
     }
    
    
}
