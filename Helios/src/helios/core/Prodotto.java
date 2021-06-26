package helios.core;

import java.io.Serializable;

public class Prodotto implements Serializable{
	
	public String nome;
	public int price;
	
	public Prodotto(String nome,int price) {
		this.nome = nome;
		this.price = price;
	}

	@Override
	public String toString() {
		return " --> Name: " + nome + " --> Price: " + price + " € ";
	}
	
	

}
