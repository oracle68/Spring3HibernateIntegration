<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="com.myapp.struts.HelloForm" %>

<html>
<head>
</head>
<body>
<h2><bean:write name="helloForm" property="message" /> <br>
 <bean:write name="helloForm" property="data" />
</h2>
</body>
</html>