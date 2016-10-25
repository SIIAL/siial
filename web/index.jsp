<%-- 
    Document   : index
    Created on : 02-oct-2016, 11:05:11
    Author     : WILSON
--%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.xml.bind.ParseConversionEvent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "Entidad_Negocio.Usuario_EN"%>
<%@ page import= "Logica_Negocio.Usuario_LN"%>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Estilos/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  		<!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
            <!--  <link href="Estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
            <script src="JS/bootstrap_min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Estilos/bootstrap.min.css">
        <title>Validación de Usuarios</title>
    </head>
    <body>
        
        <center>
        	<!-- TABLA ENCABEZADO width="100%" border="0" -->
	    	<table class="table table-condensed">
          		<tr>
    	    		<td width="6%" height="112" style="text-align: left"><img src="Iconos/LE.png" width="66" height="65" alt=""/></td>
    	   			<td width="83%">
             			<h6><strong>MINISTERIO DE DEFENSA NACIONAL<br>
   	            		 FUERZAS MILITARES DE COLOMBIA<br>
   	            		 EJÃRCITO NACIONAL <br>
   	            		 COMANDO DE PERSONAL<br>
              			 SECCION EJECUCION PRESUPUESTAL</strong></h6>
            		</td>
           			 <td width="9%"><p style="text-align: left">
            		 <img class="img-rounded" alt="Cinque Terre" src="Iconos/COPER.jpg" width="60" height="79" alt="right" /></p>
            		 </td>
    		</table>
            <!-- TÃTULO SIIAL -->
         	 
            <h3><div class="alert alert-info"><strong>SISTEMA INTEGRADO DE ALIMENTACIÓN DEL EJÉRCITO (SIIAL)</strong></h3></div>
			              
             <!-- TEXTO JUSTIFICADO -->
            <div class="container">
            <div class="jumbotron">
                <h3><p class="text-justify">El SISTEMA INTEGRADO DE ALIMENTACIÓN SOLDADOS "SIIAL", es un sistema de información diseñado para la administración y control en tiempo real de la partida de alimentación en su ejecución, fortaleciendo con ello los lineamientos del Comando General del Ejército Nacional y garantizando el cumplimiento de las normas y directivas vigentes.</p><h3>
                        <h></h>
                        </div>  
            </div>
            
 <div class="container">
          
     <h4>INGRESAR AL SISTEMA</h4>
     <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Autenticación</button>
        
        
          <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
            
             
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Validación del Usuario</h4>
                </div>
                <div class="modal-body">
        
        
                    
                     <form  Action="index.jsp" method= 'post' >
  <center>
  <table>
  	<tr><td>
    	<div class="form-group">
  		<div class="col-md-12">
   		<label for="exampleInputEmail1">Usuario</label>
   		<input type="usu" class="form-control" id="exampleInputEmail1" name="Login" placeholder="Nombre de usuario"><p></p>
    		<div class="form-group">
    		<label for="exampleInputPassword1">Contraseña</label>
			<input type="password" class="form-control" name="Password" id="exampleInputPassword1" placeholder=	"Contraseña">
        	
                </div>
                
         </div>
        </div></td></tr>
   </table>
   </center>
                            <button type="submit" class="btn btn-primary" name="Ingresar">Ingresar</button>
   </form>
                    
                    
        
        

    <p>
            <script src="assets/packages/jquery/dist/jquery.min.js"></script>
            <script src="assets/packages/bootstrap/dist/js/bootstrap.min.js"></script>
    </p>
   
                  
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
              </div>
              
            </div>
          </div>
  
</div>             
                        <!-- ABRIR LOGIN -->
<!-- TABLA PIÃ DE PÃGINA -->
     
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
            		
                       <img alt="Cinque Terre" class="img-rounded" width="120" height="120" alt="right"   src="Iconos/LA.png" alt=""/>
                            
                        </td>
                  </tr>
                <tr>       
       
            </body>
          </table>     
        
        
        
        <%
            

 if( request.getParameter("Ingresar")!=null)
     {
         

           try{
            String Login = request.getParameter("Login");
            String Password = request.getParameter("Password");
            
            Usuario_EN Usu_EN= new Usuario_EN();
            Usuario_LN Usu_LN= new Usuario_LN();
            
            Usu_EN.setLogin(Login);
            Usu_EN.setPassword(Password);
      
              HttpSession sesion=request.getSession(true);            
              ResultSet Res=  Usu_LN.Validadar_Usuario(Usu_EN);
              Res.next();
              
                    String Ident = Res.getString("Identificacion");
                    sesion.setAttribute("Ident",Ident);
          
                     String Log = Res.getString("Login");
                    sesion.setAttribute("Log",Log);
                    
                    String Nomb_Unidad = Res.getString("Nomb_Unidad") ;
                    sesion.setAttribute("Nomb_Unidad",Nomb_Unidad); 
                    
                    String Unidad = Res.getString("Unidad") ;
                    sesion.setAttribute("Unidad",Unidad); 
                    
                     String Sigla = Res.getString("Sigla") ;
                    sesion.setAttribute("Sigla",Sigla); 
                    
                    
                    String Tipo_Usuario = Res.getString("Tipo") ;
                    sesion.setAttribute("Tipo_Usu",Tipo_Usuario);  
                      
                 
                    if(!Tipo_Usuario.isEmpty()){
                  
                   response.sendRedirect("http://localhost:8084/SIIAL/GUI/Sesion.jsp");
                  
                  }
  
           }catch(Exception e){out.println("<script>alert('Usuario o contraseña invàlida')</script>");} 
                  
                  
                  
               
               }
                  
                   
                  
          
         //  }catch(Exception e){}   
                     
                     
                     
                     
                     

              
    
                   
                       
           

            
            %>
     
    </body>
</html>



