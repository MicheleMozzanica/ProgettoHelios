package helios.core;

import java.util.ArrayList;

public class FattureClienti extends Fatture {

	public double totale = 0;	 
	
	public FattureClienti(String nFattura, String codCliente, double totale,  ArrayList<Prodotto> prodotto1) {
		super(nFattura, prodotto1, codCliente);
		this.totale = totale;
		}
	
	

	

}
