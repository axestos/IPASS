package service;

public class User {
	int persoonlijk_nummer;
	String naam_vol;
	String username;
	String password;
	String klas;
	int isLeraar;
	int leerjaar;
	
	public User(int p_n, String nm, String usnm, String pass, String kl, int iL, int lj){
		persoonlijk_nummer = p_n;
		naam_vol = nm;
		username = usnm;
		password = pass;
		klas = kl;
		isLeraar = iL;	
		leerjaar = lj;
	}

	public int getPersoonlijk_nummer() {
		return persoonlijk_nummer;
	}

	public String getName() {
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
	
	public int getLeerJaar(){
		return leerjaar;
	}
	
	public String toString(){
		String userinfo = "Gebruiker: "+getName()+" "+getPersoonlijk_nummer()+" uit klas"+getKlas()
		+" Username: "+getUsername()+" Password: "+getPassword()+" IsLeraar= "+getIsLeraar()+" Uit leerjaar: "+getLeerJaar();
		return userinfo;
	}
}
