<%@page import="java.util.List"%>
<%@page import="pl.webapplicationservlet.data.ApplicationData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSTL Example</title>
	</head>
	<body>
		<h1>Przykład JSTL</h1>
		
		<h3>Tworzenie tabeli za pomocą JSTL:</h3>

		<table border="5">
			<tr>
				<th bgcolor="#123123">Imię</th>
				<c:forTokens items = "zygmunt, bolesław, wacław" delims = "," var = "name">
					<td> <c:out value = "${name}"/> </td>
				</c:forTokens>
			</tr>
			<tr>
				<th bgcolor="#321321">Nazwisko</th>
				<c:forTokens items = "Kowalksi, nowak, nowakowski" delims = "," var = "lastname">
					<c:set var="lastName" value="${lastname}" />
					<td> <c:out value = "${fn:toUpperCase(lastName)}"/> </td>
				</c:forTokens>
			</tr>
		</table>
	</body>
</html>