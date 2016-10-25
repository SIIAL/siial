/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import java.util.ArrayList;
import java.sql.ResultSet;
import Entidad_Negocio.Ciclo_EN;


/**
CREATE TABLE "Ciclo"
(
  "Id_Ciclo" integer NOT NULL,
  "Fech_Inicio" date,
  "Fech_Fin" date,
  "Numb_Dias" integer,
  "Tipo_Ciclo" character varying(20),
  "Planilla" bigint,
  CONSTRAINT "Pk_Id_Cilco" PRIMARY KEY ("Id_Ciclo"),
  CONSTRAINT "fk_Planilla" FOREIGN KEY ("Planilla")
      REFERENCES "Planilla" ("Id_Planilla") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */



public class Ciclo_AD {
    
    Conectar Con= new Conectar();
    ResultSet Res=null;
    
    
    public Boolean Registrar_Ciclo(Ciclo_EN Cicl_EN )
    {

    String SqlInst ="INSERT INTO  \"Ciclo\" (\"Fech_Inicio\",\"Fech_Fin\",\"Numb_Dias\",\"Tipo_Ciclo\",\"Planilla\") VALUES ";
    SqlInst =SqlInst+ " ('"+Cicl_EN.getFech_Inicio()+"','"+Cicl_EN.getFech_Fin()+"','"+Cicl_EN.getNumb_Dias()+"','"+Cicl_EN.getTipo_Ciclo()+"','"+Cicl_EN.getPlanilla()+"')";

    try{
      return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     

    
    }
      
  
      
   public ResultSet Listar_Ciclos_Planilla(Integer Cod_Plan)
        {
           
            String Sql="Select \"Id_Ciclo\",\"Fech_Inicio\",\"Fech_Fin\",\"Numb_Dias\",\"Tipo_Ciclo\"  "
                       + " from \"Ciclo\" Where \"Planilla\"  ="+Cod_Plan+"  order by  \"Numb_Dias\" desc;"; 
            System.out.println(Sql);
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
                return Res;
   
            } 

    
    
   
     public Boolean Elimminar_Ciclo(Integer  Id_Ciclo )
                {
    
                        String SqlInst =" delete  from \"Ciclo\" where \"Id_Ciclo\"='"+Id_Ciclo+"'";
                    try{
                            return Con.Ejecutar_Actualizacion(SqlInst);
                        }catch( Exception x ) { return false;}     
                }  
   
   
   
   
   
   
   
   
   
    
    
    
}
