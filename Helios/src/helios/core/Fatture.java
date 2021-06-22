package helios.core;

import java.util.ArrayList;

public class Fatture {
	
	String nFattura;
	public ArrayList<Prodotto> prodotto = new ArrayList();
	String Codice;
	
	public Fatture(String nFattura, ArrayList<Prodotto> prodotto, String Codice) {
		this.nFattura = nFattura;
		this.Codice = Codice;
		this.prodotto = prodotto;
	}
	
}
