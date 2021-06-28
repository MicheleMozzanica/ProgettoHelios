package helios.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OrderManager {

	String nOrder;
	static HashMap<String, Ordine> Orders = new HashMap<String, Ordine>();

	public static void addNewOrder(Ordine newOrder, String nOrder) {

		Orders.put(nOrder, newOrder);
		System.out.println("Ordini:\n");
		for (String name : Orders.keySet()) {
			String key = name.toString();
			String value = Orders.get(name).toString();
			System.out.println("#" + key + " - " + value + "\n");
		}
	}

	public static void saveDatabaseOrders() throws IOException {
		FileWriter writer = new FileWriter("OrderDatabase.csv");

		for (String name : Orders.keySet()) {
			writer.append(Orders.get(name).toString()); // nOrdine
			writer.append(',');
			writer.append(Orders.get(name).clientOnOrder.denominazione);
			writer.append(',');
			writer.append(Orders.get(name).clientOnOrder.sedeLegale);
			writer.append(',');
			writer.append(Orders.get(name).clientOnOrder.pIva);
			writer.append(',');
			writer.append(Orders.get(name).clientOnOrder.eMail);
			writer.append(',');
			for (int i = 0; i < Orders.get(name).productsOnOrder.size(); i++) {
				writer.append(Orders.get(name).productsOnOrder.get(i).nome);
				writer.append(',');
				writer.append(Integer.toString(Orders.get(name).productsOnOrder.get(i).price));
				writer.append(',');

			}
			writer.append('\n');

		}
		writer.flush();
		writer.close();

	}

	public static void loadOrders(String nameFile) throws IOException {

		File tmpFile = new File(nameFile);

		if (!tmpFile.exists()) {
			System.out.println("Creazione del file");
			tmpFile.createNewFile();
		} else {
			System.out.println("Existing" + nameFile);
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				boolean checker = true;
				Scanner s = new Scanner(line).useDelimiter(",");
				if (s.hasNext()) { // ORDINE DELLE STRINGHE = NORDINE ; DENOMINAZIONE; SEDE LEGALE; PIVA; EMAIL ;
									// NOME PRODOTTO; QUANTITA PRODOTTO
					String nOrdine = s.next();
					String Denominazione = s.next();
					String SedeLegale = s.next();
					String pIva = s.next();
					String Email = s.next();
					Cliente clienteTmp = new Cliente(Denominazione, SedeLegale, pIva, Email);
					ArrayList<ProdottoOrdine> tmpProdotto = new ArrayList<ProdottoOrdine>();
					while (checker) {
						if (s.hasNext()) {
							String nameP = s.next();
							int quantity = s.nextInt();
							// String nome, int quantity,
							ProdottoOrdine prodottoTmp = new ProdottoOrdine(nameP, quantity);
							tmpProdotto.add(prodottoTmp);
						} else {
							checker = false;
						}
					}
					Ordine tmpOrder = new Ordine(tmpProdotto, clienteTmp);
					addNewOrder(tmpOrder, nOrdine);
				}

			}
		} catch (Exception e) {
			System.out.println("Error database ordini.");
		}

	}

}
