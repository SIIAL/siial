/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author WILSON
 */
public class Novedad_AD {
    
    Conectar Con= new Conectar();
    ResultSet Res=null;
    
    
    public ResultSet Listar_Novedades(){
    
          
  String Sql="Select \"Id_Novedad\",\"Nomb_Novedad\"  "
          + " from \"Novedad\" ";
        
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
    }
          
   
    }
    
    
    

