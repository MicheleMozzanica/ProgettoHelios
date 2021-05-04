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

public class RegisrazioneCliente {

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
					RegisrazioneCliente window = new RegisrazioneCliente();
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
	public RegisrazioneCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea txtUsername = new JTextArea();
		txtUsername.setBounds(205, 94, 198, 16);
		frame.getContentPane().add(txtUsername);

		JTextArea txtPassword = new JTextArea();
		txtPassword.setBounds(205, 170, 198, 16);
		frame.getContentPane().add(txtPassword);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
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
		btnSave.setBounds(286, 222, 117, 29);
		frame.getContentPane().add(btnSave);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler uscire?", "FrmLogin", JOptionPane.YES_NO_CANCEL_OPTION)== JOptionPane.YES_OPTION) {
					System.exit(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
		btnExit.setBounds(42, 222, 117, 29);
		frame.getContentPane().add(btnExit);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(42, 94, 117, 16);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(42, 170, 117, 16);
		frame.getContentPane().add(lblPassword);

		JLabel lblRegForm = new JLabel("Registrazione cliente");
		lblRegForm.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRegForm.setBounds(117, 35, 255, 40);
		frame.getContentPane().add(lblRegForm);
	}
}
