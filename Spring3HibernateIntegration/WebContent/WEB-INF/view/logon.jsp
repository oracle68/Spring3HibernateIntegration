<%-- 
    Document   : login
    Created on : 10-abr-2019, 12:15:55
    Author     : W764-Ora
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
<html:form action="/logon">
    <table border="0">
        <tbody>
            <tr>
                <td colspan="2">
                    <bean:write name="logForm" property="error" filter="false"/>
                    &nbsp;</td>
            </tr>            
            <tr>
                <td>Your name:</td>
                <td><html:text property="name" /></td>
            </tr>
            <tr>
                <td> </td>
                <td> <html:submit value="Insert" /></td>
            </tr>
        </tbody>
    </table>



</html:form>     
    </body>
</html>
