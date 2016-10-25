/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comida_Caliente;

import Entidad_Negocio.Ciclo_EN;
import Entidad_Negocio.Estancia_EN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica_Negocio.Planilla_LN;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import Entidad_Negocio.Planilla_EN;
import Logica_Negocio.Ciclo_LN;
import Logica_Negocio.Estancia_LN;

/**
 *
 * @author WILSON
 */
public class Comida_Caliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //
        
         response.setContentType("text/html;charset=UTF-8");
     
          PrintWriter out = response.getWriter();
          
          
          
          
          if(request.getParameter ("Buscar_Existencia_Activa_Comida_Caliente") !=null )
                { 
                    
                    out.println("Existencia activa");
                } 
          
          
          
        if(request.getParameter ("Crear_Planilla_Comida_Caliente") !=null )
                {  
                  
                    Date fechaActual = new Date();
                    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    Planilla_LN Plan_LN = new Planilla_LN();
                    Planilla_EN Plan_EN = new Planilla_EN(); 
                    Estancia_LN Est_LN = new Estancia_LN();
                    
                    Ciclo_EN Cic_EN = new Ciclo_EN();
                    Ciclo_LN Cic_LN = new Ciclo_LN(); 
                    try{
                    Integer Cod_plan= Integer.parseInt(Plan_LN.Crear_Codigos_Planillas(4));
                     Plan_EN.setCod_Planilla(Cod_plan);
                    Plan_EN.setTipo_Modalidad(4);
                    Plan_EN.setEstado_Plan("Borrador");
                    Plan_EN.setEstancia(Est_LN.Listar_Estancia_Activa().getId_Estancia());
                    Plan_EN.setUnidad(Integer.parseInt(request.getParameter("Cod_Unidad")));
                    Plan_EN.setFecha_Reg(formatoFecha.format(fechaActual).toString());
                    Plan_EN.setPeriodo(2);
                    
                     if(Plan_LN.Crear_Planilla_Devolucion(Plan_EN))
                        {
                       
                        Cic_EN.setPlanilla(Cod_plan);
                        Cic_EN.setFech_Inicio(Plan_EN.getFecha_Reg());
                        Cic_EN.setFech_Fin(Plan_EN.getFecha_Reg());
                        Cic_EN.setTipo_Ciclo("Comida_Caliente");
                        Cic_EN.setNumb_Dias(1);
                          if(Cic_LN.Regisrtar_Cilco(Cic_EN)){
                              out.println("PLANILLA CREADA CON EXITO");
                          }
                          else{out.println("NO SE CREO EL CICLO");}
   
                            
                            
                            
                          //  out.println("PLANILLA REGISTRADA CON EXIO");
                        }else{out.println("NO SE REGISTRO LA PLANILLA");}
                    
                    
                    
                    }
                   catch(Exception e){}
                    
                                                     
                   
                }
                   
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
