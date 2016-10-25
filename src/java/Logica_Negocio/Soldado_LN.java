
package Logica_Negocio;
import Entidad_Negocio.Soldado_EN;
import Entidad_Negocio.Novedad_EN;
import Acceso_Datos.Soldado_AD;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Soldado_LN  {
   
    Soldado_AD Sol_AD= new Soldado_AD();
    Soldado_EN Sol_EN= new Soldado_EN ();
    Novedad_EN Nov_EN= new Novedad_EN();
    
    ResultSet Res=null;
    
  public ArrayList<Soldado_EN> Listar_Soldados(){
    
    ArrayList<Soldado_EN> Lista_Soldados = new ArrayList<Soldado_EN>();
    try{
    Res= Sol_AD.Listar_Soldados();
  
  while(Res.next()){
      
         Sol_EN = new Soldado_EN();
         Sol_EN.setIdent_Sold(Res.getInt("Ident_Sold"));
         Sol_EN.setNombres(Res.getString("Nombres"));
         Sol_EN.setNomb_Novedad(Res.getString("Nomb_Novedad"));
         
         Lista_Soldados.add(Sol_EN); 
        Sol_EN = null;
        }
    
    }catch( Exception x ) {}
  return Lista_Soldados;
  }   
    
 
  
  public  ResultSet Listar_Soldados_Unidad(Long Unidad, Integer Planilla)
        {
           return  Sol_AD.Listar_Soldados_Unidad(Unidad,Planilla);
        }  
  
   public ResultSet Listar_Soldados_Unidad_SLP(Integer Unidad, Integer Planilla)
        {
                return  Sol_AD.Listar_Soldados_Unidad_SLP(Unidad, Planilla);
        }
  
  
   
      public ResultSet Listar_Soldados_Unidad_SLR_SLB_SLC(Integer Unidad, Integer Planilla)
        {
             return  Sol_AD.Listar_Soldados_Unidad_SLR_SLB_SLC(Unidad, Planilla);
        }
   
   
   
  
  
    
  public Boolean Registrar_Soldado(Soldado_EN Sold)
        {
         return Sol_AD.Registrar_Soldado(Sold);
        }
  
  
  
  
    
    
    
}
