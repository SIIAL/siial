
package Acceso_Datos;


import Entidad_Negocio.Soldado_EN;
import java.util.ArrayList;
import java.sql.ResultSet;


public class Soldado_AD {
    
    Conectar Con= new Conectar();
    ResultSet Res=null;
  //  Soldado_EN Sol_EN= new Soldado_EN();
    
   
  public ResultSet Listar_Soldados(){
   
  String Sql="Select \"Ident_Sold\",\"Nombres\",\"Nomb_Novedad\"  "
          + " from \"Soldado\""
          + " inner join \"Novedad\"  on \"Id_Novedad\" = \"Novedad\"";
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
    }
  
  
  
 public Boolean Registrar_Soldado(Soldado_EN Sold_EN){
  
        String SqlInst = "INSERT INTO  \"Soldado\" (\"Ident_Sold\",\"Nombres\",\"Apellidos\",\"Grado\",\"Novedad\",\"Compania\")"
                + " VALUES ('"+Sold_EN.getIdent_Sold()+"','"+Sold_EN.getNombres()+"','"+Sold_EN.getApellidos()+"','"+Sold_EN.getGrado()+"','"+Sold_EN.getNovedad()+"','"+Sold_EN.getCompania()+"');";    
 
        try{
       return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}

 } 
  
     public Boolean Regitrar_Lista_Soldados( ArrayList<Soldado_EN> Sol_EN){
  
     String SqlInst ="INSERT INTO  \"Soldado\" (\"Ident_Sold\",\"Nombres\",\"Grado\",\"Novedad\",\"Compania\") VALUES ";
         
         for (Soldado_EN Sold_EN :  Sol_EN){
     
          SqlInst =SqlInst+ "('"+Sold_EN.getIdent_Sold()+"','"+Sold_EN.getNombres()+"','"+Sold_EN.getGrado()+"','"+Sold_EN.getNovedad()+"','"+Sold_EN.getCompania()+"'),";
         
      }
 SqlInst=SqlInst.substring(0,SqlInst.length()-1)+";";
 
        try{
       return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) {return false; }
      
 
 } 
 
 
 
 
   public ResultSet Listar_Soldados_Unidad(Long Unidad, Integer Planilla)
        {

  String Sql="Select * FROM  \"Soldado\" Sol\n" +
                " inner join \"Compania\" Co on Co.\"Codigo_Comp\" = Sol.\"Compania\" \n" +
                " where \"Ident_Sold\" not in (Select s.\"Ident_Sold\"  FROM  \"Soldado\" S\n" +
                " inner join \"Compania\" Com on Com.\"Codigo_Comp\" = S.\"Compania\" \n" +
                " inner join  \"Planilla_Soldado\" P on  S.\"Ident_Sold\" = P.\"Soldado\" \n" +
                " inner join \"Ciclo\" C on  C.\"Id_Ciclo\" = P.\"Ciclo\"   \n" +
                " where  C.\"Planilla\" = '"+Planilla+"'  )  and Co.\"Unidad\" = '"+Unidad+"' order by  Sol.\"Grado\" DESC;";
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
    }
 
   
 
      public ResultSet Listar_Soldados_Unidad_SLP(Integer Unidad, Integer Planilla)
        {

  String Sql="Select * FROM  \"Soldado\" Sol\n" +
                " inner join \"Compania\" Co on Co.\"Codigo_Comp\" = Sol.\"Compania\" \n" +
                " where \"Ident_Sold\" not in (Select s.\"Ident_Sold\"  FROM  \"Soldado\" S\n" +
                " inner join \"Compania\" Com on Com.\"Codigo_Comp\" = S.\"Compania\" \n" +
                " inner join  \"Planilla_Soldado\" P on  S.\"Ident_Sold\" = P.\"Soldado\" \n" +
                " inner join \"Ciclo\" C on  C.\"Id_Ciclo\" = P.\"Ciclo\"   \n" +
                " where  C.\"Planilla\" = '"+Planilla+"'  ) and \"Grado\" = 'SLP'     and Co.\"Unidad\" = '"+Unidad+"';";
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
    }
 
   
   
   
      public ResultSet Listar_Soldados_Unidad_SLR_SLB_SLC(Integer Unidad, Integer Planilla)
        {

  String Sql="Select * FROM  \"Soldado\" Sol\n" +
                " inner join \"Compania\" Co on Co.\"Codigo_Comp\" = Sol.\"Compania\" \n" +
                " where \"Ident_Sold\" not in (Select s.\"Ident_Sold\"  FROM  \"Soldado\" S\n" +
                " inner join \"Compania\" Com on Com.\"Codigo_Comp\" = S.\"Compania\" \n" +
                " inner join  \"Planilla_Soldado\" P on  S.\"Ident_Sold\" = P.\"Soldado\" \n" +
                " inner join \"Ciclo\" C on  C.\"Id_Ciclo\" = P.\"Ciclo\"   \n" +
                " where  C.\"Planilla\" = '"+Planilla+"'  ) and \"Grado\" != 'SLP'     and Co.\"Unidad\" = '"+Unidad+"';";
  try{
       Res =Con.Ejecutar_Consulta(Sql);
      }catch( Exception x ) {}
        return Res;
   
    }
 
   
   
 
 
  
  
}