
package Entidad_Negocio;
/*
  
  "Ident_Sold" bigint NOT NULL,
  "Nombres" character varying(50),
  "Grado" character varying(40),
  "Novedad" integer,
  "Compania" integer,
  "Cuenta_Banco" character varying(40),
  
  
  */

public class Soldado_EN extends Novedad_EN{
    
  private long Ident_Sold;
  private String Nombres; 
  private String Apellidos; 
  private String Grado; 
  private Integer Compania;
  private Integer Novedad; 
  
  
    public Soldado_EN(long Ident_Sold, String Nombres, String Apellidos, String Grado, Integer Compania, Integer Novedad) {
        this.Ident_Sold = Ident_Sold;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Grado = Grado;
        this.Compania = Compania;
        this.Novedad = Novedad;
    }
  
  
  
  
//  private String Nomb_Novedad; 

    public Soldado_EN() {
    }

  

   
    
    
    public long getIdent_Sold() {
        return Ident_Sold;
    }

    public String getNombres() {
        return Nombres;
    }

      public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getApellidos() {
        return Apellidos;
    }
    
    
    public String getGrado() {
        return Grado;
    }

    public Integer getNovedad() {
        return Novedad;
    }

    public Integer getCompania() {
        return Compania;
    }

  
/*
    public String getNomb_Novedad() {
        return Nomb_Novedad;
    }
*/
    public void setIdent_Sold(long Ident_Sold) {
        this.Ident_Sold = Ident_Sold;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public void setNovedad(Integer Novedad) {
        this.Novedad = Novedad;
    }

    public void setCompania(Integer Compania) {
        this.Compania = Compania;
    }

  
/*
    public void setNomb_Novedad(String Nomb_Novedad) {
        this.Nomb_Novedad = Nomb_Novedad;
    }
*/
     

  
 
  
  
  

  
      
}
