package helios.core;

public class FattureClienti extends Fatture {

	public String prodotto;
	public double prezzo;
	public int iva = 22;
	 
	
	public FattureClienti(int nFattura, int codCliente, String prodotto, double prezzo, int iva) {
		super(nFattura, codCliente);
		this.prodotto = prodotto;
		this.prezzo = prezzo;
		this.iva = iva;
	}
	
	
	
	

}
