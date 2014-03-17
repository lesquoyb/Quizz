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
	
	
	
}
