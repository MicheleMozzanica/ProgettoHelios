package helios.core;

import java.util.ArrayList;

public class Gestionale {
	
	ArrayList <FattureClienti> FattureEmesse = new ArrayList();
	ArrayList <FattureFornitori> FattureRicevute = new ArrayList();	
	
	public void AddFatt(int nFattura, String clientCode, double totale,  ArrayList<Prodotto> prodotto1){ //aggiunge una nuova fattura
//		nFattura = 4; //in input
//		codCliente = 12; //in input
//		Prodotto myProd1 = new Prodotto("prod1",1,1,22);
//		Prodotto myProd2 = new Prodotto("prod2",2,4,22);
//		Prodotto myProd3 = new Prodotto("prod3",2,16,22);
//		prodotto.add(myProd1);
//		prodotto.add(myProd2);
//		prodotto.add(myProd3);
//		for(int i=0; i<prodotto.size();i++)
//		{
//			totale += prodotto.get(i).price;
//		}
//		totale = totale * (1+iva); //Totale con iva
//		System.out.println("Totale fattura: " + totale + "€");
		FattureClienti MyFatTemp = new FattureClienti(nFattura, clientCode,totale,prodotto1);
		FattureEmesse.add(MyFatTemp);
		
		for(int i = 0; i<FattureEmesse.size();i++)
		{
			System.out.println("Tot Fattura " + FattureEmesse.get(i).nFattura + ": " + FattureEmesse.get(i).totale);
	}
	

}
	
}
