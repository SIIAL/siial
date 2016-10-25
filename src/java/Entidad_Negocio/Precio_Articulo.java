/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

/**

CREATE TABLE "Precio_Articulo"
(
  "idPrecio_Articulo" serial NOT NULL,
  "Valor" numeric(10,1),
  "Habilitado" boolean,
  "Anio" integer,
  "Mes" integer,
  "Articulo" bigint,
  CONSTRAINT pk_plan_art PRIMARY KEY ("idPrecio_Articulo"),
  CONSTRAINT "fk_Articulo" FOREIGN KEY ("Articulo")
      REFERENCES "Articulo" ("idArticulo") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
public class Precio_Articulo {
    
    public Integer idPrecio_Articulo;
    public Number  Valor;
    public Boolean  Habilitado;
    public Integer Anio;
    public Integer Mes;
    public Integer Articulo;

    public void setIdPrecio_Articulo(Integer idPrecio_Articulo) {
        this.idPrecio_Articulo = idPrecio_Articulo;
    }

    public void setValor(Number Valor) {
        this.Valor = Valor;
    }

    public void setHabilitado(Boolean Habilitado) {
        this.Habilitado = Habilitado;
    }

    public void setAnio(Integer Anio) {
        this.Anio = Anio;
    }

    public void setMes(Integer Mes) {
        this.Mes = Mes;
    }

    public void setArticulo(Integer Articulo) {
        this.Articulo = Articulo;
    }

    public Integer getIdPrecio_Articulo() {
        return idPrecio_Articulo;
    }

    public Number getValor() {
        return Valor;
    }

    public Boolean getHabilitado() {
        return Habilitado;
    }

    public Integer getAnio() {
        return Anio;
    }

    public Integer getMes() {
        return Mes;
    }

    public Integer getArticulo() {
        return Articulo;
    }

    public Precio_Articulo(Integer idPrecio_Articulo, Number Valor, Boolean Habilitado, Integer Anio, Integer Mes, Integer Articulo) {
        this.idPrecio_Articulo = idPrecio_Articulo;
        this.Valor = Valor;
        this.Habilitado = Habilitado;
        this.Anio = Anio;
        this.Mes = Mes;
        this.Articulo = Articulo;
    }

    public Precio_Articulo() {
    }
    
    
    
    
    
    
    
}
