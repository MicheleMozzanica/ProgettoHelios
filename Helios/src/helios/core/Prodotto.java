package helios.core;

import java.io.Serializable;

public class Prodotto implements Serializable{
	
	public String nome;
	public int quantity, price, iva;
	
	public Prodotto(String nome, int quantity, int price, int iva) {
		this.nome = nome;
		this.quantity = quantity;
		this.price = price;
		this.iva = iva;
	}

	@Override
	public String toString() {
		return " --> Name: " + nome + " --> Quantity: " + quantity + " --> Price: " + price + "--> Iva: " + iva;
	}
	
	

}
