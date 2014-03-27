package view.interfaces;

import java.util.ArrayList;

import model.metier.Question;
import view.modelTable.ModelTableQuestion;

public interface IPanelTableQuestion  extends IPanelTable{
	
	public ArrayList<Question>getSelection();
	
	public String getTexte();
	
	public String getReponse();
	
	public ModelTableQuestion getModel();

}
