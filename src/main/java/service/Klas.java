package service;

public class Klas {
String klascode;
int leerlingcode;
String leerlingNaam;

public Klas(String kc, int lc, String ln){
	klascode = kc;
	leerlingcode = lc;
	leerlingNaam = ln;
}

public String getKlascode() {
	return klascode;
}

public int getLeerlingcode() {
	return leerlingcode;
}

public String getLeerlingnaam() {
	return leerlingNaam;
}
}
