/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devolucion;

import Entidad_Negocio.Planilla_EN;
import Logica_Negocio.Estancia_LN;
import Logica_Negocio.Planilla_LN;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
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
public class Devolucion extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
     Planilla_LN Plan_LN = new Planilla_LN();
    Planilla_EN Plan_EN = new Planilla_EN(); 
     Estancia_LN Est_LN = new Estancia_LN();    
        
  if(request.getParameter ("Crear_Planilla") !=null )
     {
         
     /*
         Crear_Planilla : "Crear_Planilla",
                         Periodo : Periodo,
                         Tipo_Planilla : Tipo_Planilla,
                         Cod_Unidad : Cod_Unidad
         */
        
         
         Date fechaActual = new Date();
         DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
         
         try{
             
         Plan_EN.setCod_Planilla(0);
         
        
         Plan_EN.setTipo_Modalidad(Integer.parseInt(request.getParameter("Tipo_Planilla")));
         Plan_EN.setEstado_Plan("Borrador");
         Plan_EN.setEstancia(Est_LN.Listar_Estancia_Activa().getId_Estancia());
         Plan_EN.setUnidad(Integer.parseInt(request.getParameter("Cod_Unidad")));
         Plan_EN.setFecha_Reg(formatoFecha.format(fechaActual).toString());
         Plan_EN.setPeriodo(Integer.parseInt(request.getParameter("Periodo")));
  
         
        if(Plan_LN.Crear_Planilla_Devolucion(Plan_EN))
           {
                out.println("PLANILLA REGISTRADA CON EXIO");
              }else{out.println("NO SE REGISTRO LA PLANILLA");}
        
         }catch(Exception e){
             
            out.println(" ERROR AL GUARDAR"+e.getMessage());
         
         }
         
   
     }// Fin del boton Crear
       
        
        
        
        
        
        
        
        
        
         if(request.getParameter ("Eliminar_Planilla_Devolucion") !=null )
                    {
                 
                       
                       if (Plan_LN.Elimminar_Planilla(Integer.parseInt(request.getParameter("Id_Planilla")))){
                            out.println("PLANILLA DE DEVOLUCION ELIMINADA");
                       }else{   out.println("NO SE ELIMINO LA PLANILLA DE DEVOLUCION");}
                    
                      
                      
                    }
        
        
         if(request.getParameter ("Lista_Planillas_Devolucion") !=null )
                    {
                    

            try{
                 ResultSet Res= Plan_LN.Listar_Planillas_Devolucion_Borrador( Integer.parseInt(request.getParameter ("Cod_Unidad")));
   
                    out.println("'<div class='container'><div class='row' align='center'<div class='col-md-9 col-md-offset-2'><div class='panel panel-default panel-info'><div class='panel-heading'><h4><center>BANDEJA DE ENTRADA DEVOLUCIONES</center></h4></div><table class='table table-hover table-bordered table-condensed >'<tr><td><center><STRONG>ID</STRONG></center></td><td><center><STRONG>FECHA</STRONG></center></td><td><center><STRONG>GRADO</STRONG></center></td><td><center><STRONG>CARGO AL MES</STRONG></center></td><td><center><STRONG>ESTADO</STRONG></center></td><td><center><STRONG>CONFIGURAR</STRONG></center></td><td><STRONG>ELIMINAR</STRONG></td></tr></div></div></div></div></div>");  
                    int j=0;
                     while(Res.next()){
                                        j++;
                
                    //\"Id_Planilla\",\"Cod_Planilla\",\"Fecha_Reg\",\"Tipo_Modalidad\",\"Estado_Plan\",\"Valor\",\"Anio_Per\",\"Mes_Per\" 
                               out.println("<tr><td>"  +j+"</td><td align='center'>"+ Res.getString("Fecha_Reg")
                           +"</td><td align='center'>"+Res.getString("Nomb_Tipo_Mod")+"</td>"
                             +"<td align='center'>"+Res.getString("Mes_Per")+" "+Res.getString("Anio_Per") +"</td>"+"</td>" 
                            +"<td align='center'>"+Res.getString("Estado_Plan")+"</td>"+"</td>" 
                            +"<td align='center'><A href='Devolucion.jsp?Tipo_Modalidad="+Res.getString("Id_Tipo_Mod")+"&"+"Cod_Plan="+Res.getString("Id_Planilla")+"'>Modificar</A></td>"+"</td>"
                              // +"<td><A href='Devolucion.jsp?Id_planilla="+ Res.getString("Id_Planilla")+"'><CENTER><img src='../../Iconos/eliminar.png'/></CENTER></A></td></tr>");   
                              +"<td><A href=\"javascript:Eliminar_Planilla_devolucion('"+Res.getString("Id_Planilla")+"');\"><img src='../../Iconos/eliminar.png'  /></CENTER> </A></td></tr>");
                     
                     
                     }
            
                             out.println("</td></tr></table></center>");  
            
                        }catch(Exception e){out.println("error");  }

       
        
         
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
