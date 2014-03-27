package view;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

import model.metier.Joueur;
import model.metier.Question;
import model.metier.Quizz;
import view.interfaces.IPanelTableQuizz;
import view.modelTable.ModelTableQuizz;
import controller.CtrlQuizz;

public class PanelTableQuizz extends JPanel implements IPanelTableQuizz{

	private JTable tabQuizz ;
	private JScrollPane scrollPane1;
	private JButton btnValider;
	private JButton btnSupprimer;
    private JPanel jPanel1;
    private JTextField nbQuestion;

    private JTextField numero;
    private JTextField date;
    private JLabel labNbQuestion;
    private JLabel labNumJoueur;
    private JLabel labDate;
    
    private ModelTableQuizz modelTable;

	
	public PanelTableQuizz(CtrlQuizz controleurQuizz){

		modelTable = new ModelTableQuizz();
		controleurQuizz.setVue(this);
		labDate = new JLabel("date");
		labNbQuestion = new JLabel("nombre de questions");
        labNumJoueur = new JLabel("numero joueur");
		btnValider = new JButton();
		btnSupprimer = new JButton();
		tabQuizz = new JTable();
        tabQuizz.setModel(modelTable);
        tabQuizz.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(tabQuizz);
        jPanel1 = new JPanel();
        date = new JTextField();
        numero = new JTextField();
        nbQuestion = new JTextField();
        btnValider.setText("Valider");
        btnValider.setToolTipText("valide les informations entrés");
        btnValider.addActionListener(controleurQuizz);

        btnSupprimer.setText("Supprimer");
        btnSupprimer.setToolTipText("supprime la ligne selectionnée");
        btnSupprimer.addActionListener(controleurQuizz);

        initComposants();
	}
        
       private void initComposants(){ 
    	   
    	   
    	   
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        
        // Alignement Horizontal
        ParallelGroup groupHorizontal = jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        SequentialGroup groupSequentiel = jPanel1Layout.createSequentialGroup();
        SequentialGroup groupSequentiel2 = jPanel1Layout.createSequentialGroup();
        SequentialGroup groupSequentiel3 = jPanel1Layout.createSequentialGroup();


        
        
        groupSequentiel2.addGap(284, 284, 284);
        groupSequentiel2.addComponent(labDate);
        groupSequentiel2 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        groupSequentiel2.addComponent(date, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE);
        groupSequentiel2.addGap(28, 28, 28);
        groupSequentiel2.addComponent(labNbQuestion);
        groupSequentiel2.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        groupSequentiel2.addComponent(nbQuestion, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE);
        groupSequentiel2.addGap(18, 18, 18);
        groupSequentiel2.addComponent(labNumJoueur);
        groupSequentiel2.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        groupSequentiel2.addComponent(numero, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE);
        
        groupSequentiel3.addGap(383, 383, 383);
        groupSequentiel3.addComponent(btnValider);
        groupSequentiel3.addGap(118, 118, 118);
        groupSequentiel3.addComponent(btnSupprimer);
        
        ParallelGroup groupParallel = jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        groupParallel.addGroup(groupSequentiel2);
        groupParallel.addGroup(groupSequentiel3);
        groupSequentiel.addGroup(groupParallel);
        groupSequentiel.addContainerGap(375, Short.MAX_VALUE);

        groupHorizontal.addGroup(groupSequentiel);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(groupHorizontal);
        	
        //Alignement Vertical
        ParallelGroup parallelVertical = jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
        ParallelGroup parallelVertical2 = jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE);

        parallelVertical.addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        parallelVertical.addComponent(nbQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        parallelVertical.addComponent(numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        parallelVertical.addComponent(labDate);
        parallelVertical.addComponent(labNbQuestion);
        parallelVertical.addComponent(labNumJoueur);
        
        parallelVertical2.addComponent(btnValider);
        parallelVertical2.addComponent(btnSupprimer);
        
        SequentialGroup sequentielVertical = jPanel1Layout.createSequentialGroup();
        sequentielVertical.addContainerGap();
        sequentielVertical.addGroup(parallelVertical);
        sequentielVertical.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE);
        sequentielVertical.addGroup(parallelVertical2);
        sequentielVertical.addContainerGap();
        ParallelGroup groupVertical =  jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        groupVertical.addGroup(GroupLayout.Alignment.TRAILING, sequentielVertical);
        
        jPanel1Layout.setVerticalGroup(groupVertical);
        
        
        GroupLayout panQuizzLayout = new GroupLayout(this);
        SequentialGroup groupQuizzHoriz = panQuizzLayout.createSequentialGroup();
        groupQuizzHoriz.addContainerGap();
        groupQuizzHoriz.addComponent(scrollPane1);
        groupQuizzHoriz.addContainerGap();
        this.setLayout(panQuizzLayout);
       ParallelGroup quizzHoriz = panQuizzLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
       quizzHoriz.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
       quizzHoriz.addGroup(groupQuizzHoriz);
       
        panQuizzLayout.setHorizontalGroup(quizzHoriz);

        
        SequentialGroup groupQuizzVert = panQuizzLayout.createSequentialGroup();
        groupQuizzVert.addContainerGap();
        groupQuizzVert.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 389,GroupLayout.PREFERRED_SIZE);;
        groupQuizzVert.addGap(18, 18, 18);
        groupQuizzVert.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        groupQuizzVert.addContainerGap(59, Short.MAX_VALUE);
        
        ParallelGroup quizzVert = panQuizzLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        quizzVert.addGroup(groupQuizzVert);
       
        panQuizzLayout.setVerticalGroup(quizzVert);
       

	}


	@Override
	public void viderChamps() {
	    nbQuestion.setText("");
	    numero.setText("");
	    date.setText("");
	}


	@Override
	public void rafraichirTable() {
		
	}


	@Override
	public JTable getTable() {
		return tabQuizz;
	}


	@Override
	public ArrayList<Quizz> getSelection() {
		int[] selected = tabQuizz.getSelectedRows();
		ArrayList<Quizz>listeRetour = new ArrayList<Quizz>();
		
		for (int i : selected){
			
			int nbQuestion  = (int) modelTable.getValueAt(i, 2);
			Date date = Date.valueOf(String.valueOf(modelTable.getValueAt(i, 1)));
			int codeJoueur = (int) modelTable.getValueAt(i, 3);
			int codeQuizz = (int) modelTable.getValueAt(i, 0);
			Joueur joueurQuizz = new Joueur();
			joueurQuizz.setCode(codeJoueur);
			
			ArrayList<String> reponses = new ArrayList<String>();
			ArrayList<Question> questions = new ArrayList<Question>();

			listeRetour.add(new Quizz(codeQuizz,nbQuestion,date,reponses,questions,joueurQuizz));
			
		}
		return listeRetour;

	}


	@Override
	public ModelTableQuizz getModel() {
		return modelTable;
	}


	@Override
	public String getNbQuestion() {
		return this.nbQuestion.getText();
	}


	@Override
	public String getDate() {
		return this.date.getText();
	}


	@Override
	public String getCodeJoueur() {
		return this.numero.getText();
	}
	
	
}
