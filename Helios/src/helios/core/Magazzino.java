package helios.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;

public class Magazzino {
	
	public static ArrayList<Prodotto> myProducts = new ArrayList();
	
	public Magazzino() {
		super();
		initializeProdotto();
	}

	public static void addProd(Prodotto newProd) {
		myProducts.add(newProd);
		 try {
			saveDatabaseProds();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error nel salvataggio database prodotti.");
		}
		
	}

	public static void initializeProdotto() {
		String nameFile = "ProductsDatabase.csv";
		File tmpFile = new File(nameFile);

		if (!tmpFile.exists()) {
			System.out.println("Creazione del file");
			try {
				tmpFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Existing" + nameFile);
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				boolean checker = true;
				Scanner s = new Scanner(line).useDelimiter(",");
				if (s.hasNext()) { // ORDINE DELLE STRINGHE = CodeClient ; DENOMINAZIONE; SEDE LEGALE; PIVA; EMAIL ;
									// NOME PRODOTTO; QUANTITA PRODOTTO
					String nome = s.next();
					int price = s.nextInt();
					
					Prodotto tmpProdotto = new Prodotto(nome,price);
					addProd(tmpProdotto);
				}

			}
		} catch (Exception e) {
			System.out.println("Error database prodotti.");
		}
		
	
	}

	
	public static void saveDatabaseProds() throws IOException {
		FileWriter writer = new FileWriter("ProductsDatabase.csv");

		for (Prodotto tmpProd: myProducts) {
			writer.append(tmpProd.nome); // CodeCliente
			writer.append(',');
			writer.append(Integer.toString(tmpProd.price));
			writer.append('\n');

		}
		writer.flush();
		writer.close();

	}

}
