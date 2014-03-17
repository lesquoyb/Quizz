package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import model.dao.DAOJoueur;
import model.dao.DAOQuestion;
import model.dao.DAOQuizz;
import model.dao.MaConnection;
import model.metier.Joueur;
import model.metier.Question;
import view.FenetreAuthent;
import view.interfaces.IFenetrePrincipale;

public class CtrlFenetrePrincipale implements ActionListener {

	Connection connection;
	IFenetrePrincipale vue;
	
	public void setConnection(Connection c){
		connection = c;
	}
	public void setVue(IFenetrePrincipale v){
		this.vue =v;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		FenetreAuthent f = new FenetreAuthent(connection);

		/*
		j.insert(q);
		JOptionPane.showMessageDialog((Component) this.vue,
				 q.getCode(),
			    "joueur trouvé",
			    JOptionPane.INFORMATION_MESSAGE);
		
		if ( (vue.getSaisieNom() != "")) {
			ArrayList<Question> joueur =j.listeQuestion( vue.getSaisieNom() );
			JOptionPane.showMessageDialog((Component) this.vue,
					 joueur.toString(),
				    "joueur trouvé",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		*/


	}
	
}
