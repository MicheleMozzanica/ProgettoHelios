package helios.core;

import java.util.ArrayList;

public class Ordine {

	
	
	ArrayList<Prodotto> productsOnOrder = new ArrayList<Prodotto>();
	Cliente clientOnOrder;
	public Ordine(ArrayList<Prodotto> productsOnOrder, Cliente clientOnOrder) {
		this.productsOnOrder = productsOnOrder;
		this.clientOnOrder = clientOnOrder;
	}
	
}
