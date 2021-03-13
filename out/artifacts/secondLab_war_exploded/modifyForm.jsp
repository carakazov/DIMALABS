<%@ page import="model.Cinema" %><%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 13.03.2021
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cinema cinema = (Cinema) (request.getAttribute("cinema"));
    out.println("<form method=\"post\" action=\"modify\">");
    out.println("<input type=\"hidden\" name=\"cinemaId\" value=\"" + cinema.getId() + "\"/>");
    out.println("<input type=\"text\" name=\"address\" value = \"" + cinema.getAddress() + "\"/>");
    out.println("<input type=\"text\"  name=\"rating\" value = \"" + cinema.getRating() + "\"/>");
    out.println("<input type=\"text\"  name=\"licenseId\" value = \"" + cinema.getLicenseId() + "\"/>");
    out.println("<input type=\"submit\" value = \"Modify\"/>");
    out.println("</form>");
%>
</body>
</html>
