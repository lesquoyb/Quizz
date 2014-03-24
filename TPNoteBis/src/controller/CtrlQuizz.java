package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.interfaces.IFenetreGestion;
import view.interfaces.IPanelTableQuizz;

public class CtrlQuizz implements ActionListener{

	private IPanelTableQuizz vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String action= e.getActionCommand();
		if (action.equals("Supprimer")){
			
		}
		else if(action.equals("Valider"	)){
			
		}
	}

	public IPanelTableQuizz getVue() {
		return vue;
	}

	public void setVue(IPanelTableQuizz vue) {
		this.vue = vue;
	}

}
