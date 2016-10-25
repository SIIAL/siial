/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;

import java.sql.ResultSet;
import Acceso_Datos.Articulos_AD;
import Entidad_Negocio.Articulo_EN;

/**
 *
 * @author WILSON
 */
public class Articulo_LN {
    
    Articulos_AD Art_AD= new Articulos_AD();
    
        
   public ResultSet Listar_Articulos()
        {
         return   Art_AD.Listar_Articulos();
        
        }
   
   
   
        public ResultSet Sumatoria_Valor_Articulo_Planilla(Integer Planilla,Integer Cod_Articulo,Integer Cant)
        {
          return   Art_AD.Sumatoria_Valor_Articulo_Planilla(Planilla,Cod_Articulo,Cant);

        }
 
        public ResultSet Articulo_Minimo_Valor()
        {
            
             return   Art_AD.Articulo_Minimo_Valor();
            
        }
        
        
        
        
   
   
   
}
