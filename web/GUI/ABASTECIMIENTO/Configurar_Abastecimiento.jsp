<%-- 
    Document   : Ciclo
    Created on : 05-oct-2016, 20:30:29
    Author     : WILSON
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="Logica_Negocio.Planilla_Soldado_LN"%>
<%@page import="Entidad_Negocio.Planilla_Soldado_EN"%>
<%@page import="Logica_Negocio.Soldado_LN"%>
<%@page import="Entidad_Negocio.Soldado_EN"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Logica_Negocio.Planilla_LN"%>
<%@page import="Logica_Negocio.Ciclo_LN"%>
<%@page import="Entidad_Negocio.Ciclo_EN"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "Entidad_Negocio.Ciclo_EN"%>
<%@ page import= "Logica_Negocio.Ciclo_LN"%>
<!DOCTYPE html>

<html lang="us">
    
<head>
	<meta charset="utf-8">
	<title>Registro de Articulos</title>
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

     <table  >
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
    String Tipo_Modalidad="";
       HttpSession sesion=request.getSession(true);
    try{
      

                 Ident=(String)sesion.getAttribute("Ident");
                 Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                 Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                 Unidad=(String)sesion.getAttribute("Unidad");
                 Log= (String)sesion.getAttribute("Log");
                 Cod_Planilla=  (String)sesion.getAttribute("Cod_Plan");
                 Tipo_Modalidad= (String)sesion.getAttribute("Tip_Mod");
                
                 
                
               // out.println(Tipo_Modalidad);
            
               // double Total_Fresco_40=0;
                //double Total_Secos_60=0;
                
                  out.println("<br>Planilla: "+Cod_Planilla);
             
                 
                Planilla_LN Pla_LN= new Planilla_LN();
                Planilla_Soldado_EN Plan_Sold_EN = new Planilla_Soldado_EN();
                Planilla_Soldado_LN Plan_Sold_LN = new Planilla_Soldado_LN();
                Ciclo_LN Cicl_LN = new Ciclo_LN();
               
                String Mes ="";
                String Anio="";
                      
             
               out.println("<table><tr><td>");
               out.println("<tr><td>Usuario : "+Log);
               out.println("<tr><td><center>Unidad : "+Nomb_Unidad+"</center>");
               out.println("</table>");              
    }catch(Exception Ex){ response.sendRedirect("http://localhost:8084/SIIAL/index.jsp");}
    
          

%>



<%
 try{
    if(request.getParameter ("Id_Ciclo") !=null )
                    {
                        sesion.removeAttribute("Id_Ciclo");
                        sesion.setAttribute("Id_Ciclo",request.getParameter("Id_Ciclo").toString());
    
                        response.sendRedirect("Soldado_Abastecimientos.jsp");
                    }
                if(Log.isEmpty())
                        {
                            response.sendRedirect("../..//GUI/Validar_Usuario.jsp");
                        }
    }catch(Exception Ex){} 



%>


            <BR><BR><TABLE cellspacing="10">
                <TR>

                   
                      <TD colspan='2' align='center'>
                            <input type="button" class="btn btn-default" id="Btn_Abrir_Form_Ciclo"  value="Crear Ciclo" class="registrar"><br><br>
                             <div id="Lista_Ciclos_registrado" style="overflow:scroll;height:400px;width:550px;" > </div> 
                      
                      </TD>
                      <TD style="width:30px;">
                          
                      </TD>
                       <TD>
                           
                         <center> <select id="List_Ciclos"  class="form-control" style="width:450px;"  ></select> </center>  <BR>
                                         <Div id="Lista_Solados_Activos" style="overflow:scroll;height:400px;width:900px;">   </Div>   
                       </TD>
                       
               </TR>
              

            </TABLE>  
            
         
             <center> <table style="width:920px;"> 

                         <tr><td> 
                                <Div id="Lista_Solados_Planilla"  >  </Div>
                        </td></tr>    
                   <tr><td> 
                        <div align="center"> 
                        <a href="Abastecimiento.jsp" class="btn btn-default" role="button">ATRAS</a>
                         <a href="../MODULOS/Modalidades.jsp" class="btn btn-default" role="button">MENU</a>
                        <a href="Articulos_Abastecimiento.jsp" class="btn btn-default" role="button">SIGUIENTE</a>
                       
                        </div> 
                 
                        </td></tr>
       
       
                                                       
                    </table></center>    
            
            
            
            
            

