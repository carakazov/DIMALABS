<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.03.2021
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>License list</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>
                Id:
            </td>
            <td>
                Receiving date:
            </td>
            <td>
                Delete:
            </td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.receivingDate}</td>
                <td><form method="get" action="modifyLicense">
                    <input type="hidden" name = "id" value="${item.id}">
                    <input type="submit" value="delete">
                </form></td>
            </tr>
        </c:forEach>
    </table>

<label>Create license:</label>

<form method="post" action="modifyLicense">
    <label>Date: <input type="date" name="date"></label>
    <label><input type="submit" value="create"></label>
</form>
</body>
</html>
