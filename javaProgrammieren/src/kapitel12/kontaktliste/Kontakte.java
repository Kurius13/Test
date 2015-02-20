package kapitel12.kontaktliste;

public interface Kontakte {
	public void addKontakt(Kontakt kontakt);
	public String[] getWerte();
	public Kontakt removeKontakt(int index);
	
}
