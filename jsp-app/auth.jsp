<!DOCTYPE html>

<head>
    <title>authentication jsp</title>
</head>

<body>
    <%
String name=request.getParameter("name");
String password=request.getParameter("password");
if(name.equals("sarvesh@123") && password.equals("123"))
{%>
    <h1>Successful</h1>
    <p>Name is <%=name%></p>
    <p>Password is <%=password%></p>
<%}
else
    response.sendRedirect("login.html");
%>
</body>