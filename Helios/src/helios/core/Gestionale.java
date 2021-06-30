package helios.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestionale {
	static Magazzino myMagazzinoUpdate = new Magazzino();

	private static ArrayList<FattureClienti> FattureEmesse = new ArrayList();
	private static ArrayList<FattureFornitori> FattureRicevute = new ArrayList();

	public static void AddFattEmesse(FattureClienti myFatClienti) throws IOException{ // aggiunge una nuova fattura per clienti
		FattureEmesse.add(myFatClienti);
	}

	public static void AddFattRicevute(FattureFornitori MyFatFornitori) throws IOException{ // aggiunge una nuova fatture fornitore																										// fattu																									// d																									// fornitori
		FattureRicevute.add(MyFatFornitori);
	}
	
	public static void save() throws IOException {
		
		saveDatabaseFattureEmesse();
		saveDatabaseFattureRicevute();
		// TODO Auto-generated method stub
	
	}
	
	
	public static ArrayList<FattureClienti> getFattureEmesse() {
		return FattureEmesse;
	}

	public static void setFattureEmesse(ArrayList<FattureClienti> fattureEmesse) {
		FattureEmesse = fattureEmesse;
	}

	public static ArrayList<FattureFornitori> getFattureRicevute() {
		return FattureRicevute;
	}

	public static void setFattureRicevute(ArrayList<FattureFornitori> fattureRicevute) {
		FattureRicevute = fattureRicevute;
	}

	//LOAD DATABASE
	public static void loadFattureEmesse(String nomeFile) throws ClassNotFoundException, IOException {
		File tmpFile = new File(nomeFile);

		if (!tmpFile.exists()) {
			System.out.println("Creazione del file");
			tmpFile.createNewFile();
		} else {
			System.out.println("Existing" + nomeFile);
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				boolean checker = true;
				Scanner s = new Scanner(line).useDelimiter(",");
				if (s.hasNext()) {
					String nFattura = s.next();
					String Codice = s.next();
					ArrayList<Prodotto> tmpProdotto = new ArrayList<Prodotto>();
					while (checker) {
						if (!s.hasNextDouble()) {
							String nameP = s.next();
							int priceP = s.nextInt();
							// String nome, int quantity, int price, int iva
							Prodotto prodottoTmp = new Prodotto(nameP,priceP);
							tmpProdotto.add(prodottoTmp);
						} else {
							checker = false;
						}
					}
					double tmptotaleFattura = s.nextDouble();
					FattureClienti myFatClienti = new FattureClienti(nFattura,Codice,tmptotaleFattura,tmpProdotto);
					AddFattEmesse(myFatClienti);
				}

			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	
	public static void loadFattureRicevute(String nomeFile) throws ClassNotFoundException, IOException {
		File tmpFile = new File(nomeFile);

		if (!tmpFile.exists()) {
			System.out.println("Creazione del file");
			tmpFile.createNewFile();
		} else {
			System.out.println("Existing" + nomeFile);
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
			String line = null;
			while ((line = reader.readLine()) != null) {
				boolean checker = true;
				Scanner s = new Scanner(line).useDelimiter(",");
				if (s.hasNext()) {
					String nFattura = s.next();
					String Codice = s.next();
					ArrayList<Prodotto> tmpProdotto = new ArrayList<Prodotto>();
					while (checker) {
						if (!s.hasNextDouble()) {
							String nameP = s.next();
							int priceP = s.nextInt();
							// String nome, int quantity, int price, int iva
							Prodotto prodottoTmp = new Prodotto(nameP,priceP);
							tmpProdotto.add(prodottoTmp);
						} else {
							checker = false;
						}
					}
					double tmptotaleFattura = s.nextDouble();
					FattureFornitori myFatFornitori = new FattureFornitori(nFattura,Codice,tmptotaleFattura,tmpProdotto);
					AddFattRicevute(myFatFornitori);
				}

			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	
	
	
	
// WRITE DATABASE

	public static void saveDatabaseFattureEmesse() throws IOException {
		FileWriter writer = new FileWriter("FattEmesse.csv");

		for (int i = 0; i < FattureEmesse.size(); i++) {

			
			writer.append(FattureEmesse.get(i).nFattura);
			writer.append(',');
			writer.append(FattureEmesse.get(i).Codice);
			writer.append(',');

			for (int j = 0; j < FattureEmesse.get(i).prodotto.size(); j++) {
				writer.append(FattureEmesse.get(i).prodotto.get(j).nome);
				writer.append(',');
				writer.append(Integer.toString(FattureEmesse.get(i).prodotto.get(j).price));
				writer.append(',');
			}

			writer.append(Double.toString(FattureEmesse.get(i).totale));

			writer.append('\n');

		}
		writer.flush();
		writer.close();

	}

	public static void saveDatabaseFattureRicevute() throws IOException {
		FileWriter writer = new FileWriter("FattRicevute.csv");
		for (int i = 0; i < FattureRicevute.size(); i++) {

			writer.append(FattureRicevute.get(i).nFattura);
			writer.append(',');
			writer.append(FattureRicevute.get(i).Codice);
			writer.append(',');

			for (int j = 0; j < FattureRicevute.get(i).prodotto.size(); j++) {
				writer.append(FattureRicevute.get(i).prodotto.get(j).nome);
				writer.append(',');
				writer.append(Integer.toString(FattureRicevute.get(i).prodotto.get(j).price));
				writer.append(',');
			}

			writer.append(Double.toString(FattureRicevute.get(i).totale));

			writer.append('\n');

		}
		writer.flush();
		writer.close();

	}

	
	
	public static void showFattureEmesse() {
		for(int i=0; i<FattureEmesse.size();i++)
		{
			System.out.println("\n" + FattureEmesse.get(i).nFattura + " - "+ FattureEmesse.get(i).totale + " €" + "\n");
		}
	}
	
	public static void showFattureRicevute() {
		for(int i=0; i<FattureRicevute.size();i++)
		{
			System.out.println("\n" + FattureRicevute.get(i).nFattura +" - "+ FattureRicevute.get(i).totale + " €" + "\n");
		}
	}
}
