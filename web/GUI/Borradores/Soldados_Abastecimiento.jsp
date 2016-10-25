<%-- 
    Document   : Configurar_Modalidad
    Created on : 25-sep-2016, 14:18:14
    Author     : WILSON
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import= "Logica_Negocio.Soldado_LN"%>
<%@ page import= "Entidad_Negocio.Planilla_Soldado_EN"%>
<%@ page import= "Logica_Negocio.Planilla_Soldado_LN"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="us">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link href="../JS/jquery/jquery-ui.css" rel="stylesheet">
        <script src="../JS/jquery/external/jquery/jquery.js"></script>
        <script src="../JS/jquery/jquery-ui.js"></script>
        
        
<script>
    
    
    $('#checkbox1').change(function() {
        $('#textbox1').val($(this).is(':checked'));
    });
    
    
    
	$(document).ready(function() {
		$('#Btn_Agregar_Sold').click(function(event) {
                  alert("hola");
                  
			var fecha_ini = $('#fecha_ini').val();
			var fecha_fin = $('#fecha_fin').val();
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post('../Soldados_Abastecimiento', {
				fec_ini : fecha_ini,
				fec_fin : fecha_fin
			
			}, function(responseText) {
				$('#tabla_sold').html(responseText);
			});
		});
	});
</script>
        
        
        
         
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
                
                
               out.println("<table><tr><td>");
               out.println("<tr><td>Usuario : "+Log);
               out.println("<tr><td><center>Unidad : "+Nomb_Unidad+"</center>");
               out.println("<tr><td></table>");    
                
                
            try{
                
                Soldado_LN Sold_LN = new Soldado_LN();
                String Cod_Planilla= request.getParameter("Cod_Plan").toString();
               
              
                    
          %>
          
          
          <%
          Planilla_Soldado_LN Pla_Sol_LN = new Planilla_Soldado_LN();
          if(request.getParameter ("IdPlanSold") !=null )
            {
            Pla_Sol_LN.Desvincular_Soldados_Planilla(Integer.parseInt(request.getParameter ("IdPlanSold")));
           // out.println("Holas");
            
            }
          
          
          
          
          %>
          
          
          
          
          <%
          // agregar soldado a la planilla
        if(request.getParameter ("Btn_Agregar_Sold") !=null )
            {
               
                Planilla_Soldado_EN Plan_Sold_EN = new Planilla_Soldado_EN();
                 Planilla_Soldado_LN Plan_Sold_LN = new Planilla_Soldado_LN();
              
                 ArrayList<Planilla_Soldado_EN> Lista_Soldados = new ArrayList<Planilla_Soldado_EN>(); 
                
                String Sold_selec[] = request.getParameterValues("list_soldados"); 
                  if (Sold_selec != null && Sold_selec.length != 0)
                    {
                        for (int i = 0; i < Sold_selec.length; i++) 
                            {
                                
                               
                                
                                Plan_Sold_EN = new Planilla_Soldado_EN();
                                 Plan_Sold_EN.setSoldado(Long.parseLong(Sold_selec[i]));
                                
    
                                 Lista_Soldados.add(Plan_Sold_EN);
                                 Plan_Sold_EN= null;
                                      
                            }
                        
                        Plan_Sold_LN.Registrar_Soldados_Planilla(Lista_Soldados);
  
                    }
 
            }
        
      
          
          %>
         
                  
          <form action='Soldados_Abastecimiento.jsp method='post'> 
              
             <center><br> <table border='1' >
              
             <tr><td> <div   id="tabla_sold" style="overflow:scroll;height:400px;width:600px;"> 
                  
              </div>  
               </td>  
                    <td><div style="overflow:scroll;height:450px;width:200px;"> 
                                 <center><br><table  ><tr><td colspan='2' align='center' >Cod. Planilla</td>
                                         <tr><td><input type="text" name="Cod_Plan" size="5" value='<% out.println(Cod_Planilla);%>' size="20" Disabled> </td>        
           
                                        <tr><td colspan='2' align='center'>Fecha Inicio</td> 
                                         <tr><td colspan='2' align='center'><input type="date" name="fecha_inic" value="" size="20" required > </td>
                                       <tr><td colspan='2' align='center'>Numero Dias</td>
                                           <tr><td colspan='2' align='center'><select name="Num_Dias" required>   
                                           <%
                                               for(int i =1; i<=31;i++){out.println("<option value="+i+">"+i+"</option>"); }
                                            %>
                                           
                                               </td> </select>
                                            <tr><td colspan='2' align='center'>Fecha Final</td> 
                                         <tr><td colspan='2' align='center'><input type="text" name="fecha_fin" size="10" value="" size="20" Disabled > </td>
                                       
                                       
                                       
                                   <tr><td><input type="button" id="Btn_Agregar" id="Btn_Agregar_Sold" value="Agregar a la Planilla >>" class="registrar"   ></td> </tr>     
                 </table>
                </div >
                
                </td>
               
               </tr>
               
              </table>
                  </form>                                
                                            
                                            <br><br>
                     <table border='1'><tr>
                 <td><div style="overflow:scroll;height:400px;width:800px;">
                   
                 <center><br><table border='1' >
                          <tr><td colspan='7' align='center'><b>LISTA DE SOLDADOS DE LA UNIDAD A ABASTECER</b></td>
                          <tr><tr><td align='center'><b>Id</b></td><td align='center'><b>Grado</b></td><td align='center'><b>Apellidos Nombres</b></td><td align='center'><b>Identificación</b></td><td><b>#.Dias</b><td><b>Fecha Inicio</b></td><td><b>Fecha Terminación</b></td>
                  <%
                     
                 try{   
                     
                     Planilla_Soldado_LN Plan_Sold_LN= new Planilla_Soldado_LN();
                     ResultSet Res3= Plan_Sold_LN.Listar_Soldados_Planilla(Long.parseLong(request.getParameter ("Cod_Plan")));
                    int j=0;
                     while(Res3.next()){
                         j++;
                                    out.println("<tr><td>"+j+"</td><td>"+Res3.getString("Grado")+"</td><td>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"<td>"+Res3.getString("Ident_Sold") +"</td></td><td>"+Res3.getString("Num_Dias")+"<td>"+Res3.getString("Fec_Inicio") +"</td>"+"<td>"+Res3.getString("Fec_Inicio") +"</td><td><A href='Soldados_Abastecimiento.jsp?Cod_Plan="+request.getParameter ("Cod_Plan")+"&IdPlanSold="+ Res3.getString("IdPlan_Sold")+" '>Desvincular</A></tr>" );
                                    
                                   
                                        }
                
                    } catch(Exception e){}
                   %>
                         </table>
                         
                         
                            </div >
                 
                 </td>                               
                                </tr></table>                            
                                           </center>  
                
                     
                 <%
                      }
            catch(Exception e){}

            %>
        
           <center> <Table borde ='1'>        
                    <form action='Articulos_Abastecimiento.jsp?Id_Plan=<%out.println(request.getParameter("Cod_Plan").toString());%>' name='nn' method='post'> 
                        <tr><td>  <input type="hidden" name="Id_Plan" size="10" value="<% out.println(request.getParameter("Cod_Plan").toString());%> " size="20"  ></td>
                            <td><input type="submit"  Name="nnn" value="SIGUIENTE >> "  ></td> </tr>
                    
                    
                    <div id="dialog" title="Dialog Title">
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
            </div>
                    
                    </form>      
                   </table>  
         </center> 
          
        
    </body>
</html>
