<%--
  Created by IntelliJ IDEA.
  User: Jwerl
  Date: 4/21/2023
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Java Web Programming: Class List</title>
  <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
  <div class="hero-unit">
    <h1>Class List</h1>
  </div>

  <%@ include file="includes/navigation.jsp"%>

  <div class="container">
    <c:choose>
      <c:when test="${empty people}">
        <p>Sorry, the list of people was empty.</p>
      </c:when>
      <c:otherwise>
        <c:forEach var="Movies" items="${people}">
          <h2>${person.firstName}</h2>
          <p>${person.firstName}${person.lastName} is ${person.age} years old and
              ${person.firstName}'s favorite color is ${person.favoriteColor}.</p>
        </c:forEach>
      </c:otherwise>
    </c:choose>
  </div>

  <%@ include file="includes/footer.jsp"%>
</div>
</body>
</html>