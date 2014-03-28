package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

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
        date.setPreferredSize(new Dimension(200,20));
        numero = new JTextField();
        numero.setPreferredSize(new Dimension(80,20));
        nbQuestion = new JTextField();
        nbQuestion.setPreferredSize(new Dimension(80,20));
        btnValider.setText("Valider");
        btnValider.setToolTipText("valide les informations entrés");
        btnValider.addActionListener(controleurQuizz);

        btnSupprimer.setText("Supprimer");
        btnSupprimer.setToolTipText("supprime la ligne selectionnée");
        btnSupprimer.addActionListener(controleurQuizz);

        initComposants();
	}
        
       private void initComposants(){ 
    	   this.setLayout(new BorderLayout());
    	   JPanel panCentre = new JPanel();
    	   scrollPane1.setPreferredSize(new Dimension(1200, 500));
    	   panCentre.add(scrollPane1);
    	   this.add(panCentre,BorderLayout.CENTER);
    	   
    	   JPanel panSud = new JPanel();
    	   
    	   panSud.setPreferredSize(new Dimension(this.getWidth()-4,110));
    	   JPanel interm = new JPanel();
    	   BoxLayout box = new BoxLayout(interm, BoxLayout.PAGE_AXIS);
    	   interm.setLayout(box);
    	   JPanel entrees = new JPanel();
    	   JPanel boutons = new JPanel();
    	   boutons.add(btnValider);
    	   boutons.add(btnSupprimer);
    	   entrees.add(labDate);
    	   entrees.add(date);
    	   entrees.add(labNumJoueur);
    	   entrees.add(numero);
    	   entrees.add(labNbQuestion);
    	   entrees.add(nbQuestion);
    	   interm.add(entrees);
    	   interm.add(boutons);
    	   JTabbedPane onglet = new JTabbedPane();
           onglet.addTab("Ajouter / Supprimer", null, interm, "saisir un élément à ajouter à la base de données ou selectionner dans le tableau un/des éléments à supprimer.");
    	   panSud.add(onglet);
    	   this.add(panSud,BorderLayout.SOUTH);
       }


	@Override
	public void viderChamps() {
	    nbQuestion.setText("");
	    numero.setText("");
	    date.setText("");
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
