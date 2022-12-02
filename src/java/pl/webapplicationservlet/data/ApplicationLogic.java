package pl.webapplicationservlet.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ApplicationLogic {
  public static Connection makeNewConnection(String sUrl, String sUsername, String sPassword) throws SQLException {
	 // tworzenia polaczenia z baza mysql
    String sDriverMySQL="com.mysql.jdbc.Driver";
    String sDriverMSSQL="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String sDriver=sDriverMSSQL;
	 System.out.println("FROM APP");
    try {
      // Załaduj sterownik bazy danych, jeżeli jeszcze nie został załadowany
      Class.forName(sDriver);
      // Nawiąż połączenie sieciowe z bazą danych.
      Connection connection = DriverManager.getConnection(sUrl, sUsername, sPassword);
      return connection;
    } 
	 catch(ClassNotFoundException cnfe) {
      throw new SQLException("Nie znaleziono klasy dla sterownika: " + sDriver);
    }
  }
  
  public static Connection connectDatabase() {
	 Connection databaseConnection = null;
	 String sUser="tomcatuser";
    String sPassword="tomcat";
    String sHost="155.158.112.31";
	 String SSLProtocol = "sslProtocol=TLSv1.2";
	 String sURL="jdbc:sqlserver://" + sHost + ":1433;databaseName=tomcat";
    // tu mozna zainicjować pulę połączeń, a pozniej tylko przy wywolaniu servletu
    // bedzie pobierać polączenie z puli, bez konieczności ponownego łączenia z bazą
    // bedzie to działało szybciej
    // polaczenie jdbc:odbc
    // String sURL="jdbc:odbc:sklep";
    // String sURL="jdbc:mysql://"+sHost+"/bazatest?characterEncoding=latin2";
    try {
		// pulaPolaczen = new ConnectionPool("com.mysql.jdbc.Driver", sURL, sDataBasedUser, sDataBasePassword, 10, 50, true);
		databaseConnection = makeNewConnection(sURL,sUser,sPassword);    
    }
    catch(SQLException ex) {
		ex.getSQLState();
		System.err.println(ex);
		System.err.println(ex.getSQLState());
    }
    return databaseConnection;
  }
  
  public static Connection getConnectionFromContext() throws SQLException {
	 try {
		javax.naming.Context initContext = new javax.naming.InitialContext();
		javax.naming.Context envContext  = (javax.naming.Context)initContext.lookup("java:/comp/env");
		javax.sql.DataSource ds_mssql = (javax.sql.DataSource)envContext.lookup("jdbc/bazaTestowaMSSQL");
		Connection connection = ds_mssql.getConnection(); 
		return connection;
	 }
	 catch(Exception ex) {
		throw new SQLException("Nie pobrano połączenia z kontekstu");
	 }      
  }    
}