<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Success</title>
</head>
<body>
    <h1>Congratulations!</h1>

    <p>You have successfully logged in.</p>

<p>Your name is: <bean:write name="logForm" property="name" />.</p>

</body>
</html>