<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 80%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
		.center {
		  text-align:center
		}		
	</style>
</head>
<body>

<h2>Contactos</h2>

<form:form method="post" action="contact" commandName="contact">

	<table>
	<tr>
		<td><form:label path="nom"><spring:message code="label.nom"/></form:label></td>
		<td><form:input path="nom" /></td> 
		<td><form:errors path="nom" /></td>
	</tr>
	<tr>
		<td><form:label path="cognom"><spring:message code="label.cognom"/></form:label></td>
		<td><form:input path="cognom" /></td>
		<td><form:errors path="cognom" /></td>
	</tr>
	<tr>
		<td><form:label path="mail"><spring:message code="label.mail"/></form:label></td>
		<td><form:input path="mail" /></td>
		<td><form:errors path="mail" /></td>
	</tr>
	<tr>
		<td><form:label path="telefon"><spring:message code="label.telefon"/></form:label></td>
		<td><form:input path="telefon" /></td>
		<td><form:errors path="telefon" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addcontact"/>"/>
		</td>
	</tr>
</table>	
</form:form>

	
 <div class="center"> <a href="contactList">Contact List</a> </div>


</body>
</html>
