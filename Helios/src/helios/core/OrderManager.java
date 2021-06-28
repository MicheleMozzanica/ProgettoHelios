package helios.core;

import java.util.HashMap;

public class OrderManager {
	
	String nOrder;
	static HashMap<String, Ordine> Orders = new HashMap<String, Ordine>();
	
	public static void addNewOrder(Ordine newOrder, String nOrder) {
				
		Orders.put(nOrder, newOrder);
		 System.out.println("Ordini:\n");
		for (String name: Orders.keySet()) {
		    String key = name.toString();
		    String value = Orders.get(name).toString();
		    System.out.println("#" + key + " - " + value + "\n");
		}
	}
	
	

}
