/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;
import Entidad_Negocio.Ciclo_EN;
import Acceso_Datos.Ciclo_AD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WILSON
 */
public class Ciclo_LN {
    
   Ciclo_AD Cic_AD= new Ciclo_AD();
   Ciclo_EN Cic_EN = new Ciclo_EN();
    ResultSet Res=null;
    
public Boolean Regisrtar_Cilco(Ciclo_EN Clic_EN){


return Cic_AD.Registrar_Ciclo(Clic_EN);
}    
    
       
  

     public Boolean Elimminar_Ciclo(Integer  Id_Ciclo )
                {
                    
                return Cic_AD.Elimminar_Ciclo(Id_Ciclo);
                }






   

   public ArrayList<Ciclo_EN> Listar_Ciclos_Planilla(Integer Cod_Plan)
        {
            
   // return Cic_AD.Listar_Ciclos_Planilla(Cod_Plan);
    //String Sql="Select \"Id_Ciclo\",\"Fech_Inicio\",\"Fech_Fin\",\"Numb_Dias\",\"Tipo_Ciclo\"  "
      ArrayList<Ciclo_EN> Lista_Ciclos_Plani = new ArrayList<Ciclo_EN>();
      Res=  Cic_AD.Listar_Ciclos_Planilla(Cod_Plan);
      try{
     while(Res.next()){
      Cic_EN= new Ciclo_EN();
      Cic_EN.setId_Ciclo(Integer.parseInt(Res.getString("Id_Ciclo")));
      Cic_EN.setFech_Inicio(Res.getString("Fech_Inicio").toString());
      Cic_EN.setFech_Fin(Res.getString("Fech_Fin").toString());
      Cic_EN.setNumb_Dias( Integer.parseInt(Res.getString("Numb_Dias")) );
      Cic_EN.setTipo_Ciclo(Res.getString("Tipo_Ciclo"));
      
      Lista_Ciclos_Plani.add(Cic_EN);
      Cic_EN = null;
                        }
  
            }catch(Exception e){}
      
            return Lista_Ciclos_Plani;

          }
  
    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  }

  