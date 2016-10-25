/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import Entidad_Negocio.Cuenta_EN;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author WILSON
 */
public class Cuenta_AD {
    
    Conectar Con= new Conectar();
    ResultSet Res=null;
    
    public Boolean Registrar_Cuenta(Cuenta_EN Cta_EN){
 
 
   
        String SqlInst = "INSERT INTO  \"Cuenta\" (\"Num_Cuenta\",\"Habiltado\",\"Soldado\",\"Banco\")"
                + " VALUES ('"+Cta_EN.getNum_Cuenta()+"','"+Cta_EN.getHabiltado()+"','"+Cta_EN.getSoldado()+"','"+Cta_EN.getBanco()+"');";    

        try{
       return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     
        
            /*
                CREATE TABLE "Cuenta"
                (
                  "Num_Cuenta" character varying(50) NOT NULL,
                   "Habiltado" boolean,
                   "Soldado" bigint,
                   "Banco" integer,
                   CONSTRAINT "pk_Num_Cuenta" PRIMARY KEY ("Num_Cuenta")
                )
                 */
      
        }
    
    
    
    
    
    
     public Boolean Regitrar_Lista_Cuentas( ArrayList<Cuenta_EN> Cta_EN){
  
     String SqlInst ="INSERT INTO  \"Cuenta\" (\"Num_Cuenta\",\"Habiltado\",\"Soldado\",\"Banco\" ) VALUES ";
         
         for (Cuenta_EN  Cuent_EN :  Cta_EN){
     
          SqlInst =SqlInst+ "('"+ Cuent_EN.getNum_Cuenta()+"','"+Cuent_EN.getHabiltado()+"','"+Cuent_EN.getSoldado()+"','"+Cuent_EN.getBanco()+"'),";
         
      }
 SqlInst=SqlInst.substring(0,SqlInst.length()-1)+";";
 
        try{
       return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) {return false; }
      
 
 } 
    
    
    
    
    
    
    
    
}
