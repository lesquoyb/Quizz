package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.DAOItem;
import model.metier.Item;
import view.interfaces.IPanelTableItem;

public class CtrlItem implements ActionListener{

	private IPanelTableItem vue;
	private Connection connection;
	
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
	
	public void afficheTableau() {
		DAOItem items = new DAOItem(connection);
		ArrayList<Item> listeItems = items.getAll();
		
		int nbItems = listeItems.size();
		for (int i=0; i<nbItems; i++) {
			String codeQuestion = String.valueOf(listeItems.get(i).getCodeQuestion());
			String codeQuizz = String.valueOf(listeItems.get(i).getCodeQuizz());
			String reponseJoueur = listeItems.get(i).getReponseJoueur();
			
			vue.getTable().setValueAt(codeQuestion, i, 0);
			vue.getTable().setValueAt(codeQuizz,i,1);
			vue.getTable().setValueAt(reponseJoueur, i, 2);
			
		}
	}
	
	public void setVue(IPanelTableItem vue) {
		this.vue = vue;
		afficheTableau();
	}

}
