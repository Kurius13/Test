package kapitel12.kontaktliste;

public class KontaktImp implements Kontakt {

	private String email;
	private String vorname;
	private String nachname;
	private String telefon;

	@Override
	public String getEmail() {

		return email;
	}

	@Override
	public void setEmail(String nEmail) {
		email = nEmail;

	}

	@Override
	public String getNachname() {

		return nachname;
	}

	@Override
	public void setNachname(String nNachname) {
		nachname = nNachname;

	}

	@Override
	public String getVorname() {

		return vorname;
	}

	@Override
	public void setVorname(String nVorname) {
		vorname = nVorname;

	}

	@Override
	public String getTelefon() {

		return telefon;
	}

	@Override
	public void setTelefon(String nTelefon) {
		telefon = nTelefon;

	}

	@Override
	public String toString() {
		return nachname + ";" + vorname + ";" + telefon + ";" + email;
	}

	@Override
	public void parse(String s) {
		String[] werte = new String[4];

		trennen(s, 0, werte);
		this.setNachname(werte[0]);
		this.setVorname(werte[1]);
		this.setTelefon(werte[2]);
		this.setEmail(werte[3]);
	}

	private void trennen(String str, int nr, String[] werte) {
		int z = str.indexOf(";");
		if (z < 0) {
			werte[nr] = str.substring(0, str.length());
		} else {
			werte[nr] = str.substring(0, z);
			trennen(str.substring(z + 1), nr + 1, werte);
			
		}

	}

}
