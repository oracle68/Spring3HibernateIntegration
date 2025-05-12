<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>

<% out.println("La fecha actual es "+request.getAttribute("fecha")+"<br>"); 
   out.println("La lista de usuarios es<br>");

   ArrayList<String> usuarios = (ArrayList<String>) request.getAttribute("usuarios");; 
   for(int i = 0; i < usuarios.size(); i++)
   {
	   
	  out.println(usuarios.get(i)+"<br>");
   }   
 
 
 %></body>
</html>