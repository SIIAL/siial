/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Planilla_Articulo_EN;
import Acceso_Datos.Planilla_Articulo_AD;
import java.sql.ResultSet;

/**
 *
 * @author WILSON
 */
public class Planilla_Articulo_LN {
    
     ResultSet Res=null;
     Planilla_Articulo_AD Plan_Art_AD = new Planilla_Articulo_AD();
    
    
    Planilla_Articulo_EN Plan_Art_EN = new Planilla_Articulo_EN(); 
    
    
    
     public Boolean Registrar_Articulo_Planilla(Planilla_Articulo_EN Plan_Art_EN )
            {
                return Plan_Art_AD.Registrar_Articulo_Planilla(Plan_Art_EN);
               }
      
     
     
     
       public ResultSet Listar_Articulos_Planilla(Integer Cod_Planilla)
        {
            
        return Plan_Art_AD.Listar_Articulos_Planilla(Cod_Planilla);
        }
    
    
         public Boolean Retirar_Articulo_Planilla(Integer  Id_Articulo ){
             
             
                return Plan_Art_AD.Retirar_Articulo_Planilla(Id_Articulo);
         }
         
         
           public ResultSet Consultar_Existencia_Planilla_Articulo(Integer Cod_Planilla,Integer Cod_Articulo)
            {
            
                return Plan_Art_AD.Consultar_Existencia_Planilla_Articulo(Cod_Planilla, Cod_Articulo);
            }
         
         
         
         
         
       
       
    
}
