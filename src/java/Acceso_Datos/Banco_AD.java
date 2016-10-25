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
public class Banco_AD {
    Conectar Con= new Conectar();
   ResultSet Res=null;
   
   
       
   public ResultSet Listar_Bancos()
        {
           
    String Sql="Select \"Cod_Banco\",\"Nomb_Banco\" "
                + " from \"Banco\" "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
   
   
   
   
   
   
   
           
       }
    
    

