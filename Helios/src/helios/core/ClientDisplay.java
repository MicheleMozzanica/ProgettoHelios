package helios.core;

import java.awt.EventQueue;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ClientDisplay extends RubricaClienti {

	private JFrame frame;
	private JTable ClientTable;
	private JLabel lblClienti;
	private JButton btnRefresh;
	private JLabel lblCodice;
	private JLabel lblDenominazione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientDisplay window = new ClientDisplay();
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
	public ClientDisplay() {
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

		ClientTable = new JTable(clienti.size(), 2);
		ClientTable.setBounds(6, 42, 438, 197);
		frame.getContentPane().add(ClientTable);

		JButton btnNewButton = new JButton("Registra nuovo cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrazioneCliente.main(null);
			}
		});
		btnNewButton.setBounds(260, 243, 184, 29);
		frame.getContentPane().add(btnNewButton);

		lblClienti = new JLabel("Clienti");
		lblClienti.setBounds(206, 7, 41, 16);
		frame.getContentPane().add(lblClienti);

		btnRefresh = new JButton("Refresh");

		btnRefresh.setBounds(6, 243, 117, 29);
		frame.getContentPane().add(btnRefresh);
		
		lblCodice = new JLabel("Codice");
		lblCodice.setBounds(6, 20, 43, 16);
		frame.getContentPane().add(lblCodice);
		
		lblDenominazione = new JLabel("Denominazione");
		lblDenominazione.setBounds(272, 20, 98, 16);
		frame.getContentPane().add(lblDenominazione);

		initializeTable();

		// *ACTIONS

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeTable();
			}
		});

	}

	public void initializeTable() {
		int row = 0;
		for (Entry<String, Cliente> entry : clienti.entrySet()) {
			ClientTable.setValueAt(entry.getKey(), row, 0);
			ClientTable.setValueAt(entry.getValue().denominazione, row, 1);
			row++;
		}

	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
