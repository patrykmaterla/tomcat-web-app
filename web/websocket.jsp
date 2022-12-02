<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Przykład użycia WebSocket</h1>

		<form>
			<input id="data" type="text" >
			<input onclick="doSend(document.getElementById('data').value)" value="Wyślij!" type="button">
		</form>
		<button onclick="onClose();">Odłącz</button>
		
		<div id="messageID"></div>
		
		<script src="javascript/script.js" language="javascript" type="text/javascript"></script>
	</body>
</html>
