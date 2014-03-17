package model.metier;


public class Joueur {

	private int code;
	private String nom;
	private String passwd;
	private String mail;
	

	



	public Joueur(int code, String nom, String passwd, String mail) {
		super();
		this.code = code;
		this.nom = nom;
		this.passwd = passwd;
		this.mail = mail;
	}
	
	public Joueur() {
		code = -1;
		nom = "";
		passwd = "";
		mail = "";		
	}





	public String getPasswd() {
		return passwd;
	}


	



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}





	public String getMail() {
		return mail;
	}





	public void setMail(String mail) {
		this.mail = mail;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (code != other.code)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Joueur [code=" + code + ", nom=" + nom + ", passwd=" + passwd
				+ ", mail=" + mail + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
