package pl.webapplicationservlet.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.webapplicationservlet.data.*;


public class MainServlet extends HttpServlet {
  /**
	* Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	* @param request servlet request
	* @param response servlet response
	* @throws ServletException if a servlet-specific error occurs
	* @throws IOException if an I/O error occurs
  **/
  
  Connection databaseConnection;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 ApplicationData userList = (ApplicationData) getServletContext().getAttribute("sUserList");
	 PrintWriter out = response.getWriter();
	 String sCommand=(String) request.getParameter("command");
	 if(sCommand.equals("userInfo")) {
		String name = (String)request.getParameter("name");
		String lastName = (String)request.getParameter("lastname");
		userList.addMember(name + " " + lastName);
	 }
	  
	 try {
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<title>Servlet MainServlet</title>");
		out.println("</head>");
		out.println("<body style=\"max-width: max-content; margin: auto;\">");
		out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
		
		out.println("<h3>Prezentacja danych z tabeli t_uzytkownik</h3>");
		String query = "SELECT * FROM t_uzytkownik";
		ResultSet rs = databaseConnection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		out.println("<table border=\"1\" style=\"border-collapse:collapse\">");
		out.println("<tr>");
		out.println("<th>" + "ID" + "</th>");
		out.println("<th>" + "Dane" + "</th>");
		out.println("<th>" + "Opis" + "</th>");
		out.println("<th>" + "Imię" + "</th>");
		out.println("<th>" + "Nazwisko" + "</th>");
		out.println("</tr>");
		while(rs.next()) {
		  int id = rs.getInt("id");
		  String dane = rs.getString("dane");
		  String opis = rs.getString("opis");
		  String imie = rs.getString("imie");
		  String nazwisko = rs.getString("nazwisko"); 
		  out.println("<tr>");
		  out.println("<td>" + id + "</td>");
		  out.println("<td>" + dane + "</td>");
		  out.println("<td>" + opis + "</td>");
		  out.println("<td>" + imie + "</td>");
		  out.println("<td>" + nazwisko + "</td>");
		  out.println("</tr>");
		}
		out.println("</table>");
		java.util.Iterator i = userList.listMembers().iterator();
		out.println("<h3>Uzytkownicy</h3>");
		out.println("<ul>");
//		out.println("<table border=\"1\">");
		while (i.hasNext()) {
		  String sLiniaDanych = (String) i.next();
//		  out.println("<TR>");
//		  out.println("<TD>");
		  out.println("<li>" + sLiniaDanych + "</li>");
//		  out.println("</TD>");
//		  out.println("</TR>");
		}
//		out.println("</table>");
		out.println("</ul>");
		out.println("<h3>Parametry z web.xml</h3>");
		String param1 = getServletConfig().getInitParameter("param1");
		String param2 = getServletConfig().getInitParameter("param2");
		out.println("<p>param1: " + param1 + "</p>");
		out.println("<p>param2: " + param2 + "</p>");
		out.println("</body>");
		out.println("</html>");
	 }
	 catch (SQLException ex) {
		Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
	 }	 
	 finally {
		out.close();
	 }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */

  @Override
  public void init() {
	 ApplicationData userList = new ApplicationData();
	 userList.addMember("Patryk Materla");
	 getServletContext().setAttribute("sUserList", userList);
	 try {
		databaseConnection = ApplicationLogic.getConnectionFromContext();
	 } 
	 catch (SQLException exception) {
		System.out.println(exception);
	 }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
	 processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
	 processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
	 return "Short description";
  }
  
  @Override
  public void destroy() {
	 try {
		databaseConnection.close();       
	 }
	 catch(Exception exception)
	 {
		System.out.println("Nie zamknieto polaczenia z baza: " + exception);
	 }
  }// </editor-fold>
}