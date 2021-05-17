package helios.core;

import java.io.*;
import java.util.ArrayList;

public class Magazzino {
	
	public ArrayList<Prodotto> myProducts = new ArrayList();
	int nItems;
	String nameOfMagazzino;
	Prodotto myProd1 = new Prodotto("prod1",1,1,22);
	Prodotto myProd2 = new Prodotto("prod2",2,4,22);
	Prodotto myProd3 = new Prodotto("prod3",2,16,22);
	
	
	public Magazzino(String nameOfMagazzino) {
		super();
		this.nameOfMagazzino = nameOfMagazzino;
		initializeProdotto();
	}


	public void initializeProdotto() {
		
		myProducts.add(myProd1);
		myProducts.add(myProd2);
		myProducts.add(myProd3);
		
		for(Prodotto tmpProd : myProducts)
		{
			System.out.println(tmpProd.toString());
		}
	
	}

	
	public ArrayList<Prodotto> ExtractProduct(){
		return myProducts;
		
	}
	

}
