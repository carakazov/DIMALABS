<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.03.2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
  <table border="1">
    <tr>
      <th>Id: </th>
      <th>Title: </th>
      <th>Director: </th>
      <th>Delete: </th>
      <th>Modify: </th>
    </tr>
    <c:forEach items="${list}" var="item">
      <tr>
        <td>${item.id}</td>
        <td>${item.title}</td>
        <td>${item.director}</td>
        <td>
          <form method="get" action="${pageContext.request.contextPath}/delete/${item.id}">
            <input type="submit" value="delete">
          </form>
        </td>
        <td><a href="${pageContext.request.contextPath}/modify/${item.id}">Modify form</a></td>
      </tr>
    </c:forEach>
  </table>

  <form method="post" action="${pageContext.request.contextPath}/create">
    <p><label>Title: <input type="text" name="title"></label></p>
    <p><label>Director: <input type="text" name="director"></label></p>
    <p><label><input type="submit" value="create"></label></p>
  </form>
  </body>
</html>
