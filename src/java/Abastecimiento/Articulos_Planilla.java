/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abastecimiento;

import Entidad_Negocio.Planilla_Articulo_EN;
import Entidad_Negocio.Planilla_Soldado_EN;
import Logica_Negocio.Planilla_Articulo_LN;
import Logica_Negocio.Planilla_Soldado_LN;
import Logica_Negocio.Planilla_LN;
import Entidad_Negocio.Planilla_EN;
import Logica_Negocio.Planilla_Articulo_LN;
import Logica_Negocio.Articulo_LN;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WILSON
 */
public class Articulos_Planilla extends HttpServlet {

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
       // response.setContentType("text/html;charset=UTF-8");
        
        
       
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
        
           
                       //\"Nomb_Art\",\"Un_Med\",\"Valor\"
                                            
                       
                    /*   
                        Guardar_Articulo : "Guardar_Articulo",
                              Cantidad : Cantidad,
                               Articulos : Articulos
                       */
                    
                    DecimalFormat formatter = new DecimalFormat("###,###.##"); 
                    
                    
                     if(request.getParameter ("Elim_Art_Plan") !=null )
                        {  
                              Planilla_Articulo_LN Plan_Art_LN= new Planilla_Articulo_LN();   
                          String IdPlanArt= request.getParameter("Id_Art_Plan").toString(); 
                          Plan_Art_LN.Retirar_Articulo_Planilla(Integer.parseInt(IdPlanArt));
                        
                        }
                    
                    
                    
