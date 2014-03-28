package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import model.metier.Item;
import view.interfaces.IPanelTableItem;
import view.modelTable.ModelTableItem;
import controller.CtrlItem;

public class PanelTableItem extends JPanel implements IPanelTableItem{

	



	private JButton btnSupprimerItem;
    private JButton btnValiderItem;
    private JTextField codeQuestion;
    private JTextField codeQuizz;
    private JScrollPane panScrollItem;
    private JTextField reponseJoueur;
    private JTable tabItem;
    private JLabel labReponse;
    private JLabel labQuizz;
    private JLabel labQuestion;
    private ModelTableItem modelTable;
    private JPanel jPanel2;
	
	public PanelTableItem(CtrlItem controleurItem	){
		
        panScrollItem = new JScrollPane();
        tabItem = new JTable();
        modelTable = new ModelTableItem();
        tabItem.setModel(modelTable);
        controleurItem.setVue(this);

        jPanel2 = new JPanel();
        labReponse = new JLabel();
        labQuizz = new JLabel();
        labQuestion = new JLabel();
        btnSupprimerItem = new JButton();
        codeQuestion = new JTextField();
        codeQuizz = new JTextField();
        reponseJoueur = new JTextField();
        btnValiderItem = new JButton();

        this.btnSupprimerItem.addActionListener(controleurItem);
        this.btnValiderItem.addActionListener(controleurItem);

        
        panScrollItem.setViewportView(tabItem);

        labReponse.setText("reponse");

        labQuizz.setText("code quizz");

        labQuestion.setText("code question");

        btnSupprimerItem.setText("Supprimer");
        btnSupprimerItem.setToolTipText("supprime la ligne selectionnée");

        btnValiderItem.setText("Valider");
        btnValiderItem.setToolTipText("valide les informations entrées");
        
        initComposants();
	}
	
		private void initComposants(){ 
			   this.setLayout(new BorderLayout());
			   JPanel panCentre = new JPanel();
			   panScrollItem.setPreferredSize(new Dimension(1200, 500));
			   panCentre.add(panScrollItem);
			   this.add(panCentre,BorderLayout.CENTER);
			   
			   JPanel panSud = new JPanel();
			   codeQuestion.setPreferredSize(new Dimension(100,20));
			   codeQuizz.setPreferredSize(new Dimension(100,20));
			   reponseJoueur.setPreferredSize(new Dimension(200,20));
			   panSud.setPreferredSize(new Dimension(this.getWidth()-4,110));
			   JPanel interm = new JPanel();
			   BoxLayout box = new BoxLayout(interm, BoxLayout.PAGE_AXIS);
			   interm.setLayout(box);
			   JPanel entrees = new JPanel();
			   JPanel boutons = new JPanel();
			   boutons.add(btnValiderItem);
			   boutons.add(btnSupprimerItem);
			   entrees.add(labQuestion);
			   entrees.add(codeQuestion);
			   entrees.add(labQuizz);
			   entrees.add(codeQuizz);
			   entrees.add(labReponse);
			   entrees.add(reponseJoueur);
			   interm.add(entrees);
			   interm.add(boutons);
			   JTabbedPane onglet = new JTabbedPane();
			   onglet.addTab("Ajouter / Supprimer", null, interm, "saisir un élément à ajouter à la base de données ou selectionner dans le tableau un/des éléments à supprimer.");
			   panSud.add(onglet);
			   this.add(panSud,BorderLayout.SOUTH);
			   
		}
	   
	
    @Override
	public ModelTableItem getModel() {
		return modelTable;
	}


	@Override
	public JTable getTable() {
		return tabItem;
	}


	@Override
	public ArrayList<Item> getSelection() {
		int[] selected = tabItem.getSelectedRows();
		ArrayList<Item>listeRetour = new ArrayList<Item>();
		for (int i : selected){
			int code_question = Integer.valueOf(String.valueOf(tabItem.getValueAt(i, 0)));
			int code_quizz = Integer.valueOf(String.valueOf(tabItem.getValueAt(i, 1)));
			String reponse_joueur = (String) tabItem.getValueAt(i, 2);
			listeRetour.add(new Item(code_question,code_quizz,reponse_joueur));
		}
		return listeRetour;
	}
	
	public String getCodeQuestion() {
		return this.codeQuestion.getText();
	}
	
	@Override
	public void viderChamps() {
		codeQuestion.setText("");
	    codeQuizz.setText("");;
	    reponseJoueur.setText("");
		
	}


	public String getCodeQuizz() {
		return this.codeQuizz.getText();
	}
	
	public String getReponseJoueur() {
		return this.reponseJoueur.getText();
	}
}
