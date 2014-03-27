package view.interfaces;

import java.util.ArrayList;

import model.metier.Quizz;
import view.modelTable.ModelTableQuizz;

public interface IPanelTableQuizz extends IPanelTable{
	
	public ArrayList<Quizz>getSelection();
	
	public ModelTableQuizz getModel();

	public String getNbQuestion();

	public String getDate();

	public String getCodeJoueur();

}
