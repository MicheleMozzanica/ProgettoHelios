package helios.core;

import java.util.ArrayList;

public class Ordine {

	
	
	ArrayList<ProdottoOrdine> productsOnOrder = new ArrayList<ProdottoOrdine>();
	Cliente clientOnOrder;
	public Ordine(ArrayList<ProdottoOrdine> productsOnOrder, Cliente clientOnOrder) {
		this.productsOnOrder = productsOnOrder;
		this.clientOnOrder = clientOnOrder;
	}
	
}
