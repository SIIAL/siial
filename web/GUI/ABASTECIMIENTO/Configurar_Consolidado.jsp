<%-- 
    Document   : Modalidad
    Created on : 23-sep-2016, 21:44:33
    Author     : WILSON
--%>

<%@page import="Logica_Negocio.Periodo_LN"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page import= "java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "Logica_Negocio.Periodo_LN"%>
<%@ page import= "Entidad_Negocio.Periodo_EN"%>
<%@ page import= "Entidad_Negocio.Planilla_EN"%>
<%@ page import= "Logica_Negocio.Planilla_LN"%>
<%@ page import= "Logica_Negocio.Estancia_LN"%>

<%@ page import= "Logica_Negocio.Compania_LN"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../Estilos/Estilos.css" media="all" /> 
        
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="../JS/bootstrap_min.js" type="text/javascript"></script>
         <link href="../Estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
         <script src="../JS/bootstrap_min.js" type="text/javascript"></script>
         <script src="../../JS/bootstrap_min.js" type="text/javascript"></script>
         <link href="../../Estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Registro de Abastecimiento</title>
        <table class="table table-condensed">
          		<tr>
    	    		<td width="6%" height="112" style="text-align: left"><img src="../../Iconos/LE.png" width="66" height="65" alt=""/></td>
                    
                        <td width="83%">
             			<h6><strong>MINISTERIO DE DEFENSA NACIONAL<br>
   	            		 FUERZAS MILITARES DE COLOMBIA<br>
   	            		 EJÃRCITO NACIONAL <br>
   	            		 COMANDO DE PERSONAL<br>
              			 SECCION EJECUCION PRESUPUESTAL</strong></h6>
            		</td>
           			 <td width="9%"><p style="text-align: left">
            		 <img class="img-rounded" alt="Cinque Terre" src="../../Iconos/COPER.jpg" width="60" height="79" alt="right" /></p>
                           
                                 
                                 </td>
    		</table>
        </head>
    <body>
        
        
        
            
     </div>

</div>
        
     
<%               
                HttpSession sesion=request.getSession(true);
                
                String Ident=(String)sesion.getAttribute("Ident");
                String Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                String Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                String Unidad=(String)sesion.getAttribute("Unidad");
                String Log= (String)sesion.getAttribute("Log");
                
                
                
                
                
                if(request.getParameter ("Cod_Plan") !=null )
                    {
                        sesion.removeAttribute("Cod_Plan");
                        //sesion.invalidate();
                        sesion.setAttribute("Cod_Plan",request.getParameter("Cod_Plan").toString());
                  
                             // out.println( (String)sesion.getAttribute("Cod_Plan"));
                        response.sendRedirect("Ciclo.jsp");
 
                    }
                
                if(Log.isEmpty()){
                
                response.sendRedirect("http://localhost:8084/SIIAL/GUI/Validar_Usuario.jsp");
                
                }
             
%>    
        


<div class="container">
  <div class="row" aling="center">
    <hr>
    <div class="col-md-5 col-md-offset-4">
      <div class="panel panel-default panel-info"> 
        <!-- Default panel contents -->
        <div class="panel-heading">
            <h4><center>GENERAR PLANILLA DE ABASTECIMIENTO</center></h4>
        </div>
        <!-- Table -->
        <form action="Abastecimiento.jsp" method="post"><table class="table"    >
          <tbody>
            <tr>
              <td><label>MES</label></td>
              <td colspan="1" align="center"><div class="col-md-5"></div>
                        <select class="form-control" name="Periodo" required>
                            <option value="">--Seleccionar Un Periodo--</option>

                                <% 

                               Periodo_LN Pdo_LN = new Periodo_LN();
                               Periodo_EN Pdo_EN = new Periodo_EN();
                               try{
                               for (Periodo_EN Pdo :  Pdo_LN.Listar_Periodos())
                                       {
                                           out.println("<option value="+Pdo.getId_Periodo()+">"+Pdo.getMes()+" de "+Pdo.getAnio()+" </option >  ");
                                       }
                               }catch(Exception e){}
                                %>                      
                        </select>   
              </td>
            </tr>
            <tr>
              <td><label>COMPAÑIAS</label></td>
                    <td><select class="form-control" name="Cod_Compania" required>
                        <option value="">--Seleccionar Compañia--</option>

                            <%
                             Compania_LN Comp_LN = new Compania_LN();
                       try{
                            ResultSet Res1= Comp_LN.Listar_Companias_Unnidad(Unidad);
                             while(Res1.next()){
                            out.println("<option value="+Res1.getString("Codigo_Comp")+">"+Res1.getString("Nomb_Comp")+" </option >  ");
                                        }
                       }catch(Exception e){out.println("error");}
                             %>
                        </select>   
                    </td>
            </tr>
            <tr>
              <td colspan='2' align='center'>
                 
                  <input type="submit" class="btn btn-primary" id="Btn_Crear_Planilla" Name="Btn_Crear" value="Crear_Planilla" class="registrar">
           
            </tr>
            </form>
          </tbody>
        </table>
      </div>
    </div>
   </div>
