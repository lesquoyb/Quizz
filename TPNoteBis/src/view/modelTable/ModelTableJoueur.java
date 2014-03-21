package view.modelTable;

import javax.swing.table.DefaultTableModel;

public class ModelTableJoueur extends DefaultTableModel {

	

	private final static String[] titres =  new String [] {   "code_joueur", "nom_joueur", "mail_joueur", "passwd_joueur"   };
	private final static Class[] types = new Class[] 	  {	   int.class, String.class, String.class, String.class};
	
	public ModelTableJoueur(){
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
