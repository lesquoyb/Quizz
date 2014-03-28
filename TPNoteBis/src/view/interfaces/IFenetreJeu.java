package view.interfaces;

import model.metier.Question;

public interface IFenetreJeu {

	
	public String getChoix();
	
	public String getQuestion();
	
	public String getReponse();
	
	public void poserQuestion(Question q,int numero);
	
	public void bonneReponse();
	
	public void mauvaiseReponse();
	
	public void afficherSelection();
	
	public void victoire();
	
	public void defaite();
	
	public int getScore();
}
