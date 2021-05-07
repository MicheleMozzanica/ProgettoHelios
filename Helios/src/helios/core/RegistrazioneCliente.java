package helios.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneCliente {

	private JFrame frame;
	private JTextField tUserName;
	private JPasswordField tPassword;

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
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea txtDenominazione = new JTextArea();
		txtDenominazione.setBounds(182, 72, 198, 16);
		frame.getContentPane().add(txtDenominazione);

		JTextArea txtPIVA = new JTextArea();
		txtPIVA.setBounds(182, 100, 198, 16);
		frame.getContentPane().add(txtPIVA);

		JButton btnRegistra = new JButton("Registra");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = tUserName.getText();
				String PassWord = new String(tPassword.getPassword());

				if (PassWord.isEmpty() && PassWord.length() < 5) {
					tUserName.setText(null);
					tPassword.setText(null);
					JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo");
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Password or Username");
				}

			}
		});
		btnRegistra.setBounds(286, 222, 117, 29);
		frame.getContentPane().add(btnRegistra);

		JButton btnCancel = new JButton("Annulla");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler uscire?", "FrmLogin",
						JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		btnCancel.setBounds(42, 222, 117, 29);
		frame.getContentPane().add(btnCancel);

		JLabel lblDenominazione = new JLabel("Denominazione");
		lblDenominazione.setBounds(72, 72, 98, 16);
		frame.getContentPane().add(lblDenominazione);

		JLabel lblPartitiaIva = new JLabel("Partitia Iva");
		lblPartitiaIva.setBounds(72, 100, 101, 16);
		frame.getContentPane().add(lblPartitiaIva);

		JLabel lblRegForm = new JLabel("Registrazione cliente");
		lblRegForm.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRegForm.setBounds(117, 6, 220, 29);
		frame.getContentPane().add(lblRegForm);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(72, 154, 101, 16);
		frame.getContentPane().add(lblEmail);

		JTextArea txtEmail = new JTextArea();
		txtEmail.setBounds(182, 154, 198, 16);
		frame.getContentPane().add(txtEmail);

		JTextArea txtSedeLegale = new JTextArea();
		txtSedeLegale.setBounds(182, 126, 198, 16);
		frame.getContentPane().add(txtSedeLegale);

		JLabel lblSedeLegale = new JLabel("Sede Legale");
		lblSedeLegale.setBounds(72, 126, 101, 16);
		frame.getContentPane().add(lblSedeLegale);
	}
}
