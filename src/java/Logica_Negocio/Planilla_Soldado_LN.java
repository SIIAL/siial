/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Planilla_Soldado_EN;
import Acceso_Datos.Planilla_Soldado_AD;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author WILSON
 */
public class Planilla_Soldado_LN {
    
  
    Planilla_Soldado_AD Plan_Sold_AD = new Planilla_Soldado_AD();
    
    
     public Boolean Registrar_Soldados_Planilla(Integer Ident_Sold, Integer Ciclo)
            {
             return Plan_Sold_AD.Registrar_Soldados_Planilla(Ident_Sold,Ciclo);
            }
    
    public   ResultSet Listar_Soldados_Planilla(Integer Cod_Plan)
            {
            return Plan_Sold_AD.Listar_Soldados_Planilla(Cod_Plan); 
            }
     
    
     public Boolean Desvincular_Soldados_Planilla(Integer  Soldado,Integer Ciclo ){
         
        return  Plan_Sold_AD.Desvincular_Soldados_Planilla(Soldado,Ciclo);
         
     }
     
     
     
    
      public ResultSet Listar_Total_Soldados_Estancia(String Id_Planilla)
            {
                 return  Plan_Sold_AD.Listar_Total_Soldados_Estancia(Id_Planilla);
            }
    
     
      /*
      public ResultSet Listar_Dias_Soldados_Estancia_Raciones(String Id_Planilla)
            {
                return  Plan_Sold_AD.Listar_Dias_Soldados_Estancia_Raciones(Id_Planilla);
            }
      */
      
      
      
    
}
