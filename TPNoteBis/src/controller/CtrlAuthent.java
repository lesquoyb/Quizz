package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import model.dao.DAOJoueur;
import view.FenetreJeu;
import view.interfaces.IAuthent;

public class CtrlAuthent implements ActionListener {

	private IAuthent vue;
	private Connection connection;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String mdp = vue.getMdp();
		String nom = vue.getNom();
		DAOJoueur j = new DAOJoueur(connection);
		if(j.get(nom, mdp)!= null && j.get(nom, mdp).getCode() != -1){
			vue.fermer();
			FenetreJeu f = new FenetreJeu(connection,j.get(nom,mdp));
		}
		else{
			JOptionPane.showMessageDialog(null, "Erreur de connection le mot de passe est peut être faux");
		}
	}
	
	public void setVue(IAuthent vue){
		this.vue = vue;
	}
	
	public void setConnection(Connection c){
		this.connection = c;
	}

}
