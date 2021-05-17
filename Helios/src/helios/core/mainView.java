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
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class mainView {

	private JFrame frame;
	Magazzino myMagazzino = new Magazzino("gino");
	public HashMap<String, Cliente> clienti = new HashMap();
	RubricaClienti MyClienti = new RubricaClienti(clienti);
	RubricaFornitori MyFornitori = new RubricaFornitori();
//	
//	public ImageIcon myImage = new ImageIcon(getClass().getResource());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
	 */
	public mainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(new JLabel(new ImageIcon("/Users/simonesaleri/Documents/GitHub/ProgettoHelios")));

		
		JLabel ImageLabel = new JLabel(myImage);
		ImageLabel.setBounds(298, 50, 93, 16);
		frame.getContentPane().add(ImageLabel);

		JButton btnOpenRegistraFattura = new JButton("Registra Fattura");
		btnOpenRegistraFattura.setBounds(127, 78, 178, 29);
		frame.getContentPane().add(btnOpenRegistraFattura);

		JButton btnOpenEmettiFattura = new JButton("Emetti fattura");
		btnOpenEmettiFattura.setBounds(127, 119, 178, 29);
		frame.getContentPane().add(btnOpenEmettiFattura);

		JButton btnOpenVisualizzaMagazzino = new JButton("Visualizza Magazzino");

		btnOpenVisualizzaMagazzino.setBounds(127, 160, 178, 29);
		frame.getContentPane().add(btnOpenVisualizzaMagazzino);

		JButton btnOpenGestioneOrdini = new JButton("Gestione Ordini");
		btnOpenGestioneOrdini.setBounds(127, 201, 178, 29);
		frame.getContentPane().add(btnOpenGestioneOrdini);

		JButton btnOpenClienti = new JButton("Clienti");
		btnOpenClienti.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(btnOpenClienti);
		
		JLabel lblNewLabel_1 = new JLabel("Helios Project");
		lblNewLabel_1.setBounds(166, 25, 93, 16);
		frame.getContentPane().add(lblNewLabel_1);

		/**
		 * Actions
		 * 
		 * 
		 */

		btnOpenVisualizzaMagazzino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductsDisplay displayMagazzino = new ProductsDisplay();
				displayMagazzino.main(null);
			}
		});

		btnOpenClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientDisplay.main(null);
			}
		});
	}
}
