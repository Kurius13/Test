package kapitel12.kontaktliste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BearbeitenPanelImp extends  BearbeitenPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nachnameLabel;
	private JTextField nachnameTextfeld;
	private JLabel vornameLabel;
	private JTextField emailTextfeld;
	private JLabel emailLabel;
	private JTextField telefonTextfeld;
	private JLabel telefonLabel;
	private JTextField vornameTextfeld;
	private JButton uebernehmenButton;
	private AnzeigeController anzeigeController;	
	
	public void setAnzeigeController(AnzeigeController anzeigeController) {
		this.anzeigeController = anzeigeController;
	}

	public void initGUI() {
		this.setBounds(12, 12, 521, 115);
		this.setLayout(null);
		
		{
			nachnameLabel = new JLabel();
			this.add(nachnameLabel);
			nachnameLabel.setText("Nachname");
			nachnameLabel.setBounds(12, 6, 112, 16);
		}
		{
			nachnameTextfeld = new JTextField();
			this.add(nachnameTextfeld);
			nachnameTextfeld.setBounds(12, 28, 112, 23);
		}
		{
			vornameLabel = new JLabel();
			this.add(vornameLabel);
			vornameLabel.setText("Vorname");
			vornameLabel.setBounds(136, 6, 115, 17);
		}
		{
			vornameTextfeld = new JTextField();
			this.add(vornameTextfeld);
			vornameTextfeld.setBounds(136, 28, 115, 23);
		}
		{
			telefonLabel = new JLabel();
			this.add(telefonLabel);
			telefonLabel.setText("Telefon");
			telefonLabel.setBounds(278, 6, 231, 16);
		}
		{
			telefonTextfeld = new JTextField();
			this.add(telefonTextfeld);
			telefonTextfeld.setBounds(278, 28, 226, 23);
		}
		{
			emailLabel = new JLabel();
			this.add(emailLabel);
			emailLabel.setText("Email");
			emailLabel.setBounds(12, 57, 284, 16);
		}
		{
			emailTextfeld = new JTextField();
			this.add(emailTextfeld);
			emailTextfeld.setBounds(12, 81, 240, 23);
		}
		{
			uebernehmenButton = new JButton();
			this.add(uebernehmenButton);
			uebernehmenButton.setText("Übernehmen >>");
			uebernehmenButton.setBounds(302, 81, 176, 23);
			uebernehmenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					uebernehmenButtonGedrueckt(evt);
				}
			});
		}

	}

	public String getNachnameText() {
		return nachnameTextfeld.getText();
	}

	public String getEmailText() {
		return emailTextfeld.getText();
	}

	public String getTelefonText() {
		return telefonTextfeld.getText();
	}

	public String getVornameText() {
		return vornameTextfeld.getText();
	}
	
	private void uebernehmenButtonGedrueckt(ActionEvent evt){
		anzeigeController.kontaktUebernehmen();
		
	}

	@Override
	public void setVornameText(String vName) {
		vornameTextfeld.setText(vName);
		
	}

	@Override
	public void setNachnameText(String nName) {
		nachnameTextfeld.setText(nName);
		
	}

	@Override
	public void setTelefonText(String nTelefon) {
		telefonTextfeld.setText(nTelefon);
		
	}

	@Override
	public void setEmailText(String nEmail) {
		emailTextfeld.setText(nEmail);
		
	}

}
