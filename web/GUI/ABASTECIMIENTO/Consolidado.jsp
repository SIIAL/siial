<%-- 
    Document   : Devolucion
    Created on : 11-oct-2016, 13:39:26
    Author     : WILSON
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>




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
         
         <link href="../../JS/jquery/jquery-ui.css" rel="stylesheet">
        
        <script src="../../JS/jquery/external/jquery/jquery.js"></script>
        <script src="../../JS/jquery/jquery-ui.js"></script>
         
        <style>
	body{
		font-family: "Trebuchet MS", sans-serif;
		margin: 50px;
	}
	.demoHeaders {
		margin-top: 2em;
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
		width: 200px;
	}
	</style>
        
        
         
        
        </head>
    <body>
        
        <title>Registro de Abastecimiento</title>
        <table class="table table-condensed">
          		<tr>
    	    		<td width="6%" height="112" style="text-align: left"><img src="../../Iconos/LE.png" width="66" height="65" alt=""/></td>
                    
                        <td width="83%">
             			<h6><strong>MINISTERIO DE DEFENSA NACIONAL<br>
   	            		 FUERZAS MILITARES DE COLOMBIA<br>
   	            		 EJERCITO NACIONAL <br>
   	            		 COMANDO DE PERSONAL<br>
              			 SECCION EJECUCION PRESUPUESTAL</strong></h6>
            		</td>
           			 <td width="9%"><p style="text-align: left">
            		 <img class="img-rounded" alt="Cinque Terre" src="../../Iconos/COPER.jpg" width="60" height="79" alt="right" /></p>
                           
                                 
                                 </td>
    		</table>
        
            
     </div>

</div>
        
     
<%               
                HttpSession sesion=request.getSession(true);
                
                String Ident=(String)sesion.getAttribute("Ident");
                String Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                String Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                String Unidad=(String)sesion.getAttribute("Unidad");
                String Log= (String)sesion.getAttribute("Log");
                
                
                if(Log.isEmpty()){
                
               // response.sendRedirect("http://localhost:8084/SIIAL/GUI/Validar_Usuario.jsp");
                
                }
             
%>    
        


<div class="container">
  <div class="row" aling="center">
    <hr>
    <div class="col-md-4 col-md-offset-4">
      <div class="panel panel-default panel-info"> 
        <!-- Default panel contents -->
        <div class="panel-heading">
            <h4><center>GENERAR CONSOLIDADOS</center></h4>
        </div>
        <!-- Table -->
        <form action="Consolidado.jsp" method="post"><table class="table"    >
          <tbody>
     
           <tr><td> <td><input type="text"  id="Cod_Unidad" value='<% out.println(Unidad);%>'></td></tr>
            <tr><td colspan='5' align='center'>
                    <input type="text" id="Cod_Consolidado"  name="Cod_Consolidado" size='7' readonly >    
          <input type="Button" class="btn btn-primary" id="Btn_Generar_Codigo" Name="Btn_Generar_Codigo" value="GENERAR CODIGO" class="registrar">
           </td 
            </tr>
            <tr>
              <td colspan='2' align='center'>
                       
                  
            
            </tr>
            </form>
          </tbody>
        </table>
      </div>
    </div>
   </div>
</div>
                        

       
<br> 
                           
      <div id="Lista_Plan_Completadas">  
          </div>             
       
       <div id="Listar_Consolidado_Planilla">  
          </div>             
       







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
                            Teléfono : 320___________<br>
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
    
   <script> 
    
    
    
       $(function(){
                       
         Buscar_Existencia_Codigo_Consolidado (); 
         Listar_Planillas_Abastecimmiento_Completada();
        // Listar_Consolidado_Planilla();
                     
            });   
    
    
   
   
 function  Asignar_Planilla_Consolidado(Id_Planilla){
     
     Listar_Consolidado_Planilla(Id_Planilla);
    $( "#Listar_Consolidado_Planilla" ).dialog( "open" );
     
     
 }
   
   
 /*     
 function  Listar_Consolidado_Planilla(Id_Planilla){
     
      var  Id_Planilla = Id_Planilla;
                     
			$.post('../..//Consolidado', {
                          Listar_Consolidado_Planilla : "Listar_Consolidado_Planilla",
                          Id_Planilla : Id_Planilla
			}, function(responseText) {
                        
                                $('#Listar_Consolidado_Planilla').html(responseText);
                               

			}); 
 
 }
   */ 
  
    
  function Listar_Planillas_Abastecimmiento_Completada (){
      
      
                      var  Cod_Unidad = $('#Cod_Unidad').val();
                     
			$.post('../..//Consolidado', {
                          Listar_Planillas_Abastecimmiento_Finalizadas : "Listar_Planillas_Abastecimmiento_Finalizadas",
                          Cod_Unidad : Cod_Unidad
			}, function(responseText) {
                        
                                $('#Lista_Plan_Completadas').html(responseText);
                               

			}); 
      
  }  
    
 
    
  function Buscar_Existencia_Codigo_Consolidado (){
      
      
                      var  Cod_Unidad = $('#Cod_Unidad').val();
                     
			$.post('../..//Consolidado', {
                          Buscar_Existencia_Codigo_Consolidado : "Buscar_Existencia_Codigo_Consolidado",
                          Cod_Unidad : Cod_Unidad
			}, function(responseText) {
                     
                            $('#Cod_Consolidado').val(responseText);
                    
                             if($('#Cod_Consolidado').val()!='')
                                    {
                                 $('#Btn_Generar_Codigo').attr("disabled", true);
                                 alert("LA UNIDAD TIENE UN CODIGO DE CONSOLIDADO POR FINALIZAR");
                                    }else{
                                
                                 $('#Btn_Generar_Codigo').attr("disabled", false);
                                  alert("PUEDE GENERAR UN NUEVO CODIGO");
                                    }
                                    
                                  
                              
    // Listar_Planillas_Abastecimmiento_Borrador();
			}); 
      
  }  
    
    
    
    
$(document).ready(function() {
		$('#Btn_Generar_Codigo').click(function(event) {

              
                      var  Cod_Unidad = $('#Cod_Unidad').val();
                     
			$.post('../..//Consolidado', {
                          Generar_Codigo_Consolidado : "Generar_Codigo_Consolidado",
                          Cod_Unidad : Cod_Unidad
			}, function(responseText) {
                     
                     Buscar_Existencia_Codigo_Consolidado ();
                     
                     
                    //alert(responseText);
                        // Listar_Planillas_Abastecimmiento_Borrador();
			}); 
                    
                    
                    
                      
	
		});
	});
    
    
                    
  $( "#Listar_Consolidado_Planilla").dialog({
          modal: true,
         title: "Consolidado de la Planilla de Abastecimiento",
         width: 800,
         minWidth: 750,
         maxWidth: 800,
         show: "fold",
         hide: "scale",
	autoOpen: false,
	width: 500
          
       
	
} );              
        
    
    
    
    
    
    
    
    
    
    
    
    
   </script> 
    
    
    
</html>
