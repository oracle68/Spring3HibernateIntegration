<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content=" charset=utf-8"> <!--application/json;-->
        <title>Alta city</title>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    </head>
    <body>
        <h1>Alta city!</h1>

<form id="registro" action="">
    City Name: <input type="text" name="nom" id="nom"/> <span id="mensaje"></span><br>
    <input type="submit" value="registrar"/>
</form>
<script type="text/javascript">    

    $('#registro').submit(function(evento) {
       $('#mensaje').load('addcity',"nom="+$('#nom').val());
    });
    

</script>        
    </body>
</html>