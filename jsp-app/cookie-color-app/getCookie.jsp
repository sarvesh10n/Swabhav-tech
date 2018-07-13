<!DOCTYPE html>
<head>
    <title>get cookie</title>
</head>
<body>
    <%
    Cookie[] cookies = null;
    cookies=request.getCookies();
    String color;

    for(Cookie cookie:cookies)
    {
        if(cookie.getName()==color)
        {
            color=cookie.getValue();
        }
    }
    out.print(color);

    %>
</body>