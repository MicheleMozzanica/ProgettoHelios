package helios.core;

import java.util.ArrayList;

public class FattureClienti extends Fatture {

	public ArrayList<Prodotto> prodotto = new ArrayList();
	public double totale = 0;
	public double iva = 0.22;
	String codCliente;
	 
	
	public FattureClienti(String nFattura, String codCliente, double totale,  ArrayList<Prodotto> prodotto1) {
		super(nFattura);
		this.codCliente = codCliente;
		this.totale = totale;
		this.prodotto = prodotto1;
		}
	
	

	

}
