package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import model.dao.DAOJoueur;
import model.metier.Joueur;
import view.interfaces.IPanelTableJoueur;

public class CtrlJoueur implements ActionListener{

	private IPanelTableJoueur vue;
	private Connection connection;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		String action= arg0.getActionCommand();
		if (action.equals("Supprimer")){
			
		}
		else if(action.equals("Valider"	)){
			
		}
		
	}

	public IPanelTableJoueur getVue() {
		return vue;
	}
	
	public void afficheTableau() {
		DAOJoueur joueurs = new DAOJoueur(connection);
		ArrayList<Joueur> listeJoueurs = joueurs.getAll();
		
		int nbItems = listeJoueurs.size();
		for (int i=0; i<nbItems; i++) {
			String mailJoueur =listeJoueurs.get(i).getMail();
			String nomJoueur = listeJoueurs.get(i).getNom();
			String mdpJoueur = listeJoueurs.get(i).getPasswd();
			String codeJoueur = String.valueOf(listeJoueurs.get(i).getCode());
			
			vue.getTable().setValueAt(mailJoueur, i, 0);
			vue.getTable().setValueAt(nomJoueur,i,1);
			vue.getTable().setValueAt(mdpJoueur, i, 2);
			vue.getTable().setValueAt(codeJoueur, i, 3);
			
		}
	}

	public void setVue(IPanelTableJoueur vue) {
		this.vue = vue;
	}

}
