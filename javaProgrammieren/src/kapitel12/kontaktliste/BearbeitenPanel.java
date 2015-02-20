package kapitel12.kontaktliste;
import javax.swing.JPanel;


public abstract class BearbeitenPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void initGUI();
	public abstract String getVornameText();
	public abstract String getNachnameText();
	public abstract String getTelefonText();
	public abstract String getEmailText();
	public abstract void setAnzeigeController(AnzeigeController anzeigeController);
	public abstract void setVornameText(String vName);
	public abstract void setNachnameText(String nName);
	public abstract void setTelefonText(String nTelefon);
	public abstract void setEmailText(String nEmail);
	
	
}
