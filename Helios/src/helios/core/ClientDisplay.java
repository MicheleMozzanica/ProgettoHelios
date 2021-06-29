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

public class ClientDisplay extends RubricaClienti{

	private JFrame frame;
	private JTable ClientTable;
	private JLabel lblClienti;

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
		
		ClientTable = new JTable(clienti.size(),2);
		ClientTable.setBounds(6, 35, 438, 204);
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
		 int row=0;
		 for(Entry<String, Cliente> entry: clienti.entrySet()){
			 ClientTable.setValueAt(entry.getKey(),row,0);
			 ClientTable.setValueAt(entry.getValue().denominazione,row,1);
		      row++;
		 }
	}
}
