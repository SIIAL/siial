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
public class Compania_AD {
   

 Conectar Con= new Conectar();
   ResultSet Res=null;

       
   public ResultSet Listar_Companias()
        {
           
    String Sql="Select \"Codigo_Comp\",\"Nomb_Comp\",\"Unidad\"  "
                + " from \"Compania\" "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
   
   
    public ResultSet Listar_Companias_Unnidad(String Cod_Unidad)
        {
           
    String Sql="Select \"Codigo_Comp\",\"Nomb_Comp\",\"Unidad\"  "
                + " from \"Compania\" where \"Unidad\" ='"+Cod_Unidad+"' "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
   
           
           
    
     public ResultSet Listar_Companias_Cod_Compañia(String Cod_Comp)
        {
           
    String Sql="Select \"Codigo_Comp\",\"Nomb_Comp\",\"Unidad\"  "
                + " from \"Compania\" where \"Codigo_Comp\" ='"+Cod_Comp+"' "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
    
    
    
    
    
       }
   

   
   
    
    