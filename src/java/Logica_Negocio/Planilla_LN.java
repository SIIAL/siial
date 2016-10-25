/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Planilla_EN;
import Acceso_Datos.Planilla_AD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WILSON
 */
public class Planilla_LN {
    
 // Planilla_EN Pla_EN = new Planilla_EN();
  Planilla_AD Plan_AD= new Planilla_AD();
  Planilla_EN Plan_EN = new Planilla_EN();
   ResultSet Res=null;
    
   
   
     public ResultSet Generar_Codigo_Comida_Caliente(Integer Cod_Unidad)
            {
                  return Plan_AD.Generar_Codigo_Comida_Caliente(Cod_Unidad);
            }
   
   
   //Generer Planilla
  public Boolean Crear_Planilla_Abastecimiento(  Planilla_EN Pla_EN ){
    return Plan_AD.Crear_Planilla_Abastecimiento(Pla_EN);
  }
    
    public Boolean Crear_Planilla_Devolucion( Planilla_EN Plan_EN)
        {
            
           return Plan_AD.Crear_Planilla_Devolucion(Plan_EN);  
        }
  
  
  

     public Boolean Elimminar_Planilla(Integer  Id_Planilla )
        {
              return Plan_AD.Elimminar_Planilla(Id_Planilla);
        }
  
  
  
          public ResultSet Listar_Planillas_Devolucion_Borrador(Integer Cod_Unidad)
            {
             return Plan_AD.Listar_Planillas_Devolucion_Borrador(Cod_Unidad);
            
            }
    
   public ResultSet Listar_Planillas_Abastecimmiento_Finalizada(Integer Cod_Unidad)
        {
            
             return Plan_AD.Listar_Planillas_Abastecimmiento_Finalizada(Cod_Unidad);
        }
 
  
  
 
 public ResultSet Listar_Planillas_Abastecimmiento_Borrador_Completado(Integer Cod_Unidad){
 
      try{
         Res= Plan_AD.Listar_Planillas_Abastecimmiento_Borrador_Completado(Cod_Unidad);
        }catch( Exception x ) {}
         return Res; 
         
         
     }
    
 
     
      public Boolean Realizar_Ajuste_Planilla(Planilla_EN Plan_EN)
                {
                    return Plan_AD.Realizar_Ajuste_Planilla(Plan_EN);
                }
 
 
 
           public ResultSet Buscar_Perido_Planilla(Integer Id_Planilla)
                {
            
               return Plan_AD.Buscar_Perido_Planilla(Id_Planilla);
            
                }
 
 
           
          public ResultSet Listar_Totales_Panillas(Integer Id_Planilla)
            {
                return Plan_AD.Listar_Totales_Panillas(Id_Planilla);
            } 
           
          
          
     public Boolean Actualizar_Estado_Planilla(Integer Cod_Planilla)
            {
               return Plan_AD.Actualizar_Estado_Planilla(Cod_Planilla); 
            }
          
       
     public String Crear_Codigos_Planillas(Integer Tipo_Mod)
        {
            return Plan_AD.Crear_Codigos_Planillas(Tipo_Mod); 
        }
     
     
         
        public ResultSet Buscar_Existencia_Modalidad_Soldado_Periodo(String Ident_Sold,String Id_Ciclo)
        {
              return Plan_AD.Buscar_Existencia_Modalidad_Soldado_Periodo(Ident_Sold, Id_Ciclo);
        }
     
     
     
           
    public String Calcular_Mes(String Mes)

    {

        String  Periodo="";
        if(Mes.compareTo("Enero")==0){Periodo="01";}
        if(Mes.compareTo("Febrero")==0){Periodo="02";}
        if(Mes.compareTo("Marzo")==0){Periodo="03";}
        if(Mes.compareTo("Abril")==0){Periodo="04";}
        if(Mes.compareTo("Mayo")==0){Periodo="05";}
        if(Mes.compareTo("Junio")==0){Periodo="06";}
        if(Mes.compareTo("Julio")==0){Periodo="07";}
        if(Mes.compareTo("Agosto")==0){Periodo="08";}
        if(Mes.compareTo("Septiembre")==0){Periodo="09";}
        if(Mes.compareTo("Octubre")==0){Periodo="10";}
        if(Mes.compareTo("Noviembre")==0){Periodo="11";}
        if(Mes.compareTo("Diciembre")==0){Periodo="12";}
                            
        
              
    return Periodo;

    }         
           
           
           
           
           
           
           
           
           
           
           
           
           
           
  
    
}
