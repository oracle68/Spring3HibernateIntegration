<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Being Java Guys | Spring DI Hello World</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}
.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
.center {
  text-align:center
}
</style>
</head>
<body>
	<div class="center">
		<br /> <br /> <br /> <b>User List Users </b><br /> <br />
			
		

		<table border="1">
			<tr>
				<td class="heading">User Id</td>
				<td class="heading">First Name</td>
				<td class="heading">Last Name</td>
				<td class="heading">Gender</td>
				<td class="heading">City</td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}</td> 
					<td>${user.lastName}</td>
					<td> ${user.getGender()}</td>   
					<td>${user.city.nom}</td>
					<td><a href="edit?id=${user.id}">Edit</a></td>
					<td><a href="delete?id=${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="7"><a href="register">Add New User</a></td></tr>
		</table>

	</div>
</body>
</html>