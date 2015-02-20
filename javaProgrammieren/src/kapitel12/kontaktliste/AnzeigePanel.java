package kapitel12.kontaktliste;

import javax.swing.JPanel;

public abstract class AnzeigePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void initGUI();
	public abstract void setWerte(String[] werte);
	public abstract int getIndex();
	public abstract void setController(AnzeigeController anzeigeController, DateiController dateiController);
	
	
}
