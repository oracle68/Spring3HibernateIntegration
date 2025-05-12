<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 hibernate integration</title>
</head>
<style>

.center {
  text-align:center
}
</style>
<body>
 

 
<h3>Employees List</h3>
<c:if  test="${!empty employeeList}">
<table border="1">
<tr>
    <td>Name</td>
    <td>Email</td>
    <td>Telephone</td>
    <td>&nbsp;</td>
</tr>
<c:forEach items="${employeeList}" var="emp">
    <tr>
        <td>${emp.lastname}, ${emp.firstname} </td>
        <td>${emp.email}</td>
        <td>${emp.telephone}</td>
        <td><a href="delete/${emp.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>     

 <div class="center">
    <a href="editEmployee">Add Employee</a>
    <a href="userList">UserList</a>
   <a href="contactList">Contact List</a> </div>
</body>
</html>