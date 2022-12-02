		var wsUri = getRootUri() + "/WebApplication7PM/endpoint"

		function getRootUri() {			 
			return "ws://" + (document.location.hostname == "" ? "localhost" : document.location.hostname) + ":" + (document.location.port == "" ? "8080" : document.location.port);
		}

		function init() {
			websocket = new WebSocket(wsUri);
			websocket.onopen = function(evt) { onOpen(evt); };
			websocket.onmessage = function(evt) { onMessage(evt); };
			websocket.onerror = function(evt) { onError(evt); };
		}

		function onOpen(evt) {
			writeToScreen("CONNECTED");
		}

		function onClose(evt) {
			writeToScreen("DISCONNECTED");
		}

		function onMessage(evt) {
			writeToScreen("RECEIVED: " + evt.data);
		}

		function onError(evt) {
			writeToScreen("<span style='color: red;'>ERROR: </span>" + evt.data);
		}

		function doSend(message) {
			writeToScreen("SENT: " + message);
			websocket.send(message);
			document.getElementById("data").value = "";
		}

		function writeToScreen(message) {
			var pre = document.getElementById("messageID");
			var x = pre.innerHTML;
			pre.innerHTML = x + "<br/>" + message;
		}

		window.addEventListener("load", init, false);
