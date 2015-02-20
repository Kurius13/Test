package kapitel12.kontaktliste;

public class AnzeigeControllerImp implements AnzeigeController {

	private BearbeitenPanel bPanel;
	private Kontakte kontakte = new KontakteImp();
	private AnzeigePanel aPanel;

	public AnzeigeControllerImp(BearbeitenPanel bearbeitenPanel,
			AnzeigePanel anzeigePanel) {
		aPanel = anzeigePanel;
		bPanel = bearbeitenPanel;
	}

	@Override
	public void kontaktUebernehmen() {
		Kontakt kontakt = new KontaktImp();
		kontakt.setEmail(bPanel.getEmailText());
		kontakt.setTelefon(bPanel.getTelefonText());
		kontakt.setVorname(bPanel.getVornameText());
		kontakt.setNachname(bPanel.getNachnameText());
		kontakte.addKontakt(kontakt);
		aPanel.setWerte(kontakte.getWerte());
	}

	@Override
	public void kontaktLoeschen() {
		int index = aPanel.getIndex();
		if (index >= 0) {
			kontakte.removeKontakt(aPanel.getIndex());
		}
		aPanel.setWerte(kontakte.getWerte());
	}

	@Override
	public void kontkaktBearbeiten() {
		int index = aPanel.getIndex();
		if (index >= 0) {
			Kontakt kontakt = kontakte.removeKontakt(aPanel.getIndex());
			bPanel.setNachnameText(kontakt.getNachname());
			bPanel.setVornameText(kontakt.getVorname());
			bPanel.setTelefonText(kontakt.getTelefon());
			bPanel.setEmailText(kontakt.getEmail());
		}

		aPanel.setWerte(kontakte.getWerte());
	}

	@Override
	public Kontakte getKontakte() {
		return kontakte;
	}

	@Override
	public void setKontakte(Kontakte kontakte) {
		this.kontakte = kontakte;
		aPanel.setWerte(kontakte.getWerte());
		
	}

}
