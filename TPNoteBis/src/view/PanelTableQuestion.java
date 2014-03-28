package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import model.metier.Question;
import view.interfaces.IPanelTableQuestion;
import view.modelTable.ModelTableQuestion;
import controller.CtrlQuestion;

public class PanelTableQuestion extends JPanel implements IPanelTableQuestion{

	private JPanel panelSaisie;
	private JScrollPane panScroll;
	private JButton btnValiderQuestion;
	private JButton btnSupprimerQuestion;
	private JTextArea texte;
	private JTextField reponseQuestion;
	private JScrollPane scrollTexte;
	private JTable tabQuestion;
	private JLabel labEnonce ;
	private JLabel labRep;
	
	private ModelTableQuestion modelTable;
	
	public PanelTableQuestion(CtrlQuestion controleur){
		
        modelTable = new ModelTableQuestion();
		controleur.setVue(this);
		tabQuestion = new JTable(modelTable);
		scrollTexte = new JScrollPane();
		texte = new JTextArea();
		texte.setColumns(5);
		texte.setRows(20);
		texte.setWrapStyleWord(true);
		scrollTexte.setViewportView(texte);
		panelSaisie = new JPanel();
		panScroll = new JScrollPane();
		reponseQuestion = new JTextField();
		reponseQuestion.setMaximumSize(new Dimension(150,20));
		scrollTexte.setMaximumSize(new Dimension(250,100));
        labEnonce = new JLabel("énoncé de la question:");
        labRep = new JLabel("réponse");
        btnSupprimerQuestion = new JButton();
        btnValiderQuestion = new JButton();
        
        btnValiderQuestion.setText("Valider");
        btnValiderQuestion.setToolTipText("valide les informations entrées");
        btnValiderQuestion.addActionListener(controleur);

        btnSupprimerQuestion.setText("Supprimer");
        btnSupprimerQuestion.setToolTipText("supprime la ligne selectionnée");
        btnSupprimerQuestion.addActionListener(controleur);
        panelSaisie.setLayout(new BoxLayout(panelSaisie,BoxLayout.LINE_AXIS));
        panelSaisie.add(labEnonce);
        panelSaisie.add(scrollTexte);
        panelSaisie.add(labRep);
        panelSaisie.add(reponseQuestion);
        initComposant();
	}
        
        public void initComposant(){

     	   this.setLayout(new BorderLayout());
     	   JPanel panCentre = new JPanel();
     	  panScroll.setPreferredSize(new Dimension(1200, 450));
     	  panScroll.setViewportView(tabQuestion);
     	   panCentre.add(panScroll);
     	   this.add(panCentre,BorderLayout.CENTER);
     	   
     	   JPanel panSud = new JPanel();
     	   
     	   JPanel interm = new JPanel();
     	   BoxLayout box = new BoxLayout(interm, BoxLayout.PAGE_AXIS);
     	   interm.setLayout(box);
     	   interm.setPreferredSize(new Dimension(900,110));
     	   JPanel boutons = new JPanel();
     	   boutons.add(btnValiderQuestion);
     	   boutons.add(btnSupprimerQuestion);
     	   interm.add(panelSaisie);
     	   interm.add(boutons);
     	   JTabbedPane onglet = new JTabbedPane();
           onglet.addTab("Ajouter / Supprimer", null, interm, "saisir un élément à ajouter à la base de données ou selectionner dans le tableau un/des éléments à supprimer.");
     	   panSud.add(onglet);

           panCentre.setBackground(new Color(0x34393E));
           tabQuestion.getTableHeader().setBackground(new Color(0xFF5B2B));
           panSud.setBackground(new Color(0x34393E));
     	   this.add(panSud,BorderLayout.SOUTH);
     	   this.setVisible(true);
        }

     
	@Override
	public void viderChamps() {
		texte.setText("");
		reponseQuestion.setText("");
		
	}

	public void supSelect(){
		int[] selectionne = tabQuestion.getSelectedRows();
		DefaultTableModel model = 	(DefaultTableModel) tabQuestion.getModel();
		for(int i : selectionne){
			model.removeRow(i);
		}	
	}


	@Override
	public JTable getTable() {
		return tabQuestion;
	}

	@Override
	public ArrayList<Question> getSelection() {
		int[] selected = tabQuestion.getSelectedRows();
		ArrayList<Question>listeRetour = new ArrayList<Question>();
		for (int i : selected){
			int code = (int) modelTable.getValueAt(i, 0);
			String texte = (String) tabQuestion.getValueAt(i, 1);
			String reponse = (String) tabQuestion.getValueAt(i, 2);
			listeRetour.add(new Question(code,texte,reponse));
		}
		return listeRetour;
	}

	@Override
	public String getTexte() {
		return this.texte.getText();
	}

	@Override
	public String getReponse() {
		return this.reponseQuestion.getText();
	}

	@Override
	public ModelTableQuestion getModel() {
		return modelTable;
	}
	
	
}
