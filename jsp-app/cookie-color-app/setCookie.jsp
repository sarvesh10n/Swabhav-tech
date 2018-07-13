<!DOCTYPE html>
<head>
    <title>set cookie</title>
</head>
<body>
    <%
        Cookie cookie=new Cookie("color","red");
        cookie.setMaxAge(60*60*24*10);
        response.addCookie(cookie);

    %>
    <a href="getCookie.jsp">getCookie</a>
</body>