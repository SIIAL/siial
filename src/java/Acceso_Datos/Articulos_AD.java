/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import java.sql.ResultSet;
import Entidad_Negocio.Articulo_EN;

/**
 
CREATE TABLE "Articulo"
(
  "idArticulo" serial NOT NULL,
  "Nomb_Art" character varying(80),
  "Un_Med" character varying(10),
  CONSTRAINT "pk_Articulo" PRIMARY KEY ("idArticulo")
)
 */
public class Articulos_AD {
   Conectar Con= new Conectar();
   ResultSet Res=null;
   
   
    
   public ResultSet Listar_Articulos()
        {
           
    String Sql="Select \"idArticulo\",\"Nomb_Art\",\"Un_Med\",\"Valor\" "
                +" from \"Articulo\" "
                +" inner join \"Precio_Articulo\" on \"Articulo\"=  \"idArticulo\" "
                +" where \"Habilitado\"='TRUE' order by \"Nomb_Art\" "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
   
    
    
    public ResultSet Sumatoria_Valor_Articulo_Planilla(Integer Planilla,Integer Cod_Articulo,Integer Cant)
        {
           
String Sql="select sum(\"Valor\"*\"Cantidad\") +(select (\"Valor\"*'"+Cant+"') from  \"Precio_Articulo\" where \"Articulo\"='"+Cod_Articulo+"')as Total_Art_Plan from \"Planilla\" PL\n" +
"inner join \"Planilla_Articulo\" PL_AR on PL_AR.\"Planilla\"=PL.\"Id_Planilla\"\n" +
"inner join \"Articulo\" ART on ART.\"idArticulo\"= PL_AR.\"Articulo\"\n" +
"inner join \"Precio_Articulo\" PAR on PAR.\"Articulo\"= ART.\"idArticulo\"\n" +
"\n" +
"where PL.\"Id_Planilla\"='"+Planilla+"'"; 

 
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
   
   
    public ResultSet Articulo_Minimo_Valor()
        {
           
        String Sql="select Min(\"Valor\") Valor from \"Articulo\" Ar\n" +
                    "inner join \"Precio_Articulo\" Pa on Pa.\"Articulo\"=Ar.\"idArticulo\""; 

  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
        }
   
   
 
   
     public Boolean Registrar_Ciclo(Articulo_EN Art_EN )
    {

    String SqlInst ="INSERT INTO  \"Articulo\" (\"Nomb_Art\",\"Un_Med\" )  VALUES ";
    SqlInst =SqlInst+ " ('"+Art_EN.getNomb_Art()+"','"+Art_EN.getUn_Med()+"')";

    try{
      return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     
 
  
    
    }
      
   
   
   
   
   
   
   
   
   
   
   
   
    
    
    
    
}
