package view.modelTable;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.metier.Item;

public class ModelTableItem extends AbstractTableModel{

	private final static String[] titres =  new String [] {  "code_question", "code_quizz", "reponse_joueur"    };
	private final static Class[] types = new Class[] 	  {	   int.class, int.class, String.class};
	protected ArrayList<Item> items;
	
	public ModelTableItem(){
		super();
		items = new ArrayList<Item>();
	}
	
	public void setListe(ArrayList<Item> itemsSet){
		items = itemsSet;
		this.fireTableDataChanged();
		
	}

	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}


	@Override
	public Class<?> getColumnClass(int arg0) {
		return types[arg0];
	}
	
	@Override
	public Object getValueAt (int row, int column) {
		
		Object objet = null;
		
		switch (column){
		
		case 0: objet = items.get(row).getCodeQuestion();
		case 1: objet = items.get(row).getCodeQuizz();
		case 2: objet = items.get(row).getReponseJoueur();
		}
		
		return objet;
		
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return items.size();
	}
}
