/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Entidad_Negocio.Ciclo_EN;
import Logica_Negocio.Ciclo_LN;
//import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WILSON
 */
public class Listar_Ciclos extends HttpServlet {

   Ciclo_EN Cic_EN = new Ciclo_EN();
   Ciclo_LN Cic_LN = new Ciclo_LN();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
         response.setContentType("application/json;charset=UTF-8");
        //  response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       
        
        if(request.getParameter ("Listar_Ciclo_Planilla") !=null )
              {

                  //\"Fech_Inicio\",\"Fech_Fin\",\"Numb_Dias\",\"Tipo_Ciclo\"
                                     
                       
  try{   
                            /*
                            
                            Integer Id_Plan= Integer.parseInt(request.getParameter ("Id_Pla"));
                            
                            Gson gson= new Gson();
                            PrintWriter pw=response.getWriter();
                            pw.println( gson.toJson(Cic_LN.Listar_Ciclos_Planilla(Id_Plan)));
                             pw.close(); 
                             
                             */
                            
                            
                            }           catch(Exception e){  out.println(e.getMessage());}
                 
                      
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
