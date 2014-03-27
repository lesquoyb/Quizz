package view.modelTable;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.metier.Quizz;

public class ModelTableQuizz extends AbstractTableModel {

	private final static String[] titres ={  "code_quizz", "date_quizz", "nb_question_quizz", "code_joueur"};
	private final static Class[] types = { int.class , Date.class, int.class, int.class};
	private ArrayList<Quizz> quizz;
	
	public ModelTableQuizz(){
		super();
		quizz = new ArrayList<Quizz>();
	}
	
	public void setListe(ArrayList<Quizz> quizzSet){
		quizz = quizzSet;
		this.fireTableDataChanged();
	}

    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
	@Override
	public int getColumnCount() {
		return 4;
	}


	@Override
	public int getRowCount() {
		return quizz.size();
	}


	@Override
	public Object getValueAt(int row, int column) {
		Object objet = null;
		
		switch (column){
		
		case 0: objet = quizz.get(row).getCode();
		case 1: objet = quizz.get(row).getDate();
		case 2: objet = quizz.get(row).getNombreQuestion();
		case 3: objet = quizz.get(row).getJoueur().getCode();
		}
		
		return objet;
		
		
	}

	@Override
	public String getColumnName(int arg0) {
		return titres[arg0];
	}
    
}

