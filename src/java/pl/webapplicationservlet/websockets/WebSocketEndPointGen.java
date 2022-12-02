package pl.webapplicationservlet.websockets;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/endpoint")
public class WebSocketEndPointGen {

  @OnMessage
  public String onMessage(String message) {
	 return "Odpowiedź z WebScoket: " + message;
  }

}
