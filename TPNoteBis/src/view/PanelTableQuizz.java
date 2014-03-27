package view;

import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.GroupLayout;
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



        
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(labDate)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, GroupLayout.PREFERRED_SIZE,100, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(labNbQuestion)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbQuestion, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labNumJoueur)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numero, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(btnValider)
                        .addGap(118, 118, 118)
                        .addComponent(btnSupprimer)))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labDate)
                    .addComponent(labNbQuestion)
                    .addComponent(labNumJoueur))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValider)
                    .addComponent(btnSupprimer))
                .addContainerGap())
        );

        GroupLayout panQuizzLayout = new GroupLayout(this);
        this.setLayout(panQuizzLayout);
        panQuizzLayout.setHorizontalGroup(
            panQuizzLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, panQuizzLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1)
                .addContainerGap())
                
        );
        panQuizzLayout.setVerticalGroup(
            panQuizzLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panQuizzLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 389,GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

       

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
