package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import view.interfaces.IPanelRequetes;
import controller.CtrlRequetes;

public class PanelRequetes extends JPanel implements IPanelRequetes {
	
	private CtrlRequetes controleur;
	
	private JPanel panelRequetes;
	private JPanel panelJoueur;
	private JPanel panelNombreQuestion;
	private JPanel panelCodeQuestion;
	private JPanel panelTexteQuestion;
	
	private JTextField nomJoueur;
	private JTextField mdpJoueur;
	private JTextField codeQuestion;
	private JTextArea texteQuestion;
	
	private JLabel resultatNombreQuestion;
	private JLabel lblNombreQuestion;
	private JLabel lblNomJoueur;
	private JLabel lblMdpJoueur;
	private JLabel lblCodeQuestion;
	private JLabel lblTexteQuestion;
	
	private JButton rechercheJoueur;
	private JButton rechercheCodeQuestion;
	private JButton rechercheTexteQuestion;
	
	public PanelRequetes(CtrlRequetes controleur){
		
		this.controleur = controleur;
		
		this.panelRequetes = new JPanel();
		GridLayout affichageRequetes = new GridLayout(4,1);
		this.panelRequetes.setLayout(affichageRequetes);
		
		panelJoueur = new JPanel();
		panelNombreQuestion = new JPanel();
		panelCodeQuestion = new JPanel();
		panelTexteQuestion = new JPanel();
		
		
		// ----- panel de recherche d'un joueur -----
		
		lblNomJoueur = new JLabel("Nom du joueur : ");
		nomJoueur = new JTextField();
		nomJoueur.setPreferredSize(new Dimension(100,25));
		lblMdpJoueur = new JLabel("Mot de Passe : ");
		mdpJoueur = new JTextField();
		mdpJoueur.setPreferredSize(new Dimension(100,25));
		rechercheJoueur = new JButton("rechercher");
		rechercheJoueur.setActionCommand("rechercheJoueur");
		rechercheJoueur.addActionListener(controleur);
		
		FlowLayout affichageJoueur = new FlowLayout();
		panelJoueur.setLayout(affichageJoueur);
		panelJoueur.add(lblNomJoueur);
		panelJoueur.add(nomJoueur);
		panelJoueur.add(lblMdpJoueur);
		panelJoueur.add(mdpJoueur);
		panelJoueur.add(rechercheJoueur);
		
		
		// ----- panel d'affichage du nombre de question -----
		
		lblNombreQuestion = new JLabel("Nombre de Questions : ");
		resultatNombreQuestion = new JLabel("");
		
		FlowLayout affichageNombreQuestion = new FlowLayout();
		panelNombreQuestion.setLayout(affichageNombreQuestion);
		panelNombreQuestion.add(lblNombreQuestion);
		panelNombreQuestion.add(resultatNombreQuestion);
		
		
		// ----- panel de recherche d'une question par son code -----
		
		lblCodeQuestion = new JLabel("Code de la question : ");
		codeQuestion = new JTextField();
		codeQuestion.setPreferredSize(new Dimension(100,25));
		rechercheCodeQuestion = new JButton("rechercher");
		rechercheCodeQuestion.setActionCommand("rechercheCodeQuestion");
		rechercheCodeQuestion.addActionListener(controleur);
		
		
		FlowLayout affichageCodeQuestion = new FlowLayout();
		panelCodeQuestion.setLayout(affichageCodeQuestion);
		panelCodeQuestion.add(lblCodeQuestion);
		panelCodeQuestion.add(codeQuestion);
		panelCodeQuestion.add(rechercheCodeQuestion);
		
		// ----- panel de recherche de questions par un texte -----
		
		lblTexteQuestion = new JLabel("Texte a chercher dans les questions : ");
		texteQuestion = new JTextArea();
		texteQuestion.setBorder(codeQuestion.getBorder());
		texteQuestion.setPreferredSize(new Dimension(300,100));
		rechercheTexteQuestion = new JButton("rechercher");
		rechercheTexteQuestion.setActionCommand("rechercheTexteQuestion");
		rechercheTexteQuestion.addActionListener(controleur);
		
		FlowLayout affichageTexteQuestion = new FlowLayout();
		panelTexteQuestion.setLayout(affichageTexteQuestion);
		panelTexteQuestion.add(lblTexteQuestion);
		panelTexteQuestion.add(texteQuestion);
		panelTexteQuestion.add(rechercheTexteQuestion);
		
		// ----- ajout des panels dans le panel principale -----
		
		this.panelRequetes.add(panelJoueur);
		this.panelRequetes.add(panelNombreQuestion);
		this.panelRequetes.add(panelCodeQuestion);
		this.panelRequetes.add(panelTexteQuestion);
		this.add(panelRequetes);
		this.setVisible(true);
		
		this.controleur.setVue(this);
	}
	
	@Override
	public JLabel getResultatNombreQuestion() {
		return this.resultatNombreQuestion;
	}
	
	@Override
	public CtrlRequetes getControleur() {
		return controleur;
	}

	@Override
	public void setResultatNombreQuestion(int nb) {
		this.resultatNombreQuestion.setText(String.valueOf(nb));
		
	}

	@Override
	public String getCodeQuestion() {
		return this.codeQuestion.getText();
	}

	@Override
	public String getNomJoueur() {
		return this.nomJoueur.getText();
	}

	@Override
	public String getMdpJoueur() {
		return this.mdpJoueur.getText();
	}

	@Override
	public String getTexteQuestion() {
		return this.texteQuestion.getText();
	}

	@Override
	public void viderChamps() {
		nomJoueur.setText("");
		mdpJoueur.setText("");
		codeQuestion.setText("");
		texteQuestion.setText("");
	}

	
}
