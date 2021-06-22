package helios.core;

import java.util.ArrayList;
import java.util.HashMap;

public class FattureFornitori extends Fatture{
		public double totale;
	
	
	public FattureFornitori(String nFattura, String codFornitore, double totale, ArrayList<Prodotto> prodotto) {
		super(nFattura, prodotto, codFornitore);
		this.prodotto = prodotto;
		this.totale = totale;
	}
	
}
