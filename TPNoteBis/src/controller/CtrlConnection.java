package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dao.MaConnection;
import view.interfaces.IChangementConnection;

public class CtrlConnection implements ActionListener {

	private IChangementConnection vue;
	
	public CtrlConnection(IChangementConnection vue){
		this.vue = vue;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		if (action.equals("ok")){
			MaConnection.setAdresse(vue.getAdresse());
			MaConnection.setBase(vue.getBase());
			MaConnection.setMotDePasse(vue.getMotDePasse());
			MaConnection.setNomDriver(vue.getNomDriver());
			MaConnection.setUtilisateur(vue.getIdentifiant());
		}
		vue.fermer();
	}
}
