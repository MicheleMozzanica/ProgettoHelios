package helios.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
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
	RubricaClienti myRubricaClienti = new RubricaClienti(ImportClienti);
	
	

	public ClientDisplay(JFrame frame, RubricaClienti myRubricaClienti, HashMap<String, Cliente> Importclienti) {
		myRubricaClienti = this.MyClienti;
		this.frame = frame;
		this.ImportClienti = ImportClienti; 	
	}

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
		
		
		ImportClienti = myRubricaClienti.exportClients();
		
		ArrayList<Cliente> myClients = new ArrayList<Cliente> ();
		for (Entry<String, Cliente> entry : ImportClienti.entrySet()) {
	        myClients.add(entry.getValue());
	    }
		JList ClientList = new JList(myClients.toArray());
		ClientList.setBounds(6, 26, 438, 215);
		frame.getContentPane().add(ClientList);
		
		//* ACTIONS*//
		
		btnNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrazioneCliente.main(null);
			}
		});
		
		
//		public JList refreshMetod() {
//			return null;
//		}
	}
}
