package gume;

import gume.AutoGuma;

public class AutoGuma {
	private String markaModel = null;
	private boolean zimska = false;
	private int precnik = 0;
	private int sirina = 0;
	private int visina = 0;

	
	
	public AutoGuma(String markaModel, boolean zimska, int precnik, int sirina, int visina) {
		super();
		this.markaModel = markaModel;
		this.zimska = zimska;
		this.precnik = precnik;
		this.sirina = sirina;
		this.visina = visina;
	}

	public boolean getZimska() {
		return zimska;
	}
	
	public void setZimska(boolean zimska) {
		this.zimska = zimska;
	}
	
	public String getMarkaModel() {
		return markaModel;
	}

	public void setMarkaModel(String markaModel) {
		if (markaModel == null || markaModel.length() < 3)
			throw new RuntimeException("Morate uneti marku i model");
		this.markaModel = markaModel;
	}

	public int getPrecnik() {
		return precnik;
	}

	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)  //25 10 15
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}
	
	public double izracunajCenu() {
		return (this.precnik*3+this.sirina+this.visina)*28.53;
	}
	
	public boolean povoljnaGuma() {
		if(this.izracunajCenu() <= 6500)
			return true;
		else 
			return false;
	}

	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="+ visina + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
