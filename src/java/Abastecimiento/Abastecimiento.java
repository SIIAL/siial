/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abastecimiento;

import Entidad_Negocio.Planilla_EN;
import Logica_Negocio.Estancia_LN;
import Logica_Negocio.Planilla_LN;
import Logica_Negocio.Planilla_Soldado_LN;
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
public class Abastecimiento extends HttpServlet {

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
        
         response.setContentType("text/html;charset=UTF-8");
       
        PrintWriter out = response.getWriter();
        
          
        Planilla_LN Plan_LN = new Planilla_LN();
        Planilla_EN Plan_EN = new Planilla_EN();
        Estancia_LN Est_LN = new Estancia_LN();
        
        
  if(request.getParameter ("Registrar_Abastecimiento") !=null )
     {
         
     /*
          Cod_Compania : Cod_Compania,
                              Periodo : Periodo,
                              Registrar_Abastecimiento : "Registrar_Abastecimiento"
         */
       
         
         
         Date fechaActual = new Date();
         DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
         
         try{
             
         Plan_EN.setCod_Planilla(0);
         Plan_EN.setTipo_Modalidad(1);
         Plan_EN.setEstado_Plan("Borrador");
         Plan_EN.setEstancia(Est_LN.Listar_Estancia_Activa().getId_Estancia());
         Plan_EN.setCompania(Integer.parseInt(request.getParameter("Cod_Compania")));
         Plan_EN.setFecha_Reg(formatoFecha.format(fechaActual).toString());
         Plan_EN.setPeriodo(Integer.parseInt(request.getParameter("Periodo")));
      
        if(Plan_LN.Crear_Planilla_Abastecimiento(Plan_EN))
                {
                out.println("PLANILA REGISTRADA");
                    }
        else{   out.println("NO SE REGISTRO LA PLANILA"); }
                }catch(Exception e){
             
        out.println("NO SE REGISTRO LA PLANILA SELECCIINES LOS DATOS :"+e.getMessage());
         
         }
         
   
     }// Fin del boton Crear
       

        /*
        Finalizar_Planilla : "Finalizar_Planilla",
                          Id_Planilla : Id_Planilla
  */
  
  if(request.getParameter ("Finalizar_Planilla") !=null )
            
             {
               
                
                 Integer id_planilla= Integer.parseInt(request.getParameter ("Id_Planilla"));
       
                
                 if (Plan_LN.Actualizar_Estado_Planilla(id_planilla)){
                     out.println("PLANILLA COMPLETADA");
                 }
                 else{out.println("NO SE HA COMPLETADO LA PLANILLA");}
                
             }
        
        
         if(request.getParameter ("Elimina_Planilla_Abastecimiento") !=null )
            
             {
                  out.println("SDDSADSD");
                 
               /*  
                 
                  Integer id_planilla= Integer.parseInt(request.getParameter ("id_planilla"));
       
                 
                  
                  if(Plan_LN.Elimminar_Planilla(id_planilla))
                  {
                      out.println("PLANILLA ELIMINADA");
                  }else{
                   out.println("LA PLANILLA NO SE  ELIMINO");
                  }
                  */
            
             }
        

         
         
