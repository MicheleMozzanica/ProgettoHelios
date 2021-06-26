package helios.core;

import java.io.*;
import java.util.ArrayList;

public class Magazzino {
	
	public ArrayList<Prodotto> myProducts = new ArrayList();
	int nItems;
	String nameOfMagazzino;
	Prodotto myProd1 = new Prodotto("prod1",1);
	Prodotto myProd2 = new Prodotto("prod2",4);
	Prodotto myProd3 = new Prodotto("prod3",16);
	
	
	public Magazzino(String nameOfMagazzino) {
		super();
		this.nameOfMagazzino = nameOfMagazzino;
		initializeProdotto();
	}


	public void initializeProdotto() {
		
		myProducts.add(myProd1); //TESTER PRODUCTS
		myProducts.add(myProd2);
		myProducts.add(myProd3);
		
//		for(Prodotto tmpProd : myProducts)
//		{
//			System.out.println(tmpProd.toString());
//		}
	
	}

	
	public ArrayList<Prodotto> ExtractProduct(){
		return myProducts;
		
	}
	

}