</div>
                        

       <% 

           
               
                
                
                 if(request.getParameter ("Id_planilla") !=null )
                    {
                        
                        Planilla_LN Plan_LN = new Planilla_LN();
                        Plan_LN.Elimminar_Planilla(Integer.parseInt(request.getParameter("Id_planilla")));
                    }
           
           
           
           
           
           

  if(request.getParameter ("Btn_Crear") !=null )
     {
         
     
         Planilla_EN Plan_EN = new Planilla_EN();
         Planilla_LN Plan_LN = new Planilla_LN();
         Estancia_LN Est_LN = new Estancia_LN();
         
         Date fechaActual = new Date();
         DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
         
         try{
             
         Plan_EN.setCod_Planilla(0);
         Plan_EN.setTipo_Modalidad("Abastecimiento");
         Plan_EN.setEstado_Plan("Borrador");
         Plan_EN.setEstancia(Est_LN.Listar_Estancia_Activa().getId_Estancia());
         Plan_EN.setCompania(Integer.parseInt(request.getParameter("Cod_Compania")));
         Plan_EN.setFecha_Reg(formatoFecha.format(fechaActual).toString());
         Plan_EN.setPeriodo(Integer.parseInt(request.getParameter("Periodo")));
  
         
        if(Plan_LN.Crear_Planilla_Abastecimiento(Plan_EN)){
  
        }
        
         }catch(Exception e){
             
        // out.println(" Error al guardar "+e.getMessage());
         
         }
         
   
     }// Fin del boton Crear
       
Planilla_LN Plan_LN = new Planilla_LN();

try{
   ResultSet Res= Plan_LN.Listar_Planillas_Abastecimmiento_Completada(Integer.parseInt(Unidad));
   
        out.println("'<div class='container'><div class='row'><hr><div class='col-md-10 col-md-offset-1'><div class='panel panel-default panel-info'><div class='panel-heading'><h4><center>BANDEJA DE ENTRADA ABASTECIMIENTOS</center></h4></div><table class='table table-hover table-bordered table-condensed >'<tr><td><center><STRONG>ID</STRONG></center></td><td><center><STRONG>FECHA</STRONG></center></td><td><center><STRONG>COMPAÑIA</STRONG></center></td><td><center><STRONG>CARGO AL MES</STRONG></center></td><td><center><STRONG>ESTADO</STRONG></center></td><td><center><STRONG>CONFIGURAR</STRONG></center></td><td><STRONG>ELIMINAR</STRONG></td></tr></div></div></div></div></div>");  
              int j=0;
            while(Res.next()){
                j++;
                
                       //--------------------OJO-------------------   
                     //----PENDIENTE CREAR METODO PARA ELIMINAR UN PERIODO
                     
                     
          out.println("<tr><td>"
                           +j+"</td><td align='center'>"+ Res.getString("Fecha_Reg")
                                 
                                    +"</td><td align='center'>"+Res.getString("Nomb_Comp")+"</td>"
                                    +"<td align='center'>"+Res.getString("Mes_Per")+" "+Res.getString("Anio_Per") +"</td>"+"</td>" 
                                    +"<td align='center'>"+Res.getString("Estado_Plan")+"</td>"+"</td>" 
                                    +"<td align='center'><A href='Abastecimiento.jsp?Cod_Plan="+Res.getString("Id_Planilla")+"'>Modificar</A></td>"+"</td>"
                                   +"<td><A href='Abastecimiento.jsp?Id_planilla="+ Res.getString("Id_Planilla")+" '><CENTER><img src='../../Iconos/eliminar.png'/></CENTER></A></td></tr>");   
   
    
                   
                   
                   
                        }
            
            out.println("</td></tr></table></center>");  
            
}catch(Exception e){out.println("error");  }

       
       
       %> 
<br><center>  <input type="submit" class="btn btn-primary" id="Btn_Generar_Consolidado" Name="Btn_Generar_Consolidado" value="CARGAR PLANILLAS" class="registrar"> </center> 
        </div>         
               
        <table width="102%" border="0" align="left">
             <tbody>
                   <!-- LINEA DIVISORIA DEL CUERPO AL PIE DE PAGINA-->
          
                   <tr>
                     <td width="35%"><p>
                      <%
                        out.println("<table><tr><td>");
                        out.println("<tr><td>Usuario: <kbd>"+Log+"</kbd>");
                        out.println("<tr><td><center>Unidad: <kbd>"+Nomb_Unidad+"</kbd></center>");
                        out.println("<tr><td></table>");  
                        %>                 
                           </p>
                     <tr>&nbsp;</tr>
                     <tr> </tr>
                       <td width="10%">
                     <td width="20%"><p>
                       
                                </h6>
                   	 </td>
                      <td width="44%">
                          <blockquote class="blockquote-reverse" <td width="15%">
                            <h6>
                            EJERCITO NACIONAL DE COLOMBIA<br>
                            COMANDO DE PERSONAL<br>
                            SECCION EJECUCION PRESUPUESTAL
                            BOGOTÁ DC.<br>
                            Teléfono : 3208594329<br>
                          </h6
                          </blockquote>
                       </td>       	
                    <td width="1%">
                   	<td width="17%"><p style="text-align: center">
            		
                            <img  alt="Cinque Terre" class="img-rounded" width="120" height="120" alt="right"  src="../../Iconos/LA.png" alt=""/>
            		
            		 </td>
                  </tr>
                <tr>       
            </body>
          </table>      
    </body>
</html>
