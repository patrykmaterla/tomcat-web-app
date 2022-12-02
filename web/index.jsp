<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1 align="center">WebApplication</h1>
		
		<form method="post" action="mainServlet?command=userInfo">
			<p align="center">Imię <input type="text" name="name" value="" size="20"></p>
			<p align="center">Nazwisko<input type="text" name="lastname" value="" size="20"></p>
			<p align="center"><input type="submit" value="Enter" size="20"></p>
		</form>
		
		<hr>
		<table align="center" border="1" style="border-collapse:collapse">
			<tr>
				<th> </th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<tr>
				<td>01</td>
				<td>Patryk</td>
				<td>Materla</td>			
			</tr>
		</table>

		<hr>
		<p align="center"><a href="jstl.jsp">Przykład użycia biblioteki JSTL</a></p>
		
		<hr>
		<p align="center"><a href="websocket.jsp">Przykład użycia WebSocket</a></p>
		
		<hr>
		<p align="center"><a href="webresources/webservices">Rest</a></p>
		
   </body>
</html>
