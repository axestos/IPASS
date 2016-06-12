package service;

public class Opdracht {
	String opdrachtcode;
	String vaknaam;
	int leerjaar;
	public Opdracht(String oc, String vn, int lj) {
		opdrachtcode = oc;
		vaknaam = vn;
		leerjaar = lj;
	}
	
	public String getOpdrachtcode(){
		return opdrachtcode;
	}

	public String getVaknaam() {
		return vaknaam;
	}
	public int getLeerjaar() {
		return leerjaar;
	}
}
