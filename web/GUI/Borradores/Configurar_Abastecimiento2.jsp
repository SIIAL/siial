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
<html>
    <head>
       
        <script src="../../JS/jquery-latest.js" type="text/javascript"></script>
        <script src="../../JS/jquery-ui.js" type="text/javascript"></script>
        <script src="../../JS/jquery-ui.min.js" type="text/javascript"></script>
        <link href="../JS/jquery/jquery-ui.css" rel="stylesheet">
        <script src="../JS/jquery/external/jquery/jquery.js"></script>
        <script src="../../JS/bootstrap_min.js" type="text/javascript"></script>
        <link href="../../Estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
       
        
   <script type="text/javascript">
       
       

       
       
      $(document).ready(function() {
		$('#Btn_Agregar').click(function(event) {
                   $( "#nn" ).dialog({
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
       
     
   //calcular fecha segun nuero de dias 
function Calcular_Fecha(){
  // fecha_inic=document.getElementById("Anio").value+"/"+document.getElementById("Mes").value+"/"+document.getElementById("Dia").value; 

 fecha_inic= document.getElementById("fecha_inicio").value;



 
   num_dias= document.getElementById("Num_Dias").value;
   
   mes_prog= document.getElementById("Mes").value;
   
   Fech_Ini = Date.parse(fecha_inic);
   fecha = new Date(Fech_Ini);
   var  dia = fecha.getDate();
   var  mes = fecha.getMonth() + 1;
   var anio = fecha.getFullYear();
       // tiempo = prompt("Ingrese la cantidad de días a añadir"),
        addTime = (num_dias) * 86400; //Tiempo en segundos
        fecha.setSeconds(addTime); //Añado el tiempo

      var  mes1=(fecha.getMonth()+1);

     
  //document.nn.fecha_fin.value=(fecha.getDate() ) +"/"+(fecha.getMonth()+1)+"/"+fecha.getFullYear(); 
    if( parseInt(mes1) == parseInt(mes_prog)){
        //alert(mes1+""+mes_prog);
       // alert(parseInt(mes1)+"-"+ parseInt(mes_prog));
        document.nn2.fecha_fin.value=(fecha.getDate() ) +"/"+(fecha.getMonth()+1)+"/"+fecha.getFullYear(); 
    }
 
   else{ document.nn2.fecha_fin.value="";
        // alert(parseInt(mes1)+"-"+ parseInt(mes_prog));
     // alert("La fecha de Inicio y el numero de dias, supera el lapso de Tiempo");
   }
  
}
     </script>
       
<%
    
    HttpSession sesion=request.getSession(true);

                String Ident=(String)sesion.getAttribute("Ident");
                String Tipo_User=(String)sesion.getAttribute("Tipo_Usu");
                String Nomb_Unidad=(String)sesion.getAttribute("Nomb_Unidad");
                String Unidad=(String)sesion.getAttribute("Unidad");
                String Log= (String)sesion.getAttribute("Log");
                String Cod_Planilla=  (String)sesion.getAttribute("Cod_Plan");
                 double Total_Fresco_40=0;
                double Total_Secos_60=0;
                
                  out.println("<br>Planilla: "+Cod_Planilla);
             
                 
                Planilla_LN Pla_LN= new Planilla_LN();
                  Planilla_Soldado_EN Plan_Sold_EN = new Planilla_Soldado_EN();
                 Planilla_Soldado_LN Plan_Sold_LN = new Planilla_Soldado_LN();
                 Ciclo_LN Cicl_LN = new Ciclo_LN();
               
                String Mes ="";
                String Anio="";
                 try{
                 ResultSet Res_Per=Pla_LN.Buscar_Perido_Planilla(Integer.parseInt(Cod_Planilla));
                 
                   while(Res_Per.next()){
                       
                       Mes=Pla_LN.Calcular_Mes(Res_Per.getString("Mes_Per")) ;
                       Anio=Res_Per.getString("Anio_Per");
                     
                                        }   
                   }catch(Exception e){}
           
           

               
                 if(request.getParameter ("Id_Ciclo") !=null )
                    {
                        sesion.removeAttribute("Id_Ciclo");
                        sesion.setAttribute("Id_Ciclo",request.getParameter("Id_Ciclo").toString());
    
                        response.sendRedirect("Soldado_Abastecimientos.jsp");
                    }
                
               
                if(Log.isEmpty())
                        {
                            response.sendRedirect("http://localhost:8084/SIIAL/GUI/Validar_Usuario.jsp");
                        }
               
                         
               
               /*out.println("<table><tr><td>");
               out.println("<tr><td>Usuario : "+Log);
               out.println("<tr><td><center>Unidad : "+Nomb_Unidad+"</center>");
               out.println("</table>");   */           


%>  


<%
    // retarar soldados de la lista
         

           
                  if(request.getParameter ("Ciclo") !=null && request.getParameter ("Soldado") !=null  )
                        {
                            Plan_Sold_LN.Desvincular_Soldados_Planilla(Integer.parseInt(request.getParameter ("Soldado")),Integer.parseInt(request.getParameter ("Ciclo")) );
                        }
                 

%>

 
   
   
   
   <%     
          
        				if(request.getParameter ("Btn_Agregar") !=null )
                      {
             
                          //out.println(request.getParameter ("INGRESA"));
                          
                         //SimpleDateFormat formato_Fecha = new SimpleDateFormat("yyyy-MM-dd");
                          
                          try{
                            Ciclo_EN Cic_EN = new Ciclo_EN();
                            Ciclo_LN Cic_LN = new Ciclo_LN();  
                     
                          Cic_EN.setPlanilla(Integer.parseInt(Cod_Planilla));
                          Cic_EN.setFech_Inicio(request.getParameter ("fecha_inicio"));
                          Cic_EN.setFech_Fin(request.getParameter ("fecha_fin"));
                          Cic_EN.setTipo_Ciclo(request.getParameter ("Tipo_Ciclo"));
                          Cic_EN.setNumb_Dias(Integer.parseInt(request.getParameter ("Num_Dias")));
                          
                         if(Cic_LN.Regisrtar_Cilco(Cic_EN)){
        
                              ///out.println(  "<script>alert('SE REGISTRO EL CICLO CON EXITO')<script>");
                              //response.sendRedirect("Soldado_Abastecimiento.jsp?Cod_Plan="+request.getParameter("Cod_Plan")+"");       
                         }
        
                          }catch(Exception e){out.println("ERROR");}
                       
                      }
        
                  %>    
   
   
   
   
   
   

<%
// Registrar Soldados al ciclo de la planilla

  if(request.getParameter ("Bton_Agregar_Sold") !=null )
                        {
              
                      
                 ArrayList<Planilla_Soldado_EN> Lista_Soldados = new ArrayList<Planilla_Soldado_EN>(); 
                
                String Sold_selec[] = request.getParameterValues("list_soldados"); 
                  if (Sold_selec != null && Sold_selec.length != 0)
                    {
                        for (int i = 0; i < Sold_selec.length; i++) 
                            {
                                Plan_Sold_EN = new Planilla_Soldado_EN();
                                Plan_Sold_EN.setCiclo(Long.parseLong(request.getParameter("Ciclo").toString() ));
                                 Plan_Sold_EN.setSoldado(Long.parseLong(Sold_selec[i]));
 
                                 Lista_Soldados.add(Plan_Sold_EN);
                                 Plan_Sold_EN= null;
                                      
                            }
                        
                           // Plan_Sold_LN.Registrar_Soldados_Planilla(Lista_Soldados);
  
                        }
               
                    }
     

%>








<%
    // retarar soldados de la lista
         

           
                  if(request.getParameter ("ID_Ciclo") !=null )
                        {
                            try{
                             Cicl_LN.Elimminar_Ciclo(Integer.parseInt(request.getParameter ("ID_Ciclo")));
                            
                            }catch(Exception e){}

                            //Plan_Sold_LN.Desvincular_Soldados_Planilla(Integer.parseInt(request.getParameter ("Soldado")),Integer.parseInt(request.getParameter ("Ciclo")) );
                        }
 %>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Planilla de Abastecimiento</title>
    </head>
    
    <table class="table table-condensed">
          		<tr>
    	    		
                        <td width="6%" height="112" style="text-align: left"><img src="../../Iconos/LE.png"  width="66" height="65" alt=""/>
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
    
    <body>
     
        
   <div class="table-responsive">
       <table align="center">
            <tr>
                <td width=150>
                    <form action="Configurar_Abastecimiento.jsp" method="post" name="nn2">
                        <!-- ciclo de abastecimiento-->
                        <div>
                            <table class="table table-bordered"  align="center" bgcolor="#F4F4F4">
                        <caption class="info"><h4><center><b>CICLO DE ABASTECIMIENTOS</b></center></h4></caption>
                            <thead border="1">
                                <tr>
                                    <th colspan="2"><center>MODALIDAD: </center></th>
                                    <th colspan="2"><select class="form-control" name="Tipo_Ciclo" required>   
                                                    <option value="Abastecimiento">Abastecimiento</option>
                                            <option value="Raciones">Raciones de Capaña</option>
                                         </select>
                                    </th>
                                 </tr>
                                 <tr>
                                     <th><p>N°</p></th>
                                      <th><p>FECHA INICIO</p></th>
                                      <th><p>PER</p></th>
                                       <th><p>FECHA TÉRMINO</p></th>
                                        
                                 </tr>
                             </thead>
                            <tbody>
                                   <tr>
                                       <td><select   name="Num_Dias" id="Num_Dias" onChange="Calcular_Fecha()"  required>   
                                               <%
                                                   for(int i =1; i<=31;i++){out.println("<option value="+i+">"+i+" Dia </option>"); }
                                                %>
                                            </select>
                                       </td>
                                       <td>
                                           <input type="date" name="fecha_inicio" id="fecha_inicio" onChange="Calcular_Fecha()" >
                                       </td>
                                       <td>
                                           <input type="text" name="Mes" id="Mes" value="<%out.println(Mes);%>" size="2" ReadOnly >
                                           <input type="hidden"  name="Anio" id="Anio" value="<%out.println(Anio);%>" size="2" ReadOnly >
                                       </td>
                                       <td>
                                           <input type="text" name="fecha_fin" id="fecha_fin" size="10"  size="20" readonly required >
                                       </td>
                                  </tr>
                              </tbody>
                              <tfoot>
                                            <tr>
                                           <td colspan="3"></td>
                                                                   <td><input type="submit" name="Btn_Agregar" value="CREAR LAPSO" class="btn btn-info"></td>
                                   </tr>
                                   <tr></tr>
                              </tfoot>
                        </table>
                         </div>              
                    </form>
                </td>
                <td width=60>                
                </td>
                <td rowspan="2">
                    <!-- lista SL -->
                     <form action="Configurar_Abastecimiento.jsp" method="post" name="nn">
                         <div>
                         <table class="table table-bordered" style="font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif" align="top" bgcolor="#F4F4F4">
                        <caption class="info"><h4><center><b>LISTA DE SOLDADOS DE LA UNIDAD</b></center></h4></caption>
                            <thead>
                                <tr>
                               <td colspan='4'><center>
                           <select class="form-control" name="Ciclo" required><option value="">--Seleccionar Ciclo de Abastecimiento</option></center>
                                    <% Ciclo_EN Cicl_EN= new Ciclo_EN();
                                            for (Ciclo_EN Cicl :  Cicl_LN.Listar_Ciclos_Planilla(Integer.parseInt(Cod_Planilla)))
                                                 {
                                                    out.println("<option value="+Cicl.getId_Ciclo()+"> dias "+Cicl.getNumb_Dias()+" del "+Cicl.getFech_Inicio()+" hasta "+Cicl.getFech_Fin()+"</option>" );
                                                  }
                                        %>                             
                                    </<select>
                               </td>
                            </tr>
                            <tr>
                                <td><center><b>Nº</b></center></td>
                                   <td><center><b>Grado</b></center></td>
                                   <td><center><b>Apellidos Nombres</b></center></td>
                                   <td><center><b>Identificación</b></center></td> 
                                   <td><center><b>[_]</b></center></td>
                            </tr>

                        </thead>
                        <tbody>
                               <tr>
                                       <%
                                     try{   
                                       Soldado_EN Sold_EN= new Soldado_EN();
                                       Soldado_LN Sold_LN = new Soldado_LN();
                                                       ResultSet Res3= Sold_LN.Listar_Soldados_Unidad(Long.parseLong(Unidad),Integer.parseInt(Cod_Planilla));
                                       int j=0;
                                       while(Res3.next()){
                                       j++;
                                       out.println("<tr><td>"+j+"</td><td>"+Res3.getString("Grado")+"</td><td>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"<td>" + Res3.getString("Ident_Sold")+"<td><input type='checkbox' name='list_soldados' value='"+Res3.getString("Ident_Sold")+"'></td> " );
                                                                                               }
                                                       } catch(Exception e){}
                                    %>   
                                </tr>
                                <tr>
                                       <td colspan="5" align="center">
                                           <input type="submit" class="btn btn-info" Name="Bton_Agregar_Sold" value="Cargar Listado ">
                                   </td>
                                </tr>
                        </tbody>
                </table>
                         </form>
                </div>
                    </div>
                </td>
            <tr>
                <td align="top">
                    <br>
                    <!-- LISTA LAPSOS TIEMPO-->
                    <div>
                 <table class="table table-bordered" style="font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif" align="center" bgcolor="#F4F4F4">
                       <caption class="info"><h4><center><b>LISTADO DE LAPSOS DE TIEMPOS</b></center></h4></caption>
                       <thead>
                           <tr>
                               <th><center>Nº</center></th>
                                <th><center>CANT. DIAS</center></th>
                               <th><center>DESDE</center></th>
                               <th><center>HASTA</center></th></tr>
                            </tr>
                        </thead>
                        <tbody>
                                       <% Ciclo_EN Ci_EN= new Ciclo_EN();
                                          Ciclo_LN Ci_LN = new Ciclo_LN();
                                          int i = 0;
                                          for (Ciclo_EN Cicl :  Ci_LN.Listar_Ciclos_Planilla(Integer.parseInt(Cod_Planilla)))
                                          { i++;
                                            out.println("<tr><td><center>"+i+"</center><td><center>"+ Cicl.getNumb_Dias() +"</center></td><td><center>"+Cicl.getFech_Inicio()+"</center></td><td><center>"+Cicl.getFech_Fin()+"</center></td><td><A href='Configurar_Abastecimiento.jsp?ID_Ciclo="+ Cicl.getId_Ciclo()+"'</center><center><img src='../../Iconos/eliminar.png'  /></center> </A></td></tr>" );
                                           
                                           }
                                        %>
                          </tbody>

                 </table></div>
                </td>
                <td></td>
            <tr>   
                <td colspan="2">
                </td>
                        <!-- LISTA DE SL DE LA UNIDAD  -->
                    
                       
            
            <div  style="overflow-y: scroll ">
            <table class="table table-bordered">
                        
               <tbody>
                            
                      <tr><h4><center><b>LISTA DE SOLDADOS DE LA UNIDAD</b></center></h4>
                    </tr>
                
                      <tr>
                    	<td align="center"><b>Nº.</b></td>
                        <td align="center"><b>GRADO</b></td>
                        <td align="center"><b>APELLIDOS NOMBRES</b></td>
                        <td align="center"><b>IDENTIFICACIÓN</b></td>
                        <td align="center"><b>Nº DÍAS</b></td>
                        <td align="center"><b>FECHA INICIO</b></td>
                        <td align="center"><b>FECHA TÉRMINO</b></td>
                     </tr>
                    <tr> 
                    <%
                     try{   
                     ResultSet Res3= Plan_Sold_LN.Listar_Soldados_Planilla(Long.parseLong(Cod_Planilla));
                                                     int j=0;
                                                         while(Res3.next()){
                                                                            j++;
                                                                             out.println("<tr><td>"+j+"</td><td>"+Res3.getString("Grado")+"</td><td>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"</td><td>"+Res3.getString("Ident_Sold")+"</td><td>"+Res3.getString("Numb_Dias")+"</td><td>"+Res3.getString("Fech_Inicio")+"</td><td>"+Res3.getString("Fech_Fin")+"</td><td><A href='Configurar_Abastecimiento.jsp?Ciclo="+ Res3.getString("Id_Ciclo")+"&Soldado="+Res3.getString("Ident_Sold")+" '><img src='../../Iconos/eliminar.png'  /> </A> </tr>" );
                                                        
                                                                            }
                
                                                                            } catch(Exception e){}
                    %>         	
                 </tr>
                 
                 </tbody>
                   
          </table>
              </div>   
                 
                 
               
                    <div align="center"><a href="Articulos_Abastecimiento.jsp" class="btn btn-info" role="button">SIGUIENTE</a></div>
                     <table>
            <tr>
                <td>
               		
           </td>
          </tr>
      </table>
                    </form>
                </td>
             </tr> 
   </div>
   
   
   
   
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
       
            </body>
          </table>    
    </body>
</html>
       