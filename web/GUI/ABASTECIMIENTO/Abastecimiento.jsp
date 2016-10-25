<%-- 
    Document   : Modalidad
    Created on : 23-sep-2016, 21:44:33
    Author     : WILSON
--%>

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
        <meta charset="utf-8">
	<title>Registro de Abastecimientos</title>
        
     
        
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
            		 <img class="img-rounded" alt="Cinque Terre" src="../../Iconos/COPER.jpg" width="60" height="79" alt="right" /></p>
                           
                                 
                                 </td>
    		</table>     
        
      

</div>
        
     
<%    
      HttpSession sesion=request.getSession(true);
                String Ident="";
                String Tipo_User="";
                String Nomb_Unidad="";
                String Unidad="";
                String Log= "";
                String Sigla="";
                
    
    
    try{
                 Ident=(String)sesion.getAttribute("Ident");
                 Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                 Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                 Unidad=(String)sesion.getAttribute("Unidad");
                 Log= (String)sesion.getAttribute("Log");
                 Sigla=(String)sesion.getAttribute("Sigla");
                
               
                
                if(request.getParameter ("Cod_Plan") !=null )
                    {
                        sesion.removeAttribute("Cod_Plan");
                        //sesion.invalidate();
                        sesion.setAttribute("Cod_Plan",request.getParameter("Cod_Plan").toString());
                  
                             // out.println( (String)sesion.getAttribute("Cod_Plan"));
                        response.sendRedirect("Configurar_Abastecimiento.jsp");
 
                    }
                
    }catch(Exception Ex){ response.sendRedirect("http://localhost:8084/SIIAL/index.jsp");}
             
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
                <tr><td> <td><input type="text"  id="Cod_Unidad" value='<% out.println(Unidad);%>'></td></tr>
          <tbody>
            <tr>
              <td><label>MES</label></td>
              <td colspan="1" align="center"><div class="col-md-5"></div>
                        <select class="form-control" id="Periodo" required>
                            <option value="">--Seleccionar Un Periodo--</option>

                                <% 

                               Periodo_LN Pdo_LN = new Periodo_LN();
                               Periodo_EN Pdo_EN = new Periodo_EN();
                               try{
                               for (Periodo_EN Pdo :  Pdo_LN.Listar_Periodos())
                                       {
                                           out.println("<option value='"+Pdo.getId_Periodo()+"'>"+Pdo.getMes()+" de "+Pdo.getAnio()+" </option >  ");
                                       }
                               }catch(Exception e){}
                                %>                      
                        </select>   
              </td>
            </tr>
            <tr>
              <td><label>COMPAÑIAS</label></td>
                    <td><select class="form-control" id="Cod_Compania" required>
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
                 
                  <input type="Button" class="btn btn-inverse" id="Btn_Crear_Planilla" Name="Btn_Crear_Planilla" value="Crear Planilla" class="registrar">
           
            </tr>
            </form>
          </tbody>
        </table>
      </div>
    </div>
   </div>
</div>
       
     
          
                                                  
                        
<div id="Listar_Planillas_Abastecimmiento_Borrador">
     </div>
   
                        <div id="Finalizar_Planillas">
                            <center>ESTA SEGURO QUE DESEA FINALIZAR LA PLANILLA</center>
                        </div>       
        
                 <center> <div align="center">
                         <a href="../MODULOS/Modalidades.jsp" class="btn btn-default" role="button">ATRAS</a>
                         <a href="../Sesion.jsp" class="btn btn-default" role="button">MENU PRICIPAL</a>
                     
                     </div></center> 
      
               
        <table width="102%" border="0" align="left">
             <tbody>
                   <!-- LINEA DIVISORIA DEL CUERPO AL PIE DE PAGINA-->
          
                   <tr>
                     <td width="35%"><p>
                      <%
                        out.println("<table><tr><td>");
                        out.println("<tr><td>Usuario: <kbd>"+Log+"</kbd>");
                        out.println("<tr><td><center>Unidad: <kbd>"+Sigla+"</kbd></center>");
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
            </body>
          </table>                         
   <script>

   $(function(){
                       
         Listar_Planillas_Abastecimmiento_Borrador(); 
                     
            });   
            
            
      function Finalizar_Planilla_Abastecimiento(Id_Planilla){
         
                       
                        
                         var  Id_Planilla =Id_Planilla;
                     
			$.post('../..//Abastecimiento', {
                          Listar_Totales_Planilla : "Listar_Totales_Planilla",
                          Id_Planilla : Id_Planilla
			}, function(responseText) {
                          
                            $('#Finalizar_Planillas').html(responseText);
                            
                             $('#Cod_Plan_Fin').val(Id_Planilla);
                            
                             $( "#Finalizar_Planillas" ).dialog( "open" );
			}); 
                     
                        
                        
      }     
      
      
            
       $( "#Finalizar_Planillas" ).dialog({
          modal: true,
         title: "Finalizar Planilla",
         width: 800,
         minWidth: 750,
         maxWidth: 800,
         show: "fold",
         hide: "scale",
	autoOpen: false,
	width: 500
          
       
	
} );           
            
            
    function Elimina_Planilla_Abastecimiento(id_planilla){
        
       // alert("sasas");
         var  id_planilla =id_planilla;
                     
			$.post('../..//Abastecimiento', {
                          Elimina_Planilla_Abastecimiento : "Elimina_Planilla_Abastecimiento",
                          id_planilla : id_planilla
			}, function(responseText) {
                    
                        // Listar_Planillas_Abastecimmiento_Borrador();
			});   
  
    }        
            
            
            
   function Listar_Planillas_Abastecimmiento_Borrador(){
       
                      var  Cod_Unidad = $('#Cod_Unidad').val();
                      //alert(Cod_Unidad);
			$.post('../..//Abastecimiento', {
                          Listar_Planillas_Abast_Borra : "Listar_Planillas_Abast_Borra",
                          Cod_Unidad : Cod_Unidad
			}, function(responseText) {
                          //  alert(responseText);
                         $('#Listar_Planillas_Abastecimmiento_Borrador').html(responseText);
			});                    
    
   }         

//


function Fin_Planilla_Abastecimiento(Id_Planilla){
    
                      
			 var  Id_Plan = Id_Planilla;
                      //alert(Cod_Unidad);
			$.post('../..//Abastecimiento', {
                          Finalizar_Planilla : "Finalizar_Planilla",
                          Id_Planilla : Id_Plan
			}, function(responseText) {
                        
                               Listar_Planillas_Abastecimmiento_Borrador();   
                                $( "#Finalizar_Planillas" ).dialog( "close" );
			});                     
    
    
    
}





$(document).ready(function()
            {

                $('#Btn_Crear_Planilla').click(function(event)
                                {  
                           var Cod_Compania = $( "#Cod_Compania" ).val() ;
                           var Periodo = $( "#Periodo" ).val() ;
              
                            $.post('../..//Abastecimiento', {
                              Cod_Compania : Cod_Compania,
                              Periodo : Periodo,
                              Registrar_Abastecimiento : "Registrar_Abastecimiento"
                                                  
                        
                        }, function(responseText) 
                            {
                             Listar_Planillas_Abastecimmiento_Borrador();   
                            alert(responseText);
                          
                            });    
                            
                                   
                                });
                
                   
                });
             
                
    
 


</script>
                                   
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
    </body>
</html>
