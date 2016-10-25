/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import java.util.ArrayList;
import java.sql.ResultSet;
import Entidad_Negocio.Usuario_EN;


/**
CREATE TABLE "Usuario"
(
  "Identificacion" bigint NOT NULL,
  "Login" character varying(25),
  "Password" character varying(15),
  "Tipo" character varying(20),
  "Unidad" bigint,
)N
 */
public class Usuario_AD {
      Conectar Con= new Conectar();
      ResultSet Res=null;
      Usuario_EN Usu_EN = new Usuario_EN();    
    
    public ResultSet Validar_Usuario(Usuario_EN Us_EN){
    
      String Sql="Select \"Identificacion\",\"Login\",\"Password\",\"Tipo\",\"Unidad\",\"Nomb_Unidad\", \"Sigla\"  "
                + " from \"Usuario\" "
                + " inner join \"Unidad\" on \"Cod_Unidad\"  = \"Unidad\"  "
              + " Where \"Login\" ='"+Us_EN.getLogin()+"' and \"Password\" ='"+Us_EN.getPassword()+"' "; 
    System.out.println(Sql);
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
        
        
    
    }
    
    
    
    
    
    
}
