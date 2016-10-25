<%-- 
    Document   : Soldado_Abatecimientos
    Created on : 05-oct-2016, 22:59:35
    Author     : WILSON
--%>

<%@page import="Entidad_Negocio.Planilla_Articulo_EN"%>
<%@page import="Logica_Negocio.Planilla_Articulo_LN"%>
<%@page import="Logica_Negocio.Articulo_LN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad_Negocio.Planilla_Soldado_EN"%>
<%@page import="Logica_Negocio.Soldado_LN"%>
<%@page import="Entidad_Negocio.Soldado_EN"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Logica_Negocio.Planilla_Soldado_LN"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="Estilos/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
               HttpSession sesion=request.getSession(true);
                
                String Ident=(String)sesion.getAttribute("Ident");
                String Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                String Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                String Unidad=(String)sesion.getAttribute("Unidad");
                String Log= (String)sesion.getAttribute("Log");
                String Id_Ciclo=(String)sesion.getAttribute("Id_Ciclo");
                String Cod_Planilla=  (String)sesion.getAttribute("Cod_Plan");
                
                           
                out.println("<table><tr><td>");
                out.println("<tr><td>Usuario : "+Log);
                out.println("<tr><td><center>Unidad : "+Nomb_Unidad+"</center>");
                out.println("<tr><td></table>");  
                       
                out.println("Planilla: "+Cod_Planilla);
                out.println("<br>Ciclo "+Id_Ciclo);
        


                Planilla_Soldado_EN Plan_Sold_EN = new Planilla_Soldado_EN();
                 Planilla_Soldado_LN Plan_Sold_LN = new Planilla_Soldado_LN();

           
                  if(request.getParameter ("Ciclo") !=null && request.getParameter ("Soldado") !=null  )
                        {
                            Plan_Sold_LN.Desvincular_Soldados_Planilla(Integer.parseInt(request.getParameter ("Soldado")),Integer.parseInt(request.getParameter ("Ciclo")) );
                        }
                 
                 
                 
                 
                 if(request.getParameter ("Bton_Agregar_Sold") !=null )
                        {
              
              
                 ArrayList<Planilla_Soldado_EN> Lista_Soldados = new ArrayList<Planilla_Soldado_EN>(); 
                
                String Sold_selec[] = request.getParameterValues("list_soldados"); 
                  if (Sold_selec != null && Sold_selec.length != 0)
                    {
                        for (int i = 0; i < Sold_selec.length; i++) 
                            {
                                Plan_Sold_EN = new Planilla_Soldado_EN();
                                Plan_Sold_EN.setCiclo(Long.parseLong(Id_Ciclo));
                                 Plan_Sold_EN.setSoldado(Long.parseLong(Sold_selec[i]));
 
                                
                                 
                                 Lista_Soldados.add(Plan_Sold_EN);
                                 Plan_Sold_EN= null;
                                      
                            }
                        
                        Plan_Sold_LN.Registrar_Soldados_Planilla(Lista_Soldados);
  
                    }
            
                    }
                  
          
             
             %>
         
               
                     
              
             <%

        try{
       
        ResultSet Rs8 =Plan_Sold_LN.Listar_Dias_Soldados_Estancia(Cod_Planilla);
         
         out.println("<center><table border='1'><tr><td>DETALLE</td><td>SL</td><td>DIAS</td><td>V. ESTANCIA</td><td>V/TOTAL</td></tr>"    );
          Integer sl=0;
          float Total=0;
         while(Rs8.next()){
             sl= sl+ Integer.parseInt(Rs8.getString("Sold"));
             Total=Total+ Float.parseFloat(Rs8.getString("Total"));
              out.println("<tr><td>SOLDADOS ABASTECIDOS</td><td>"+Rs8.getString("Sold")+"</td><td>"+Rs8.getString("Numb_Dias")+"</td><td>"+ Rs8.getString("Estancia")+"</td><td>"+Rs8.getString("Total"));
 
         }
             
         out.println("<tr><td>TOTAL </td><td>"+sl+"</td><td></td><td></td><td>"+Total+"</td></tr>");  
         
         out.println("</tr></table></center>");  
        }catch(Exception e){ out.println("Error de Parametro");}
  
        %>   
               <form action='Soldado_Abastecimientos.jsp' method= 'post' >  
         
                     <br>
                            <center>  <table border='1' >
                                        <tr><td><div style="overflow:scroll;height:400px;width:500px;">
                                                  <br><center><table border='1'  >
                                                                    <tr><td colspan='7' align='center'><b>LISTA DE SOLDADOS DE LA UNIDAD</b></td>
                                                                    <tr><tr><td align='center'><b>Id</b></td><td align='center'><b>Grado</b></td><td align='center'><b>Apellidos Nombres</b></td><td align='center'><b>Identificación</b></td> 
              
                                                                <%
                     
                                                                    try{   
               
                                                                            Soldado_EN Sold_EN= new Soldado_EN();
                                                                            Soldado_LN Sold_LN = new Soldado_LN();
                  
                                                                            ResultSet Res3= Sold_LN.Listar_Soldados_Unidad( Long.parseLong(Unidad),Integer.parseInt(Cod_Planilla));
                                                                            int j=0;
                                                                                while(Res3.next()){
                                                                                                    j++;
                                                                                out.println("<tr><td>"+j+"</td><td>"+Res3.getString("Grado")+"</td><td>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"<td>" + Res3.getString("Ident_Sold")+"<td><input type='checkbox' name='list_soldados' value='"+Res3.getString("Ident_Sold")+"'></td> " );
              
                                                                                            }
                
                                                                            } catch(Exception e){}
                                                                    %>   
                                                                        
                                                                       
                                                           </td></tr> </table></center>
                                                                  
                                                
                                                </div><td> <input type="submit"  Name="Bton_Agregar_Sold" value=">> "  ></td></td>
                    
                                                                                 
                                            </form >  
                                          <td>       
                                                  <div style="overflow:scroll;height:400px;width:500px;">
                                                      
                                                  
                          <br><center><table border='1' >
                          <tr><td colspan='7' align='center'><b>LISTA DE SOLDADOS DE LA UNIDAD A ABASTECER</b></td>
                          <tr><tr><td align='center'><b>Id</b></td><td align='center'><b>Grado</b></td><td align='center'><b>Apellidos Nombres</b></td><td align='center'><b>Identificación</b></td><td><b>#.Dias</b><td><b>Fecha Inicio</b></td><td><b>Fecha Terminación</b></td>
                                            <%
                     
                                            try{   
                     
                                            ResultSet Res3= Plan_Sold_LN.Listar_Soldados_Planilla(Long.parseLong(Cod_Planilla));
                                        int j=0;
                                            while(Res3.next()){
                                            j++;
                                           out.println("<tr><td>"+j+"</td><td>"+Res3.getString("Grado")+"</td><td>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"</td><td>"+Res3.getString("Ident_Sold")+"</td><td>"+Res3.getString("Numb_Dias")+"</td><td>"+Res3.getString("Fech_Inicio")+"</td><td>"+Res3.getString("Fech_Fin")+"</td><td><A href='Soldado_Abastecimientos.jsp?Ciclo="+ Res3.getString("Id_Ciclo")+"&Soldado="+Res3.getString("Ident_Sold")+" '><img src='../../Iconos/eliminar.png'  /> </A></tr>" );
                                                        
                                                      }
                
                                            } catch(Exception e){}
                                            %>
                       
                                         </table></center>
                                                           </div>                   
                                            </td> </tr>
                                        <tr><td colspan='3' align='center'><A href="Articulos_Abastecimiento.jsp">REGISTRAR ARTICULOS >> <A></td><tr>
                           
                                </table>
                     </center> <br>      

    </body>
</html>
