<!DOCTYPE html>
<head>
    <title>display count</title>
</head>
<body>

    <%
        if(session.isNew())
        {
            session.setAttribute("count",0);
        }
    %>
    <h1>Old count is <%=session.getAttribute("count")%></h1>
   <%
        Integer count=(Integer)session.getAttribute("count");
        count++;
        session.setAttribute("count",count);    
    %>
    <br>
    <h1>New count is <%=session.getAttribute("count")%></h1>
    <br>
    <h1>Session id is <%=session.getId()%></h1>
</body>