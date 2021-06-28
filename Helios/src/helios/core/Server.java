package helios.core;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;

public class Server {

	OrderManager myOrderManager = new OrderManager();

	int port = 1234;

	public Server() {
		initialize();
	}

	public void initialize() {

		System.out.println("Server in avvio...");

		try (ServerSocket server = new ServerSocket(port);
				Socket client = server.accept();
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));) {
			System.out.printf("Server Info: %s [%d] \n", server.getInetAddress(), server.getLocalPort());
			System.out.printf("Client Connesso: %s [%d] \n", client.getInetAddress(), client.getPort());
			out.println("Scegliere un operazione da effettuare: \n1. Mandare un messaggio \n2.Effettua un ordine");
			String choose;

			while ((choose = in.readLine()) != null) {
				out.println("Scegliere un operazione da effettuare: \n1. Mandare un messaggio \n2.Effettua un ordine");
				System.out.printf("Richiesta ricevuta", choose);
				if ("quit".equals(choose)) {
					System.out.println("Quitting...");
					break;
				} else if (choose.equals("1")) {
					String msgTmp = sendMessaggio(client, out, in); // immagazzino il messaggio
					out.println("Il messaggio è stato recapitato, eccolo di seguito: \n" + msgTmp);
				} else if (choose.equals("2")) {
					sendOrdine(client, out, in);
					myOrderManager.saveDatabaseOrders();
				} else {
					out.println("Non è possibile scegliere un opzione al di fuori della 1 e 2.");
				}

			}
		} catch (IOException e) {

		}
		System.out.println("Server Terminato.");

		// TODO Auto-generated method stub

	}

	public void sendOrdine(Socket socketClient, PrintWriter out, BufferedReader inOrder) {
		ArrayList<ProdottoOrdine> tmpProds = new ArrayList<ProdottoOrdine>();
		Cliente clientTmp = new Cliente("basic", "basic", "basic", "basic");
		out.println("I suoi dati anagrafici:\n");
		// Dati cliente
		try {
			out.println("Denominazione:");
			String denominazione = inOrder.readLine();
			System.out.println("Dati ricevuti" + denominazione);
			out.println("Sede Legale:");
			String sedeLegale = inOrder.readLine();
			System.out.println("Dati ricevuti" + sedeLegale);
			out.println("P.IVA:");
			String pIVA = inOrder.readLine();
			System.out.println("Dati ricevuti" + pIVA);
			out.println("Email:");
			String email = inOrder.readLine();
			System.out.println("Dati ricevuti" + email);

			clientTmp = new Cliente(denominazione, sedeLegale, pIVA, email);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("Errore nell'inserimento dei dati.");
		}

		out.println("Quali prodotti vuole ordinare?(Scrivere 'nop' quando non si vuole più inserire prodotti)\n");

		String nameProd = "start"; //!!!!!!!!!!!!!!!!!!!!!
		// Prodotti ordine
		try {
			while (!((nameProd = inOrder.readLine()).equals("nop"))){
				out.println("Nome del prodotto:");
				nameProd = inOrder.readLine();
				if (nameProd.equals("nop")) {
					out.println("Chiusura ordine");
					break;
				}
				out.println("Quantità del prodotto:");
				int quantity = Integer.parseInt(inOrder.readLine());
				ProdottoOrdine tmpProd = new ProdottoOrdine(nameProd, quantity);
				tmpProds.add(tmpProd);
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("Errore nell'invio dell'ordine");
		}

		String nOrder = clientTmp.denominazione.substring(0, 3).toUpperCase();
		double random = (int) (Math.random() * 100);
		nOrder = nOrder + random;

		Ordine newOrder = new Ordine(tmpProds, clientTmp);
		System.out.println("Nuovo Ordine ricevuto #" + nOrder + "da " + clientTmp.denominazione);
		myOrderManager.addNewOrder(newOrder, nOrder);
		out.println("Nuovo Ordine effettuato #" + nOrder);


	}

	public String sendMessaggio(Socket socketClient, PrintWriter out, BufferedReader inMex) {
		String message = new String();
		try {
			out.println("Scrivi un messaggio\n");
			message = inMex.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("Errore nell'invio del messaggio");
		}
		return message;
	}

}
