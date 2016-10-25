package Acceso_Datos;
import java.sql.*;




public class Conectar {
    
  protected String Servidor="localhost";    
  protected  String Usuario="postgres";    
  protected  String Clave="123";        
  protected String Bd="bd_siial";  
  protected Connection conexion=null;
     
       
   public  void Abrir(){
        try{    
        
           String driver = "org.postgresql.Driver";      
            Class.forName( driver );             
            String url  = "jdbc:postgresql://"+this.Servidor+":5432/"+this.Bd+"" ;      
            this.conexion = DriverManager.getConnection(url,this.Usuario,this.Clave);      
            
        }catch (Exception e){ }
       
   } 
   
    
    
  public ResultSet Ejecutar_Consulta(String Sql){
      Abrir();
      Statement St;
      ResultSet Rs=null;
  try{
        St=conexion.createStatement();
        Rs= St.executeQuery(Sql);    
    }catch(SQLException e) 
            {  Cerrar();
                e.printStackTrace();
            }
        Cerrar();
        return Rs;  
    
  }
 
        
 public boolean Ejecutar_Actualizacion(String Sql){
 
 Abrir();
 Statement St;
 boolean Save=true;
  try{
        St=conexion.createStatement();
        St.executeUpdate(Sql);    
    }catch(SQLException e) 
            { Save=false;
              Cerrar();
              e.printStackTrace();
            }
  Cerrar();
 return Save;
    
  }
  
 
 
 
 
    

 
 
 
 
 /*
 
 */
  
 public boolean Cerrar(){
 boolean Ok=true;
 try{
    conexion.close();
   
    }catch(Exception e)
            {
                Ok=false;
                e.printStackTrace();
            }
 return Ok;
 }
    
    
}
/*


*/