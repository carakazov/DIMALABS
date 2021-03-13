<%@ page import="beans.CinemaBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 12.03.2021
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            address
        </th>
        <td>
            rating
        </td>
        <td>
            license receiving date
        </td>
        <td>
            delete cinema
        </td>
    </tr>
    <%
        List<CinemaBean> items = (List<CinemaBean>)request.getAttribute("list");
        for(CinemaBean item : items){
            int id = item.getCinemaId();
            String address = item.getAddress();
            int rating = item.getRating();
            Date receivingDate = item.getLicenseReceivingDate();
            out.println("<tr>");
            out.println("<th>" + id + "</th>");
            out.println("<th>" + address + "</th>");
            out.println("<th>" + rating + "</th>");
            out.println("<th>" + receivingDate + "</th>");
            out.print("<th><form method=\"get\" action=\"create\"><input type=\"hidden\" value="+id+" name=\"id\"/><input type=\"submit\" value=\"delete\"/></form>");
            out.print("<th><form method=\"get\" action=\"modify\"><input type=\"hidden\" value="+id+" name=\"id\"/><input type=\"submit\" value=\"modify\"/></form>");
            out.println("</tr>");
        }
    %>
</table>
<a href="CreateForm.html">Create</a>
</body>
</html>
