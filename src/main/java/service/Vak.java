package service;

public class Vak {
	String vaknaam;
	int leerjaar;
	public Vak(String vn, int lj) {
		vaknaam = vn;
		leerjaar = lj;
	}

	public String getVaknaam() {
		return vaknaam;
	}
	public int getLeerjaar() {
		return leerjaar;
	}
}