<div class="table-responsive"  style="width:60%" id="Form_Ciclos" >
    <input type="text" id="id_planilla"  size="20" value="<%out.println(Cod_Planilla); %>"  >
    <input type="text" id="Cod_Unidad"  size="20" value="<%out.println(Unidad); %>"  >
        <table class="table table-bordered" align="center" bg-ground="#D2D2D2">
                <tr>
                    <td width="150">
                        <form action="Configurar_Abastecimiento.jsp" method="post" name="nn">

                                        <!-- CICLO DEVOLUCIÓN -->
                           <div class="table table-bordered table-hover">
                                   <table class="table table-bordered" align="center">
                                       <caption class=""><h4><center><b>CICLO DE ABASTECIMIENTOS</b></center></h4></caption>
                                        <thead border="1">
                                                            <tr>
                                                                <th ><center>MODALIDAD: </center></th>
                                                                <th colspan="3"><select class="form-control" Id="Tipo_Ciclo" required>   
                                                                        <option value="Abastecimiento">Abastecimiento</option>
                                                                         <option value="Raciones">Raciones de Capaña</option>
                                                                         </select>
                                                                </th>
                                                            </tr>
                                               <tr>
                                                    <td><center><b>Mes</b></center></td>
                                                   <td><center><b>Fecha Inicio </b></center></td>  
                                                    <td><center><b>N°. Dias</b></center></td>
                                                   
                                                    <td><center><b>Fecha Término</b></center></td>

                                               </tr>
                                               <tr>
                                                    <td>
                                                     <input type="text" name="Periodo" id="Periodo" value="" size="15" ReadOnly >
                                                    
                                                   </td>
                                                   <td>
                                                    <input type="date" id="fecha_inicio" onChange="Calcular_Fecha()" >  
                                                   </td>                     
                                                   <td>
                                                       
                                                        <select name="Num_Dias"  id="Num_Dias" onChange="Calcular_Fecha()" style="width : 100px; heigth : 100px"   required>   
                                                                                    <%
                                                                                            for(int i =1; i<=31;i++){out.println("<option value="+i+">"+i+" Dia </option>"); }
                                                                                     %>
                                                    </select> 
                                                       
                                                   
                                                   </td> 
                                                  
                                                   <td>
                                                     <input type="text" name="fecha_fin" id="fecha_fin" size="10"  size="20" readonly required >  
                                                   </td>
                                             </tr>
                                           <tr>
                                               <td colspan="4" align="center">   <input type="button" class="btn btn-default" id="Btn_Agregar_Ciclo"  value="Crear Lapso" class="registrar"   >
                                               </td>
                                           </tr>
                             </table>
                                                    <form>
                                                        
                                                        
                                                         
                          </div>
                                                    
                    </table>  
                                               
            </div>
                                                    
                                               
                                                    
                                                    






 
                    
                        

<table width="102%" border="0" align="center">
             <tbody>
                
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

 <DIV id="Confirmacion_Guardado_Soldado"></DIV>   

            
   <script>
       
 
       
 function Convertir_Mes(Mes){
     
if(Mes == 'Enero' ) return 1;
if(Mes == 'Febrero' ) return 2;
if(Mes == 'Marzo' ) return 3;
if(Mes == 'Abril' ) return 4;
if(Mes == 'Mayo' ) return 5;
if(Mes == 'Junio' ) return 6;
if(Mes == 'Julio' ) return 7;
if(Mes == 'Agosto' ) return 8;
if(Mes == 'Septiembre' ) return 9;
if(Mes == 'Octubre' ) return 10;
if(Mes == 'Noviembre' ) return 11;
if(Mes == 'Diciembre' ) return 12;
         
 
     
     
     
     
 }      
       
  
  function Calcular_Fecha(){
  // fecha_inic=document.getElementById("Anio").value+"/"+document.getElementById("Mes").value+"/"+document.getElementById("Dia").value; 
 
       
 fecha_inic= document.getElementById("fecha_inicio").value;
 
 num_dias= document.getElementById("Num_Dias").value;
 

 var Periodo= document.getElementById("Periodo").value;
 //
 var Mes_Anio = Periodo.split("-");
 
  var Period =Convertir_Mes(Mes_Anio[0]);
 
  
   Fech_Ini = Date.parse(fecha_inic);
   fecha = new Date(Fech_Ini);
   var  dia = fecha.getDate();
   var  mes = fecha.getMonth() + 1;
   var anio = fecha.getFullYear();
   
       // tiempo = prompt("Ingrese la cantidad de días a añadir"),
        addTime = (num_dias) * 86400; //Tiempo en segundos
        fecha.setSeconds(addTime); //Añado el tiempo

      var  mes1=(fecha.getMonth()+1);
  if( parseInt(mes1)==Period)
        {
      // alert(mes1+"-"+Mes_Anio[0])
            document.nn.fecha_fin.value=(fecha.getDate() ) +"/"+(fecha.getMonth()+1)+"/"+fecha.getFullYear(); 
        }
 
   else{ document.nn.fecha_fin.value="";
            alert("LA FECHA SELECCIONADA ESTA FUERA DEL RANGO DEL PERIODO");
        }
   

}  


