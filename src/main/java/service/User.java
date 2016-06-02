package service;

public class User {
	int persoonlijk_nummer;
	String naam_vol;
	String username;
	String password;
	String klas;
	int isLeraar;
	
	public User(int p_n, String nm, String usnm, String pass, String kl, int iL){
		persoonlijk_nummer = p_n;
		naam_vol = nm;
		username = usnm;
		password = pass;
		klas = kl;
		isLeraar = iL;		
	}

	public int getPersoonlijk_nummer() {
		return persoonlijk_nummer;
	}

	public String getNaam_vol() {
		return naam_vol;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getKlas() {
		return klas;
	}

	public int getIsLeraar() {
		return isLeraar;
	}
	
}
