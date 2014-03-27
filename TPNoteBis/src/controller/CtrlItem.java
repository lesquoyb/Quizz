package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action= e.getActionCommand();
		if (action.equals("Supprimer")){
			DAOItem items = new DAOItem(connection);
			for(Item item: vue.getSelection()){
				try {
					items.delete(item);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
			}
		}
		else if(action.equals("Valider"	)){
			DAOItem items = new DAOItem(connection);
			
			int codeQuestion = Integer.parseInt(vue.getCodeQuestion());
			int codeQuizz = Integer.parseInt(vue.getCodeQuizz());
			String reponseJoueur = vue.getReponseJoueur();
			
			Item itemInsert = new Item(codeQuestion,codeQuizz,reponseJoueur);
			
			try {
				items.insert(itemInsert);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public IPanelTableItem getVue() {
		return vue;
	}
	
	public void remplissageTableau() {
		DAOItem items = new DAOItem(connection);
		ArrayList<Item> listeItems = items.getAll();
		modelTable = vue.getModel();
		modelTable.setListe(listeItems);
	}
	
	public void setVue(IPanelTableItem vue) {
		this.vue = vue;
		this.remplissageTableau();
	}

}
