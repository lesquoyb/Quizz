package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.DAOItem;
import model.dao.DAOJoueur;
import model.metier.Item;
import model.metier.Joueur;
import view.interfaces.IPanelTableJoueur;
import view.modelTable.ModelTableJoueur;

public class CtrlJoueur implements ActionListener{

	private IPanelTableJoueur vue;
	private Connection connection;
	private ModelTableJoueur modelTable;
	
	public CtrlJoueur(Connection con) {
		connection = con;
	}
	
	public void remplissageTableau() {
		DAOJoueur joueurs = new DAOJoueur(connection);
		ArrayList<Joueur> listeJoueurs = joueurs.getAll();
		modelTable = vue.getModel();
		modelTable.setListe(listeJoueurs);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		String action= arg0.getActionCommand();
		if (action.equals("Supprimer")){
			DAOJoueur joueurs = new DAOJoueur(connection);
			for (Joueur joueur: vue.getSelection()) {
				try {
					joueurs.delete(joueur);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
			this.remplissageTableau();
		}
		else if(action.equals("Valider"	)){
			DAOJoueur joueurs = new DAOJoueur(connection);
			
			String nom = vue.getNomJoueur();
			String mdp = vue.getMdpJoueur();
			String mail = vue.getMailJoueur();
			
			Joueur joueurInsert = new Joueur(-1,nom,mdp,mail);
			
			try {
				joueurs.insert(joueurInsert);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.remplissageTableau();
		}
		
	}

	public IPanelTableJoueur getVue() {
		return vue;
	}
	

	public void setVue(IPanelTableJoueur vue) {
		this.vue = vue;
		this.remplissageTableau();
	}

}
