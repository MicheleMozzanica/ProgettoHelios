package helios.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class mainView {

	private JFrame frame;
	static Magazzino myMagazzino = new Magazzino();
	RubricaClienti MyClienti = new RubricaClienti();
	static RubricaFornitori MyFornitori = new RubricaFornitori();
	static Gestionale MyGestionale = new Gestionale();
	static OrderManager MyOrderManager = new OrderManager();
	//
//	public ImageIcon myImage = new ImageIcon(getClass().getResource());

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGestionale.loadFattureEmesse("FattEmesse.csv");
					MyGestionale.loadFattureRicevute("FattRicevute.csv");
					MyOrderManager.loadOrders("OrderDatabase.csv");
					
		
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					mainView window = new mainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public mainView() throws ClassNotFoundException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(new JLabel(new ImageIcon("/Users/simonesaleri/Documents/GitHub/ProgettoHelios")));

//		JLabel ImageLabel = new JLabel(myImage);
//		ImageLabel.setBounds(298, 50, 93, 16);
//		frame.getContentPane().add(ImageLabel);

		JButton btnOpenRegistraFattura = new JButton("Registra Fattura");
		btnOpenRegistraFattura.setBounds(127, 78, 178, 29);
		frame.getContentPane().add(btnOpenRegistraFattura);

		JButton btnOpenEmettiFattura = new JButton("Emetti fattura");
		btnOpenEmettiFattura.setBounds(127, 119, 178, 29);
		frame.getContentPane().add(btnOpenEmettiFattura);

		JButton btnOpenGestioneOrdini = new JButton("Gestione Ordini");
		btnOpenGestioneOrdini.setBounds(127, 160, 178, 29);
		frame.getContentPane().add(btnOpenGestioneOrdini);

		JButton btnOpenClienti = new JButton("Clienti");
		btnOpenClienti.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(btnOpenClienti);

		JLabel lblNewLabel_1 = new JLabel("Helios Project");
		lblNewLabel_1.setBounds(166, 25, 93, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnSaveDatabase = new JButton("Save Database");
		btnSaveDatabase.setBounds(6, 242, 154, 29);
		frame.getContentPane().add(btnSaveDatabase);
		
		JButton btnStartServer = new JButton("Start Server ");
		btnStartServer.setBounds(327, 0, 117, 29);
		frame.getContentPane().add(btnStartServer);
		
		JButton btnEconomy = new JButton("Situazione Economica");
		btnEconomy.setBounds(155, 243, 165, 29);
		frame.getContentPane().add(btnEconomy);

		btnOpenRegistraFattura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display_FattureRicevute.main(null);
			}
		});

		btnOpenClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MyClienti.initalizeClients();
					ClientDisplay.main(null);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				System.out.println("Errore nell'inizializzazione dei clienti");
				}
			}
		});

		btnOpenEmettiFattura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display_FattureEmesse.main(null);

			}
		});
		
		
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Server myServer = new Server();
			}
		});


		
		btnSaveDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MyGestionale.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnOpenGestioneOrdini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders_Display.main(null);
			}
		});
		
		btnEconomy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EconomicSituation.main(null);
			}
		});
	}
}
