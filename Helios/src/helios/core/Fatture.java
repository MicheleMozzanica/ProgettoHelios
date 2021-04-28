package helios.core;

import java.util.ArrayList;

public class Fatture {
	
	int nFattura, codCliente;
	ArrayList<Prodotto> listProduct = new ArrayList();
	
	public Fatture(int nFattura, int codCliente, ArrayList<Prodotto> listProduct) {
		super();
		this.nFattura = nFattura;
		this.codCliente = codCliente;
		this.listProduct = listProduct;
	}
	
}
