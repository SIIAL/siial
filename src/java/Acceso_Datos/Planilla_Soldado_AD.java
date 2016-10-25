/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import java.util.ArrayList;
import java.sql.ResultSet;
import Entidad_Negocio.Planilla_Soldado_EN;

/**
 *
 * @author WILSON
 */
public class Planilla_Soldado_AD {
    
        Conectar Con= new Conectar();
    ResultSet Res=null;
    Planilla_Soldado_EN Plan_Sold= new Planilla_Soldado_EN();
    
    
    
    
    
    
    
    
    //permite resitrar Soldado a la Planilla
    public Boolean Registrar_Soldados_Planilla(Integer Ident_Sold, Integer Ciclo){
    
 
     String SqlInst ="INSERT INTO  \"Planilla_Soldado\" (\"Soldado\",\"Ciclo\") VALUES ";
     
          SqlInst =SqlInst+ "('"+Ident_Sold+"','"+Ciclo+"'),";
         
     
        SqlInst=SqlInst.substring(0,SqlInst.length()-1)+";";
    
    
    
    try{
      return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     
 
  
    
    }
    
    
    // Listar todos los soldados registrado a una Planilla
   public ResultSet Listar_Soldados_Planilla(Integer Cod_Plan)
        {
          
            
        String Sql="Select \"Ident_Sold\",\"Apellidos\",\"Nombres\",\"Grado\",\"Fech_Inicio\",\"Fech_Fin\",\"Numb_Dias\",\"Tipo_Ciclo\",\"Id_Ciclo\" FROM  \"Ciclo\" \n" +
                    "inner join \"Planilla_Soldado\" on \"Ciclo\"= \"Id_Ciclo\"\n" +
                    "inner join \"Soldado\" on \"Ident_Sold\" = \"Soldado\"\n"
                     +"where \"Planilla\"='"+Cod_Plan+"'";
             
       
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
             return Res;
             
             
   
        }   

   //desvincular soldado agregado a una planilla
     public Boolean Desvincular_Soldados_Planilla(Integer  Soldado,Integer Ciclo ){
     String SqlInst =" delete  from \"Planilla_Soldado\" where \"Soldado\"='"+Soldado+"' and  \"Ciclo\"='"+Ciclo+"' ";


        try{
                return Con.Ejecutar_Actualizacion(SqlInst);
            }catch( Exception x ) { return false;}     
    }
   
  
    
     public ResultSet Listar_Total_Soldados_Estancia(String Id_Planilla)
            {
        String Sql="select \"Tipo_Ciclo\",\"Numb_Dias\", count(\"Soldado\") As Sold,\"Valor\" as Estancia,((count(\"Soldado\")* \"Valor\")*\"Numb_Dias\") as Total   from \"Planilla\"\n" +
                   "inner join \"Ciclo\"  on  \"Planilla\"= \"Id_Planilla\"\n" +
                   "inner join \"Estancia\" on \"Estancia\"=\"Id_Estancia\" \n" +
                   "inner join \"Planilla_Soldado\" on \"Ciclo\"=\"Id_Ciclo\"\n" +
                    "where \"Id_Planilla\"= '"+Id_Planilla+"'    group by \"Tipo_Ciclo\",\"Numb_Dias\",\"Valor\";";
                
            
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
             return Res;
            }
     
   /*
     
      public ResultSet Listar_Dias_Soldados_Estancia_Raciones(String Id_Planilla)
            {
        String Sql="select \"Numb_Dias\", count(\"Soldado\") As Sold,\"Valor\" as Estancia,((count(\"Soldado\")* \"Valor\")*\"Numb_Dias\") as Total   from \"Planilla\"\n" +
"inner join \"Ciclo\"  on  \"Planilla\"= \"Id_Planilla\"\n" +
"inner join \"Estancia\" on \"Estancia\"=\"Id_Estancia\" \n" +
"inner join \"Planilla_Soldado\" on \"Ciclo\"=\"Id_Ciclo\"\n" +
"where \"Id_Planilla\"= '"+Id_Planilla+"' AND \"Tipo_Ciclo\"='Raciones' "     +
"group by \"Numb_Dias\" ,\"Soldado\" ,\"Valor\" ";
                
            
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
             return Res;
            }
     */
     
     
     
     
   
     
    
    
}
