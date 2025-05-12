<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>    <title>Lista Empleados AngularJS</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
  <!-- script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js"></script-->
  <script>
   function add(f){
	   if (f.firstname.value!="")
	   {
		   f.action = "adddEmployee/"+f.firstname.value+"/"+f.lastname.value+"/"+f.email.value+"/"+f.telephone.value;
		   f.submit();
	   }
	   else alert("firstname NULL");
	  
   }
  </script>
 </head>
<body>
 Lista Empleados AngularJS
 
 <form name="f" action="" method="post">
<table border="1"> 
<tr><td>firstname</td><td><input type="text" id="firstname" name="firstname" /></td></tr>
<tr><td>lastname</td> <td><input type="text" id="lastname"  name="lastname"/></td></tr>
<tr><td>email</td> <td><input type="text" id="email" name="email" /></td></tr>
<tr><td>telephone</td> <td><input type="text" id="telephone" name="telephone"/></td></tr>
<tr><td></td> <td><input type="button" onClick="add(f);" /></td></tr>
 </table>
 </form>
 <div  ng-app ng-controller="MyFilter">
<table border="1">
<tr>
  <td>id</td>
  <td>firstname</td>
  <td>lastname</td>
  <td>email</td>
  <td>telephone</td>
</tr>  
<tr ng-repeat="element in lista | orderBy:'firstname'">
  <td>{{element.id}}</td>
  <td>{{element.firstname}}</td>
  <td>{{element.lastname}}</td>
  <td>{{element.email}}</td>
  <td>{{element.telephone}}</td>
  <td><a href="deleteEmployee/{{element.id}}">delete</a></td>
</tr>
 
</table>
</div>
 <script> 
       function MyFilter($scope)
  {           
		$scope.lista =  ${lista};
		
	}
  
</script>
</body>
</html>