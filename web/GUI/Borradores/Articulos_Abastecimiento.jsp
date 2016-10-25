<%-- 
    Document   : Articulos_Abastecimiento
    Created on : 30-sep-2016, 0:07:04
    Author     : WILSON
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "Logica_Negocio.Planilla_Soldado_LN"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Articulos a la Planialla</title>
    </head>
    <body>
       
    
       
  <%
  
      
        try{
        Planilla_Soldado_LN Plan_Sold_LN = new Planilla_Soldado_LN();
        ResultSet Rs1 =Plan_Sold_LN.Listar_Dias_Soldados_Estancia(request.getParameter("Id_Plan").toString());
         
         out.println("<center><table border='1'><tr><td>DETALLE</td><td>SL</td><td>DIAS</td><td>V. ESTANCIA</td><td>V/TOTAL</td></tr>"    );
          Integer sl=0;
          float Total=0;
         while(Rs1.next()){
             sl= sl+ Integer.parseInt(Rs1.getString("Sl"));
             Total=Total+ Float.parseFloat(Rs1.getString("Total"));
              out.println("<tr><td>SOLDADOS ABASTECIDOS</td><td>"+Rs1.getString("Sl")+"</td><td>"+Rs1.getString("Num_Dias")+"</td><td>"+Rs1.getString("Estancia")+"</td><td>"+Rs1.getString("Total")+"</td></tr>");
          }
             
         out.println("<tr><td>TOTAL </td><td>"+sl+"</td><td></td><td></td><td>"+Total+"</td></tr>");  
         
         out.println("</tr></table></center>");  
        }catch(Exception e){ out.println("Error de Parametro");}
  
        %>
      
        
     
           <center> <Table borde ='1'>        
                    <form action='Articulos_Abastecimiento.jsp?Id_Plan=<%out.println(request.getParameter("Id_Plan").toString());%>' name='nn' method='post'> 
                        <tr><td>  <input type="text" name="Id_Plan" size="10" value="<% out.println(request.getParameter("Id_Plan").toString());%> " size="20"  ></td>
                            <td><input type="submit"  Name="nnn" value="REGISTRAR"  ></td> </tr>
                    </form>      
                   </table>  
         </center> 

    <% 
        
try{ 
 


}catch(Exception e){}
    %>
    
    
        
    </body>
</html>
