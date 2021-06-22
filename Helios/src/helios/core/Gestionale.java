package helios.core;

import java.util.ArrayList;

public class Gestionale {
	
	ArrayList <FattureClienti> FattureEmesse = new ArrayList();
	ArrayList <FattureFornitori> FattureRicevute = new ArrayList();	
	
	public void AddFatt(String nFattura, String clientCode, double totale,  ArrayList<Prodotto> prodotto1){ //aggiunge una nuova fattura
		FattureClienti MyFatTemp = new FattureClienti(nFattura, clientCode,totale,prodotto1);
		FattureEmesse.add(MyFatTemp);
		
		for(int i = 0; i<FattureEmesse.size();i++)
		{
			System.out.printf("Tot Fattura " + FattureEmesse.get(i).nFattura + ": %.2f € " +"\nCodice Cliente: " + FattureEmesse.get(i).codCliente + "\n--------------", FattureEmesse.get(i).totale);
	}
	

}
	
}