         if(request.getParameter ("Listar_Totales_Planilla") !=null )
            //"Id_Planilla","Secos","Frescos","Sl_Abas","Dias_Abas","Val_Estancia","Sl_Rac","Dias_Rac" 
                {
          
                     Integer Id_Planilla= Integer.parseInt(request.getParameter ("Id_Planilla"));
              
                         try{
                            ResultSet Res= Plan_LN.Listar_Totales_Panillas(Id_Planilla);
               
                            out.println("<center><h4><center>TOTALES DE LA PLANILLA   </center></h4>"
                                    + "<table class='table table-hover table-bordered table-condensed >'<tr><td>DETALLE</td><td><center><STRONG>SL ABAST.</STRONG></center></td><td><center><STRONG>Nº. DIAS</STRONG></td><td><center><STRONG>ESTANCIA</STRONG></center></td><td><center><STRONG>TOTAL</STRONG></center></td> </tr></div></div></div></div></div>");  
                           
                    while(Res.next())
                                {
                                 
                                    out.println("<tr><TD>SOLDADOS ABASTECIDOS :<TD align='center' >"+Res.getString("Sl_Abas")+"</td>" 
                                           
                                          +"<td align='center'>"+Res.getString("Dias_Abas")+"</td>"+"</td>"    
                                          +"<td align='center'>"+Res.getString("Val_Estancia")+"</td>"+"</td>"
                                
                                          +"<TR><TD>RACION DE CAMPAÑA</TD><td align='center'>"+Res.getString("Sl_Rac")+"</td>"+"</td>"
                                           +"<td align='center'>"+Res.getString("Dias_Rac")+"</td>"
                                       + "<TR><td>TOTAL VIVRES SECOS</TD><TD colspan='3'><td>"+Res.getString("Secos")+"</td>"
                                          +"<TR></td><td>TOTAL VIVERES FRESCOS</TD><TD colspan='3'><TD>"+ Res.getString("Frescos")+"</td>"); 
                                    
                                    
                                   
                                 
                                }
            
                          
                      out.println("<TR><td colspan='5' align='center'><A href=\"javascript:Fin_Planilla_Abastecimiento('"+Id_Planilla+"');\" class=\"btn btn-info\" role=\"button\" >FINALIZAR</A></td></tr>");
                  
                      out.println("</div></div>" );  
                       
                             
                  
                              
            
                        }catch(Exception e){out.println("error");  }
                  
                    
                }
         
         
         
        if(request.getParameter ("Listar_Planillas_Abast_Borra") !=null )
            
                {
                    
                    
 
                    Integer Unidad= Integer.parseInt(request.getParameter ("Cod_Unidad"));
              
                         try{
                            ResultSet Res= Plan_LN.Listar_Planillas_Abastecimmiento_Borrador_Completado(Unidad);
                            out.println("'<div class='container'><div class='row'><hr><div class='col-md-10 col-md-offset-1'><div class='panel panel-default panel-info'><div class='panel-heading'><h4><center>BANDEJA DE ENTRADA ABASTECIMIENTOS </center></h4></div><table class='table table-hover table-bordered table-condensed >'<tr><td><center><STRONG>Nº.</STRONG></center></td><td><center><STRONG>FECHA</STRONG></center></td><td><center><STRONG>COMPAÑIA</STRONG></center></td><td><center><STRONG>CARGO AL MES</STRONG></center></td><td colspan='2'><center><STRONG>ESTADO</STRONG></center></td><td align='center'><STRONG>ELIMINAR</STRONG></td></tr></div></div></div></div></div>");  
                            int j=0;
                    while(Res.next())
                                {
                                    j++;
                                    out.println("<tr><td align='center'>"
                                    +j+"</td><td align='center'>"+ Res.getString("Fecha_Reg")
                                 
                                    +"</td><td align='center'>"+Res.getString("Nomb_Comp")+"</td>"
                                    +"<td align='center'>"+Res.getString("Mes_Per")+" "+Res.getString("Anio_Per") +"</td>"+"</td>"); 
                                     
                                   
                                      out.println("<td align='center'><A href='Abastecimiento.jsp?Cod_Plan="+Res.getString("Id_Planilla")+"'\" class=\"btn btn-default\" role=\"button\" >Modificar</A></td>");
                                      
                                      out.println("<td align='center'><A href=\"javascript:Finalizar_Planilla_Abastecimiento('"+Res.getString("Id_Planilla")+"');\" class=\"btn btn-default\" role=\"button\" >Finalizar</A></td>");
                                       
                                    
                                 
                                    out.println("<td align='center'><A href=\"javascript:Elimina_Planilla_Abastecimiento('"+Res.getString("Id_Planilla")+"');\"><img src='../../Iconos/eliminar.png'/> </A></td></tr>");
                             
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
