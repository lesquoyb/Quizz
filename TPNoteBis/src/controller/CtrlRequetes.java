package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.dao.DAOQuestion;
import model.dao.MaConnection;
import view.interfaces.IPanelRequetes;

public class CtrlRequetes implements ActionListener {
	
	private IPanelRequetes vue;
	private DAOQuestion question;
	
	public CtrlRequetes() throws ClassNotFoundException, SQLException {
		this.question = new DAOQuestion(MaConnection.getInstance());
	}
	
	public void afficheNombreQuestion() {
		
		int nb = question.nombreQuestions();
		this.vue.setResultatNombreQuestion(nb);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setVue(IPanelRequetes panelRequetes) {
		this.vue = panelRequetes;
		this.afficheNombreQuestion();
		
	}
	
	

}
