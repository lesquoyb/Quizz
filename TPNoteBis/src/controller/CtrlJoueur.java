package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.DAOJoueur;
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
					 if (JOptionPane.showConfirmDialog(null,"Êtes vous sur de vouloir supprimer ce joueur ainsi que les quizz qu'il a effectué?","joueur trouvé",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							connection.commit();
							joueur.setCode(-1);
						 }
						 else{
							 connection.rollback();
						 }
					 
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Echec de la suppression:\n"+e1.getMessage(), "Suppression échouée", JOptionPane.ERROR_MESSAGE );
				}	
				finally{
					try {
						connection.setAutoCommit(true);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			this.remplissageTableau();
		}
		else if(action.equals("Valider"	)){
			DAOJoueur joueurs = new DAOJoueur(connection);
			
			String nom = vue.getNomJoueur();
			String mdp = vue.getMdpJoueur();
			String mail = vue.getMailJoueur();
			
			if ((nom.equals("")) ||(mdp.equals("")) || (mail.equals("")) ) {
				
				JOptionPane.showMessageDialog(null, "Remplissez tout les champs !", "information manquante", JOptionPane.ERROR_MESSAGE);
			}
			
			else{
			
				Joueur joueurInsert = new Joueur(-1,nom,mdp,mail);

				try {
					joueurs.insert(joueurInsert);
					vue.viderChamps();
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Echec de l'ajout:\n"+e1.getMessage(), "Ajout échoué", JOptionPane.ERROR_MESSAGE );
				}
				this.remplissageTableau();
			
			}
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
