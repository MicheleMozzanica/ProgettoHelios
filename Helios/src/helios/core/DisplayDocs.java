package helios.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayDocs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDocs window = new DisplayDocs();
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
	public DisplayDocs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 103);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFattureEmesse = new JButton("Fatture Emesse");
		btnFattureEmesse.setBounds(32, 36, 139, 29);
		frame.getContentPane().add(btnFattureEmesse);
		
		JButton btnFattureRicevute = new JButton("Fatture Ricevute");
		btnFattureRicevute.setBounds(268, 36, 143, 29);
		frame.getContentPane().add(btnFattureRicevute);
		
		
		//*ACTIONS
		
		
		btnFattureEmesse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayDocumentsGeneralFattEmesse.main(null);
			}
		});
		

		btnFattureRicevute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayDocumentsGeneralFattRicevute.main(null);
			}
		});
	}

}
