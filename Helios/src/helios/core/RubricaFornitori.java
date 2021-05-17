package helios.core;

import java.util.*;
import java.util.Map.Entry;

public class RubricaFornitori {

	public HashMap <String, Fornitore> fornitori = new HashMap();
	
	public void addFornitore (String codice, Fornitore fornitoreTmp) {
		//il campo CODE sono le prime 3 lettere della denominazione del cliente
		fornitori.put(codice, fornitoreTmp);
	}
	
}
