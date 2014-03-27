package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.DAOItem;
import model.dao.DAOQuestion;
import model.metier.Item;
import model.metier.Question;
import view.interfaces.IPanelTableQuestion;
import view.modelTable.ModelTableQuestion;

public class CtrlQuestion implements ActionListener{

	private IPanelTableQuestion vue;
	private Connection connection;
	private ModelTableQuestion modelTable;
	
	public CtrlQuestion(Connection con) {
		connection = con;
	}
	
	public void remplissageTableau() {
		DAOQuestion questions = new DAOQuestion(connection);
		ArrayList<Question> listeQuestions = questions.getAll();
		modelTable = vue.getModel();
		modelTable.setListe(listeQuestions);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		String action= arg0.getActionCommand();
		if (action.equals("Supprimer")){
			DAOQuestion questions = new DAOQuestion(connection);
			for (Question question: vue.getSelection()) {
				try {
					questions.delete(question);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Echec de la suppression", "Suppression échouée", JOptionPane.ERROR_MESSAGE );
				}	
			}
			this.remplissageTableau();
		}
		else if(action.equals("Valider"	)){
			DAOQuestion questions = new DAOQuestion(connection);
			

			
			String texte = vue.getTexte();
			String reponse = vue.getReponse();
			
			if ((texte.equals("")) ||(reponse.equals(""))) {
				JOptionPane.showMessageDialog(null, "Remplissez tout les champs !", "information manquante", JOptionPane.ERROR_MESSAGE);
			}
			else {

				Question questionInsert = new Question(texte,reponse);

				try {
					questions.insert(questionInsert);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Echec de l'ajout", "Ajout échoué", JOptionPane.ERROR_MESSAGE );
				}
				this.remplissageTableau();
			}
		}
		
	}

	public IPanelTableQuestion getVue() {
		return vue;
	}
	

	public void setVue(IPanelTableQuestion vue) {
		this.vue = vue;
		this.remplissageTableau();
	}

}
