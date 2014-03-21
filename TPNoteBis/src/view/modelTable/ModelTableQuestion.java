package view.modelTable;

import javax.swing.table.DefaultTableModel;

public class ModelTableQuestion  extends DefaultTableModel {

	

	private final static String[] titres =  new String [] {   "code_question", "texte_question", "reponse_question"   };
	private final static Class[] types = new Class[] 	  {	   int.class, String.class, String.class};
	
	public ModelTableQuestion(){
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

