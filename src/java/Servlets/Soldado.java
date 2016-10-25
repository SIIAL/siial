/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica_Negocio.Soldado_LN;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WILSON
 */
public class Soldado extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request, response);
          PrintWriter out = response.getWriter();
        


            out.println("<center><br><table border='1' >");
            out.println("<tr><td colspan='7' align='center'><b>LISTA DE SOLDADOS DE LA UNIDAD</b></td>");
            out.println("<tr><tr><td>Id</td><td>Grado</td></td><td>Apellidos Nombres</td><td>Identificación</td>");
                
                     
                 try{   
                 
                     Soldado_LN Sold_LN =  new Soldado_LN();
                     String Cod_Unidad= request.getParameter ("Cod_Unidad");
                      String Cod_Planilla= request.getParameter ("Cod_Unidad");
                     ResultSet Res3= Sold_LN.Listar_Soldados_Unidad(Long.parseLong(Cod_Unidad),17);
                    int j=0;
                    //"Ident_Sold","Nombres","Apellidos","Nomb_Novedad","Nomb_Comp","Codigo_Comp","Grado"  
                     while(Res3.next()){
                         j++;
                       out.println("<tr><td>"+j+"</td><td>"+Res3.getString("Grado")+"</td>  <td>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"</td><td>"+Res3.getString("Ident_Sold")+"</td><td><input  id='list_soldados' type='checkbox' value="+Res3.getString("Ident_Sold")+" /></td><td>"+Res3.getString("Ident_Sold")+"</td> </tr>" ); 
                                   }
                
                    } catch(Exception e){}
                  
                        out.println("  </table>");
                       
        
        
        
        
        
        
        
        
        
        
        
        
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
