/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import java.util.ArrayList;
import java.sql.ResultSet;

/**
CREATE TABLE "Estancia"
(
  "Id_Estancia" serial NOT NULL,
  "Anio" integer,
  "Habilitado" boolean,
  "Valor" numeric,
  CONSTRAINT "Pk_IdSerial" PRIMARY KEY ("Id_Estancia")
)
 */
public class Estancia_AD {
  Conectar Con= new Conectar();
  ResultSet Res=null;
    
      
   public ResultSet Listar_Estancia_Activa()
        {
           
    String Sql="Select \"Id_Estancia\",\"Anio\",\"Habilitado\",\"Valor\"  "
                + " from \"Estancia\" Where \"Habilitado\"  ='true' "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        } 

    
}
