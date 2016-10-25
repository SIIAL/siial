<%-- 
    Document   : Abastecimiento_Soldado
    Created on : 04-oct-2016, 21:01:45
    Author     : WILSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="us">
<head>
	<meta charset="utf-8">
	<title>jQuery UI Example Page</title>
	<link href="../JS/jquery/jquery-ui.css" rel="stylesheet">
        <script src="../JS/jquery/external/jquery/jquery.js"></script>
  
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
    <script>      
     // al cargar la pagina Listar
            $(function(){
                       
                         $('#Ciclos').hide();
                          Listar_Ciclos_Planilla();
                            Listar_Soldados_Unidad();
                            Listar_Soldados_Reg_Planilla() ;
                        });  
             
      
// funcion para agregar ciclo de una planilla
$(document).ready(function() {
		$('#Boton_Abrir_Form_Ciclo').click(function(event) {
			
                      $( "#Ciclos" ).dialog({
                           modal: true,
                            title: "Registro de Ciclos de Alimentación",
                            width: 550,
                            minWidth: 400,
                            maxWidth: 650,
                            show: "fold",
                            hide: "scale"
                            });
		});
	});
                  
      
  //---------------------------------------------------------------    
// funcion para Guardar  ciclos de una planilla
$(document).ready(function() {
		$('#Btn_Crear_Ciclo').click(function(event) {
			var Id_Plan = $('#Id_Planilla').val();
                        var fecha_inic = $('#fecha_inic').val();
                        var Num_Dias = $('#Num_Dias').val();
                        var fecha_fin = $('#fecha_inic').val();
                        var Tipo_Ciclo = $('#Tipo_Ciclo').val();
                        
                        var Btn_Crear_Ciclo = $('#Btn_Crear_Ciclo').val();
                        var Listar_Ciclo_Planilla = $('#Btn_Crear_Ciclo').val();
		   
			$.post('../Ciclos', {
				Id_Pla : Id_Plan,
                                fecha_inic : fecha_inic,
                                Num_Dias : Num_Dias,
                                fecha_fin : fecha_fin,
                                Btn_Crear_Cic : Btn_Crear_Ciclo,
                                Tipo_Ciclo : Tipo_Ciclo,
                                Listar_Ciclo_Planilla : Listar_Ciclo_Planilla
       
			}, function(responseText) {
                            $( "#Ciclos" ).dialog( "close" );
                            Listar_Ciclos_Planilla();
                             // alert(responseText);
                            
                             //  event.preventDefault();  
                               
                           
			});
		});
	});
     
    
  //-------------------------------------------------------------------------  
   
//Se listan los ciclos creados para un planilla
function Listar_Ciclos_Planilla() {
                                        // $("#tabla_SLD").load("../Soldado_Abastecimiento");
             var Id_Plan = $('#Id_Planilla').val();
           var Listar_Ciclo_Planilla = $('#Btn_Crear_Ciclo').val();
           
			$.post('../Listar_Ciclos', {
				
                          Id_Pla : Id_Plan,
                          Listar_Ciclo_Planilla : Listar_Ciclo_Planilla
           
			}, function(responseText) {
                           // $('#tabla_SLD').text("");
                                 $('#List_Ciclos').html('');                       
                           $.each(responseText,function(ind,Ciclo_EN) {
                         
                         
                         
                                 $('#List_Ciclos').append($("<option>", { 
                                        value: Ciclo_EN.Id_Ciclo,
                                            text : Ciclo_EN.Tipo_Ciclo+" de "+Ciclo_EN.Numb_Dias +" Dias,  Del " +Ciclo_EN.Fech_Inicio+" Hasta " +Ciclo_EN.Fech_Fin
                                                    }));
                                
                           });
                        
			});                              
                                                   
                                       }
                                       
                                       
               
    //---------------SE LISTAN SOLDADOS DE LA UNIDAD-----------
    
    function Listar_Soldados_Unidad() {
                                        
           
           //alert("hola");
            var Cod_Unidad = $('#Cod_unidad').val();
           var Listar_Soldado_Uni = "Listar_Soldado_Unidad";
			$.post('../Soldado', {
				
                          Cod_Unidad : Cod_Unidad,
                          Listar_Soldado_Unidad : Listar_Soldado_Uni
           
			}, function(responseText) {
                           // alert(responseText);
                            $('#Lista_Soldados_Planilla').html(responseText);
			});                                       
                                       }
    
    //----------------------REGISTRAR SOLDADO A AL CICLO----------------------------------
  //Bton_Reg_Sold
         
