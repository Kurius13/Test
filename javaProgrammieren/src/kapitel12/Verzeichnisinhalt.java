package kapitel12;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

public class Verzeichnisinhalt {

	private JFrame frmVerzeichnisinhalt;
	private JTextField verzeichnisTextfeld;
	private DefaultListModel verzeichnisListModel;
	private DefaultListModel dateiListModel;
	private File verzeichnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verzeichnisinhalt window = new Verzeichnisinhalt();
					window.frmVerzeichnisinhalt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Verzeichnisinhalt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVerzeichnisinhalt = new JFrame();
		frmVerzeichnisinhalt.setTitle("Verzeichnisinhalt");
		frmVerzeichnisinhalt.setBounds(100, 100, 450, 300);
		frmVerzeichnisinhalt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVerzeichnisinhalt.getContentPane().setLayout(null);

		JLabel lblVerzeichnis = new JLabel("Verzeichnis");
		lblVerzeichnis.setBounds(20, 11, 105, 14);
		frmVerzeichnisinhalt.getContentPane().add(lblVerzeichnis);

		verzeichnisTextfeld = new JTextField();
		verzeichnisTextfeld.setBounds(20, 36, 389, 20);
		frmVerzeichnisinhalt.getContentPane().add(verzeichnisTextfeld);
		verzeichnisTextfeld.setColumns(10);

		JButton btnInhaltAnzeigen = new JButton("Inhalt anzeigen");
		btnInhaltAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dateiListModel.clear();
				verzeichnisListModel.clear();
				if (verzeichnisTextfeld.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(null,
									"Kein Verzeichnisname vorhanden! Bitte gib einen Verzeichnisnamen ein!");
				} else {
					verzeichnis = new File(verzeichnisTextfeld.getText());
					if (verzeichnis.exists()) {
						String[] inhalt = verzeichnis.list();
						for (String eintrag : inhalt) {
							File f = new File(verzeichnis, eintrag);
							if (f.isDirectory()) {
								verzeichnisListModel.addElement(eintrag);
							} else {
								dateiListModel.addElement(eintrag);
							}
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"Verzeichnis existiert nicht! Bitte gib ein gültiges ein!");
					}
				}
			}
		});
		btnInhaltAnzeigen.setBounds(20, 67, 137, 23);
		frmVerzeichnisinhalt.getContentPane().add(btnInhaltAnzeigen);

		JLabel lblVerzeichnisse = new JLabel("Verzeichnisse");
		lblVerzeichnisse.setBounds(20, 107, 137, 14);
		frmVerzeichnisinhalt.getContentPane().add(lblVerzeichnisse);

		JLabel lblDateien = new JLabel("Dateien");
		lblDateien.setBounds(231, 107, 128, 14);
		frmVerzeichnisinhalt.getContentPane().add(lblDateien);

		JScrollPane verzeichnisScrollPane = new JScrollPane();
		verzeichnisScrollPane.setBounds(20, 132, 173, 91);
		frmVerzeichnisinhalt.getContentPane().add(verzeichnisScrollPane);

		verzeichnisListModel = new DefaultListModel();
		JList verzeichnisList = new JList(verzeichnisListModel);
		verzeichnisScrollPane.setViewportView(verzeichnisList);

		JScrollPane dateiScrollPane = new JScrollPane();
		dateiScrollPane.setBounds(231, 132, 178, 91);
		frmVerzeichnisinhalt.getContentPane().add(dateiScrollPane);

		dateiListModel = new DefaultListModel();
		JList dateiList = new JList(dateiListModel);
		dateiScrollPane.setViewportView(dateiList);

		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(138, 234, 149, 23);
		frmVerzeichnisinhalt.getContentPane().add(btnEnde);

		JButton btnAuswhlen = new JButton("Ausw\u00E4hlen...");
		btnAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int status = fc.showOpenDialog(null);
				if (status == JFileChooser.APPROVE_OPTION) {
					File selectionFile = fc.getSelectedFile();
					verzeichnisTextfeld.setText(selectionFile.getPath());
				}
			}
		});
		btnAuswhlen.setBounds(255, 67, 154, 23);
		frmVerzeichnisinhalt.getContentPane().add(btnAuswhlen);

		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnStart.setBounds(166, 67, 81, 23);
		frmVerzeichnisinhalt.getContentPane().add(btnStart);
		
	}

}
