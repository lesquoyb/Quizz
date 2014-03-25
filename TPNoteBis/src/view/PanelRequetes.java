package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.interfaces.IPanelRequetes;

public class PanelRequetes extends JPanel implements IPanelRequetes {
	
	private JPanel panelRequetes;
	private JPanel panelJoueur;
	private JPanel panelNombreQuestion;
	private JPanel panelCodeQuestion;
	private JPanel panelTexteQuestion;
	
	private JTextField nomJoueur;
	private JTextField mdpJoueur;
	private JTextField codeQuestion;
	private JTextField texteQuestion;
	
	private JLabel resultatNombreQuestion;
	private JLabel lblNombreQuestion;
	private JLabel lblNomJoueur;
	private JLabel lblMdpJoueur;
	private JLabel lblCodeQuestion;
	private JLabel lblTexteQuestion;
	
	private JOptionPane resultatJoueur;
	private JOptionPane resultatCodeQuestion;
	private JOptionPane resultatTexteQuestion;
	
	private JButton rechercheJoueur;
	private JButton rechercheCodeQuestion;
	private JButton rechercheTexteQuestion;
	
	public PanelRequetes(){
		
		this.panelRequetes = new JPanel();
		BoxLayout affichageRequetes = new BoxLayout(this.panelRequetes, BoxLayout.PAGE_AXIS);
		this.panelRequetes.setLayout(affichageRequetes);
		
		panelJoueur = new JPanel();
		panelNombreQuestion = new JPanel();
		panelCodeQuestion = new JPanel();
		panelTexteQuestion = new JPanel();
		
		
		// ----- panel de recherche d'un joueur -----
		
		lblNomJoueur = new JLabel("Nom du joueur : ");
		nomJoueur = new JTextField();
		lblMdpJoueur = new JLabel("Mot de Passe : ");
		mdpJoueur = new JTextField();
		rechercheJoueur = new JButton("rechercher");
		
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
		rechercheCodeQuestion = new JButton("rechercher");
		
		FlowLayout affichageCodeQuestion = new FlowLayout();
		panelCodeQuestion.setLayout(affichageCodeQuestion);
		panelCodeQuestion.add(lblCodeQuestion);
		panelCodeQuestion.add(codeQuestion);
		panelCodeQuestion.add(rechercheCodeQuestion);
		
		// ----- panel de recherche de questions par un texte -----
		
		lblTexteQuestion = new JLabel("Texte a chercher dans les questions : ");
		texteQuestion = new JTextField();
		rechercheTexteQuestion = new JButton("rechercher");
		
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
	}

}
