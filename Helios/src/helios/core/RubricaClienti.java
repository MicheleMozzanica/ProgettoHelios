package helios.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class RubricaClienti {
	
	public static HashMap<String, Cliente> clienti = new HashMap();

	public RubricaClienti(){
		
		try {
			initalizeClients();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initalizeClients() throws IOException {
		String nameFile = "ClientsDatabase.csv";
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
				if (s.hasNext()) { // ORDINE DELLE STRINGHE = CodeClient ; DENOMINAZIONE; SEDE LEGALE; PIVA; EMAIL ;
									// NOME PRODOTTO; QUANTITA PRODOTTO
					String code = s.next();
					String Denominazione = s.next();
					String SedeLegale = s.next();
					String pIva = s.next();
					String Email = s.next();
					Cliente clienteTmp = new Cliente(Denominazione, SedeLegale, pIva, Email);
					addCliente(code, clienteTmp);
				}

			}
		} catch (Exception e) {
			System.out.println("Error database clienti.");
		}

	}

	public static void addCliente(String Code, Cliente clientTmp) {

		/* il campo CODE sono le prime 3 lettere della denominazione del cliente */
		clienti.put(Code, clientTmp);

//		for (Entry<String, Cliente> entry : clienti.entrySet()) {
//			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue() + "\n");
//		}

	}

	
	public static void saveDatabaseClienti() throws IOException {
		FileWriter writer = new FileWriter("ClientsDatabase.csv");

		for (Entry<String, Cliente> entry : clienti.entrySet()) {
			writer.append(entry.getKey()); // CodeCliente
			writer.append(',');
			writer.append(entry.getValue().denominazione);
			writer.append(',');
			writer.append(entry.getValue().sedeLegale);
			writer.append(',');
			writer.append(entry.getValue().pIva);
			writer.append(',');
			writer.append(entry.getValue().eMail);
			writer.append('\n');

		}
		writer.flush();
		writer.close();

	}
}
