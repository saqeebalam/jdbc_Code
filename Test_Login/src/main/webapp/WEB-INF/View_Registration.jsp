<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regForm" method="post">
	<pre>
	  NAME<input type="text" name="name"/>
	  CITY<input type="text" name="city"/>
	  MOBILE<input type="number" name="mobile"/>
	  EMAIL<input type="text" name="email"/>
	  <input type="submit" value="Save">
	</pre>
	</form>
	<%
		if(request.getAttribute("msge")!=null){
			out.println(request.getAttribute("msge"));
		}
	%>
</body>
</html>