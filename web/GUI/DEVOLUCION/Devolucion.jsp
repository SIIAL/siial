<%-- 
 
--%>

<%@page import="Logica_Negocio.Compania_LN"%>
<%@page import="Entidad_Negocio.Periodo_EN"%>
<%@page import="Logica_Negocio.Periodo_LN"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Logica_Negocio.Articulo_LN"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="us">
    
<head>
	<meta charset="utf-8">
	<title>Registro de Devolucion</title>
	<link href="../../JS/jquery/jquery-ui.css" rel="stylesheet">
        
        <script src="../../JS/jquery/external/jquery/jquery.js"></script>
        <script src="../../JS/jquery/jquery-ui.js"></script>
        <script src="../JS/bootstrap_min.js" type="text/javascript"></script>
         <link href="../Estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    
         <script src="../../JS/bootstrap_min.js" type="text/javascript"></script>
         <link href="../../Estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<style>
	body{
		font-family: "Arial", verdana;
		margin: 0px;
	}
	.demoHeaders {
		margin-top: 0em;
	}
	#dialog-link {
		padding: .4em 1em .4em 20px;
		text-decoration: none;
		position: relative;
	}
	#dialog-link span.ui-icon {
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px;
	}
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
	.fakewindowcontain .ui-widget-overlay {
		position: absolute;
	}
	select {
		width: 400px;
	}
	</style>
        
    
</head>
<body>

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
            		
                                     <img src="../../Iconos/COPER.jpg" alt="Cinque Terre" src="Iconos/COPER.jpg" width="60" height="79" alt="right" /></p>
                                 </td>
    		</table>   
    
<%
    double Total_Fresco_40=0;
    double Total_Secos_60=0;
    String Ident="";
    String Tipo_User="";
    String Nomb_Unidad="";
    String Unidad="";
     String Log= "";
      String Cod_Planilla= "";
       HttpSession sesion=request.getSession(true);
    try{
      

                 Ident=(String)sesion.getAttribute("Ident");
                 Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                 Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                 Unidad=(String)sesion.getAttribute("Unidad");
                 Log= (String)sesion.getAttribute("Log");
                 Cod_Planilla=  (String)sesion.getAttribute("Cod_Plan");
                
                
    
               out.println("<table><tr><td>");
               out.println("<tr><td>Usuario : "+Log);
               out.println("<tr><td><center>Unidad : "+Nomb_Unidad+"</center>");
               out.println("</table>");  
    }catch(Exception Ex){ response.sendRedirect("http://localhost:8084/SIIAL/index.jsp");}
    
          

%>



<%
 
                if(request.getParameter ("Cod_Plan") !=null )
                    {
                        sesion.removeAttribute("Cod_Plan");
                        //sesion.invalidate();
                        sesion.setAttribute("Cod_Plan",request.getParameter("Cod_Plan").toString());
                  
                        
                         sesion.setAttribute("Tip_Mod",request.getParameter("Tipo_Modalidad").toString());
                             // out.println( (String)sesion.getAttribute("Cod_Plan"));
                     response.sendRedirect("Configurar_Devolucion.jsp");
 
                    }




%>


<div class="container">
  <div class="row" aling="center">
    <hr>
    <div class="col-md-4 col-md-offset-4">
      <div class="panel panel-default panel-info"> 
        <!-- Default panel contents -->
        <div class="panel-heading">
            <h4><center>GENERAR PLANILLA DE DEVOLUCION</center></h4>
        </div>
        <!-- Table -->
        <form action="Devolucion.jsp" method="post"><table class="table"    >
          <tbody>
              
         <tr><td colspan='5' align='center'><b>TIPO DE PLANILLA</b></td>
        
            <tr><td colspan='5' align='center'>
                <select id="Tipo_Planilla" class="form-control"  required> 
                       <option value="">--Seleccionar Tipo Modalidad--</option>
                    <option value="2">Soldados Profesionales</option>
                   <option value="3">Soldados Regulares-Bachilleres-Campesinos</option>                 
               </select></td></tr>   
            <tr>
              <td><label>PERIODO</label></td>
              <td colspan="1" align="center"><div class="col-md-5"></div>
                        <select class="form-control" id="Periodo" required>
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
              <td><label>UNIDAD</label></td>
                  <td><input type="text"  id="Cod_Unidad" value='<% out.println(Unidad);%>'>
                  <input type="text" style="width : 250px; heigth : 250px"  id="Nomb_Unidad" value='<% out.println(Nomb_Unidad);%>'></td>
            </tr>
            <tr>
              <td colspan='2' align='center'>
                 
                  <input type="button" class="btn btn-primary" id="Btn_Crear_Planilla" Name="Btn_Crear_Planilla" value="Crear_Planilla" class="registrar">
           
            </tr>
            </form>
            <tr><td>
             
                        
                </td></tr>
          </tbody>
        </table>
      </div>
    </div>
   </div>
