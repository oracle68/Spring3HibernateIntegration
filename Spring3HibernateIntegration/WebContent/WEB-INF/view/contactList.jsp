<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contactos</title>ctos
</head>
<style>

.center {
  text-align:center
}
</style>
<body>

<h3>Contactos</h3>
<c:if  test="${!empty contactList}">
<table border="0">
<tr>
	<td><spring:message code="label.nom"/></td>
        <td><spring:message code="label.cognom"/></td>
	<td><spring:message code="label.mail"/></td>
	<td><spring:message code="label.telefon"/></td>
</tr>
<c:forEach items="${contactList}" var="contact">
	<tr>
		<td>${contact.nom} </td>
                <td>${contact.cognom} </td>
		<td>${contact.mail}</td>
		<td>${contact.telefon}</td>
               <td><a href="borrar/${contact.cId}">Eliminar</a></td>
	</tr>
</c:forEach>
</table>
 <td><a href="contact">AddContact</a></td>
  <td><a href="employeeList">EmployeeList</a></td>
   <td><a href="userList">UserList</a></td>
</c:if>
</body>
</html>