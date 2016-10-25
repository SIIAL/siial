<%-- 
    Document   : Validadar_Usuario
    Created on : 24-sep-2016, 14:38:53
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
        <link rel="stylesheet" type="text/css" href="../Estilos/Estilos.css" media="all" /> 
        <title>Validación de Usuarios</title>
    </head>
    <body>
       
        <BR><BR><BR><CENTER><B><H2>VALIDAR USUARIO</H2></B></CENTER><BR>
         <CENTER><TABLE class="table">   <FORM action="Validar_Usuario.jsp" method="post">
   
 
       <TR><TD><LABEL for="Usuario:">Usuario: </LABEL><TD><INPUT type="text" name="Login">
       <TR><TD><LABEL for="Clave :">Clave </LABEL><TD> <INPUT type="password" name="Password">
       <TR><TD  align ="CENTER" COLSPAN="2"><input type="submit" name="Ingresar" value="Ingresar" class="registrar" ><BR><BR><BR><BR>
   
    </FORM><TR></TABLE></CENTER>
        
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
                    
                    String Tipo_Usuario = Res.getString("Tipo") ;
                    sesion.setAttribute("Tipo_Usu",Tipo_Usuario);  
                      
                 
                    if(!Tipo_Usuario.isEmpty()){
                  
                   response.sendRedirect("http://localhost:8084/SIIAL/GUI/Sesion.jsp");
                  
                  }
  
           }catch(Exception e){out.println("error");} 
 
               }
    
          
         //  }catch(Exception e){}   
                     
         
            %>
        
        
        
        
       
    </body>
</html>



