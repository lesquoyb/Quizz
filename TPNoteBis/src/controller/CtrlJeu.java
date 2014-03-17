package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import model.dao.DAOItem;
import model.dao.DAOQuestion;
import model.dao.DAOQuizz;
import model.metier.Item;
import model.metier.Joueur;
import model.metier.Question;
import model.metier.Quizz;
import view.interfaces.IFenetreJeu;

public class CtrlJeu implements ActionListener{

	private Joueur joueur;
	private int nbQuestionAPoser;
	private ArrayList<Question> questionAPoser;
	private ArrayList<String> reponsesApportees;
	private IFenetreJeu vue;
	private Connection connection;
	private Quizz quizzEnCours;
	private SimpleDateFormat  format;
	
	public CtrlJeu(){
		questionAPoser = new ArrayList<Question>();
		reponsesApportees = new ArrayList<String>();
		nbQuestionAPoser = 10;
		format = new SimpleDateFormat("yy-MM-dd");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		String action = arg0.getActionCommand();
		if (action.equals("difficulte")){
			DAOQuestion q = new DAOQuestion(connection);
			ArrayList<Question> listeQuestions = q.listeQuestion();			//on selectionne toutes les questions de la base de données
			String choix = vue.getChoix();
			if (choix.equals("facile")){				
				nbQuestionAPoser = 10;
				Date maintenant = new Date(new java.util.Date().getTime());
				quizzEnCours = new Quizz(nbQuestionAPoser,maintenant,reponsesApportees,questionAPoser,joueur);
				if (listeQuestions.size() < nbQuestionAPoser){
					JOptionPane.showMessageDialog(null, "Il n'y a pas assez de questions dans la base de données");
				}
				else{
					questionAPoser = questionAleatoire(listeQuestions, nbQuestionAPoser);
					vue.poserQuestion(questionAPoser.get(0),0);
				}
			}
		}
		else if (action.startsWith("valider")){
			
			int id = Integer.parseInt(action.substring(7));
			String reponse = vue.getReponse();
			reponsesApportees.add(reponse);
			if( reponse.toUpperCase().equals(questionAPoser.get(id).getReponse().toUpperCase()) ){
				vue.bonneReponse();
			}
			else{
				vue.mauvaiseReponse();
			}
			if( id < nbQuestionAPoser - 1){
				vue.poserQuestion(questionAPoser.get(id+1), id+1);
			}
			else{
					DAOQuizz quizz = new DAOQuizz(connection);
					ArrayList<Item>listeItem = new ArrayList<Item>();
					for(int i=0; i < nbQuestionAPoser; i++){
						int codeQuestion = questionAPoser.get(i).getCode();
						String reponseApportee = reponsesApportees.get(i);
						Item it = new Item(codeQuestion,quizzEnCours.getCode(),reponseApportee);
						listeItem.add(it);
					}
					quizz.insert(quizzEnCours,listeItem);
				vue.afficherSelection();
			}
		}
	}

	/**
	 * Retourne une liste de questions différentes de <b>nombre</b> éléments.
	 * @param nombre
	 * @return
	 */
	private ArrayList<Question> questionAleatoire(ArrayList<Question> listeDepart,int nombre){
		ArrayList<Integer>dejaChoisis = new ArrayList<Integer>();
		ArrayList<Question> retour = new ArrayList<Question>();
		int i = 0;
		while (i<nombre	){
			Random rd = new Random();
			int temp = rd.nextInt(listeDepart.size());
			if (!dejaChoisis.contains(temp)){
				retour.add(listeDepart.get(temp));
				dejaChoisis.add(temp);
				i++;
			}
		}
		return retour;
		
	}
	public void setVue(IFenetreJeu v){
		vue = v;
	}
	
	public void setJoueur(Joueur j){
		joueur = j;
	}
	
	public void setConnection(Connection c){
		connection = c;
	}
	
}
