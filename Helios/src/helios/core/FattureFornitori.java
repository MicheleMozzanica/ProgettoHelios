package helios.core;

import java.util.HashMap;

public class FattureFornitori extends Fatture{

	public String prodotto;
	public double prezzo;
	public int iva = 22;
	Fornitore fornitore;
	
	public FattureFornitori(int nFattura, int codCliente, String prodotto, double prezzo, int iva) {
		super(nFattura, codCliente);
		this.prodotto = prodotto;
		this.prezzo = prezzo;
		this.iva = iva;
	}
	
}
