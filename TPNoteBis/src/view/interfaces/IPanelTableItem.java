package view.interfaces;

import java.util.ArrayList;

import model.metier.Item;

public interface IPanelTableItem  extends IPanelTable{
	
	public ArrayList<Item>getSelection();

}
