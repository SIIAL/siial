/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Devolucion;

import Entidad_Negocio.Ciclo_EN;
import Entidad_Negocio.Soldado_EN;
import Logica_Negocio.Ciclo_LN;
import Logica_Negocio.Planilla_LN;
import Logica_Negocio.Planilla_Soldado_LN;
import Logica_Negocio.Soldado_LN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
/**
 *
 * @author WILSON
 */
public class Configurar_Devolucion extends HttpServlet {

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
         //
          response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
               
           if(request.getParameter ("Listar_Ciclos") !=null )
                    {
                      // out.println("Hola");  
                                                Ciclo_EN Cicl_EN= new Ciclo_EN();
                                                Ciclo_LN Cicl_LN = new Ciclo_LN();
                                                
                          Integer Cod_Planilla= Integer.parseInt( request.getParameter ("id_Planilla") );              
                          Gson gson= new Gson();
                          PrintWriter pw=response.getWriter();
                          pw.println(gson.toJson(Cicl_LN.Listar_Ciclos_Planilla(Cod_Planilla)));
                          pw.close();                        
          
                    }
       
     
           
           
           
           
           
        
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
     
         
        
          
          
            if(request.getParameter ("Retirar_Soldado_Planilla") !=null )
              {
                  
                /*
                  Ciclo : Ciclo,
                        Iden_Sold : Iden_Sold
                  */  
                  
              Planilla_Soldado_LN  Plan_Sold_LN= new Planilla_Soldado_LN();
            if(Plan_Sold_LN.Desvincular_Soldados_Planilla(Integer.parseInt(request.getParameter ("Iden_Sold")),Integer.parseInt(request.getParameter ("Ciclo")) ))
                {
                 out.println("SOLDADO RETIRADO DE  LA PLANILLA");
                }else{out.println("NO SE RETIRO EL SOLDADO DE LA PLANILLA");}
              }
          
          
          
