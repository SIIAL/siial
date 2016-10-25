<%-- 
    Document   : Sesion
    Created on : 24-sep-2016, 16:43:22
    Author     : WILSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="us">
<head>
	<meta charset="utf-8">
	<title>jQuery UI Example Page</title>
	<link href="../../JS/jquery/jquery-ui.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                
	<style>
	body{
		font-family: "Arial", verdana;
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

    <table class="table table-condensed">
          		<td width="6%" height="112" style="text-align: left">
                            <img src="../../Iconos/LE.png" width="66" height="65" alt=""/>
                        </td>
                        <td width="83%">
             			<h6><strong>MINISTERIO DE DEFENSA NACIONAL<br>
   	            		 FUERZAS MILITARES DE COLOMBIA<br>
   	            		 EJÃRCITO NACIONAL <br>
   	            		 COMANDO DE PERSONAL<br>
              			 SECCION EJECUCION PRESUPUESTAL</strong></h6>
            		</td>
           			 <td width="9%">
                                     <p style="text-align: left">
                                        <img class="img-rounded" alt="Cinque Terre" src="../../Iconos/COPER.jpg" width="60" height="79" alt="right"/>
                                       
                                     </p>
                                 </td>
    </table>
          
         	 
<h5 class="demoHeaders">
<%
    double Total_Fresco_40=0;
    double Total_Secos_60=0;
    String Ident="";
    String Tipo_User="";
    String Nomb_Unidad="";
    String Unidad="";
    String Log= "";
    String Cod_Planilla= "";
    String Sigla= "";
    try{
       HttpSession sesion=request.getSession(true);

                 Ident=(String)sesion.getAttribute("Ident");
                 Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                 Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                 Unidad=(String)sesion.getAttribute("Unidad");
                 Log= (String)sesion.getAttribute("Log");
                 Cod_Planilla=  (String)sesion.getAttribute("Cod_Plan");
                 Sigla=(String)sesion.getAttribute("Sigla");
                
                
    
               //out.println("<table><tr><td>");
               //out.println("<tr><td>Usuario : "+Log);
               out.println("<center><b><font size='5' face='arial' color='black'>MODALIDADES "+Sigla+"</font></center>");
               //out.println("</table>");  
    }catch(Exception e){}
    

  
                if(Log.isEmpty()){
                
                response.sendRedirect("../Validar_Usuario.jsp");
                
                }
               

%>

</h4>
<Center>
    
    
    <div>
    <ul style="width:500px;" id="menu">
	
        <li><div><h4>ABASTECIMIENTO</p></h4></div>
		<ul>
			<li><div><a href="../ABASTECIMIENTO/Abastecimiento.jsp">REGISTRAR ABASTECIMIENTO</a></div></li>
                        <li><div><a href="../ABASTECIMIENTO/Consolidado.jsp">GENERAR CONSOLIDADO</a></div></li>
			
		</ul>
	</li>
        <li><div><a href="../DEVOLUCION/Devolucion.jsp"><h4>DEVOLUCIONES</h4></a></div></li>
        <li><div><a href="../COMIDA_CALIENTE/Comida_Caliente.jsp"><h4>COMIDA CALIENTE</h4></div></li>
        <li><div><h4>PLAN DE MEJORAS</h4></div></li>
</ul></div>
    
 
</Center>




<table width="102%" border="0" align="center">
                  
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
                              </h6>
                          </blockquote>
                       </td>
                                    	
                    <td width="1%">
                   	<td width="17%"><p style="text-align: left">
                        <img alt="Cinque Terre" class="img-rounded" width="120" height="120" alt="right" src="../../Iconos/LA.png" alt=""/>
                        </td>
                  </tr>
                <tr>       
       
            
          </table>  

</body>


<script src="../../JS/jquery/external/jquery/jquery.js"></script>
<script src="../../JS/jquery/jquery-ui.js"></script>
<script>




$( "#menu" ).menu();


$( "#radioset" ).buttonset();






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







</body>
</html>
