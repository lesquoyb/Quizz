package view.interfaces;

import javax.swing.JLabel;

import controller.CtrlRequetes;

public interface IPanelRequetes {
	
	public JLabel getResultatNombreQuestion();
	
	public CtrlRequetes getControleur();
	
	public void setResultatNombreQuestion(int nb);

}