                     if(request.getParameter ("Guardar_Articulo") !=null )
                        {  
                             try{
              
                           Planilla_Articulo_EN Plan_Art_EN = new Planilla_Articulo_EN();
                           Planilla_Articulo_LN Plan_Art_LN = new Planilla_Articulo_LN();                      
                           Plan_Art_EN.setArticulo(Integer.parseInt(request.getParameter("Articulos").toString())); 
                           Plan_Art_EN.setCatidad(Integer.parseInt(request.getParameter("Cantidad").toString()));  
                           Plan_Art_EN.setPlanilla(Integer.parseInt(request.getParameter ("Cod_Plan")));
                          
                           
                                                   
                          ResultSet Res5=    Plan_Art_LN.Consultar_Existencia_Planilla_Articulo(Plan_Art_EN.getPlanilla(),Plan_Art_EN.getArticulo());
                           
                          Res5.next();
                          
                            
                           
                           
                           
                           if(Integer.parseInt(Res5.getString("cant"))==0)
                                        {
                               
                                
                               if(Plan_Art_LN.Registrar_Articulo_Planilla(Plan_Art_EN)){
                               out.println("ARTICULO REGISTRADO CON EXITO");
                               }else{
                               out.println("EL ARTICULO NO SE HA REGISTRADO");
                               }
                               
                            
                            }else{out.println("EL ARTICULO YA SE ENCUENTRA REGISTRADO EN LA PLANILLA");}
                           
                         
                           
                          
                           
                            }catch(Exception Ex){}
                        
                        } 
                    
                       
                     
                 
                            
                           
                               
                   
                     
                     
                     
                       
                    if(request.getParameter ("Listar_Art_Planilla") !=null )
                        {  
                       
                       try{   
                     
                                            Planilla_Articulo_EN Plan_Art_EN = new Planilla_Articulo_EN();
                                            Planilla_Articulo_LN Plan_Art_LN = new Planilla_Articulo_LN();   
                                            ResultSet Res3= Plan_Art_LN.Listar_Articulos_Planilla( Integer.parseInt(request.getParameter ("Cod_Plan")));
                                            int j=0;//
                                            //Cod_Planilla
                                            float Valor_Tot=0;
                                             out.println("<br><center><table class='table table-bordered'>");
                                             
                                       
		
	
                                             
                                             out.println("<tr bgcolor='#F2F2F2'><td colspan='7' align='center'><b>LISTA DE ARTICULOS DE LA PLANILLA</td>");
                                             out.println("<tr><tr><td align='center'><b>N°</b></td><td align='center'><b>ARTICULO</b></td><td align='center'><b>UNIDAD</b></td><td align='center'><b>CANTIDAD</b></td><td align='center'><b>VALOR</b></td> <td align='center'><b>V. TOTAL</b></td><td align='center'><b>ELIMINAR</b></td>");                                           
                                                float Valor;
                                                float VT;
                                                    while(Res3.next()){
                                                            j++;
                                                                     
                                                           Valor= Float.parseFloat(Res3.getString("Valor"));
                                                            VT= Float.parseFloat(Res3.getString("VT"));
                                                            out.println("<tr><td align='center' width='5%'>"+j+"</td><td>"+Res3.getString("Nomb_Art")+"<TD align='center'>"+Res3.getString("Un_Med")+"</TD><TD align='center'>"+Res3.getString("Cantidad")+"</TD><TD align='center'>"+  formatter.format(Valor)+"</TD><td align='right'>"+ formatter.format(VT)+"</td><td>   <A href=\"javascript:Eliminar_Articulo_Planilla('"+Res3.getString("IdPlanArt")+"');\"><center><img  src='../../Iconos/eliminar.png'  /></center> </A>");
                                                           Valor_Tot=   Valor_Tot+ Float.parseFloat(Res3.getString("VT"));
                                                           
                                                             
                                                    }
                                                     out.println("<tr><td colspan='5' aling='center'><b>TOTAL</b></td><TD> <input type='text' style='text-align:right;' id='Total_Planilla_Art' value='"+Valor_Tot  +"'  name='Total_Planilla_Art' readonly> </TD>");
                                                    
                                            } catch(Exception e){}
                                          
                                             out.println("</table></center>");                          
                                             out.println(" </td> </tr>");
                                             out.println("  </table>");
                                             
              }                   
                                             
                                             
                       //  out.println( request.getParameter ("Cod_Plan").toString()  );
        
     
        
        
        
        
      
               
               

          
   if(request.getParameter ("Listar_Consolidado_Planilla") !=null )
                        {  
            
            try{
           Planilla_Soldado_LN Plan_Sold_LN = new Planilla_Soldado_LN();
          out.println(request.getParameter ("Cod_Plan"));
          ResultSet Rs8 =Plan_Sold_LN.Listar_Total_Soldados_Estancia(request.getParameter ("Cod_Plan"));
          out.println("<center><br><table CELLPADDING=2 border='0' width='730px'><tr bgcolor='#F2F2F2'><td align='center'><b>DETALLE</b></td><td align='center'><b>SL</b></td><td align='center'><b>DIAS</b></td><td align='center'><b>V. ESTANCIA</b></td><td align='center'><b>V/TOTAL</b></td></tr>"    );
         
         float Aux_Total_Abast=0;
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
             
               Aux_Total_Abast= Integer.parseInt(Rs8.getString("Numb_Dias"))*Estancia_Abast*Integer.parseInt(Rs8.getString("Sold"));
             Total_Abast=  Total_Abast+Aux_Total_Abast; 
         
                                       
             out.println("<tr><td><b>SOLDADOS ABASTECIDOS</b></td><td align='center'><b>"+ Rs8.getString("Sold") +"</b></td><td align='center'><b>"+Rs8.getString("Numb_Dias")+"</b></td><td align='center'><b>"+Estancia_Abast+"</b></td><td align='right'><b>"+ formatter.format(Aux_Total_Abast) +"</b></td></tr>");  
               
           }
             Total_Secos_60=(Total_Abast*0.60);
             Total_Fresco_40= (Total_Abast*0.40);
             
               
           if(Rs8.getString("Tipo_Ciclo").compareTo("Raciones")==0)
                {
                 Estancia_Abast= Float.parseFloat(Rs8.getString("Estancia"));
                Cant_Sold_racio= Cant_Sold_racio+ Integer.parseInt(Rs8.getString("Sold"));
                Dias_racio=  Dias_racio+ Integer.parseInt(Rs8.getString("Numb_Dias"));
                Total_Racio=  Cant_Sold_racio*Estancia_Abast *Dias_racio;  
               
                }
           
           
                  
                            } 
         
            out.println("<tr><td align='center'><b>TOTAL</b></td><td><center><input  type='text' style='text-align:center;' id='Sl_Abas' value='"+Cant_Sold_Abast+"'  name='Sl_Abas' size='10' readonly></center></td><td><center><input type='text'  style='text-align:center;' id='Dias_Abas' value='"+Dias_Abast+"'  name='Dias_Abas' size='10' readonly></center></td><td><center><input type='text' style='text-align:center;' id='Val_Estancia' value='"+Estancia_Abast+"'  name='Val_Estancia' size='10' readonly></center></td><td align='right'>"+ formatter.format(Total_Abast)  );
           
         
         
