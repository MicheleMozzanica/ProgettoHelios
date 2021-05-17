package helios.core;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;

public class ProductsDisplay {

	private JFrame frame;
	ArrayList <Prodotto> ImportedProduct = new ArrayList();
	Magazzino myImportMagazzino = new Magazzino("ImportMagazzino");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductsDisplay window = new ProductsDisplay();
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
	public ProductsDisplay() {
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
		
		JLabel lblMyProducts = new JLabel("Products");
		lblMyProducts.setBounds(200, 6, 61, 16);
		frame.getContentPane().add(lblMyProducts);
		
		
	
//		Prodotto myProd1 = new Prodotto("prod1",1,1,22);
//		Prodotto myProd2 = new Prodotto("prod2",2,4,22);
//		Prodotto myProd3 = new Prodotto("prod3",2,16,22);
		ImportedProduct = myImportMagazzino.ExtractProduct();
		
		for(Prodotto tmpProd : ImportedProduct)
		{
			System.out.println(tmpProd.toString());
		}
		
		JList ProductsJList = new JList(ImportedProduct.toArray());
		ProductsJList.setBounds(6, 32, 438, 240);
		frame.getContentPane().add(ProductsJList);
		
	}
	
}
