package view.modelTable;

import java.sql.Date;

import javax.swing.table.DefaultTableModel;

public class ModelTableQuizz extends DefaultTableModel {

	private final static String[] titres ={  "code_quizz", "date_quizz", "nb_question_quizz", "code_joueur"};
	private final static Class[] types = { int.class , Date.class, int.class, int.class};
	
	
	public ModelTableQuizz(){
		super( new Object [][] {  },titres	);
	}

    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}