          if(request.getParameter ("Lista_Solados_Planilla") !=null )
              {
                  
                  
                  
             // Integer Cod_Planilla = Integer.parseInt(request.getParameter ("Cod_Planilla"));
             // Integer Cod_Unidad = Integer.parseInt(request.getParameter ("Cod_Unidad"));
              
                  
          out.println("<table  class='table table-bordered' style='font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif' align='top' bgcolor='#F4F4F4'>");
          out.println("<thead><td colspan='7' align='center'><b>LISTA DE SOLDADOS DE LA UNIDAD A ABASTECER</b></td>");
          out.println("</thead>");
          out.println("<tr>");
          out.println("<td align='center'><b>Nº</b></td>");
          out.println("<td align='center'><b>Grado</b></td>");
          out.println("<td align='center'><b>Apellidos Nombres</b></td>");
          out.println("<td align='center'><b>Identificación</b></td>");
          out.println("<td align='center'><b>#.Dias</b>");
          out.println("<td align='center'><b>Fecha Inicio</b></td>");
          out.println("<td align='center'><b>Fecha Terminación</b></td>");
          out.println("</tr>");
           out.println("<tr>");
                          

          try{   
         Integer Cod_Planilla= Integer.parseInt(request.getParameter ("Cod_Planilla"));
              
              
           Planilla_Soldado_LN  Plan_Sold_LN= new Planilla_Soldado_LN();
            ResultSet Res3= Plan_Sold_LN.Listar_Soldados_Planilla(Cod_Planilla);
            int j=0;
            while(Res3.next()){
            j++;
            out.println("<tr><td align='center'>"+j+"</td><td align='center'>"+Res3.getString("Grado")+"</td><td align='center'>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"</td><td align='center'>"+Res3.getString("Ident_Sold")+"</td><td align='center'>"+Res3.getString("Numb_Dias")+"</td><td align='center'>"+Res3.getString("Fech_Inicio")+"</td><td align='center'>"+Res3.getString("Fech_Fin")+"</td><td align='center'>"
                          
                        + "<A href=\"javascript:Retirar_Soldado_Planilla('"+Res3.getString("Id_Ciclo")+"','"+Res3.getString("Ident_Sold")+"');\"><img src='../../Iconos/eliminar.png'/> </A>");
                                              
            }
          }catch(Exception e){}

                out.println("</tr>"); 
                out.println("</table>");
         
              }
          
          
          
          
          
          
          if(request.getParameter ("Lista_Solados_Activos") !=null )
              {
             
                 out.println("<br><br><table class='table table-bordered' style='font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif' align='top' bgcolor='#F4F4F4'>");
                 
                 out.println("<tr>");
                 out.println("<td colspan='4'><center> <b>LISTA DE SOLDADOS DE LA UNIDAD</b> </td>  </tr>");       
                 out.println("<tr>");             
          
                out.println("<td align='center'><b>Nº</b></td>");
                out.println("<td><center><b>Grado</b></center></td>");                  
                out.println("<td><center><b>Apellidos Nombres</b></center></td>");                
                out.println("<td><center><b>Identificación</b></center></td> ");
                out.println(" <td><center><b>[_]</b></center></td>");                  
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");        
                out.println("<tr>");        
                           
                                     
                                                            // Cod_Unidad : Cod_Unidad,
                                                            //        id_planilla : id_planilla,
                
                
                                     try{   
                                       Soldado_EN Sold_EN= new Soldado_EN();
                                       Soldado_LN Sold_LN = new Soldado_LN();
                                       ResultSet Res3= Sold_LN.Listar_Soldados_Unidad(Long.parseLong(request.getParameter ("Cod_Unidad") ),Integer.parseInt(request.getParameter ("id_planilla")));
                                       int j=0;
                                       while(Res3.next()){
                                       j++;
                                       out.println("<tr><td>"+j+"</td><td>"+Res3.getString("Grado")+"</td><td>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"<td>" + Res3.getString("Ident_Sold")+"<td>"
                                             
                                               + "<A href=\"javascript:Agregar_Soldado_Planilla('"+Res3.getString("Ident_Sold")+"');\"><img src='../../Iconos/mas.png' width='25' height='25'  /> </A>"
                                               + "</td> " );
                                                                                               }
                                                       } catch(Exception e){}
                                     
                  out.println("</tr>");
                  out.println("</tbody>");
                  out.println("</table>");  
 
              }
          

          
             if(request.getParameter ("Buscar_Existencia_Modalidad_Soldado_Periodo") !=null )
                        {
                     
                            
                         
                            ResultSet Rs =null;
                            Planilla_LN Plan_LN = new Planilla_LN();
                            String Ident =  request.getParameter ("Ident_Sold");
                            String Id_Cilco=  request.getParameter ("Ciclo");
                                    
                                    
                                 // out.println(Id_Cilco);
                            Rs= Plan_LN.Buscar_Existencia_Modalidad_Soldado_Periodo(Ident,Id_Cilco);
                            
                    
                      
                        try{
                            
                            if (!Rs.next()) {                            //if rs.next() returns false
                                            
                           out.println("1");
                            // out.println("NO TIENE ASIGNADO ABASTECMIENTO EN EL LAPSO DE TIEMPO<BR>"); 
                            ///out.println("<A href='javascript:Confirmacion_Guardado_Soldado("+Ident+")' class=\"btn btn-info\" role=\"button\">REGISTRAR </A>");
                                         
                                    }
                            else {
                                
                                        out.println("<center><table border='1'>"); 
                                        out.println("<tr>");
                                        out.println("<td>");    
                                        out.println("<thead><td colspan='6' align='center' ><b>HISTORIAL DEL SOLDADO</b></td> ");
                                        out.println("</thead>");
                                        out.println("<tbody>");
                                        out.println("<tr width=\'250\'>");
                                        out.println("<td align=\'center\'><b>NOMBRES</b></td>");
                                        out.println("<td align=\'center\'><b>DIAS</b></td>");
                                        out.println("<td align=\'center\'><b>FECHA INICIO</b></td>");  
                                        out.println("<td align=\'center\'><b>FECHA FIN</b></td>");
                                        out.println("<td align='center'><b>MODALIDAD</b></td> ");                   
                                        out.println(" </tr> <tr><td> "); 
                                    do {
                                        
                                         out.println("<tr><td>"+Rs.getString("Apellidos")+" "+Rs.getString("Nombres")+"</td>" );
                                         out.println("<td>"+Rs.getString("Numb_Dias")+"</td>" );
                                         out.println("<td>"+Rs.getString("Fech_Inicio")+"</td>" );
                                         out.println("<td>"+Rs.getString("Fech_Fin")+"</td>" );
                                         out.println("<td>"+Rs.getString("Tipo_Ciclo")+"</td>" );
                                        } while (Rs.next());
                                    
                                        out.println(" </td></tr></TABLE><br><br>");  
                                         out.println("<A href='javascript:Confirmacion_Guardado_Soldado("+Ident+")' class=\"btn btn-info\" role=\"button\">REGISTRAR </A>");
                                         out.println("<A href='javascript:Cancelar_Guardado_Soldado()' class=\"btn btn-info\" role=\"button\">CANCELAR </A>");
                       
                                }
                   
                            }  catch(Exception e){  out.println("error");}
                        
                        }          
          
          
          
          
          
          
          
          
           if(request.getParameter ("Agregar_Soldado_Planilla") !=null )
                        {
              
                            /*
                            
                             ident_Sold : ident_Sold,
                             Ciclo : Ciclo,
                            */
                            try{
                            Planilla_Soldado_LN Plan_Sold_LN= new Planilla_Soldado_LN();
                            Integer  ident_Sold= Integer.parseInt(request.getParameter("ident_Sold").toString());
                            Integer  Ciclo= Integer.parseInt(request.getParameter("Ciclo").toString());
                 
                            
                           if(Plan_Sold_LN.Registrar_Soldados_Planilla(ident_Sold,Ciclo))
                                {
                                  out.println("SOLDADO ASIGNADO A LA PLANILLA");
                                }
                           else{ out.println("NO SE ASIGNO SOLDADO A LA PLANILLA");}
                            }catch(Exception e){ out.println("SELECCIONE UN CICLO");}
   
                    }
          
          
          
          
          
          
          
          
          
          
              
