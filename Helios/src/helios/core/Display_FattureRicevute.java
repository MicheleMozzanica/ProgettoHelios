package helios.core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Display_FattureRicevute extends Gestionale{

	private JFrame frame;
	private JTextField textNFattura;
	private JTextField textProd1;
	private JTextField textProd2;
	private JTextField textProd3;
	private JTextField textProd4;
	private JTextField textProd5;
	private JTextField textPrice1;
	private JTextField textPrice2;
	private JTextField textPrice3;
	private JTextField textPrice4;
	private JTextField textPrice5;
	private JTextField textCodCliente;
	double  totTemp;
	String tempString ;
	int tempnum;
	private JButton btnRegistraFattura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display_FattureRicevute window = new Display_FattureRicevute();
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
	public Display_FattureRicevute() {
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
		
		JLabel lblFattureEmesse = new JLabel("Registra una fattura");
		lblFattureEmesse.setBounds(163, 6, 124, 16);
		lblFattureEmesse.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblFattureEmesse);
		
		textNFattura = new JTextField();
		textNFattura.setBounds(6, 39, 57, 26);
		frame.getContentPane().add(textNFattura);
		textNFattura.setColumns(10);
		
		textProd1 = new JTextField();
		textProd1.setBounds(16, 77, 364, 26);
		frame.getContentPane().add(textProd1);
		textProd1.setColumns(10);
		
		textProd2 = new JTextField();
		textProd2.setColumns(10);
		textProd2.setBounds(16, 104, 364, 26);
		frame.getContentPane().add(textProd2);
		
		textProd3 = new JTextField();
		textProd3.setColumns(10);
		textProd3.setBounds(16, 131, 364, 26);
		frame.getContentPane().add(textProd3);
		
		textProd4 = new JTextField();
		textProd4.setColumns(10);
		textProd4.setBounds(16, 157, 364, 26);
		frame.getContentPane().add(textProd4);
		
		textProd5 = new JTextField();
		textProd5.setColumns(10);
		textProd5.setBounds(16, 185, 364, 26);
		frame.getContentPane().add(textProd5);
		
		textPrice1 = new JTextField();
		textPrice1.setColumns(10);
		textPrice1.setBounds(387, 77, 57, 26);
		frame.getContentPane().add(textPrice1);
		
		textPrice2 = new JTextField();
		textPrice2.setColumns(10);
		textPrice2.setBounds(387, 104, 57, 26);
		frame.getContentPane().add(textPrice2);
		
		textPrice3 = new JTextField();
		textPrice3.setColumns(10);
		textPrice3.setBounds(387, 131, 57, 26);
		frame.getContentPane().add(textPrice3);
		
		textPrice4 = new JTextField();
		textPrice4.setColumns(10);
		textPrice4.setBounds(387, 157, 57, 26);
		frame.getContentPane().add(textPrice4);
		
		textPrice5 = new JTextField();
		textPrice5.setColumns(10);
		textPrice5.setBounds(387, 185, 57, 26);
		frame.getContentPane().add(textPrice5);
		
		JLabel lblTotaleFattura = new JLabel("Totale Fattura:");
		lblTotaleFattura.setVerticalAlignment(SwingConstants.TOP);
		lblTotaleFattura.setBounds(263, 256, 91, 16);
		frame.getContentPane().add(lblTotaleFattura);
		
		JLabel lblTotaleFattura_1 = new JLabel("0,00");
		lblTotaleFattura_1.setVerticalAlignment(SwingConstants.TOP);
		lblTotaleFattura_1.setBounds(367, 256, 66, 16);
		frame.getContentPane().add(lblTotaleFattura_1);
		
		JLabel lblTotaleFattura_1_1 = new JLabel("€");
		lblTotaleFattura_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblTotaleFattura_1_1.setBounds(436, 256, 8, 16);
		frame.getContentPane().add(lblTotaleFattura_1_1);
		
		JLabel lblNFattura = new JLabel("N° Fattura");
		lblNFattura.setVerticalAlignment(SwingConstants.TOP);
		lblNFattura.setBounds(6, 23, 66, 16);
		frame.getContentPane().add(lblNFattura);
		
		JLabel lblCodcliente = new JLabel("Fornitore");
		lblCodcliente.setVerticalAlignment(SwingConstants.TOP);
		lblCodcliente.setBounds(387, 23, 57, 16);
		frame.getContentPane().add(lblCodcliente);
		
		textCodCliente = new JTextField();
		textCodCliente.setColumns(10);
		textCodCliente.setBounds(387, 39, 57, 26);
		frame.getContentPane().add(textCodCliente);
		
		JButton btnCalcolaTotale = new JButton("Calcola Totale");
		
		btnCalcolaTotale.setBounds(327, 223, 117, 29);
		frame.getContentPane().add(btnCalcolaTotale);
		
		btnRegistraFattura = new JButton("REGISTRA FATTURA");
		btnRegistraFattura.setBounds(6, 243, 157, 29);
		frame.getContentPane().add(btnRegistraFattura);
		
		
//Act
	
		
		
		btnRegistraFattura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nFattura = textNFattura.getText();
				String ClientCode = textCodCliente.getText();
				ArrayList<Prodotto> ProdottiFattura = new ArrayList();
				Vector<Integer> prices = new Vector<>(); 
				
				
				if(textPrice1.getText().equals(""))
				{
					prices.add(0);
				}
				else
				{
					prices.add(Integer.parseInt(textPrice1.getText()));
				}
				
				if(textPrice2.getText().equals(""))
				{
					prices.add(0);
				}
				else
				{
					prices.add(Integer.parseInt(textPrice2.getText()));
				}
				
				if(textPrice3.getText().equals(""))
				{
					prices.add(0);
				}
				else
				{
					prices.add(Integer.parseInt(textPrice3.getText()));
				}
				
				if(textPrice4.getText().equals(""))
				{
					prices.add(0);
				}
				else
				{
					prices.add(Integer.parseInt(textPrice4.getText()));
				}
				
				if(textPrice5.getText().equals(""))
				{
					prices.add(0);
				}
				else
				{
					prices.add(Integer.parseInt(textPrice5.getText()));
				}
				
				Vector<String> names = new Vector<>(); 
				names.add(textProd1.getText());
				names.add(textProd2.getText());
				names.add(textProd3.getText());
				names.add(textProd4.getText());
				names.add(textProd5.getText());
				
				for(int i = 0; i<5; i++)
				{
					int quantity = 1;
					int iva = 22;
					String nome = names.get(i);
					int prezzo = prices.get(i);
					Prodotto tempProd = new Prodotto(nome,prezzo,quantity,iva);
					ProdottiFattura.add(tempProd);
				}
				double totaleFattura = Double.parseDouble(lblTotaleFattura_1.getText());
				AddFattRicevute(nFattura,ClientCode,totaleFattura,ProdottiFattura); //VAI A REGISTRARE LA FATTURA IN GESTIONALE
				
				textProd1.setText("");
				textProd2.setText("");
				textProd3.setText("");
				textProd4.setText("");
				textProd5.setText("");
				textPrice1.setText("");
				textPrice2.setText("");
				textPrice3.setText("");
				textPrice4.setText("");
				textPrice5.setText("");
				textCodCliente.setText("");
				textNFattura.setText("");
				lblTotaleFattura_1.setText("");


				
			}
		});
		
		
		btnCalcolaTotale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				tempString = textPrice1.getText();
						if(tempString.equals("")) {
							tempnum = 0;
							}
						else {
							tempnum = Integer.parseInt(tempString);
						}
							totTemp += tempnum;
							
				tempString = textPrice2.getText();
							if(tempString.equals("")) {
								tempnum = 0;
								}
							else {
								tempnum = Integer.parseInt(tempString);
							}
								totTemp += tempnum;
							
				tempString = textPrice3.getText();
								if(tempString.equals("")) {
									tempnum = 0;
									}
								else {
									tempnum = Integer.parseInt(tempString);
								}
									totTemp += tempnum;
							
				tempString = textPrice4.getText();
									if(tempString.equals("")) {
										tempnum = 0;
										}
									else {
										tempnum = Integer.parseInt(tempString);
									}
										totTemp += tempnum;
										
										
				tempString = textPrice5.getText();
										if(tempString.equals("")) {
											tempnum = 0;
											}
										else {
											tempnum = Integer.parseInt(tempString);
										}
											totTemp += tempnum;
											
							
							totTemp = totTemp*1.22;
						    totTemp = Math.round(totTemp*100.0)/100.0;

							tempString = Double.toString(totTemp);
							lblTotaleFattura_1.setText(tempString);
				
				
			}
		});
	}
}
