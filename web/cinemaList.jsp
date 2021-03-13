<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.03.2021
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <table class="table" border="1">
      <tr class="row">
        <th>
          Cinema Id
        </th>
        <th>
          Address
        </th>
        <th>
          Rating:
        </th>
        <th>
          License Id:
        </th>
        <th>
          License receiving date:
        </th>
        <th>
          Delete:
        </th>
        <th>
          Modify:
        </th>
      </tr>
      <c:forEach items="${list}" var="item">
        <tr>
          <td>
            ${item.id}
          </td>
          <td>
            ${item.address}
          </td>
          <td>
            ${item.rating}
          </td>
          <td>
            ${item.licenseId}
          </td>
          <td>
            ${item.receivingDate}
          </td>
          <td>
            <form method="get" action="changeCinemaList">
              <input type="hidden" name="id" value="${item.id}">
              <input type="submit" value="Delete">
            </form>
          </td>
          <td>
            <form method="get" action="modify">
              <input type="hidden" name="id" value="${item.id}">
              <input type="submit" value="Modify">
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>

  <p><label><a href="createCinema.html">Add new cinema</a></label></p>
  </body>
</html>
