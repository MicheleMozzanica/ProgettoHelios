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
			out.println("Vuole effettuare un ordine? [Y/N] - 'quit per uscire'");

			String choose;

			while ((choose = in.readLine()) != null) {
				System.out.printf("Richiesta ricevuta", choose);
				if ("quit".equals(choose) || "N".equals(choose)|| "n".equals(choose)) {
					System.out.println("Quitting...");
					break;
				} else if (!(choose.equals("quit") || "N".equals(choose) || "n".equals(choose))) {
					out.println("In questa pagina può effettuare un ordine");
					sendOrdine(client, out, in);
					myOrderManager.saveDatabaseOrders();
					myOrderManager.loadOrders("OrderDatabase.csv");
				} else {
					out.println("Non è possibile scegliere un opzione al di fuori di Y/N/quit.");
				}
				out.println("Vuole effettuare un altro ordine? [Y/N] - 'quit per uscire'");

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

		// Prodotti ordine
		String nameProd = "not null";
		try {
			while (!((nameProd.equals(null)))){
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

}
