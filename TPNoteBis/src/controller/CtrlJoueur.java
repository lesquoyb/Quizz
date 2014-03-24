package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.interfaces.IFenetreGestion;
import view.interfaces.IPanelTableJoueur;

public class CtrlJoueur implements ActionListener{

	private IPanelTableJoueur vue;
	
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

	public void setVue(IPanelTableJoueur vue) {
		this.vue = vue;
	}

}
