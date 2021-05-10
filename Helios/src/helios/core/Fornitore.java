package helios.core;

public class Fornitore extends RubricaFornitori {

	public String denominazione;
	public String sedeLegale;
	public String pIVA;
	public String eMail;

	public Fornitore(String denominazione, String sedeLegale, String pIVA, String eMail) {
		super();
		this.denominazione = denominazione;
		this.sedeLegale = sedeLegale;
		this.pIVA = pIVA;
		this.eMail = eMail;

	}

	@Override
	public String toString() {
		return "Fortnitore [denominazione=" + denominazione + ", sedeLegale=" + sedeLegale + ", pIVA=" + pIVA
				+ ", eMail=" + eMail + "]";
	}

}
