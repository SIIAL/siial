/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import java.util.ArrayList;
import java.sql.ResultSet;
import Entidad_Negocio.Periodo_EN;

/**
CREATE TABLE "Periodo"
(
  "Id_Periodo" serial NOT NULL,
  "Mes" integer,
  "Anio" integer,
  "Estado_Periodo" boolean,
  CONSTRAINT "Pk_Id_Periodo" PRIMARY KEY ("Id_Periodo")
)
 */

public class Periodo_AD {
  Conectar Con= new Conectar();
  ResultSet Res=null;
   
     
   
    public Boolean Registrar_Periodo(Periodo_EN Per_EN){
 
         String SqlInst = "INSERT INTO  \"Periodo\" (\"Mes_Per\",\"Anio_Per\",\"Estado_Periodo\")"
                + "VALUES ('"+Per_EN.getMes()+"','"+Per_EN.getAnio()+"','"+Per_EN.getEstado_Periodo()+"');";    

        try{
             return Con.Ejecutar_Actualizacion(SqlInst);
            }catch( Exception x ) { return false;}     
        
        }
    
   
    
        
   public ResultSet Listar_Periodos()
        {
           
    String Sql="Select \"Id_Periodo\",\"Mes_Per\",\"Anio_Per\",\"Estado_Periodo\"  "
                + " from \"Periodo\" Where \"Estado_Periodo\" ='true' "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
    
    
    
    
    
    
    
    
    
    
    
}
