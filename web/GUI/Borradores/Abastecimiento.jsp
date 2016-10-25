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

<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../Estilos/Estilos.css" media="all" /> 
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="../JS/bootstrap_min.js" type="text/javascript"></script>
         <link href="../Estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
         <script src="../JS/bootstrap_min.js" type="text/javascript"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <title>Registro de Abastecimiento</title>
        
        
        
    </head>
    <body>
       
    
<%
               
                HttpSession sesion=request.getSession(true);
                
                String Ident=(String)sesion.getAttribute("Ident");
                String Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                String Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                String Unidad=(String)sesion.getAttribute("Unidad");
                String Log= (String)sesion.getAttribute("Log");
                
                
                if(Log.isEmpty()){
                
                response.sendRedirect("http://localhost:8084/SIIAL/GUI/Validar_Usuario.jsp");
                
                }
               
           
               
               
               out.println("<table><tr><td>");
               out.println("<tr><td>Usuario : "+Log);
               out.println("<tr><td><center>Unidad : "+Nomb_Unidad+"</center>");
               out.println("<tr><td></table>");              



%>    
        <table width="350" border="0" align="center" class="table-hover" >
<tr>
<td colspan="2" align="center"><div class="title">GENERAR PLANILLA DE ABASTECIMIENTO </div></td>
</tr><br><br><br><br>
       
    
        <form action="Abastecimiento.jsp" method="post">
            
            
        <select  class="form-control" name="Periodo"  i="gggg" >
            <option value="">sasa</option >
            </select>
            
            ytdtdtdjhfyjuvjb
            
         <tr><td><label >PERIODO</label></td><br><br><td><select  class="form-control" name="Periodo" required >
             <option value="">----Seleccionar Un Periodo----</option>

                 <% 
 
                Periodo_LN Pdo_LN = new Periodo_LN();
                Periodo_EN Pdo_EN = new Periodo_EN();
                for (Periodo_EN Pdo :  Pdo_LN.Listar_Periodos())
                        {
                            out.println("<option value="+Pdo.getId_Periodo()+">"+Pdo.getMes()+" de "+Pdo.getAnio()+" </option >  ");
                        }
                 %>                      
            </select>   </tr></td>  
         
       
         <tr><td><label>COMPAÑIAS</label></td><br><br><td><select name="Cod_Compania" required>
             <option value="">----Seleccionar Una Compañia----</option>
            <%
             Compania_LN Comp_LN = new Compania_LN();
       try{
            ResultSet Res1= Comp_LN.Listar_Companias_Unnidad(Unidad);
             while(Res1.next()){
            out.println("<option value="+Res1.getString("Codigo_Comp")+">"+Res1.getString("Nomb_Comp")+" </option >  ");
                        }
       }catch(Exception e){out.println("error");}
             %>
         </select>   </tr></td>  
            <tr>       
                <td colspan='2' aling='center'><input type="submit" id="Btn_Crear_Planilla" Name="Btn_Crear" value="Crear Planilla" class="registrar"    >
                </td> </tr> </table><br><br> 
        </form>
      
        
        
       <%
       
             
  if(request.getParameter ("Btn_Crear") !=null )
     {
         
     
         Planilla_EN Plan_EN = new Planilla_EN();
         Planilla_LN Plan_LN = new Planilla_LN();
         Estancia_LN Est_LN = new Estancia_LN();
         
         Date fechaActual = new Date();
         DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
         
         try{
             
         Plan_EN.setCod_Planilla(Plan_LN.Generar_Codigo_Abastecimiento()+1);
         
         
         Plan_EN.setTipo_Modalidad("Abastecimiento");
         Plan_EN.setEstado_Plan("Borrador");
         Plan_EN.setEstancia(Est_LN.Listar_Estancia_Activa().getId_Estancia());
         Plan_EN.setCompania(Integer.parseInt(request.getParameter("Cod_Compania")));
         Plan_EN.setFecha_Reg(formatoFecha.format(fechaActual).toString());
         Plan_EN.setPeriodo(Integer.parseInt(request.getParameter("Periodo")));
  
         
        if(Plan_LN.Crear_Planilla(Plan_EN)){
  
        }
        
         }catch(Exception e){
             
        // out.println(" Error al guardar "+e.getMessage());
         
         }
         
   
     }// Fin del boton Crear
       
Planilla_LN Plan_LN = new Planilla_LN();

try{
   ResultSet Res= Plan_LN.Listar_Planillas_Abastecimmiento_Borrador( Integer.parseInt(Unidad));
   
    out.println("<center><table class='table table-hover'><tr><td>CODIGO</td><td>FECHA</td><td>ESTADO</td><TD>CONFIGURAR</TD>");  
              
            while(Res.next()){
   
              out.println("<tr><td>"+Res.getString("Cod_Planilla")+"</td>"
                                    +"<td align='center'>"+Res.getString("Fecha_Reg")+"</td>"
                                 //  +"<td>"+Res.getString("Mes_Per")+"-"+Res.getString("Anio_Per")+"</td>" 
                                    +"<td align='center'>"+Res.getString("Estado_Plan")+"</td>"+"</td>"  
                                    
                                    +"<td align='center'><A href='Soldados_Abastecimiento.jsp?Cod_Plan="+Res.getString("Id_Planilla")+"'>Abrir</A></td>"+"</td>");  
                                 
                        }
            
            out.println("</td></tr></table></center>");  
            
}catch(Exception e){out.println("error");  }

       
       
       %> 
                 
                 
                 
                 
                 
                 
                 
                 
                 
        
        
    </body>
</html>
