/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import java.util.ArrayList;
import java.sql.ResultSet;
import Entidad_Negocio.Planilla_EN;

/**
 "Id_Planilla" serial NOT NULL,
  "Cod_Planilla" bigint,
  "Estado_Plan" character varying(30),
  "Estancia" integer,
  "Periodo" integer,
  "Compania" bigint,
  "Fecha_Reg" date,
  "Secos" numeric(10,2),
  "Frescos" numeric(10,2),
  "Tipo_Modalidad" integer,
  "Unidad" bigint,
  "Sl_Abas" integer,
  "Dias_Abas" integer,
  "Val_Estancia" numeric(10,2),
  "Sl_Rac" integer,
  "Dias_Rac" integer,
 */
public class Planilla_AD {
    
    
 
    Conectar Con= new Conectar();
    ResultSet Res=null;
    
    
    
    //Registra na nueva planilla abastecimiento
    public Boolean Crear_Planilla_Abastecimiento( Planilla_EN Plan_EN)
        {
     String SqlInst =   "INSERT INTO  \"Planilla\" (\"Cod_Planilla\",\"Tipo_Modalidad\",\"Estado_Plan\",\"Estancia\",\"Periodo\",\"Compania\",\"Fecha_Reg\" )"
                    + "VALUES ('"+Plan_EN.getCod_Planilla()+"','"+Plan_EN.getTipo_Modalidad()+"','"+Plan_EN.getEstado_Plan()+"','"+Plan_EN.getEstancia()+"','"+Plan_EN.getPeriodo()+"','"+Plan_EN.getCompania()+"','"+Plan_EN.getFecha_Reg()+"' );";    
        try{
      return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     
 
        }
    

    public String Crear_Codigos_Planillas(Integer Tipo_Mod)
        {
            String Resp="";            
          String SqlInst ="select crear_codigo_planilla('"+Tipo_Mod+"');";    
     
     try{   
         Res= Con.Ejecutar_Consulta(SqlInst);
            while (Res.next())
            {
                Resp=Res.getString(1);
            }
        }catch( Exception x ) { }    
            
          return Resp;   
            
        }

    
    
    
    
      //Registra na nueva planilla abastecimiento
    public Boolean Crear_Planilla_Devolucion( Planilla_EN Plan_EN)
        {
     String SqlInst =   "INSERT INTO  \"Planilla\" (\"Cod_Planilla\",\"Tipo_Modalidad\",\"Estado_Plan\",\"Estancia\",\"Periodo\",\"Unidad\",\"Fecha_Reg\" )"
                    + "VALUES ((select max(\"Cod_Planilla\")+1 from \"Planilla\"  where \"Tipo_Modalidad\"='2' or \"Tipo_Modalidad\"='3'),'"+Plan_EN.getTipo_Modalidad()+"','"+Plan_EN.getEstado_Plan()+"','"+Plan_EN.getEstancia()+"','"+Plan_EN.getPeriodo()+"','"+Plan_EN.getUnidad()+"','"+Plan_EN.getFecha_Reg()+"' );";    
       
     
     try{
      return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     
   
 
        }
    
    
      public Boolean Crear_Planilla_Comida_Caliente( Planilla_EN Plan_EN)
        {
     String SqlInst =   "INSERT INTO  \"Planilla\" (\"Cod_Planilla\",\"Tipo_Modalidad\",\"Estado_Plan\",\"Estancia\",\"Periodo\",\"Unidad\",\"Fecha_Reg\" )"
                    + " '"+Plan_EN.getCod_Planilla()+"','"+Plan_EN.getTipo_Modalidad()+"','"+Plan_EN.getEstado_Plan()+"','"+Plan_EN.getEstancia()+"','"+Plan_EN.getPeriodo()+"','"+Plan_EN.getUnidad()+"','"+Plan_EN.getFecha_Reg()+"' );";    
       
     
     try{
      return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     
   
 
        }
    
    
    
    
    
 
     public Boolean Actualizar_Estado_Planilla(Integer Cod_Planilla)
            {
         
            String Sql=" UPDATE \"Planilla\"  SET \"Estado_Plan\"  ='Finalizado' "
                        + " where \"Id_Planilla\" ='"+Cod_Planilla+"';"; 
                   try{
                     return Con.Ejecutar_Actualizacion(Sql);
            }catch( Exception x ) { return false;}   
                      
                      
                      
            }
    
    
    
    
    
    
    

    //Crear un nuevo codigo para planillas de abastecimiento
       public ResultSet Generar_Codigos_Planila_Devolucion(Integer Cod_Planilla, String Tipo_Planilla )
            {
         
            String Sql=" UPDATE 'Planilla' SET 'cod_planilla\" = "
                        + " (select max(p.\"cod_planilla\")+1 from \"Planilla\" p where p.\"tipo\"='"+Tipo_Planilla+"' ) "
                        + " where \"id_planilla\" ='"+Cod_Planilla+"' and \"tipo\"='"+Tipo_Planilla+"' ;"; 
            try{
                            Res =Con.Ejecutar_Consulta(Sql);
                    }catch( Exception x ) {}
                      return Res;
            }
    
   
       public ResultSet Generar_Codigo_Comida_Caliente(Integer Cod_Unidad)
            {
         
            String Sql=" UPDATE \"Planilla\" SET \"cod_planilla\" = "
                        + " (select max(p.\"Cod_Planilla\")+1 from \"Planilla\" p where p.\"tipo\"='3' ), "
                        + " \"Estado_Plan\"='Borrador',\"Tipo_Modalidad\"='3' ,\"Unidad\"='"+Cod_Unidad+"', "
                        + " \"Fecha_Reg\"='current_date'";
                       
            try{
                            Res =Con.Ejecutar_Consulta(Sql);
                    }catch( Exception x ) {}
                      return Res;
            } 
       
       
       
       
       
       
     
       
        public ResultSet Listar_Planillas_Abastecimmiento_Borrador_Completado(Integer Cod_Unidad)
        {
           
        String Sql="Select \"Id_Planilla\",\"Nomb_Comp\",\"Cod_Planilla\",\"Fecha_Reg\",\"Tipo_Modalidad\",\"Estado_Plan\",\"Valor\",\"Anio_Per\",\"Mes_Per\"   \n" +
                    "from \"Planilla\" \n" +
                    "inner join \"Estancia\" on \"Id_Estancia\" =\"Estancia\"\n" +
                    "inner join \"Periodo\" on  \"Id_Periodo\"   =\"Periodo\"\n" +
                    "inner join \"Compania\" Com on Com.\"Codigo_Comp\" = \"Compania\"\n" +
                    " inner join \"Unidad\" Un on  Un.\"Cod_Unidad\" = Com.\"Unidad\" \n" +
                    "where  ( \"Estado_Plan\"='Borrador' or \"Estado_Plan\"='Completado' ) and \"Tipo_Modalidad\"='1' and  \"Cod_Unidad\" ='"+Cod_Unidad+"' ORDER BY \"Fecha_Reg\",\"Estado_Plan\" ASC;"; 
            
        
        
        try{
                 Res =Con.Ejecutar_Consulta(Sql);
                }catch( Exception x ) {}
                    return Res;
         }
      
        
        
         public ResultSet Listar_Planillas_Abastecimmiento_Finalizada(Integer Cod_Unidad)
        {
           
            
               String Sql="Select \"Id_Planilla\",\"Nomb_Comp\",\"Cod_Planilla\",\"Fecha_Reg\",\"Tipo_Modalidad\",\"Estado_Plan\",\"Valor\",\"Anio_Per\",\"Mes_Per\"   \n" +
                    "from \"Planilla\" \n" +
                    "inner join \"Estancia\" on \"Id_Estancia\" =\"Estancia\"\n" +
                    "inner join \"Periodo\" on  \"Id_Periodo\"   =\"Periodo\"\n" +
                    "inner join \"Compania\" Com on Com.\"Codigo_Comp\" = \"Compania\"\n" +
                    " inner join \"Unidad\" Un on  Un.\"Cod_Unidad\" = Com.\"Unidad\" \n" +
                    "where  ( \"Estado_Plan\"='Finalizado') and \"Tipo_Modalidad\"='1' and  \"Cod_Unidad\" ='"+Cod_Unidad+"' ORDER BY \"Fecha_Reg\" ASC;"; 
            
        try{
                 Res =Con.Ejecutar_Consulta(Sql);
                }catch( Exception x ) {}
                    return Res;
         }
        
        
                
        /*
        
         */
         
        
         public ResultSet Listar_Totales_Panillas(Integer Id_Planilla)
            {
                String Sql=" select \"Id_Planilla\",\"Secos\",\"Frescos\",\"Sl_Abas\",\"Dias_Abas\",\"Val_Estancia\",\"Sl_Rac\",\"Dias_Rac\" \n" +
                "from \"Planilla\"\n" +
                "where \"Id_Planilla\"='"+Id_Planilla+"'"; 
   
        try{
                 Res =Con.Ejecutar_Consulta(Sql);
                }catch( Exception x ) {}
                    return Res;
            }
         
         
         
         
         
         
         
         
         
        
        
          public ResultSet Listar_Planillas_Devolucion_Borrador(Integer Cod_Unidad)
            {
                                                                    
                                                                            
            String Sql=" Select \"Id_Planilla\",\"Cod_Planilla\",\"Fecha_Reg\",\"Nomb_Tipo_Mod\",\"Id_Tipo_Mod\" ,\"Estado_Plan\",\"Valor\",\"Anio_Per\",\"Mes_Per\"   \n" +
                    " from \"Planilla\" \n" +
                    " inner join \"Estancia\" on \"Id_Estancia\" =\"Estancia\"\n" +
                    " inner join \"Periodo\" on  \"Id_Periodo\"   =\"Periodo\"\n" +
                     " inner join \"Tipo_Modalidad\" on  \"Id_Tipo_Mod\"   =\"Tipo_Modalidad\"\n" +
                    " where  ( \"Estado_Plan\"='Borrador') and ( \"Tipo_Modalidad\"='2' or \"Tipo_Modalidad\"='3') and  \"Unidad\" ='"+Cod_Unidad+"' ORDER BY \"Anio_Per\" DESC; "; 
            
        
                                                                    
                                                                                            
        
        try{
                 Res =Con.Ejecutar_Consulta(Sql);
                }catch( Exception x ) {}
                    return Res;
         }
        
        
        
        
        
        
        
        
        
        
        
        
         public Boolean Elimminar_Planilla(Integer  Id_Planilla )
                {
    
                        String SqlInst =" delete  from \"Planilla\" where \"Id_Planilla\"='"+Id_Planilla+"'";
                    try{
                            return Con.Ejecutar_Actualizacion(SqlInst);
                        }catch( Exception x ) { return false;}     
                }   
        
       
           public ResultSet Buscar_Perido_Planilla(Integer Id_Planilla)
        {
           
        String Sql="Select \"Cod_Planilla\",\"Anio_Per\",\"Mes_Per\"  \n" +
                    "from \"Planilla\" \n" +
                    "inner join \"Periodo\" on  \"Id_Periodo\"   =\"Periodo\"where \"Id_Planilla\"='"+Id_Planilla+"' "; 
            try{
                 Res =Con.Ejecutar_Consulta(Sql);
                }catch( Exception x ) {}
                    return Res;
         }
      
         
         
     
        public ResultSet Buscar_Existencia_Modalidad_Soldado_Periodo(String Ident_Sold,String Id_Ciclo)
        {
           
        String Sql=" select Pl.\"Id_Planilla\",\"Apellidos\",\"Nombres\",\"Grado\",\"Fech_Inicio\",\"Fech_Fin\",\"Numb_Dias\",\"Tipo_Ciclo\" from \"Planilla\" Pl\n" +
                   " inner join \"Ciclo\" Ci on  Ci.\"Planilla\"=  Pl.\"Id_Planilla\"\n" +
                   " inner join \"Planilla_Soldado\" PS on PS.\"Ciclo\"= CI.\"Id_Ciclo\"\n" +
                   " Inner join \"Soldado\" Sol on Sol.\"Ident_Sold\" = PS.\"Soldado\"\n" +
                   " where ( \"Fech_Inicio\" >=(select \"Fech_Inicio\" from \"Ciclo\" where \"Id_Ciclo\" ='"+Id_Ciclo+"') AND  \"Fech_Fin\" <=(select \"Fech_Fin\" from \"Ciclo\" where \"Id_Ciclo\" ='"+Id_Ciclo+"')    ) \n" +
                   " and  \"Soldado\" ='"+Ident_Sold+"' AND CI.\"Id_Ciclo\" <> '"+Id_Ciclo+"' "; 
            
        
        
        try{
                 Res =Con.Ejecutar_Consulta(Sql);
                }catch( Exception x ) {}
                    return Res;
         }
            
           
           
           
           
           
           
           
         
         
      public Boolean Realizar_Ajuste_Planilla(Planilla_EN Plan_EN)
                {
                    
                /*    
         
               "Id_Planilla" serial NOT NULL,
  "Cod_Planilla" bigint,
  "Estado_Plan" character varying(30),
  "Estancia" integer,
  "Periodo" integer,
  "Compania" bigint,
  "Fecha_Reg" date,
                    
  "Secos" numeric(10,2),
  "Frescos" numeric(10,2),
                    
  "Tipo_Modalidad" integer,
                    
  "Unidad" bigint,
                    
  "Sl_Abas" integer,
  "Dias_Abas" integer,
  "Val_Estancia" numeric(10,2),
  "Sl_Rac" integer,
  "Dias_Rac" integer,     
                    
                    
                    
                   */ 
    
                        String SqlInst =" update  \"Planilla\" set  \"Secos\" ="+Plan_EN.getSecos()+", \"Frescos\" ="+Plan_EN.getFrescos()+", \"Estado_Plan\" ='"+Plan_EN.getEstado_Plan()+"',"
                                + "\"Sl_Abas\" ='"+Plan_EN.getSl_Abas()+"',\"Dias_Abas\" ='"+Plan_EN.getDias_Abas()+"',"
                                + "\"Val_Estancia\" ='"+Plan_EN.getVal_Estancia()+"',\"Sl_Rac\" ='"+Plan_EN.getSl_Rac()+"',\"Dias_Rac\" ='"+Plan_EN.getDias_Rac()+"'  "
                                + " where \"Id_Planilla\"='"+Plan_EN.getId_Planilla()+"'";
                    try{
                            return Con.Ejecutar_Actualizacion(SqlInst);
                        }catch( Exception x ) { return false;}     
                }   
           
         
         
         
         
         
         
        
        
     
    
    
}
