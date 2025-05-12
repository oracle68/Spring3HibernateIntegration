    <%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="jquery-3.4.0.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
      
      $("#ajax").click(function(){
        
        
        $.get("ServletJSON",function(datos){
          
          datos.forEach(function(persona) {
          
            $("body").append(`<p>\${persona.nombre},\${persona.apellidos},\${persona.edad}</p>`);
            
          })
        });
        
      });
      
    })
    </script>
    </head>
    <body>
    <input type="button" value="ajax" id="ajax"/>
    </body>
    </html>