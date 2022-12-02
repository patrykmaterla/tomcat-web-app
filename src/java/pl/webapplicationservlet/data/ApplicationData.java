/* DTO, Data Transer Object */
package pl.webapplicationservlet.data;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class ApplicationData implements Serializable {
  List<String> usersList = new ArrayList();
  
  public void addMember(String sData) {
	 usersList.add(sData);    
  }
  public java.util.List listMembers() {
	 return usersList;    
  }
}