$(function(){
          
         Listar_Periodo();
       Cargar_Select_Ciclo();
      
       Lista_Ciclos_registrado();
       Lista_Solados_Activos();
       Lista_Solados_Planilla();
       
 
       
            }); 
   
  
   
   
   
   
   
   
   function Retirar_Soldado_Planilla(Ciclo,Iden_Sold){
       
        var Ciclo=   Ciclo;
        var Iden_Sold=   Iden_Sold;
             
          $.post('../..//Configurar_Abastecimiento', {
                        Retirar_Soldado_Planilla : "Retirar_Soldado_Planilla",  
                        Ciclo : Ciclo,
                        Iden_Sold : Iden_Sold
                        }, function(responseText) 
                            {
                            alert(responseText) ;
                                Lista_Solados_Planilla();
                                Lista_Solados_Activos();
                            // $('#Lista_Solados_Planilla').html(responseText);
                                });   
       
       
   }
   
   
   
   

   function Lista_Solados_Planilla(){ 
    
      // Listar_Ciclos   Cod_Planilla 
       var id_Plan=    $( "#id_planilla" ).val() ;
       
       var  Cod_Unidad = $(Cod_Unidad).val();
      
          $.post('../..//Configurar_Abastecimiento', {
                        Lista_Solados_Planilla : "Lista_Solados_Planilla",  
                        Cod_Planilla : id_Plan,
                        Cod_Unidad : Cod_Unidad
                        }, function(responseText) 
                            {
                           
                             $('#Lista_Solados_Planilla').html(responseText);
                                });    
   
}          
    
 function Cancelar_Guardado_Soldado(){
       
         $( "#Confirmacion_Guardado_Soldado" ).dialog( "close" );
       
       
   }

function Confirmacion_Guardado_Soldado(ident_Sold){
             
         
      var ident_Sold =ident_Sold;
      var Ciclo = $(List_Ciclos).val();
         
          $.post('../..//Configurar_Abastecimiento', {
                        ident_Sold : ident_Sold,
                        Ciclo : Ciclo,
                        Agregar_Soldado_Planilla : "Lista_Solados_Activos"  
                       
                        }, function(responseText) 
                            {
                                alert(responseText);
                              
                                Lista_Solados_Planilla();
                                Lista_Solados_Activos();
                                 
                                 $( "#Confirmacion_Guardado_Soldado" ).dialog( "close" );
                               // Lista_Ciclos_registrado();
                            //$('#Lista_Solados_Activos').html(responseText);
             
                                });    
   
}



       
  function Agregar_Soldado_Planilla(ident_Sold){

      var ident_Sold =ident_Sold;
      var Ciclo = $(List_Ciclos).val();

      var Ident_Sold=    ident_Sold ;
             var Ciclo = $(List_Ciclos).val();
            $.post('../..//Configurar_Abastecimiento', {
                        Ident_Sold : Ident_Sold,
                        Ciclo : Ciclo,
                        Buscar_Existencia_Modalidad_Soldado_Periodo : "Buscar_Existencia_Modalidad_Soldado_Periodo"  
                       
                        }, function(responseText) 
                            {
                                
                               var Rest= responseText;
                                //alert(Rest);
                               
                               if(parseInt(Rest)==1)
                                 Confirmacion_Guardado_Soldado(Ident_Sold)
                              else{
                                  
                                  $('#Confirmacion_Guardado_Soldado').html(responseText);
                                  $( "#Confirmacion_Guardado_Soldado" ).dialog( "open" );  
                                  
                              }
                                
                           
                           
                          
                            });    
      
      
           
                           
      
  }  
    
    
                
   function Lista_Ciclos_registrado(){ 
    
      // Listar_Ciclos   Cod_Planilla 
       var id_Plan=    $( "#id_planilla" ).val() ;
      
          $.post('../..//Configurar_Abastecimiento', {
                        Lista_Ciclos_registrado : "Lista_Ciclos_registrado",  
                        Cod_Planilla : id_Plan
                        }, function(responseText) 
                            {
                                
                            // $( "#Lista_Cilcos_registrado" ).val(responseText) ;    
                 
                         $('#Lista_Ciclos_registrado').html(responseText);
                                });    
   
}          
    
    
    
    
   
function Listar_Periodo(){ 
    
      // Listar_Ciclos   Cod_Planilla 
                             
                 

       var id_Plan=    $( "#id_planilla" ).val() ;
       
         
      
          $.post('../..//Configurar_Abastecimiento', {
                        Listar_Periodo : "Listar_Periodo",  
                        Cod_Planilla : id_Plan
                        }, function(responseText) 
                            {
                             
                             $("#Periodo").val(responseText) ;    
                 
            // $('#Lista_Planillas_Devolucion').html(responseText);
            
    
    
                                });    
   
}            
                
    

