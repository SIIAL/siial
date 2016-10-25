/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import Entidad_Negocio.Planilla_Articulo_EN;
import java.sql.ResultSet;
/**
 *CREATE TABLE "Planilla_Articulo"
(
  "IdPlanArt" serial NOT NULL,
  "Articulo" bigint,
  "Planilla" bigint,
 */
public class Planilla_Articulo_AD {
    
    Conectar Con= new Conectar();
    ResultSet Res=null;
    
    
    public Boolean Registrar_Articulo_Planilla(Planilla_Articulo_EN Plan_Art_EN )
    {

    String SqlInst ="INSERT INTO  \"Planilla_Articulo\" (\"Articulo\",\"Planilla\",\"Cantidad\" )  VALUES ";
    SqlInst =SqlInst+ " ('"+Plan_Art_EN.getArticulo()+"','"+Plan_Art_EN.getPlanilla()+"','"+Plan_Art_EN.getCatidad()+"')";

    try{
          return Con.Ejecutar_Actualizacion(SqlInst);
              
      }catch( Exception x ) {
          return false;
      }     
  
    }
      
   
    
   /* 

CREATE TABLE "Planilla_Articulo"
(
  "IdPlanArt" serial NOT NULL,
  "Articulo" bigint,
  "Planilla" bigint,    
  
CREATE TABLE "Articulo"
(
  "idArticulo" serial NOT NULL,
  "Nomb_Art" character varying(80),
  "Un_Med" character varying(10),
  CONSTRAINT "pk_Articulo" PRIMARY KEY ("idArticulo")
)
    */
        public ResultSet Listar_Articulos_Planilla(Integer Cod_Planilla)
        {
           
 String Sql="Select \"IdPlanArt\",\"Nomb_Art\",\"Un_Med\",\"Valor\",\"Cantidad\",(\"Valor\"* Plan.\"Cantidad\") VT " +
"from \"Planilla_Articulo\" Plan \n" +
"inner join \"Articulo\" Art  on Art.\"idArticulo\"= Plan.\"Articulo\"\n" +
"inner join \"Precio_Articulo\" Pre on Pre.\"Articulo\" =  Art.\"idArticulo\" \n" +
" where     Plan.\"Planilla\"='"+Cod_Planilla+"';";
        
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
             return Res;
   
        }
    
        
        
            public ResultSet Consultar_Existencia_Planilla_Articulo(Integer Cod_Planilla,Integer Cod_Articulo)
            {
           
                String Sql=" select count(*) cant from \"Planilla_Articulo\" where \"Articulo\"="+Cod_Articulo+" and \"Planilla\"="+Cod_Planilla+";";
        
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
             return Res;
   
        }
        
        
   
   
        
        
 //desvincular soldado agregado a una planilla
     public Boolean Retirar_Articulo_Planilla(Integer  Id_Articulo ){
         
     String SqlInst =" delete  from \"Planilla_Articulo\" where \"IdPlanArt\"='"+Id_Articulo+"'";


        try{
                return Con.Ejecutar_Actualizacion(SqlInst);
            }catch( Exception x ) { return false;}     
    }   
    
    
    
    
    
    
    
    
    
      
    
    
}
