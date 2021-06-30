package helios.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;

public class DisplayDocumentsGeneralFattEmesse extends Gestionale{

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDocumentsGeneralFattEmesse window = new DisplayDocumentsGeneralFattEmesse();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayDocumentsGeneralFattEmesse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable(getFattureEmesse().size(), 3);
		table.setBounds(6, 47, 438, 225);
		frame.getContentPane().add(table);
		
		JLabel lblFattureEmesse = new JLabel("Fatture Emesse");
		lblFattureEmesse.setBounds(174, 6, 103, 16);
		frame.getContentPane().add(lblFattureEmesse);
		populate();
	}

	private void populate() {
		
		int row = 0;
		for (FattureClienti tmpFat: getFattureEmesse()) {
			table.setValueAt(tmpFat.nFattura, row, 0);
			table.setValueAt(tmpFat.Codice, row, 1);
			table.setValueAt(tmpFat.totale + " €", row, 2);
			row++;
		}

		
		
	}
}
