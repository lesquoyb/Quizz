package view.modelTable;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.metier.Item;

public class ModelTableItem extends DefaultTableModel{

	private final static String[] titres =  new String [] {  "code_question", "code_quizz", "reponse_joueur"    };
	private final static Class[] types = new Class[] 	  {	   int.class, int.class, String.class};
	
	public ModelTableItem(){
		super(new Object [][] {  }, titres );
	}

	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}


	@Override
	public Class<?> getColumnClass(int arg0) {
		return types[arg0];
	}
	
}
