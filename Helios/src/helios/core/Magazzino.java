package helios.core;

import java.io.*;
import java.util.ArrayList;

public class Magazzino {
	
	public ArrayList<Prodotto> myProducts = new ArrayList();
	int nItems;
	String nameOfMagazzino;
	
	public Magazzino(String nameOfMagazzino) {
		super();
		this.nameOfMagazzino = nameOfMagazzino;
	}

	Prodotto myProd1 = new Prodotto("prod1",1,1,22);
	Prodotto myProd2 = new Prodotto("prod2",2,4,22);
	Prodotto myProd3 = new Prodotto("prod3",2,16,22);
	
	public void addProdotto() throws IOException {
		
		myProducts.add(myProd1);
		myProducts.add(myProd2);
		myProducts.add(myProd3);
		
		for(Prodotto tmpProd : myProducts)
		{
			System.out.println(tmpProd.toString());
		}
	
		write();
	}

	private void write() {
		//write to file 
//		try{
//		    FileOutputStream writeData = new FileOutputStream("dataMagazzino.ser");
//		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
//
//		    writeStream.writeObject(myProducts);
//		    writeStream.flush();
//		    writeStream.close();
//
//		}catch (IOException e) {
//		    e.printStackTrace();
//		}
//		finally {
//			System.out.println("file Saved.");
//		}
	}

	public void readData() {
		//READS THE DATA FROM THE FILE AND PUTS RECORDS INTO A ARRAYLIST OF PRODOTTO
//		try{
//		    FileInputStream readData = new FileInputStream("dataMagazzino.ser");
//		    ObjectInputStream readStream = new ObjectInputStream(readData);
//
//		    ArrayList<Prodotto> MyProd = (ArrayList<Prodotto>) readStream.readObject();
//		    readStream.close();
//		    System.out.println(MyProd.toString() + "\n");
//		}catch (Exception e) {
//		    e.printStackTrace();
//		}
		// TODO Auto-generated method stub
		
	}
	

}
