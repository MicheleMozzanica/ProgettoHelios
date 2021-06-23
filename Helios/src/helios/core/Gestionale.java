package helios.core;

import java.io.*;
import java.util.ArrayList;

public class Gestionale{
	
	ArrayList <FattureClienti> FattureEmesse = new ArrayList();
	ArrayList <FattureFornitori> FattureRicevute = new ArrayList();	
	
	public void AddFattEmesse(String nFattura, String clientCode, double totale,  ArrayList<Prodotto> prodotto1) throws IOException{ //aggiunge una nuova fattura per clienti
		FattureClienti MyFatTemp = new FattureClienti(nFattura, clientCode,totale,prodotto1);
		FattureEmesse.add(MyFatTemp);
		
		for(int i = 0; i<FattureEmesse.size();i++)
		{
			System.out.printf("Tot Fattura " + FattureEmesse.get(i).nFattura + ": %.2f € " +"\nCodice Cliente: " + FattureEmesse.get(i).Codice + "\n--------------", FattureEmesse.get(i).totale);
	}
	

}
	
	public void AddFattRicevute(String nFattura, String CodFornitore, double totale,  ArrayList<Prodotto> prodotto1){ //aggiunge una nuova fattura da fornitori
		FattureFornitori MyFatTemp = new FattureFornitori(nFattura, CodFornitore,totale,prodotto1);
		FattureRicevute.add(MyFatTemp);
		
		for(int j = 0; j<FattureRicevute.size();j++)
		{
			System.out.printf("Tot Fattura " + FattureEmesse.get(j).nFattura + ": %.2f € " +"\nCodice Cliente: " + FattureEmesse.get(j).Codice + "\n--------------", FattureEmesse.get(j).totale);
	}
	

}

	
	//WRITE DATABASE
	
		public void write(String nomeFile) {

			
			
		}
	
}
