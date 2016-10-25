/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abastecimiento;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica_Negocio.Consolidado_LN;
import Entidad_Negocio.Consolidado_EN;
import Logica_Negocio.Planilla_LN;
import Logica_Negocio.Planilla_Soldado_LN;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author WILSON
 */
public class Consolidado extends HttpServlet {

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
        processRequest(request, response);
        
        
        
         response.setContentType("text/html;charset=UTF-8");
     
          PrintWriter out = response.getWriter();
          
          
          
          if(request.getParameter ("Buscar_Existencia_Codigo_Consolidado") !=null )
                {   
                       Consolidado_LN Cons_LN = new Consolidado_LN();
                       long cod_Unidad = Long.parseLong(request.getParameter ("Cod_Unidad"));
                       
                       try{
                       ResultSet Res1=  Cons_LN.Buscar_Existencia_Codigo_Consolidado(cod_Unidad);;
                                 while(Res1.next()){
                                                   out.println(Res1.getString("Id_Consolidado"));
                                                   }
                       }catch(Exception e){}
                    
                }
          
          
          if(request.getParameter ("Generar_Codigo_Consolidado") !=null )
                {
                         Consolidado_LN Cons_LN = new Consolidado_LN();
                         Consolidado_EN Cons_EN = new Consolidado_EN();
                    try{
                        long cod_Unidad = Long.parseLong(request.getParameter ("Cod_Unidad"));
                         Date fechaActual = new Date();
                         DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                         
                         
                        Cons_EN.setUnidad(cod_Unidad);
                        Cons_EN.setEstado_Cons("Borrador");
                        Cons_EN.setFecha_Cons(formatoFecha.format(fechaActual).toString());
                        
                        if(Cons_LN.Generar_Codigo_Consolidado(Cons_EN))
                        
                                {  out.println("CODIGO GENERADO"); 

                                
                                }
                        else{ out.println("NO SE GENERO EL CODIGO");}
            
                    }catch(Exception e){}
                
         
                } 
          
          
           if(request.getParameter ("Listar_Planillas_Abastecimmiento_Finalizadas") !=null )
                { 
                    Planilla_LN Plan_LN = new Planilla_LN();
                   
                    Integer Unidad= Integer.parseInt(request.getParameter ("Cod_Unidad"));
              
                         try{
                            ResultSet Res= Plan_LN.Listar_Planillas_Abastecimmiento_Finalizada(Unidad);
                            
//\"Id_Planilla\",\"Nomb_Comp\",\"Cod_Planilla\",\"Fecha_Reg\",\"Tipo_Modalidad\",\"Estado_Plan\",\"Valor\",\"Anio_Per\",\"Mes_Per\"     
                            out.println("'<div class='container'><div class='row'><hr><div class='col-md-10 col-md-offset-1'><div class='panel panel-default panel-info'><div class='panel-heading'><h4><center>BANDEJA DE ENTRADA ABASTECIMIENTOS COMPLETADAS</center></h4></div><table class='table table-hover table-bordered table-condensed >'<tr><td><center><STRONG>ID</STRONG></center></td><td><center><STRONG>FECHA</STRONG></center></td><td><center><STRONG>COMPAÑIA</STRONG></center></td><td><center><STRONG>CARGO AL MES</STRONG></center></td><td><center><STRONG>ESTADO</STRONG></center></td><td><STRONG>AGREGAR</STRONG></td></tr></div></div></div></div></div>");  
                            int j=0;
                    while(Res.next())
                                {
                                    j++;
                                    out.println("<tr><td>"
                                    +j+"</td><td align='center'>"+ Res.getString("Fecha_Reg")
                                 
                                    +"</td><td align='center'>"+Res.getString("Nomb_Comp")+"</td>"
                                    +"<td align='center'>"+Res.getString("Mes_Per")+" "+Res.getString("Anio_Per") +"</td>"+"</td>" 
                                    +"<td align='center'>"+Res.getString("Estado_Plan")+"</td>"+"</td>" 
                                   
                                    + "<td><A href=\"javascript:Asignar_Planilla_Consolidado('"+Res.getString("Id_Planilla")+"');\"><img src='../../Iconos/mas.png'  width='25' height='25' /> </A></td></tr>");
                                
                                }
            
                        out.println("</td></tr></table></center>");  
            
                        }catch(Exception e){out.println("error");  }
                  
                    
                }
          
 
 
          
   if(request.getParameter ("Listar_Consolidado_Planilla") !=null )
         {  
            
          
             
            DecimalFormat formatter = new DecimalFormat("###,###.##");   
             
            try{
           Planilla_Soldado_LN Plan_Sold_LN = new Planilla_Soldado_LN();
          out.println(request.getParameter ("Cod_Plan"));
          ResultSet Rs8 =Plan_Sold_LN.Listar_Total_Soldados_Estancia(request.getParameter ("Id_Planilla"));
          out.println("<center><table border='1' ><tr><td>DETALLE</td><td>SL</td><td>DIAS</td><td>V. ESTANCIA</td><td>V/TOTAL</td></tr>"    );
         
          float Total_Abast=0;
         double Total_Fresco_40=0;
         double Total_Secos_60=0;
         float   Estancia_Abast=0;
         Integer Cant_Sold_Abast=0;
         Integer Dias_Abast=0;
      
         Integer Cant_Sold_racio=0;
         Integer Dias_racio=0;
          float Total_Racio=0;
     
         while(Rs8.next()){
      
           if(Rs8.getString("Tipo_Ciclo").compareTo("Abastecimiento")==0){
           
             Estancia_Abast= Float.parseFloat(Rs8.getString("Estancia"));
             Cant_Sold_Abast= Cant_Sold_Abast+ Integer.parseInt(Rs8.getString("Sold"));
             Dias_Abast=  Dias_Abast+Integer.parseInt(Rs8.getString("Numb_Dias"));
             
             Total_Abast=  Cant_Sold_Abast*Estancia_Abast *Dias_Abast;      
            
                                                                        }
             Total_Secos_60=(Total_Abast*0.60);
             Total_Fresco_40= (Total_Abast*0.40);
               
           if(Rs8.getString("Tipo_Ciclo").compareTo("Raciones")==0)
           {
                 Estancia_Abast= Float.parseFloat(Rs8.getString("Estancia"));
                Cant_Sold_racio= Cant_Sold_racio+ Integer.parseInt(Rs8.getString("Sold"));
                Dias_racio=  Dias_racio+ Integer.parseInt(Rs8.getString("Numb_Dias"));
                Total_Racio=  Cant_Sold_racio*Estancia_Abast *Dias_racio;                                                   }
                  
         }  
         
         
             out.println("<tr><td>SOLDADOS ABASTECIDOS</td><td>"+Cant_Sold_Abast+"</td><td>"+Dias_Abast+"</td><td>"+ formatter.format(Estancia_Abast) +"</td><td>"+ formatter.format(Total_Abast)  );
             out.println("<tr><td>TOTAL </td><td>"+ Cant_Sold_Abast+"</td><td></td><td></td><td>"+ formatter.format(Total_Abast) +"</td></tr>");  
             out.println("<tr><td colspan='4'>VIVERES SECOS</td><td > <input type='text' id='Total_Secos_60' value='"+Total_Secos_60+"'  name='Total_Secos_60' readonly></td>");
             out.println("<tr><td colspan='4'>VIVERES FRESCOS</td><td ><input type='text' id='Total_Fresco_40' value='"+Total_Fresco_40+"'  name='Total_Secos_60' readonly></td>");
         
             out.println("<tr><td>RACIONES DE CAMPAÑA</td><td>"+Cant_Sold_racio+"</td><td>"+Dias_racio+"</td><td>"+ formatter.format(Estancia_Abast) +"</td><td>"+ formatter.format(Total_Racio)  );
      
             out.println("</tr></table></center>");  
         
        }catch(Exception e){ out.println("Error de Parametro");}
  
        
        
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
