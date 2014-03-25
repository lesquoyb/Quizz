package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.DAOJoueur;
import model.dao.DAOQuestion;
import model.dao.MaConnection;
import model.metier.Joueur;
import model.metier.Question;
import view.interfaces.IPanelRequetes;

public class CtrlRequetes implements ActionListener {
	
	private IPanelRequetes vue;
	private DAOQuestion question;
	private DAOJoueur joueur;
	
	public CtrlRequetes() throws ClassNotFoundException, SQLException {
		this.question = new DAOQuestion(MaConnection.getInstance());
		this.joueur = new DAOJoueur(MaConnection.getInstance());
	}
	
	public void afficheNombreQuestion() {
		
		int nb = question.nombreQuestions();
		this.vue.setResultatNombreQuestion(nb);
	}
	

	@Override
	public void actionPerformed(ActionEvent commande) {
		String ordre = commande.getActionCommand();
		if (ordre.equals("rechercheJoueur")){
			String nomEntree = vue.getNomJoueur();
			String mdpEntree = vue.getMdpJoueur();
			
			Joueur resultat = joueur.get(nomEntree, mdpEntree);
			
			if (resultat == null) {
				JOptionPane.showMessageDialog(null, "Ce joueur n'existe pas !", "Joueur inexistant", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String nomResultat = resultat.getNom();
				String mdpResultat = resultat.getPasswd();
				String mailResultat = resultat.getMail();
				int codeResultat = resultat.getCode();
				
				JOptionPane.showMessageDialog(null, "Nom : "+ nomResultat + "\nMot de Passe : "+ mdpResultat + "\nEmail : " + mailResultat + "\nCode : " + codeResultat, "Joueur Trouvé",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (ordre.equals("rechercheCodeQuestion")){
			int codeEntree = Integer.parseInt(vue.getCodeQuestion());
			
			Question resultat = question.get(codeEntree);
			
			if (resultat == null) {
				JOptionPane.showMessageDialog(null, "Aucune question n'a ce code", "Question Inexistante", JOptionPane.ERROR_MESSAGE);
			}
			else {
				int codeResultat = resultat.getCode();
				String texteResultat = resultat.getTexte();
				String reponseResultat = resultat.getReponse();
				
				JOptionPane.showMessageDialog(null, "Question : "+ texteResultat + "\nReponse : " + reponseResultat + "\nCode : "+ codeResultat, "Question Trouvée", JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		else if (ordre.equals("rechercheTexteQuestion")){
			String texteEntree = vue.getTexteQuestion();
			
			ArrayList<Question> listeResultat = question.listeQuestion(texteEntree);
			
			if (listeResultat.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ce texte n'est présent dans aucune question", "Texte non trouvé", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String afficheResultat = "";
				for (int i=0;i<listeResultat.size();i++) {
					
					Question resultat = listeResultat.get(i);
					
					int codeResultat = resultat.getCode();
					String texteResultat = resultat.getTexte();
					String reponseResultat = resultat.getReponse();
					int numeroQuestion = i+1;
					
					afficheResultat = afficheResultat+"Question "+numeroQuestion+" : "+texteResultat+"        Reponse : "+reponseResultat+"        Code : "+codeResultat+"\n";
				}
				JOptionPane.showMessageDialog(null, afficheResultat, "Liste des Questions trouvées", JOptionPane.INFORMATION_MESSAGE);
					
					
			}
		}
	}
		

	public void setVue(IPanelRequetes panelRequetes) {
		this.vue = panelRequetes;
		this.afficheNombreQuestion();
		
	}
	
	

}
