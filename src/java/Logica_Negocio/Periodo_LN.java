/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Periodo_EN;
import Acceso_Datos.Periodo_AD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WILSON
 */
public class Periodo_LN {
    
   Periodo_AD Pdo_AD= new Periodo_AD();
   Periodo_EN Pdo_EN= new Periodo_EN();
   ResultSet Res=null;
    
    
    public Boolean Registrar_Periodo(Periodo_EN Pdo_EN){
     return Pdo_AD.Registrar_Periodo(Pdo_EN);
    }
    
    
    
       
    
 public ArrayList<Periodo_EN> Listar_Periodos(){
     
           ArrayList<Periodo_EN> Lista_Periodos = new ArrayList<Periodo_EN>();
      try{
    Res= Pdo_AD.Listar_Periodos();
  
  while(Res.next()){
      Pdo_EN= new Periodo_EN();
      Pdo_EN.setId_Periodo(Res.getInt("Id_Periodo"));
      Pdo_EN.setMes(Res.getString("Mes_Per"));
      Pdo_EN.setAnio(Res.getInt("Anio_Per"));
      Pdo_EN.setEstado_Periodo(Res.getBoolean("Estado_Periodo"));

      Lista_Periodos.add(Pdo_EN); 
      Pdo_EN = null;
        }
    }catch( Exception x ) {}
         return Lista_Periodos; 
         
         
     }
    
    
    
     
    
    
}
