package model.metier;


public class Question {

	private int code;
	private String texte;
	private String  reponse;
	


	public Question( int code, String texte, String reponse) {
		super();
		this.code = code;
		this.texte = texte;
		this.reponse = reponse;
	}

	public Question( String texte, String reponse) {
		super();
		this.code = -1;
		this.texte = texte;
		this.reponse = reponse;
	}


	@Override
	public String toString() {
		return "Question [code=" + code + ", texte=" + texte + ", reponse="
				+ reponse + "]";
	}

	
	



	public String getTexte() {
		return texte;
	}




	public void setTexte(String texte) {
		this.texte = texte;
	}




	public String getReponse() {
		return reponse;
	}




	public void setReponse(String reponse) {
		this.reponse = reponse;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (code != other.code)
			return false;
		if (reponse == null) {
			if (other.reponse != null)
				return false;
		} else if (!reponse.equals(other.reponse))
			return false;
		if (texte == null) {
			if (other.texte != null)
				return false;
		} else if (!texte.equals(other.texte))
			return false;
		return true;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
