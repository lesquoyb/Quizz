package model.metier;

import java.sql.Date;
import java.util.ArrayList;

public class Quizz {
	
	private int nombreQuestion;
	private Date date;
	private Joueur joueur;
	private ArrayList<String> reponses;
	private ArrayList<Question> listeQuestions;
	private int code;
	
	
	public Quizz(int codeQuizz,int nombreQuestion, Date date, ArrayList<String> reponses,
			ArrayList<Question> listeQuestions,Joueur j) {
		this.code = codeQuizz;
		this.nombreQuestion = nombreQuestion;
		this.date = date;
		this.joueur = j;
		this.reponses = reponses;
		this.listeQuestions = listeQuestions;
	}
	
	
	
	public Quizz(int nombreQuestion, Date date,
			ArrayList<String> reponses, ArrayList<Question> listeQuestions, Joueur joueur) {
		super();
		this.nombreQuestion = nombreQuestion;
		this.date = date;
		this.joueur = joueur;
		this.reponses = reponses;
		this.listeQuestions = listeQuestions;
		code = -1;
	}



	public int getNombreQuestion() {
		return nombreQuestion;
	}



	public void setNombreQuestion(int nombreQuestion) {
		this.nombreQuestion = nombreQuestion;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public ArrayList<String> getReponses() {
		return reponses;
	}



	public void setReponses(ArrayList<String> reponses) {
		this.reponses = reponses;
	}



	public ArrayList<Question> getListeQuestions() {
		return listeQuestions;
	}



	public void setListeQuestions(ArrayList<Question> listeQuestions) {
		this.listeQuestions = listeQuestions;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	@Override
	public String toString() {
		return "Quizz [nombreQuestion=" + nombreQuestion + ", date=" + date
				+ ", reponses=" + reponses + ", listeQuestions="
				+ listeQuestions + ", code=" + code + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quizz other = (Quizz) obj;
		if (code != other.code)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (listeQuestions == null) {
			if (other.listeQuestions != null)
				return false;
		} else if (!listeQuestions.equals(other.listeQuestions))
			return false;
		if (nombreQuestion != other.nombreQuestion)
			return false;
		if (reponses == null) {
			if (other.reponses != null)
				return false;
		} else if (!reponses.equals(other.reponses))
			return false;
		return true;
	}



	public Joueur getJoueur() {
		return joueur;
	}



	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	
	
	
}