function Cargar_Select_Ciclo(){
                 $('#List_Ciclos').html("");
                  var id_Plan=    $( "#id_planilla" ).val() ;
                $.get('../..//Configurar_Abastecimiento', {
                        Listar_Ciclos : "Listar_Ciclos",  
                        id_Planilla : id_Plan
                        }, function(responseText) 
                    {
                         $.each(responseText,function(ind,Ciclo_EN) {
                          
                                 $('#List_Ciclos').append($("<option>", { 
                                        value: Ciclo_EN.Id_Ciclo,
                                            text :  Ciclo_EN.Tipo_Ciclo+" - "+ Ciclo_EN.Numb_Dias +" Dias,  Del " +Ciclo_EN.Fech_Inicio+" Hasta " +Ciclo_EN.Fech_Fin
                                                    }));
                                
                           });
                           
                           
                         // $('#Lista_Planillas_Devolucion').html(responseText);
			});    
    
    
    
}



$(document).ready(function()
            {
                        $('#Btn_Agregar_Ciclo').click(function(event)
                                {  

                            var id_Plan=    $( "#id_planilla" ).val() ;
                            var    fecha_inicio = $( "#fecha_inicio" ).val() ;
                            var    fecha_fin = $( "#fecha_fin" ).val() ;
                            var    Num_Dias = $( "#Num_Dias" ).val() ;
                            var    Tipo_Ciclo = $( "#Tipo_Ciclo" ).val() ;
                            
                            
                            $.post('../..//Configurar_Abastecimiento', {
                                fecha_inicio : fecha_inicio,
                                fecha_fin : fecha_fin,
                                id_Planilla : id_Plan,
                                Num_Dias : Num_Dias,
                                Tipo_Ciclo : Tipo_Ciclo,
                                Btn_Agregar_Ciclo : "Btn_Agregar_Ciclo"                      
                        
                        }, function(responseText) 
                            {
                                Cargar_Select_Ciclo();
                                 Lista_Ciclos_registrado();
                                 $( "#Form_Ciclos" ).dialog( "close" );
                        //alert(responseText);
                         // $('#Lista_Planillas_Devolucion').html(responseText);
                            });       
                                });              
                });

$(document).ready(function()
            {
                        $('#Btn_Abrir_Form_Ciclo').click(function(event)
                                {  
                                Listar_Periodo();           
                            $( "#Form_Ciclos" ).dialog( "open" );
                            
                                   
                                });
                });
    
    
  function  Lista_Solados_Activos(){
      
           //  
             var id_planilla =$( "#id_planilla" ).val() ;
              var Cod_Unidad =$( "#Cod_Unidad" ).val() ;
      
          $.post('../..//Configurar_Abastecimiento', {
                        Cod_Unidad : Cod_Unidad,
                        id_planilla : id_planilla,
                        Lista_Solados_Activos : "Lista_Solados_Activos"  
                       
                        }, function(responseText) 
                            {
                             //  alert(responseText);
                        //  Lista_Ciclos_registrado();
              $('#Lista_Solados_Activos').html(responseText);
             
             
                                });    
      
      
  }
    
    
    
    function Eliminar_Ciclo_Planilla(Id_Ciclo){
        
      //  alert(Id_Ciclo);
      // Listar_Ciclos   Cod_Planilla 
       var Id_Ciclo=  Id_Ciclo; 
      
          $.post('../..//Configurar_Abastecimiento', {
                        Eliminar_Ciclo_Planilla : "Eliminar_Ciclo_Planilla",  
                        Id_Ciclo : Id_Ciclo
                        }, function(responseText) 
                            {
                             //  alert(responseText);
                          Lista_Ciclos_registrado();
                          Cargar_Select_Ciclo();
             
                                });    
    }
    
    
    
    
 $("#Confirmacion_Guardado_Soldado" ).dialog({
          modal: true,
         title: "CONFIRMACIÓN DEL REGISTRO DEL SOLDADO",
         width: 800,
         minWidth: 750,
         maxWidth: 800,
         show: "fold",
         hide: "scale",
	autoOpen: false	
} );              
        
    
    
    
    
  $( "#Form_Ciclos" ).dialog({
          modal: true,
         title: "Registro Ciclo de Abastecimiento",
         width: 800,
         minWidth: 750,
         maxWidth: 800,
         show: "fold",
         hide: "scale",
	autoOpen: false,
	width: 500
          
       
	
} );              
        



</script>
         
            
            
          
</body>
</html>
