<%-- 
 
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Logica_Negocio.Articulo_LN"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="us">
    
<head>
	<meta charset="utf-8">
	<title>Registro de Articulos</title>
	<link href="../../JS/jquery/jquery-ui.css" rel="stylesheet">
        
        <script src="../../JS/jquery/external/jquery/jquery.js"></script>
        <script src="../../JS/jquery/jquery-ui.js"></script>
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
</head>
<body>
<%
    double Total_Fresco_40=0;
    double Total_Secos_60=0;
    String Ident="";
    String Tipo_User="";
    String Nomb_Unidad="";
    String Unidad="";
     String Log= "";
      String Cod_Planilla= "";
    try{
       HttpSession sesion=request.getSession(true);

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





        <center><div id="Lista_Consolidado_Plani" style="width:750px">
        </div></center>  





	

<!-- ui-dialog -->
<input type="text" id="Cod_Plan" value="<% out.println(Cod_Planilla); %>"  name="Cod_Plan">

<div id="dialog" title="REGISTRAR ARTICULOS">
    <fieldset>
	<legend>Articulos</legend>
	<div id="controlgroup">
            <table class="table table-bordered"><tr>
                    <td>Articulo</td> <td>Cantidad</td><td>Saldo</td>
                    <tr><td>
            <select id="Articulos">
             <%
                                Articulo_LN Art_LN = new Articulo_LN();
                                try{
                                        ResultSet Res1=  Art_LN.Listar_Articulos();
                                        while(Res1.next()){          
                                            out.println("<option value="+Res1.getString("idArticulo")+">"+Res1.getString("Nomb_Art")+" = "+Res1.getString("Valor")+"</option>");  
                                        }
                                    }catch(Exception e){out.println("error");}
                                %>
            </select>
                    </td><td><input type="Number" id="Cantidad" name="Cantidad" style="width : 100px; heigth : 100px" ></td>
                    <td><input type="Number" id="Saldo" name="Faltante" size='3' style="width : 100px; heigth : 100px" readonly></td>
                        
                       
                       <tr>  <td colspan='2' align='center'><button id="Btn_Guardar_Articulo">REGISTRAR</button></td>
                    </td ></tr>
            
	</table>
  
	</div>
      
</fieldset>

</div>
            
            
<!--style="overflow:scroll;height:500px;width:600px;"-->
<p>&nbsp;&nbsp;</p>
<center><div id="controlgroup"  style="overflow-y: scroll; width:920px">
            <fieldset>
                  <legend style="font-weight:bold; color:#61380B;">
                  <button id="dialog-link" class="ui-button ui-corner-all ui-widget">
                          <span class="ui-icon ui-icon-newwin"></span><h4>AGREGAR<h4>
                  </button>
                  </legend>

                    <div id="Lista_Articulos_Registrado">

                    </div>  

           </fieldset>
        </div> 
</center>


<center>  <tr>  <tr>  <td colspan='2' align='center'>
    <legend style="font-weight:bold; color:#61380B;">
  
       <br> <button id="Bton_Ajustar" class="ui-button ui-corner-all ui-widget">
		<span class="ui-icon ui-icon-newwin"></span>REGISTRAR
	</button>
     </legend></td>
                    </td ></tr></center>

             
             
             
<div id="Ventana_Realilzar_Ajuste">
          
      <legend style="font-weight:bold; color:#61380B;">
         AJUSTE :<input  type="Number" id="Saldo_Ajuste" name="Saldo_Ajuste" size='3'  style="width : 100px; heigth : 100px" readonly>    
            <button id="Bton_Guardar_Ajuste" class="ui-button ui-corner-all ui-widget">
		<span class="ui-icon ui-icon-newwin"></span>GUARDAR
	  </button>
     </legend>
                
</div>         
             
  
<center><div>  <a href="Configurar_Abastecimiento.jsp" class="btn btn-default" role="button">ATRAS</a>
</div> </center>        
             
<script>


 $(function(){
                       
  
                        // $('#Ciclos').hide();
                        Actualizar_Ajustes();
                        Listar_Articulos_Plantilla();
                        Listar_Consolidado_Planilla();

                        //$('#Faltante').val(Total_Secos_60-Total_Planilla_Art);
    
                         $('#Cod_Plan').hide();
                        }); 
                        
       


 function Eliminar_Articulo_Planilla(art) {
     
  
             var Id_Art_Plan=art;

			$.post('../..//Articulos_Planilla', {
			
                          Id_Art_Plan : Id_Art_Plan,
                          Elim_Art_Plan : "Elim_Art_Plan"
           
			}, function(responseText) {
                           // alert(responseText);
                           Listar_Articulos_Plantilla();
                            Actualizar_Ajustes();
                           // $('#Lista_Articulos_Registrado').html(responseText);
			});                                       
                               
     
     
     
 }



//Boton hacer Ajustes a la Planilla

$(document).ready(function() {
		$('#Bton_Ajustar').click(function(event) {

                Actualizar_Ajustes();
                        
                $( "#Ventana_Realilzar_Ajuste" ).dialog( "open" );
	                
		});
	});
    
    
    
  $(document).ready(function() {
		$('#Bton_Guardar_Ajuste').click(function(event) {


                var Cod_Plan = $('#Cod_Plan').val();
                var Realizar_Ajuste = "Realizar_Ajuste";
                var Faltante =  $('#Saldo_Ajuste').val();
                var Frescos=  $('#Frescos').val();
                var Secos=  $('#Secos').val();
                var Sl_Abas=  $('#Sl_Abas').val();
                var Dias_Abas=  $('#Dias_Abas').val();
                var Val_Estancia=  $('#Val_Estancia').val();
                var Sl_Rac=  $('#Sl_Rac').val();
                var Dias_Rac=  $('#Dias_Rac').val();
                var   Estado_Planill = "Borrador";
                var Saldo =  $('#Saldo').val();
            // alert(Saldo);

              
              var Secos_Ajustado= Secos - Faltante;
              var Frescos_Ajustado = parseFloat(Frescos) + parseFloat(Faltante);
 
               $.post('../..//Articulos_Planilla', {
                       Cod_Plan : Cod_Plan,
                       Realizar_Ajuste : Realizar_Ajuste,         
                       Estado_Planilla : Estado_Planill,
                       Frescos_Ajustado : Frescos_Ajustado,
                       Secos_Ajustado :  Secos_Ajustado,
                       Sl_Abas : Sl_Abas,
                       Dias_Abas :   Dias_Abas,
                       Val_Estancia : Val_Estancia,
                       Sl_Rac :  Sl_Rac,
                       Dias_Rac :  Dias_Rac,
                       Sald : Saldo

			}, function(responseText) {
                       
                            $( "#Ventana_Realilzar_Ajuste" ).dialog( "close" );
                                alert(responseText);
                            $(location).attr('href',"Abastecimiento.jsp"); 
                       
                    
                            
                             
                          
                           
			});
		});
	});  
    
    
    
    
        
    
    

function Actualizar_Ajustes() {
 
      var Total_Secos_60=$('#Secos').val();
      var Total_Planilla_Art=$('#Total_Planilla_Art').val();
    //  $('#Faltante').val(Total_Secos_60-Total_Planilla_Art);
    
      $('#Saldo').val(Total_Secos_60-Total_Planilla_Art); 
        $('#Saldo_Ajuste').val($('#Saldo').val());
      
      
   
    }



 function Listar_Consolidado_Planilla() {
                                        
           
         
             var Cod_Plan = $('#Cod_Plan').val();
             var Listar_Consolidado_Planilla="Listar_Consolidado_Planilla";

			$.post('../..//Articulos_Planilla', {
				
                          Cod_Plan : Cod_Plan,
                          Listar_Consolidado_Planilla : Listar_Consolidado_Planilla
           
			}, function(responseText) {
                           // alert(responseText);
                            $('#Lista_Consolidado_Plani').html(responseText);
			});                                       
  
    }



    function Listar_Articulos_Plantilla() {
                                        
           
         
             var Cod_Plan = $('#Cod_Plan').val();
             var Listar_Art_Planilla="Listar_Art_Planilla";

			$.post('../..//Articulos_Planilla', {
				
                          Cod_Plan : Cod_Plan,
                          Listar_Art_Planilla : Listar_Art_Planilla
           
			}, function(responseText) {
                           // alert(responseText);
                            $('#Lista_Articulos_Registrado').html(responseText);
			});                                       
                                       }




$( "#Ventana_Realilzar_Ajuste" ).dialog({
          modal: true,
         title: "Realzar ajuste a la planilla",
         width: 550,
         minWidth: 400,
         maxWidth: 650,
         show: "fold",
         hide: "scale",
	autoOpen: false,
	width: 500
       
	
});





$( "#dialog" ).dialog({
          modal: true,
         title: "Registro de articulos a la planilla",
         width: 750,
         minWidth: 750,
         maxWidth: 750,
         show: "fold",
         hide: "scale",
	autoOpen: false,
	width: 500
          
       
	
} );

function Minimo_Valor_Articulo(){
  /* 
   var Valor_Minimo;
    $.post('../..//Articulos_Planilla', {
                   Minimo_Valor_Articulo : "Minimo_Valor_Articulo"
			}, function(responseText) {
                             Valor_Minimo= responseText.toString();
                          
			});
                        return Valor_Minimo;
        
        */
}

  //---------------------------------------------------------------    
// funcion para Guardar  ciclos de una planilla
$(document).ready(function() {
		$('#Btn_Guardar_Articulo').click(function(event) {
		
		      var Cod_Plan = $('#Cod_Plan').val();
                      var Cantidad = $('#Cantidad').val();
                       var Articulos = $('#Articulos').val();
                   
                        var Valor_Art = $("#Articulos option:selected").html();
                        Valor_Art=  Valor_Art.split("=");
                        var Saldo=$('#Saldo').val();
                        var valor_Catidad= parseInt(Valor_Art[1])* parseInt( $('#Cantidad').val());
                        
                 // alert(Minimo_Valor_Articulo());

                if(valor_Catidad > parseInt(Saldo) )
                        {
                         
                         alert("EL MONTO DE ARTICULOS SUPERA EL 60% DE LOS VIVERES SECOS");
                         
                        }
                     else{
                        
                         
                         $.post('../..//Articulos_Planilla', {
                              
				Cod_Plan : Cod_Plan,
                                Guardar_Articulo : "Guardar_Articulo",
                                Cantidad : Cantidad,
                               Articulos : Articulos
                              
       
			}, function(responseText) {
                           
                            alert(responseText);
                            $('#Cantidad').val("");
                 
                             $( "#dialog" ).dialog( "close" );
                            
                               Listar_Articulos_Plantilla();
                            
                                Actualizar_Ajustes();
                           
			});
                         
                       
                         
                         
                     }
                     
                     
                  
			
		});
	});
     
 

// Link to open the dialog
$( "#dialog-link" ).click(function( event ) {
	$( "#dialog" ).dialog( "open" );
	event.preventDefault();
         Actualizar_Ajustes();
});






// Hover states on the static widgets
$( "#dialog-link, #icons li" ).hover(
	function() {
		$( this ).addClass( "ui-state-hover" );
	},
	function() {
		$( this ).removeClass( "ui-state-hover" );
	}
);
</script>


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
          
</body>
</html>
