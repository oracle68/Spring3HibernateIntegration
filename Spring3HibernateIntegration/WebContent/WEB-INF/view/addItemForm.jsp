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
        <h1>Add Item</h1>
<html:form action="/addItemForm">
    <table border="0">
        <tbody>
            <tr>
                <td colspan="2">
                    <bean:write name="addItemForm" property="error" filter="false"/>
                    &nbsp;</td>
            </tr> 

            <tr>
                <td>Name:</td>
                <td><html:text property="name" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><html:text property="description" /></td>
            </tr>     
            <tr>
                <td>Price:</td>
                <td><html:text property="price" /></td>
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