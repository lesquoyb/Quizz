package view.interfaces;

import java.util.ArrayList;

import view.modelTable.ModelTableItem;
import model.metier.Item;

public interface IPanelTableItem  extends IPanelTable{
	
	public ArrayList<Item>getSelection();

	public String getCodeQuestion();
	
	public String getCodeQuizz();
	
	public String getReponseJoueur();

	public ModelTableItem getModel();

}
