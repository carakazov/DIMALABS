<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.03.2021
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify page</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/modifyFilm" method="post">
        <p><label>Title: <input type="text" name="title" value="${film.title}"></label></p>
        <p><label>Director: <input type="text" name="director" value="${film.director}"></label></p>
        <p><label>
            <input type="hidden" name="id" value="${film.id}"/>
            <input type="submit" value="modify"/></label>
        </p>
    </form>
</body>
</html>
