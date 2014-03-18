package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.interfaces.IFenetreGestion;

public class CtrlQuizz implements ActionListener{

	private IFenetreGestion vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String action= e.getActionCommand();
		if (action.equals("Supprimer")){
			
		}
		else if(action.equals("Valider"	)){
			
		}
	}

	public IFenetreGestion getVue() {
		return vue;
	}

	public void setVue(IFenetreGestion vue) {
		this.vue = vue;
	}

}
