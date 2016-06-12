package service;

public class Huiswerk {
	String opdrachtcode;
	String vraag;
	public Huiswerk(String oc, String vr) {
		opdrachtcode = oc;
		vraag = vr;
	}
	
	public String getOpdrachtcode(){
		return opdrachtcode;
	}

	public String getVraag() {
		return vraag;
	}
}
