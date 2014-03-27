package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.dao.DAOItem;
import model.metier.Item;
import view.interfaces.IPanelTableItem;
import view.modelTable.ModelTableItem;

public class CtrlItem implements ActionListener{

	private IPanelTableItem vue;
	private Connection connection;
	private ModelTableItem modelTable;
	
	public CtrlItem(Connection con){
		connection = con; 
	}
	
	public void remplissageTableau() {
		DAOItem items = new DAOItem(connection);
		ArrayList<Item> listeItems = items.getAll();
		modelTable = vue.getModel();
		modelTable.setListe(listeItems);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action= e.getActionCommand();
		if (action.equals("Supprimer")){
			DAOItem items = new DAOItem(connection);
			for(Item item: vue.getSelection()){
				try {
					items.delete(item);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Echec de la suppression:\n"+e1.getMessage(), "Suppression échouée", JOptionPane.ERROR_MESSAGE );
				}		
			}
			this.remplissageTableau();
		}
		else if(action.equals("Valider"	)){
			DAOItem items = new DAOItem(connection);
			
			if (( vue.getCodeQuestion().equals("") ) || ( vue.getCodeQuizz().equals("")) || (vue.getReponseJoueur().equals("") )) {
				
				JOptionPane.showMessageDialog(null, "Remplissez tout les champs !", "information manquante", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				
				try {
					int codeQuestion = Integer.parseInt(vue.getCodeQuestion());
					int codeQuizz = Integer.parseInt(vue.getCodeQuizz());
					String reponseJoueur = vue.getReponseJoueur();
					Item itemInsert = new Item(codeQuestion,codeQuizz,reponseJoueur);
					vue.viderChamps();
					try {
						items.insert(itemInsert);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Echec de l'ajout:\n"+e1.getMessage(), "Ajout échoué", JOptionPane.ERROR_MESSAGE );
					}

				} catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(null, "Entrées invalides ! (les codes sont des nombres):\n"+e1.getMessage(), "Ajout échoué", JOptionPane.ERROR_MESSAGE );		
				}
				this.remplissageTableau();


			}
		}
	}

	public IPanelTableItem getVue() {
		return vue;
	}
	
	
	public void setVue(IPanelTableItem vue) {
		this.vue = vue;
		this.remplissageTableau();
	}

}
