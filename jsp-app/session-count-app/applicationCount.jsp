<!DOCTYPE html>
<head>
    <title>display count</title>
</head>
<body>

    <%
        Integer count=(Integer)application.getAttribute("count");
        if(count==null||count==0)
        {
            application.setAttribute("count",0);
            count=0;
        }
    %>
    <h1>Old count is <%=application.getAttribute("count")%></h1>
   <%
        count++;
        application.setAttribute("count",count);    
    %>
    <br>
    <h1>New count is <%=application.getAttribute("count")%></h1>
   
</body>