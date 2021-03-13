<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.03.2021
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Form</title>
</head>
<body>
<h1>Modify cinema</h1>
<form method="post" action="modify">
    <p><label>Address: <input type="text" name="address" value="${cinema.address}"/></label></p>
    <p><label>Rating: <input type="number" name="rating" value="${cinema.rating}"/></label></p>
    <p><label>License id: <input type="number" name="licenseId" value="${cinema.licenseId}"/></label></p>
    <p><label><input type="hidden" name="id" value="${cinema.id}"/><input type="submit" value="modify"></label></p>
</form>
</body>
</html>
