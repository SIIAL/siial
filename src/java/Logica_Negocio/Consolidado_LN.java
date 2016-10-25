/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Consolidado_EN;
import Acceso_Datos.Consolidado_AD;
import java.sql.ResultSet;

/**
 *
 * @author WILSON
 */
public class Consolidado_LN {
    
    Consolidado_EN Cons_EN= new Consolidado_EN();
    Consolidado_AD Cons_AD = new Consolidado_AD();
    
    public Boolean Generar_Codigo_Consolidado( Consolidado_EN Cons_EN)
            { 
              return  Cons_AD.Generar_Codigo_Consolidado(Cons_EN);
            } 
    
    
     public ResultSet Buscar_Existencia_Codigo_Consolidado(Long Cod_Undad)
        {
              return  Cons_AD.Buscar_Existencia_Codigo_Consolidado(Cod_Undad);
            
        }
    
    
    
    
    
    
    public ResultSet Listar_Consolidados_Avtivos(Integer Cod_Undad)
        {
     return  Cons_AD.Listar_Consolidados_Avtivos(Cod_Undad);


}

    
    
    
    
    
    
    
    
    
    
    
    
}






