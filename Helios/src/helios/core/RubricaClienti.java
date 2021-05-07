package helios.core;

import java.util.HashMap;

public class RubricaClienti {
	
	public HashMap<pIva, Cliente> clienti;
	
	public void addCliente(String nome, pIva pIva) {
		clienti.put(pIva, nome);
	}
	
	public void getCliente(String nome, pIva pIva) {
		clienti.get(nome);
	}
	
	
	
}
