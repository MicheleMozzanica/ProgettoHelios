package helios.core;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;

public class ProductsDisplay extends Magazzino{

	private JFrame frame;
	private JTable tableProducts;
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
		tableProducts = new JTable(myProducts.size(), 2);
		tableProducts.setBounds(6, 60, 438, 212);
		frame.getContentPane().add(tableProducts);
		initializeTable();
		
		
	}
	
	
	public void initializeTable() {
		int row = 0;
		for (Prodotto tmpProd: myProducts) {
			tableProducts.setValueAt(tmpProd.nome, row, 0);
			tableProducts.setValueAt(tmpProd.price + " €", row, 1);
		}

	}
	
}
