package helios.core;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ClientDisplay extends mainView{

	private JFrame frame;
	public HashMap<String, Cliente> ImportClienti = new HashMap();
	ArrayList<Cliente> myClients = new ArrayList<Cliente> ();

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
		
		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setBounds(202, 6, 44, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewClient = new JButton("Add New Client");
		
		btnNewClient.setBounds(272, 243, 172, 29);
		frame.getContentPane().add(btnNewClient);
		
		
		JButton RefreshButton = new JButton("Refresh");
		
		
		RefreshButton.setBounds(16, 243, 117, 29);
		frame.getContentPane().add(RefreshButton);
		
		initializeList();
			
		//* ACTIONS*//
		
		btnNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrazioneCliente.main(null);
			}
		
			});
		
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeList();
				
			}
		});
	}

	private void initializeList() {
		ImportClienti = MyClienti.getClienti();
		for (Entry<String, Cliente> entry : ImportClienti.entrySet()) {
	        myClients.add(entry.getValue());
	    }
		for(int i = 0; i < ImportClienti.size();i++) {
		System.out.println(ImportClienti.get(i).toString());
	    }
		JList ClientList = new JList(myClients.toArray());
		ClientList.setBounds(6, 26, 438, 215);
		frame.getContentPane().add(ClientList);		
	}

}
