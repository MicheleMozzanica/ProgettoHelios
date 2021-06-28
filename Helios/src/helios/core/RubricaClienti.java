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

	public RubricaClienti() throws IOException {
		initalizeClients();
	}

	public static void initalizeClients() throws IOException {
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
				if (s.hasNext()) { // ORDINE DELLE STRINGHE = NORDINE ; DENOMINAZIONE; SEDE LEGALE; PIVA; EMAIL ;
									// NOME PRODOTTO; QUANTITA PRODOTTO
					String Denominazione = s.next();
					String SedeLegale = s.next();
					String pIva = s.next();
					String Email = s.next();
					String code = Denominazione.substring(0, 3);
					Cliente clienteTmp = new Cliente(Denominazione, SedeLegale, pIva, Email);
					addCliente(code, clienteTmp);
				}

			}
		} catch (Exception e) {
			System.out.println("Error database ordini.");
		}

	}

	public static void addCliente(String Code, Cliente clientTmp) {

		/* il campo CODE sono le prime 3 lettere della denominazione del cliente */
		clienti.put(Code, clientTmp);

		for (Entry<String, Cliente> entry : clienti.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}

	}

	public HashMap<String, Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(HashMap<String, Cliente> clienti) {
		this.clienti = clienti;
	}

	public void getCliente(String nome, int pIva) {
		clienti.get(nome);
	}

	// bisogna collegare l'anagrafica registrazione cliente a questa classe in
	// modo che quando viene aggiunto un nuovo cliente vada automaticamente in
	// questa hashmap

	
	public static void saveDatabaseClienti() throws IOException {
		FileWriter writer = new FileWriter("ClientsDatabase.csv");

		for (String name : clienti.keySet()) {
			writer.append(clienti.get(name).toString()); // nOrdine
			writer.append(',');
			writer.append(clienti.get(name).denominazione);
			writer.append(',');
			writer.append(clienti.get(name).sedeLegale);
			writer.append(',');
			writer.append(clienti.get(name).pIva);
			writer.append(',');
			writer.append(clienti.get(name).eMail);
			writer.append(',');
			writer.append('\n');

		}
		writer.flush();
		writer.close();

	}
}
