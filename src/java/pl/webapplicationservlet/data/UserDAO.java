package pl.webapplicationservlet.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    
  public static List<User> selectAllUsers() {
	 List<User> users = new ArrayList<>(); 
	 String query = "SELECT * FROM t_uzytkownik";
	 try {
		Connection databaseConnection = ApplicationLogic.getConnectionFromContext();
		ResultSet rs = databaseConnection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		while (rs.next()) {
		  int id = rs.getInt("id");
		  String opis = rs.getString("opis");
		  String dane = rs.getString("dane");
		  String imie = rs.getString("imie");
		  String nazwisko = rs.getString("nazwisko");
		  users.add(new User(id, opis, dane, imie , nazwisko));
		}
		databaseConnection.close();
	 }
	 catch (SQLException exception) {
		System.out.println(exception);
	 }
	 return users;
  }

}