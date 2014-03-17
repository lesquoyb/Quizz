package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.interfaces.IFenetreGestion;

public class CtrlQuestion implements ActionListener {

	private IFenetreGestion vue;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public IFenetreGestion getVue() {
		return vue;
	}

	public void setVue(IFenetreGestion vue) {
		this.vue = vue;
	}

}
