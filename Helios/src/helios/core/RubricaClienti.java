package helios.core;

import java.util.HashMap;
import java.util.Map.Entry;

public class RubricaClienti {
		public HashMap<String, Cliente> clienti = new HashMap();

		public RubricaClienti(HashMap<String, Cliente> clienti) {
		super();
		clienti = clienti;
		initalizeClients();
	}

	public void initalizeClients() {
		Cliente client1 = new Cliente("Simone", "Via le mani dal culo", "04277270981", "info@simonesaleri.it");
		Cliente client2 = new Cliente("Michele", "Via le mani dal culo", "04277270981", "info@simonesaleri.it");
		Cliente client3 = new Cliente("Giovanni", "Via le mani dal culo", "04277270981", "info@simonesaleri.it");
		
		clienti.put(client1.denominazione.substring(0,3), client1);
		clienti.put(client2.denominazione.substring(0,3), client2);
		clienti.put(client3.denominazione.substring(0,3), client3);
	}
	
	public void addCliente(String Code, Cliente clientTmp) {
		
		/* il campo CODE sono le prime 3 lettere della denominazione del cliente*/
		clienti.put(Code, clientTmp);	
		
		for (Entry<String, Cliente> entry : clienti.entrySet()) {
	        System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
	    }
	}
	
	
	public HashMap<String, Cliente> exportClients(){
		return clienti;
		
	}
	
	public void getCliente(String nome,int pIva) {
		clienti.get(nome);
	}
	
	//bisogna collegare l'anagrafica registrazione cliente a questa classe in 
	//modo che quando viene aggiunto un nuovo cliente vada automaticamente in questa hashmap 
	
}
