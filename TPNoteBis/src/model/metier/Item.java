package model.metier;

public class Item {

	private int code_question;
	private int code_quizz;
	private String reponse_joueur;
	
	
	
	
	
	public Item(int code_question, int code_quizz, String reponse_joueur) {
		super();
		this.code_question = code_question;
		this.code_quizz = code_quizz;
		this.reponse_joueur = reponse_joueur;
	}
	public int getCodeQuestion() {
		return code_question;
	}
	public void setCodeQuestion(int code_question) {
		this.code_question = code_question;
	}
	public int getCodeQuizz() {
		return code_quizz;
	}
	public void setCodeQuizz(int code_quizz) {
		this.code_quizz = code_quizz;
	}
	public String getReponseJoueur() {
		return reponse_joueur;
	}
	public void setReponseJoueur(String reponse_joueur) {
		this.reponse_joueur = reponse_joueur;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (code_question != other.code_question)
			return false;
		if (code_quizz != other.code_quizz)
			return false;
		if (reponse_joueur == null) {
			if (other.reponse_joueur != null)
				return false;
		} else if (!reponse_joueur.equals(other.reponse_joueur))
			return false;
		return true;
	}
	
	
	
}
