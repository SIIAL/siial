/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

/**
 CREATE TABLE "Planilla_Articulo_EN"
(
  "IdPlanArt" serial NOT NULL,
  "Articulo" bigint,
  "Planilla" bigint,
  CONSTRAINT "Pk_Plan_Art" PRIMARY KEY ("IdPlanArt"),
  CONSTRAINT fk_articulo FOREIGN KEY ("Articulo")
      REFERENCES "Articulo" ("idArticulo") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_planilla FOREIGN KEY ("Planilla")
      REFERENCES "Planilla" ("Id_Planilla") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
public class Planilla_Articulo_EN {
    
    public Integer IdPlanArt;
    public Integer Articulo;
    public Integer Planilla;
    public Integer Catidad;

    public Planilla_Articulo_EN(Integer IdPlanArt, Integer Articulo, Integer Planilla, Integer Catidad) {
        this.IdPlanArt = IdPlanArt;
        this.Articulo = Articulo;
        this.Planilla = Planilla;
        this.Catidad = Catidad;
    }
    
    
    

    public void setCatidad(Integer Catidad) {
        this.Catidad = Catidad;
    }

    public Planilla_Articulo_EN() {
    }

   

     public Integer getCatidad() {
        return Catidad;
    }
    
    public Integer getIdPlanArt() {
        return IdPlanArt;
    }

    public Integer getArticulo() {
        return Articulo;
    }

    public Integer getPlanilla() {
        return Planilla;
    }

    public void setIdPlanArt(Integer IdPlanArt) {
        this.IdPlanArt = IdPlanArt;
    }

    public void setArticulo(Integer Articulo) {
        this.Articulo = Articulo;
    }

    public void setPlanilla(Integer Planilla) {
        this.Planilla = Planilla;
    }
    
    
    
}
