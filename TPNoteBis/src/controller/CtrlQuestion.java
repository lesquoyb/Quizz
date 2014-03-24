package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.interfaces.IFenetreGestion;
import view.interfaces.IPanelTableQuestion;

public class CtrlQuestion implements ActionListener {

	private IPanelTableQuestion vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String action= e.getActionCommand();
		if (action.equals("Supprimer")){
			
		}
		else if(action.equals("Valider"	)){
			
		}
	}

	public IPanelTableQuestion getVue() {
		return vue;
	}

	public void setVue(IPanelTableQuestion vue) {
		this.vue = vue;
	}

}
