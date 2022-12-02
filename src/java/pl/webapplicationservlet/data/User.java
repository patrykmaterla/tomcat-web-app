package pl.webapplicationservlet.data;


public class User {
  private int id;
  private String dane;
  private String opis;
  private String imie;
  private String nazwisko;
  
  public User() {}
  
  public User (int id, String imie, String nazwisko) {
	 this.id = id;
	 this.imie = imie;
	 this.nazwisko = nazwisko;
  }
  
  public User(int id, String opis, String dane, String imie, String nazwisko) {
	 this.id = id;
	 this.opis = opis;
	 this.dane = dane;
	 this.imie = imie;
	 this.nazwisko = nazwisko;
  }
  
    public int getId() {
		return id;
    }

    public void setId(int id) {
		this.id = id;
    }

    public String getDane() {
		return dane;
    }

    public void setDane(String dane) {
		this.dane = dane;
    }

    public String getOpis() {
		return opis;
    }

    public void setOpis(String opis) {
		this.opis = opis;
    }

    public String getImie() {
		return imie;
    }

    public void setImie(String imie) {
		this.imie = imie;
    }

    public String getNazwisko() {
		return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	 }
}
