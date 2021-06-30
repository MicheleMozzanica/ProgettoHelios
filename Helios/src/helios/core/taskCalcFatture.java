package helios.core;

import java.util.*;
import java.util.concurrent.Callable;

public class taskCalcFatture implements Callable<Double> {

	String typeCalc;
	Gestionale MyGestionale = new Gestionale();
	public double Totale = 0;


	public taskCalcFatture(String typeCalc) {
		super();
		this.typeCalc = typeCalc;
	}


	@Override
	public Double call() throws Exception {
		
		if (typeCalc.equals("Crediti")) {
			for (int i = 0; i < MyGestionale.getFattureEmesse().size(); i++) {
				Totale += MyGestionale.getFattureEmesse().get(i).totale;
			}
			
			System.out.println("Il totale dei crediti è");
		} else {
			for (int i = 0; i < MyGestionale.getFattureRicevute().size(); i++) {
				Totale += MyGestionale.getFattureRicevute().get(i).totale;
			}

		}
		return Totale;
	}

}
