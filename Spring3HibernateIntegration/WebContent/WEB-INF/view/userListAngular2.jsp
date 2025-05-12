<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>    <title>AngularJS User List</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
  <!-- script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js"></script-->
 </head>
<body ng-app ng-controller="MyFilter">
 Lista Users AngularJS
<table>
<tr>
  <td>id</td>
  <td>firstname</td>
  <td>lastname</td>
  <td>gender</td>
  <td>city</td>

</tr>  
<tr ng-repeat="element in lista | orderBy:'firstname'">
  <td>{{element.id}}</td>
  <td>{{element.firstname}}</td>
  <td>{{element.lastname}}</td>
  <td>{{element.gender}}</td>
  <td>{{element.city}}</td>
</tr>
 
</table>
 <script> 
       function MyFilter($scope,$http)
  {           
    	   $http.get('http://localhost:8180/Spring3HibernateIntegration/userJson')
    	    .success(function (response){
    	        $scope.lista = response;
    	        console.log($scope.lista);
    	    })
    	    .error(function (response){
    	        	        console.log(response); 
    	  }); 

	}
  
</script>
</body>
</html>