$(document).ready(function() {
		$('#Bton_Reg_Sold').click(function(event) {
	            var Id_Ciclo =  $('#List_Ciclos').val();
                        
                     var list_soldados = $('#list_soldados').val();
                     
                     var Reg_Sald_Planill = "Reg_Sald_Planilla";
                     
                    
		   
			$.post('../Planilla_Soldado', {
                               list_soldados : list_soldados,
                               Id_Ciclo : Id_Ciclo,
                               Reg_Sald_Planilla : Reg_Sald_Planill
			}, function(responseText) {
                               Listar_Soldados_Unidad();     
                             alert(responseText);
                               
                           
			});
		});
	});
       
    
    
    //----------------------------------------------------------------
       
    
    
      function Listar_Soldados_Reg_Planilla() {
                                        
         
            var Id_Plan = $('#Id_Planilla').val();
            var Listar_Sold_Reg_Plan = "Listar_Sold_Reg_Plan";
			$.post('../Planilla_Soldado', {
				
                          Id_Plan : Id_Plan,
                          Listar_Sold_Reg_Plan : Listar_Sold_Reg_Plan
           
			}, function(responseText) {
                           // alert(responseText);
                            $('#Lista_Sold_Reg_Planilla').html(responseText);
			});                                       
                                       }   
    
    
    
    
    
    
    
    
    
    
    
    
   //---------------------------------------------------------
    
    
    
    
    
 
     </script>     
        
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


 String Cod_Planilla= request.getParameter("Cod_Plan").toString();

            
         %>



</form>

<br><br><br><fieldset>
	<legend>REGISTRAR CICLOS DE ALIMENTACION</legend>
	<center><div id="demoHeaders">
                <select id="List_Ciclos">
			<option>---</option>
		</select>
                <button id="Boton_Abrir_Form_Ciclo" class="ui-button ui-corner-all ui-widget">
		<span class="ui-icon ui-icon-newwin"></span>CREAR CICLO
	</button>
	</div></center>
</fieldset>

<!-- Tabs -->

<div id="tabs">
	<ul>
		<li><a href="#Ciclos_Reg">SOLDADOS</a></li>
		<li><a href="#tabs-2">ARTICULOS</a></li>
	</ul>
	
    
    <div id="Ciclos_Reg">
        
        <fieldset>
	<legend><button id="Bton_Reg_Sold">Registrar</button></legend>
        
        
        
           <div id="Lista_Soldados_Planilla" style="overflow:scroll;height:800px;width:600px;">  
            
           </div>
            <div id="Lista_Soldados_Planilla" style="overflow:scroll;height:800px;width:600px;">  
            
           </div>
        
         </fieldset>
  
	
	

</div>

   <div id="Ciclos" height:450px; width:300px;">
                            
                                   <center><br><table  ><tr><td <td colspan='4' align='center'></td>CREAR CICLO DE ABASTECIMIENTO</td>
                                         <tr><td><input type="text" id="Cod_unidad" size="5" value="<% out.println(Unidad);%>" Disabled> </td>        
                                         <tr><td><input type="text" name="transmission" id="Id_Planilla" size="5" value="<% out.println(Cod_Planilla);%>" Disabled> </td>        
           
                                             
                                         <tr><td colspan='4' align='center'><select id="Tipo_Ciclo" required>      
                                             <option value="Abastecimiento">Abastecimiento de Alimentación</option>
                                             <option value="Raciones">Racion de Campaña</option>
                                             </select></td>
                                                        <tr><td>Fecha Inicio</td><td ><input type="date" id="fecha_inic" value="" size="20" required > </td>
                                                        <tr><td>Numero Dias</<td><td><select id="Num_Dias" required>   
                                                        <%
                                                             for(int i =1; i<=31;i++){out.println("<option value="+i+">"+i+" Dia"+"</option>"); }
                                                        %>
                                           
                                               </td> </select>
                                                <tr><td>Fecha Final</td> <td><input type="text" id="fecha_fin" size="10" value="" size="20" Disabled > </td>
                                                <tr><tr><td colspan='4'  align='center'><input type="button"  id="Btn_Crear_Ciclo" value="CREAR CICLO"   ></td> </tr>     
                 </table>
                                
                            </div>
    


<script>


$( "#tabs" ).tabs();










</script>
</body>
</html>
