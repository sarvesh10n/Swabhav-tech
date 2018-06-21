<!DOCTYPE html>
<head>
    <title>display count</title>
</head>
<body>
    <%
        Integer sessionCount=(Integer)session.getAttribute("count");
        Integer applicationCount=(Integer)application.getAttribute("count");
        if(sessionCount==null)
            sessionCount=0;

        if(applicationCount==null)
            applicationCount=0;

    %>
    <h1>Session count is <%=sessionCount%></h1>

    <h1>Application count is <%=applicationCount%></h1>
   
   
   
</body>