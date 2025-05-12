<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Item Success</title>
</head>
<body>
    <h1>Congratulations!</h1>

    <p>You have insert item successfully.</p>

<p>Your item is: <bean:write name="addItemForm" property="name" />
				<bean:write name="addItemForm" property="description" />
				<bean:write name="addItemForm" property="price" />
</p>

</body>
</html>