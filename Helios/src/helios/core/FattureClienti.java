package helios.core;

import java.util.ArrayList;

public class FattureClienti extends Fatture {

	public ArrayList<Prodotto> prodotto = new ArrayList();
	public double totale = 0;
	public double iva = 0.22;
	int codCliente;
	 
	
	public FattureClienti(int nFattura, int codCliente, double totale,  ArrayList<Prodotto> prodotto1) {
		super(nFattura, codCliente);
		this.totale = totale;
		this.prodotto = prodotto1;
		}
	
	

	

}
