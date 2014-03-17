package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.interfaces.IFenetreGestion;

public class CtrlJoueur implements ActionListener{

	private IFenetreGestion vue;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		// test GIT
		
	}

	public IFenetreGestion getVue() {
		return vue;
	}

	public void setVue(IFenetreGestion vue) {
		this.vue = vue;
	}

}
