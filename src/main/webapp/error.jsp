<%--
  Created by IntelliJ IDEA.
  User: Jwerl
  Date: 4/14/2023
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internal Server Error</title>
</head>
<body>
<h1>Houston, we've had a problem.</h1>
<h2>Error Details:</h2>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.toString()}</p>
</body>
</html>
