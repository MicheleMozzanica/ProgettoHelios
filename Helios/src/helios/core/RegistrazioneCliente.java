package helios.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RegistrazioneCliente extends ClientDisplay{

	private JFrame frame;
	private JTextField textDenominazione;
	private JTextField textSedeLegale;
	private JTextField textPiva;
	private JTextField textEmail;
	RubricaClienti MyClienti = new RubricaClienti();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrazioneCliente window = new RegistrazioneCliente();
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
	public RegistrazioneCliente() {
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
		
		JLabel lblNewClientLabel = new JLabel("Registrazione nuovo cliente");
		lblNewClientLabel.setBounds(142, 6, 174, 16);
		frame.getContentPane().add(lblNewClientLabel);
		
		JButton btnRegistra = new JButton("Registra Cliente");
		btnRegistra.setBounds(142, 243, 143, 29);
		frame.getContentPane().add(btnRegistra);
		
		textDenominazione = new JTextField();
		textDenominazione.setBounds(6, 49, 438, 26);
		frame.getContentPane().add(textDenominazione);
		textDenominazione.setColumns(10);
		
		textSedeLegale = new JTextField();
		textSedeLegale.setColumns(10);
		textSedeLegale.setBounds(6, 102, 438, 26);
		frame.getContentPane().add(textSedeLegale);
		
		textPiva = new JTextField();
		textPiva.setColumns(10);
		textPiva.setBounds(6, 150, 438, 26);
		frame.getContentPane().add(textPiva);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(6, 205, 438, 26);
		frame.getContentPane().add(textEmail);
		
		JLabel lblDenominazione = new JLabel("Denominazione");
		lblDenominazione.setBounds(6, 33, 98, 16);
		frame.getContentPane().add(lblDenominazione);
		
		JLabel lblSedeLegale = new JLabel("Sede Legale");
		lblSedeLegale.setBounds(6, 87, 73, 16);
		frame.getContentPane().add(lblSedeLegale);
		
		JLabel lblPiva = new JLabel("PIVA");
		lblPiva.setBounds(6, 133, 28, 16);
		frame.getContentPane().add(lblPiva);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(6, 188, 34, 16);
		frame.getContentPane().add(lblEmail);
		
		
		
		/*
		 * 
		 * 
		 * ACTIONS
		 *
		 *
		 *
		 **/
		
		
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String denominazione = textDenominazione.getText();
				String SedeLegale = textSedeLegale.getText();
				String pIva = textPiva.getText();
				String Email = textEmail.getText();
				Cliente clientTmp = new Cliente(denominazione, SedeLegale, pIva, Email);
				String code = denominazione.substring(0, 3).toUpperCase();
				MyClienti.addCliente(code, clientTmp);
				try {
					RubricaClienti.saveDatabaseClienti();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Errore nel salvataggio dei clienti");
				}
			}
		});
	
	
	
	}
	
}
