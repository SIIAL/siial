/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

/**
EATE TABLE "Articulo"
(
  "idArticulo" serial NOT NULL,
  "Nomb_Art" character varying(80),
  "Un_Med" character varying(10),
  CONSTRAINT "pk_Articulo" PRIMARY KEY ("idArticulo")
)
 */
public class Articulo_EN {
    
    public Integer idArticulo;
    public String Nomb_Art;
    public String Un_Med;

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setNomb_Art(String Nomb_Art) {
        this.Nomb_Art = Nomb_Art;
    }

    public void setUn_Med(String Un_Med) {
        this.Un_Med = Un_Med;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public String getNomb_Art() {
        return Nomb_Art;
    }

    public String getUn_Med() {
        return Un_Med;
    }

    public Articulo_EN(Integer idArticulo, String Nomb_Art, String Un_Med) {
        this.idArticulo = idArticulo;
        this.Nomb_Art = Nomb_Art;
        this.Un_Med = Un_Med;
    }

    public Articulo_EN() {
    }
    
    
    
    
    
    
}