          if(request.getParameter ("Eliminar_Ciclo_Planilla") !=null )
              {
                   
                  
                
                  try{
                      Ciclo_LN Cicl_LN= new Ciclo_LN();
                             Cicl_LN.Elimminar_Ciclo(Integer.parseInt(request.getParameter ("Id_Ciclo")));
                            
                            }catch(Exception e){}

                       
                  
                  
              }
          
          
          
      
              
              
          if(request.getParameter ("Lista_Ciclos_registrado") !=null )
              {
                  
                 out.println("<center><table border='1'>"); 
                 out.println("<tr>");
                 out.println("<td>");
                       
                out.println("<thead><td colspan='6' align='center' ><b>LISTADOS DE LAPSOS DE TIEMPOS</b></td> ");
                out.println("</thead>");
                out.println("<tbody>");
                out.println("<tr width=\'250\'>");
                out.println("<td align=\'center\'><b>Nº</b></td>");
                out.println("<td align=\'center\'><b>CANT. DIAS</b></td>");
                out.println("<td align=\'center\'><b>DESDE</b></td>");  
                out.println("<td align=\'center\'><b>HASTA</b></td>");
                out.println("<td align='center'><b>Eliminar</b></td> ");                   
                out.println(" </tr> <tr><td> ");                        
              

                                Ciclo_EN Ci_EN= new Ciclo_EN();
                                Ciclo_LN Ci_LN = new Ciclo_LN();
                                int i = 0;
                                for (Ciclo_EN Cicl :  Ci_LN.Listar_Ciclos_Planilla(Integer.parseInt(request.getParameter ("Cod_Planilla"))))
                                       {

                                            i++;
                                            out.println("<tr><td>"+i+"<td align='center'>"+ Cicl.getNumb_Dias() +"</td><td aling='center'>"+Cicl.getFech_Inicio()+"</td><td align='center'> "+Cicl.getFech_Fin()+"</td><td align='center'><A href='javascript:Eliminar_Ciclo_Planilla("+Cicl.getId_Ciclo()+")'><img src='../../Iconos/eliminar.png'  /> </A></td></tr>" );
                                          
                                                                                                                                                                                                                                        
                                        }
                
             
                                
               out.println("  </table></center>");
                             
                  
              }    
              
              
              
              
          
        
if(request.getParameter ("Btn_Agregar_Ciclo") !=null )
              {
                       
                  try{
                    Ciclo_EN Cic_EN = new Ciclo_EN();
                    Ciclo_LN Cic_LN = new Ciclo_LN();  
             
                  Cic_EN.setPlanilla(Integer.parseInt(request.getParameter ("id_Planilla")));
                  Cic_EN.setFech_Inicio(request.getParameter ("fecha_inicio"));
                  Cic_EN.setFech_Fin(request.getParameter ("fecha_fin"));
                  Cic_EN.setTipo_Ciclo("Devolucion");
                  Cic_EN.setNumb_Dias(Integer.parseInt(request.getParameter ("Num_Dias")));
          
                  
                 if(Cic_LN.Regisrtar_Cilco(Cic_EN)){

                      out.println("CICLO REGITRADO");
                 }else{ out.println("NO SE REGISTRO EL CICLO");}

                  }catch(Exception e){out.println("ERROR");}
              }
                    
          
          
         
           if(request.getParameter ("Listar_Periodo") !=null )
                    {
                    try{  
                        
                      Planilla_LN Plan_LN= new Planilla_LN();
                        
                    ResultSet Res_Per=Plan_LN.Buscar_Perido_Planilla(Integer.parseInt(request.getParameter ("Cod_Planilla")));
                 
                   while(Res_Per.next()){
                       
                       out.println(Plan_LN.Calcular_Mes(Res_Per.getString("Mes_Per"))+"-"+Res_Per.getString("Anio_Per"));
                      
                                    }   
                            }catch(Exception e){ } 
         
                    
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
