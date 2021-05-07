package helios.core;

public class Cliente extends RubricaClienti{

	public String denominazione;
	public String sedeLegale;
	public String pIva;
	public String eMail;

	public Cliente(String denominazione, String sedeLegale, String pIva, String eMail) {
		super();
		this.denominazione = denominazione;
		this.sedeLegale = sedeLegale;
		this.pIva = pIva;
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Cliente [denominazione=" + denominazione + ", sedeLegale=" + sedeLegale + ", pIva=" + pIva + ", eMail="
				+ eMail + "]";
	}

}
