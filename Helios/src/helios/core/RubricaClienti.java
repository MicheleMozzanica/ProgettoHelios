package helios.core;

import java.util.HashMap;
import java.util.Map.Entry;

public class RubricaClienti {
	
	public HashMap<String, Cliente> clienti = new HashMap();;
	
	public void addCliente(String Code, Cliente clientTmp) {
		
		/* il campo CODE sono le prime 3 lettere della denominazione del cliente*/
		clienti.put(Code, clientTmp);	
		
		for (Entry<String, Cliente> entry : clienti.entrySet()) {
	        System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	    }
	}
	
	public void getCliente(String nome, pIva pIva) {
		clienti.get(nome);
	}
	
	//bisogna collegare l'anagrafica registrazione cliente a questa classe in 
	//modo che quando viene aggiunto un nuovo cliente vada automaticamente in questa hashmap 
	
}
