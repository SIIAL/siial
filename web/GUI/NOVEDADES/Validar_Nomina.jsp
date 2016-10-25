<%-- 
    Document   : Validar_Nomina
    Created on : 20-sep-2016, 23:27:05
    Author     : WILSON
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import= "Logica_Negocio.Archivo_Plano_LN"%>
<%@ page import= "Entidad_Negocio.Soldado_EN"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            
    /*FileItemFactory es una interfaz para crear FileItem*/
        FileItemFactory file_factory = new DiskFileItemFactory();
 
        /*ServletFileUpload esta clase convierte los input file a FileItem*/
        ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
        /*sacando los FileItem del ServletFileUpload en una lista */
        
            
  try{
       List items = servlet_up.parseRequest(request);
      
        for(int i=0;i<items.size();i++){
            /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
            FileItem item = (FileItem) items.get(i);
            /*item.isFormField() false=input file; true=text field*/
           
            if (! item.isFormField()){
                
                if(item.getContentType().equals("text/plain"))
                {
                
                if( item.getSize() > 0 ){
                /*cual sera la ruta al archivo en el servidor*/
                                    
                File archivo_server = new File("C:/Archivo/"+item.getName());
                /*y lo escribimos en el servido*/
                item.write(archivo_server);
               // 
                //out.print("<br> Tipo --> " + item.getContentType());
              
                //out.print("<br>");
                Archivo_Plano_LN Archivo_LN= new Archivo_Plano_LN();
                            
               // Archivo_LN.Grardar_Archivo_Plano("C:/Archivo/"+item.getName()); 
               String Datos = Archivo_LN.Validar_Archivo_Plano("C:/Archivo/"+item.getName());
               out.print(Datos ); 
               out.print(item.getName() +" =>" + (item.getSize()/1240)+ "KB");
   
                   }
                }else{out.print("<center><a  href='Registro_Soldados.jsp'> No es un archivo plano </a></center>");}
            }
        }
        
        
            
            
        }        catch(Exception e){ out.print(e.getMessage()); }     
            
          
     /*   
        String Archivo_Url = "C:\\Archivo";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024);
        factory.setRepository(new File (Archivo_Url));
        ServletFileUpload Upload= new ServletFileUpload(factory);
     try{
        List <FileItem>  partes=Upload.parseRequest(request);
    for(FileItem items :partes ){
    
    File file = new File(Archivo_Url,items.getName());
    items.write(file);
                                    }
    out.println("Se Cargo ok");
    }
        catch(Exception e){ }
*/
        %>
    </body>
</html>
