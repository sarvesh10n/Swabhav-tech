<!DOCTYPE html>
<head>
	<title>welcome</title>
</head>
<body>
<%
	String name=request.getParameter("user");
	if(name==null)
	{
		name="jsp";
	}
%>
<h1>Hello <%=name%></h1>

<h1>
	<%for(int i=0;i<10;i++)
	{
		%><p><%="hello jsp world "+i%></p>
	<%}%>
</h1>
</body>