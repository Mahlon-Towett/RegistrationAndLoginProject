<%-- 
    Document   : Home
    Created on : 20 Apr 2022, 16:10:06
    Author     : mahlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
</head>
<body>
 <center><h2>Home Page</h2></center>
 Welcome <%=request.getAttribute("userName") %> 
 <div style="text-align: right"><a href="LogoutServlet">Logout</a></div>
 <style><%@include file="/WEB-INF/login.css"%></style>
 <div style="text-align: center">
  <b>Please <a href="http://localhost:8080/LoginMVC/article.jsp">Send Email</a> to let us know your views.</b>
 </div>
</body>
</html>