</div>
       
            <div id="Lista_Planillas_Devolucion"  >
               
            </div>
                        
                
                        

<table width="102%" border="0" align="center">
             <tbody>
                   <!-- LÃNEA DIVISORIA DEL CUERPO AL PIÃ DE PÃGNIA-->
      
                   <tr>
                   <td width="20%"><p></p>
                     <tr>&nbsp;</tr>
                     <tr>&nbsp;</tr>
                       <td width="10%">
                     <td width="20%"><p>
                     
                     </td>
                       
                      <td width="44%">
                          <blockquote class="blockquote-reverse" <td width="15%">
                            <h6>
                            EJERCITO NACIONAL DE COLOMBIA<br>
                            COMANDO DE PERSONAL<br>
                            SECCION EJECUCION PRESUPUESTAL<br>
                            BOGOTÁ DC.<br>
                            Teléfono : 3208594329<br>
                          </h6
                          </blockquote>
                       </td>
                                    	
                    <td width="1%">
                   	<td width="17%"><p style="text-align: left">
            		
                      <img alt="Cinque Terre" class="img-rounded" width="120" height="120" alt="right"   src="../../Iconos/LA.png" alt=""/>
                        </td>
                  </tr>
                <tr>       
        </table> 
            </body>
            
            
   <script>

$(function(){
                       
         Lista_Planillas_Devolucion(); 
                     
            }); 
            
            
   function Eliminar_Planilla_devolucion(Id_Planilla){
       
                         // alert(Id_Planilla);
                        var  Id_Planilla = Id_Planilla;
			$.post('../..//Devolucion', {
                          Eliminar_Planilla_Devolucion : "Eliminar_Planilla_Devolucion",
                          Id_Planilla : Id_Planilla
			}, function(responseText) {
                            Lista_Planillas_Devolucion();
                            alert(responseText);
                         // $('#Lista_Planillas_Devolucion').html(responseText);
			});                  
                
       
       
   }         






$(document).ready(function() {
		$('#Btn_Crear_Planilla').click(function(event) {
                //Periodo
                //Tipo_Planilla
                //Cod_Unidad
              var Periodo=  $('#Periodo').val();
              var Tipo_Planilla= $('#Tipo_Planilla').val();
              var Cod_Unidad =  $('#Cod_Unidad').val();
                
			$.post('../..//Devolucion', {
                         Crear_Planilla : "Crear_Planilla",
                         Periodo : Periodo,
                         Tipo_Planilla : Tipo_Planilla,
                         Cod_Unidad : Cod_Unidad
                         
			}, function(responseText) {
                            Lista_Planillas_Devolucion();
                            alert(responseText);
                         // $('#Lista_Planillas_Devolucion').html(responseText);
			});      
   
    
    
    
    
		});
	});
    
    
    
                
                
                
    
    
    
  
function Lista_Planillas_Devolucion(){
    
                var  Cod_Unidad = $('#Cod_Unidad').val();
			$.post('../..//Devolucion', {
                          Lista_Planillas_Devolucion : "Lista_Planillas_Devolucion",
                          Cod_Unidad : Cod_Unidad
			}, function(responseText) {
                            //alert(responseText);
                          $('#Lista_Planillas_Devolucion').html(responseText);
			});                  
                
    
    }



</script>
         
            
            
          
</body>
</html>
