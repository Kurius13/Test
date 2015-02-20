package kapitel12.kontaktliste;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Kontaktliste extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BearbeitenPanel bearbeitenPanel;
	private AnzeigePanel anzeigePanel;
	private AnzeigeController anzeigeController;
	public DateiController dateiController;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Kontaktliste inst = new Kontaktliste();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Kontaktliste() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				bearbeitenPanel = new BearbeitenPanelImp();
				getContentPane().add(bearbeitenPanel);
				bearbeitenPanel.initGUI();

			}
			{
				anzeigePanel = new AnzeigePanelImp();
				getContentPane().add(anzeigePanel);
				anzeigePanel.initGUI();

			}
			anzeigeController = new AnzeigeControllerImp(bearbeitenPanel,
					anzeigePanel);
			dateiController = new DateiControllerImp();
			bearbeitenPanel.setAnzeigeController(anzeigeController);
			anzeigePanel.setController(anzeigeController,dateiController);
			Kontakte kontakte = dateiController.kontakteLaden();
			anzeigeController.setKontakte(kontakte);
			
			pack();
			this.setSize(561, 360);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
