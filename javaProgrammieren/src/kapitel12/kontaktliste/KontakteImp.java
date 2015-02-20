package kapitel12.kontaktliste;

import java.util.ArrayList;

public class KontakteImp implements Kontakte {
	
	private ArrayList <Kontakt> kontakte = new ArrayList();

	
	@Override
	public void addKontakt(Kontakt kontakt) {
		kontakte.add(kontakt);

	}
	
	@Override 
	public String[] getWerte(){
		String[] werte = new String[kontakte.size()];
		for(int i=0; i<kontakte.size(); i++){
			werte[i] = kontakte.get(i).toString();
			
		}
		return werte;
		
	}

	@Override
	public Kontakt removeKontakt(int index) {
		Kontakt kontakt = kontakte.get(index);
		kontakte.remove(index);
		return kontakt;
	}
	
	

}