            out.println("<tr><td colspan='5'><p> </p></td></tr>");       
             out.println("<tr><td colspan='4'><b>VIVERES SECOS  (60%)</b></td><td align='right'> <input type='text' style='text-align:right;' id='Secos' value='"+Total_Secos_60+"'  name='Secos' size='10' readonly></td>");
             out.println("<tr><td colspan='4'><b>VIVERES FRESCOS  (40%)</b></td><td align='right'><input type='text' style='text-align:right;' id='Frescos' value='"+Total_Fresco_40+"'  name='Frescos' size='10' readonly></td>");
             out.println("<tr><td colspan='5'><p> </p></td></tr>");
             out.println("<tr><td><b>RACIONES DE CAMPAÑA</b></td><td align='center'><input type='text' style='text-align:center;' id='Sl_Rac' value='"+Cant_Sold_racio+"'  name='Sl_Rac' size='10' readonly></td><td align='center'><input type='text'  style='text-align:center;' id='Dias_Rac' value='"+Dias_racio+"'  name='Dias_Rac' size='10' readonly></td><td align='center'>"+ formatter.format(Estancia_Abast) +"</td><td align='right'>"+ formatter.format(Total_Racio)  );
      
             out.println("</tr></table></center>");  
         
        }catch(Exception e){ out.println("Error de Parametro");}
  

        
    }
        
        
   
             
   if(request.getParameter ("Realizar_Ajuste") !=null )
        {  
            
       
            
            
            /*
            
                       Cod_Plan : Cod_Plan,
                       Realizar_Ajuste : Realizar_Ajuste,         
                       Estado_Planilla : Estado_Planill,
                       Frescos : Frescos,
                       Secos :  Secos,
                       Sl_Abas : Sl_Abas,
                       Dias_Abas :   Dias_Abas,
                       Val_Estancia : Val_Estancia,
                       Sl_Rac= :  Sl_Rac,
                       Dias_Rac :  Dias_Ra
            */
            
           
            
            try{
                
                
                /*
                 Frescos_Ajustado : Frescos_Ajustado,
                       Secos_Ajustado :  Secos_Ajustado,
                */
              
            Planilla_LN Plan_LN= new Planilla_LN();
            Planilla_EN Plan_EN = new Planilla_EN();
            Articulo_LN Art_LN = new Articulo_LN();
            float Valor_Minimo_Art;
            float Saldo;
            
            Plan_EN.setId_Planilla( Long.parseLong(request.getParameter ("Cod_Plan")));
            Plan_EN.setEstado_Plan(request.getParameter ("Estado_Planilla"));
            
            Plan_EN.setSecos(Float.parseFloat(request.getParameter ("Secos_Ajustado")));
            Plan_EN.setFrescos(Float.parseFloat(request.getParameter ("Frescos_Ajustado")));
            Plan_EN.setSl_Abas( Integer.parseInt(request.getParameter ("Sl_Abas")));
            Plan_EN.setDias_Abas(Integer.parseInt(request.getParameter ("Dias_Abas")));
            Plan_EN.setVal_Estancia(Float.parseFloat(request.getParameter ("Val_Estancia")));
            Plan_EN.setSl_Rac(Integer.parseInt(request.getParameter ("Sl_Rac")));
            Plan_EN.setDias_Rac(Integer.parseInt(request.getParameter ("Dias_Rac")));
            
            Saldo = Float.parseFloat(request.getParameter ("Sald"));
                   
            ResultSet Res12=    Art_LN.Articulo_Minimo_Valor();                          
            Res12.next();
            Valor_Minimo_Art=Float.parseFloat(Res12.getString("Valor"));
          
              
              
               
               if(Saldo<=Valor_Minimo_Art )
                {
                   if(Plan_LN.Realizar_Ajuste_Planilla(Plan_EN)){
                        out.println("AJUSTE REALIZADO CON EXITO");
                       
                    }
                }
               else{out.println("EXISTEN ARTICULOS CON PRECIO POR DEBAJO DE ESTE AJUSTE. ADICIONE MAS ARTICULOS O CANTIDADES");}
               
           
            
            
            
            }catch(Exception e){ out.println("Error :"+ e.getMessage());}
            
                
            
            
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
