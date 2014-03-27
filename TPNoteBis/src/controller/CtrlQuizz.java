package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.DAOJoueur;
import model.dao.DAOQuizz;
import model.metier.Joueur;
import model.metier.Question;
import model.metier.Quizz;
import view.interfaces.IPanelTableQuizz;
import view.modelTable.ModelTableQuizz;

public class CtrlQuizz implements ActionListener{

	private IPanelTableQuizz vue;
	private Connection connection;
	private ModelTableQuizz modelTable;
	
	public CtrlQuizz(Connection con) {
		connection = con;
	}
	
	public void remplissageTableau() {
		DAOQuizz quizz = new DAOQuizz(connection);
		ArrayList<Quizz> listeQuizz = quizz.getAll();
		modelTable = vue.getModel();
		modelTable.setListe(listeQuizz);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String action= e.getActionCommand();
		if (action.equals("Supprimer")){
			DAOQuizz quizz = new DAOQuizz(connection);
			for (Quizz quizzSelect: vue.getSelection()) {
				try {
					quizz.delete(quizzSelect);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
			this.remplissageTableau();
		}
		else if(action.equals("Valider"	)){
			DAOQuizz quizz = new DAOQuizz(connection);

			int nbQuestion  = Integer.parseInt(vue.getNbQuestion());
			Date date = Date.valueOf(vue.getDate());
			int codeJoueur = Integer.parseInt(vue.getCodeJoueur());
			
			DAOJoueur joueur = new DAOJoueur(connection);
			Joueur joueurQuizz = joueur.get(codeJoueur);
			
			ArrayList<String> reponses = new ArrayList<String>();
			ArrayList<Question> questions = new ArrayList<Question>();

			Quizz quizzInsert = new Quizz(nbQuestion,date,reponses,questions,joueurQuizz);

			try {
				quizz.insert(quizzInsert);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.remplissageTableau();
		}
	}


	public IPanelTableQuizz getVue() {
		return vue;
	}
	

	public void setVue(IPanelTableQuizz vue) {
		this.vue = vue;
		this.remplissageTableau();
	}
	
	

}
