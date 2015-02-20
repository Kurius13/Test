package kapitel12.kontaktliste;

public interface Kontakt {
	public String getEmail();
	public void setEmail(String nEmail);
	public String getNachname();
	public void setNachname(String nNachname);
	public String getVorname();
	public void setVorname(String nVorname);
	public String getTelefon();
	public void setTelefon(String nTelefon);
	public String toString();
	public void parse(String s);
	
	
}
