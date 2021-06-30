package helios.core;

import java.awt.EventQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EconomicSituation {

	private JFrame frame;
	double totale;
	Future<Double> totaleCredits;
	Future<Double> totaleDebits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EconomicSituation window = new EconomicSituation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public EconomicSituation() throws InterruptedException, ExecutionException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	private void initialize() throws InterruptedException, ExecutionException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Situazione Economica");
		lblNewLabel.setBounds(158, 6, 137, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Crediti");
		lblNewLabel_1.setBounds(70, 41, 42, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Debiti");
		lblNewLabel_1_1.setBounds(338, 41, 38, 16);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblTotalCrediti = new JLabel("0.00 €");
		lblTotalCrediti.setBounds(70, 64, 101, 16);
		frame.getContentPane().add(lblTotalCrediti);

		JLabel lblTotalDebiti = new JLabel("0.00 €");
		lblTotalDebiti.setBounds(338, 64, 82, 16);
		frame.getContentPane().add(lblTotalDebiti);

		JLabel lblTaxToPay = new JLabel("Tasse da pagare");
		lblTaxToPay.setBounds(170, 119, 101, 16);
		frame.getContentPane().add(lblTaxToPay);

		JLabel lblTax = new JLabel("0.00 €");
		lblTax.setBounds(180, 137, 101, 16);
		frame.getContentPane().add(lblTax);

		JLabel lblTotaleNetto = new JLabel("Totale netto");
		lblTotaleNetto.setBounds(180, 193, 76, 16);
		frame.getContentPane().add(lblTotaleNetto);

		JLabel lblTotalNetto = new JLabel("0.00 €");
		lblTotalNetto.setBounds(180, 209, 115, 16);
		frame.getContentPane().add(lblTotalNetto);
		CalculateTotals();
		lblTotalCrediti.setText(Double.toString(Math.round(totaleCredits.get()*100.0)/100.0) +" €");
		lblTotalDebiti.setText(Double.toString(Math.round(totaleDebits.get()*100.0)/100.0) +" €");
		double totale = totaleCredits.get()-totaleDebits.get();
		lblTax.setText(Double.toString(Math.round(totale*0.15*100.0)/100.0) +" €");
		lblTotalNetto.setText(Double.toString(Math.round((totale-(totale*0.15))*100.0)/100.0) +" €");
		
	}

	

	public void CalculateTotals() {
		ExecutorService executor = Executors.newCachedThreadPool();
		totaleCredits = executor.submit(new taskCalcFatture("Crediti"));
		totaleDebits = executor.submit(new taskCalcFatture("Debiti"));

		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
				executor.shutdownNow();
			}
			

			System.out.println("shutdown finished");

			// TODO Auto-generated method stub

		}
	}

}
