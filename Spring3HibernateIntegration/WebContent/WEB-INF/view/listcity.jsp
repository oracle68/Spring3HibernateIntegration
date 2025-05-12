<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content=" charset=utf-8"> <!--application/json;-->
        <title>List city</title>
    </head>
    <body>
        <h1>List city!</h1>
<table>
    <c:forEach var="ct" items="${cityList}">
	 <td>${ct.nom}</td> 
	 </c:forEach>
</table>	        
     
    </body>
</html>
