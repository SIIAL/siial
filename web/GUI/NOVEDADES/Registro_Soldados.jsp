<%-- 
    Document   : Registro_Soldados
    Created on : 19-sep-2016, 22:22:03
    Author     : WILSON
--%>

<%@page import="Entidad_Negocio.Banco_EN"%>
<%@page import="Acceso_Datos.Novedad_AD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import= "Logica_Negocio.Novedades_LN"%>
<%@ page import= "Entidad_Negocio.Novedad_EN"%>
<%@ page import= "Logica_Negocio.Compania_LN"%>
<%@ page import= "Entidad_Negocio.Compania_EN"%>
<%@ page import= "Logica_Negocio.Banco_LN"%>
<%@ page import= "Entidad_Negocio.Banco_EN"%>
<%@ page import= "Logica_Negocio.Soldado_LN"%>
<%@ page import= "Entidad_Negocio.Soldado_EN"%>

<%@ page import= "Logica_Negocio.Cuenta_LN"%>
<%@ page import= "Entidad_Negocio.Cuenta_EN"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../Estilos/Estilos.css" media="all" /> 
    </head>
    
    <script type="text/javascript">

function Activar_Banccos(){
    
    
    
    
    
}

</script>

           
    <body>
       
  
        <table width="350" border="0" align="center" class="table" >
<tr>
<td colspan="2" align="center"><div class="title">REGISTRO DE SOLDADOS </div></td>
</tr><br>
       
    
        <form action="Registro_Soldados.jsp" method="post">
    
       <tr><td width="111"><label> IDENTIFICACIÓN </label></td><td>    <input type="number"  name="Identificacion" size="50"  placeholder="Digite la Identificacion" required="required" /></td></tr>
       
       <tr><td><label>NOMBRES</label></td><td> <input type="text" name="Nombres" size="50" placeholder="Digite los Nombres" required /></td></tr>
         
       <tr><td><label>APELLIDOS</label></td><td> <input type="text" name="Apellidos" size="50" placeholder="Digite los Apellidos" required /></td></tr>
           
       <tr><td><label>GRADO</label></td><td><select name="Grado" required >
             <option value="">----Seleccionar el Grado----</option>
             <option value="SLP">SOLDADO PROFESIONAL</option>
             <option value="SLR">SOLDADO REGULAR</option>
             <option value="SLB">SOLDADO BACHILLER</option>
              <option value="SLC">SOLDADO CAMPESINO</option>
               </select>   </tr></td> 
             
             
            
          <tr><td><label>NOVEDAD</label></td><td><select name="Novedad" required>
             <option value="">----Seleccionar Novedad----</option>

                 <% 
 
                 Novedad_EN Nov_EN = new Novedad_EN();
                 Novedades_LN Nov_LN = new Novedades_LN();
                    
                 for (Novedad_EN noved :  Nov_LN.Lista_Novedades()){
             out.println("<option value="+noved.getId_Novedad()+">"+noved.getNomb_Novedad()+" </option >  ");
            }
                 
                 %>
                                     
            </select>   </tr></td>      
      
            
          <tr><td>  <label >COMPAÑIA</label><td><select name="Compania" required>
             <option value="">----Seleccionar Compañia----</option>
               
              <% 
                Compania_EN comp_EN = new Compania_EN();
                Compania_LN Comp_LN=  new Compania_LN();
      
                 for (Compania_EN comp :  Comp_LN.Lista_Compania()){
                      out.println("<option value="+comp.getCodigo_Comp()+">"+comp.getNomb_Comp()+" </option >  ");
            }
                 
                 %>
                 
            </select></td>   </tr>        
           <tr><td colspan="2" align="center">
                   <fieldset id="Cuentas">
                       
                       <legend>CUENTA BANCARIA</legend>
                   
                       <br><label>BANCO </label><br><select name="Banco" required>
             <option value="">----Seleccionar Banco----</option>
             
                <% 
                  Banco_EN Banc_EN = new Banco_EN();
                  Banco_LN Banc_LN = new Banco_LN();
         
                 for (Banco_EN Banc :  Banc_LN.Lista_Bancos())
                        {
                        out.println("<option value="+Banc.getCod_Banco()+">"+Banc.getNomb_Banco()+" </option >  ");
                        }
                 %>
                        
            </select><br>     
                   <br><label> NUM. CUENTA </label> <br><input type="text" name="Num_Cuenta" size="50" placeholder="Digite la Num. Cuenta" required />    
                   </fieldset> </tr></td>
        
        <tr><td  align="center"> 
 
        </label></tr></td>
        
        <tr><td colspan="2"  align="center" > <table width="350" border="0" align="center" >
        <tr><td> <input type="submit" id="Btn_Registrar" Name="Btn_Guardar" value="Guardar" class="registrar"></td>        
    <td><input type="Button" id="Btn_Eliminar" Name="Btn_Eliminar" value="Eliminar" class="registrar"    onclick="miFuncion()"  ></td> </tr>  
  </table >
       
 </table> <br>
         
        </form>
   <table width="350" border="0" align="center" class="table" >            
                 
  <form method="POST" enctype="multipart/form-data" action="Validar_Nomina.jsp">
  <tr><td>Seleccionar Archivo Plano :</td>
  <tr><td><input type="file" name="upfile"  ></td><br/>
 
  <br/>
   <tr><td><input type="submit" value="Subir" class="registrar"></td> 
</form>       
                 
          </table >              
                 
                 
                 
                 
      
                 
  <%
      
  if(request.getParameter ("Btn_Guardar") !=null )
     {
                
             Soldado_EN Sold_EN = new Soldado_EN();
             Soldado_LN Sol_LN = new Soldado_LN();
             
             Cuenta_EN Cta_EN= new Cuenta_EN();
             Cuenta_LN Cta_LN= new Cuenta_LN();
                     
             
             try{
                 
//Datos del soldado
             Sold_EN.setIdent_Sold(Integer.parseInt(request.getParameter ("Identificacion")));
             Sold_EN.setNombres(request.getParameter ("Nombres"));
             Sold_EN.setGrado(request.getParameter ("Grado"));
             Sold_EN.setNovedad(Integer.parseInt(request.getParameter ("Novedad")));
             Sold_EN.setCompania(Integer.parseInt(request.getParameter ("Compania")));
             Sold_EN.setApellidos(request.getParameter ("Apellidos"));
            
//Datos de la Cuenta
             
             Cta_EN.setNum_Cuenta(request.getParameter ("Num_Cuenta"));
             Cta_EN.setBanco(Integer.parseInt(request.getParameter ("Banco")));
             Cta_EN.setHabiltado(true);
             Cta_EN.setSoldado(Integer.parseInt(request.getParameter ("Identificacion")));
                 
             
              
              
           
           if( Sol_LN.Registrar_Soldado(Sold_EN)){
               
                if( Cta_LN.Registrar_Cuenta(Cta_EN)){
                    out.println("<script>alert('DATOS DEL SOLDADO REGISTRADO');</script>");
                    }
           } else {   out.println("<script>alert('NO SE REGISTRO EL SOLDADO');</script>");}
           
           
             }catch(Exception e) {}            
              
                
                
     }
  
  
  
  %>               
                 
                 
                 
                 
            
            
    </body>
</html>
