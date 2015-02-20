package kapitel12.kontaktliste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class AnzeigePanelImp extends AnzeigePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel kontaktlisteLabel;
	private JList kontaktlisteList;
	private JScrollPane jScrollPane1;
	private JButton loeschenButton;
	private JButton bearbeitenButton;
	private JButton endeButton;
	private AnzeigeController anzeigeController;
	private DateiController dateiController;

	public void setController(AnzeigeController anzeigeController,DateiController dateiController) {
		this.anzeigeController = anzeigeController;
		this.dateiController = dateiController;
	}

	@Override
	public void initGUI() {
		this.setBounds(12, 139, 521, 300);
		this.setLayout(null);
		{
			kontaktlisteLabel = new JLabel();
			this.add(kontaktlisteLabel);
			kontaktlisteLabel.setText("Kontaktliste");
			kontaktlisteLabel.setBounds(5, 6, 180, 16);

		}
		{
			jScrollPane1 = new JScrollPane();
			this.add(jScrollPane1);
			jScrollPane1.setBounds(4, 24, 503, 123);
			// jScrollPane1.createHorizontalScrollBar();
			// jScrollPane1.createVerticalScrollBar();
			{
				kontaktlisteList = new JList();
				kontaktlisteList.setBounds(5, 25, 500, 120);
				kontaktlisteList
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			}
			{
				loeschenButton = new JButton();
				this.add(loeschenButton);
				loeschenButton.setBounds(4, 150, 200, 23);
				loeschenButton.setText("Makierten Eintrag löschen");
				loeschenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						loeschenButtonGedrueckt(evt);
					}

				});
			}
			{
				bearbeitenButton = new JButton();
				this.add(bearbeitenButton);
				bearbeitenButton.setBounds(215, 150, 150, 23);
				bearbeitenButton.setText("bearbeiten");
				bearbeitenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						bearbeitenButtonGedrueckt(evt);
					}

				});
			}
			{
				endeButton = new JButton();
				this.add(endeButton);
				endeButton.setBounds(375, 150, 131, 23);
				endeButton.setText("Ende");
				endeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						endeButtonGedrueckt(evt);
					}

				});
			}
		}

	}

	@Override
	public void setWerte(String[] werte) {
		int index = kontaktlisteList.getSelectedIndex();
		if(index<0||index>werte.length-1){
			index = 0;
		}
		
		
		DefaultComboBoxModel kontaktlisteModel = new DefaultComboBoxModel(werte);
		jScrollPane1.setViewportView(kontaktlisteList);
		kontaktlisteList.setModel(kontaktlisteModel);
		kontaktlisteList.setSelectedIndex(index);
	}

	@Override
	public int getIndex() {
		return kontaktlisteList.getSelectedIndex();

	}

	private void loeschenButtonGedrueckt(ActionEvent evt) {
		anzeigeController.kontaktLoeschen();
	}

	private void endeButtonGedrueckt(ActionEvent evt) {
		dateiController.kontakteSpeichern(anzeigeController.getKontakte());
		System.exit(0);
	}
	
	private void bearbeitenButtonGedrueckt(ActionEvent evt){
		anzeigeController.kontkaktBearbeiten();
	}

	
}
