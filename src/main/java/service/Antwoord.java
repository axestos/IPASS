package service;

public class Antwoord {
	String antwoord;
	int persoonlijkecode;
	String opdrachtvraag;
	String opdrachtcode;

	public Antwoord(String ant, int pc, String ov, String oc) {
		antwoord = ant;
		persoonlijkecode = pc;
		opdrachtvraag = ov;
		opdrachtcode = oc;
	}

	public String getAntwoord() {
		return antwoord;
	}

	public int getPersoonlijkecode() {
		return persoonlijkecode;
	}

	public String getOpdrachtvraag() {
		return opdrachtvraag;
	}
	
	public String getOpdrachtcode(){
		return opdrachtcode;
	}

}
