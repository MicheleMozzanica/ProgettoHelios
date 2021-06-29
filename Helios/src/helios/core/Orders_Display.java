package helios.core;

import java.awt.EventQueue;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Orders_Display extends OrderManager {

	private JFrame frame;
	private JTable OrdersTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders_Display window = new Orders_Display();
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
	public Orders_Display() {
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

		OrdersTable = new JTable(Orders.size(), 2);
		OrdersTable.setBounds(6, 41, 438, 231);
		frame.getContentPane().add(OrdersTable);

		JLabel lblNewLabel = new JLabel("ORDINI");
		lblNewLabel.setBounds(197, 6, 46, 16);
		frame.getContentPane().add(lblNewLabel);
		initializeTable();

	}

	public void initializeTable() {
		int row = 0;
		for (Entry<String, Ordine> entry : Orders.entrySet()) {
			OrdersTable.setValueAt(entry.getKey(), row, 0);
			OrdersTable.setValueAt(entry.getValue().clientOnOrder.denominazione, row, 1);
			row++;
		}

	}

}
