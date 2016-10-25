/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidad_Negocio.Ciclo_EN;
import Logica_Negocio.Ciclo_LN;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author WILSON
 */
public class Ciclos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     Ciclo_EN Cic_EN = new Ciclo_EN();
     Ciclo_LN Cic_LN = new Ciclo_LN();
    
    
    
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
        response.setContentType("text/html;charset=UTF-8");
    
   

        
        

if(request.getParameter ("Btn_Crear_Cic") !=null )
              {
     
                 //SimpleDateFormat formato_Fecha = new SimpleDateFormat("yyyy-MM-dd");
                  
                  try{
             
                  Cic_EN.setPlanilla(Integer.parseInt(request.getParameter ("Id_Pla")));
                  Cic_EN.setFech_Inicio(request.getParameter ("fecha_inic"));
                  Cic_EN.setFech_Fin(request.getParameter ("fecha_inic"));
                   Cic_EN.setTipo_Ciclo(request.getParameter ("Tipo_Ciclo"));
                  Cic_EN.setNumb_Dias(Integer.parseInt(request.getParameter ("Num_Dias")));
                  
                 if(Cic_LN.Regisrtar_Cilco(Cic_EN)){
                            out.println("SE REGISTRO EL CICLO CON EXITO");
                 }
                 else{ out.println("NO SE REGISTRO EL CICLO");}
                  
                  }catch(Exception e){out.println(e.getMessage());}
               
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
