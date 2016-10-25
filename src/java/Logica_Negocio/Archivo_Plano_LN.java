/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;

import java.io.*;
import Entidad_Negocio.Soldado_EN;
import Acceso_Datos.Soldado_AD;

import Entidad_Negocio.Cuenta_EN;
import Acceso_Datos.Cuenta_AD;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;
import java.util.ArrayList;



/**
 *
 * @author WILSON
 */
public class Archivo_Plano_LN {
    
    Soldado_EN Sold_EN = new Soldado_EN();
    Soldado_AD Sold_AD = new Soldado_AD();
    Cuenta_EN Cta_EN = new Cuenta_EN();
    Cuenta_LN Cta_LN= new Cuenta_LN();
    Cuenta_AD Cta_AD= new Cuenta_AD();
    
    //Leer Archivo plano
    public String Validar_Archivo_Plano(String Direccion) {
    String texto ="<center><table border='1'><tr><td>Identificacion</td><td>Nombres</td><td>Grado</td><td>Novedad</td><td>Compañia</td></tr>";
    try{
            BufferedReader bf = new BufferedReader(new FileReader(Direccion));
            String bfRead;
           Boolean estado=false;
            while ((bfRead=bf.readLine())!= null)
                    {
                        String Dato[] = bfRead.split(",");
                        String colorIdent="#F2F2F2";
                        String colorNomb="#F2F2F2";
                        
                     if (!Dato[0].matches("[0-9]*")) { colorIdent="Red";estado=true; }

                     if(!Dato[1].matches("[a-z]*")){colorNomb="Red";estado=true;} 

                        texto=texto+"<tr><td bgcolor='"+colorIdent+"' >"+Dato[0]+"</td>" +"<td bgcolor='"+colorNomb+"'>"+Dato[1]+"</td>"+"<td>"+Dato[2]+"</td>"+"<td>"+Dato[3]+"</td>"+"<td>"+Dato[4]+"</td>";
                     }
                   bf.close();
                               Grardar_Archivo_Plano(Direccion);
                            

        }catch(Exception e){System.out.println("No se encontro el archivo");}
      return texto;
    }// fin de la funcion 

    
    
    //funcion guardar archivo plano
    
  
    public   void  Grardar_Archivo_Plano( String Direccion){
     
            ArrayList<Soldado_EN> Lista_Soldados = new ArrayList<Soldado_EN>(); 
              ArrayList<Cuenta_EN> Lista_Cuentas = new ArrayList<Cuenta_EN>();
    try{
            BufferedReader bf = new BufferedReader(new FileReader(Direccion));
            String bfRead;
            while ((bfRead=bf.readLine())!= null)
                    {
                        String Dato[] = bfRead.split(",");
                        Sold_EN = new Soldado_EN();
                        Sold_EN.setIdent_Sold(Long.parseLong(Dato[0])); 
                        Sold_EN.setNombres(Dato[1]);
                        Sold_EN.setGrado(Dato[2]);
                        Sold_EN.setNovedad(Integer.parseInt(Dato[3]));
                        Sold_EN.setCompania(Integer.parseInt(Dato[4]));
                        Lista_Soldados.add(Sold_EN); 
                        Sold_EN = null;
                        
                        
                        Cta_EN = new Cuenta_EN();
                        Cta_EN.setSoldado(Long.parseLong(Dato[0]));  
                        Cta_EN.setNum_Cuenta(Dato[5]);
                        Cta_EN.setHabiltado(true);
                        Cta_EN.setBanco(6);
                        
                        Lista_Cuentas.add(Cta_EN);
                        Cta_EN=null;
                                 
                     }
                   bf.close();
                Sold_AD.Regitrar_Lista_Soldados(Lista_Soldados);
                Cta_AD.Regitrar_Lista_Cuentas(Lista_Cuentas);
                
                
                 
        }catch(Exception e){System.out.println("No se encontro el archivo");}
     
    }

    
}// fin de la clase




                        //return Lista_Soldados; 
                     
                    //    if (Comunes.isNumeric(Dato[0]) == true ) { }
                       
                            // Sold_EN.setIdent_Sold(Dato[0]);  