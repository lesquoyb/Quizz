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
			
		}
	}

	public IPanelTableItem getVue() {
		return vue;
	}

	public void setVue(IPanelTableItem vue) {
		this.vue = vue;
	}

}
