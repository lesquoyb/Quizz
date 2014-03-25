package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.metier.Joueur;
import model.metier.Question;
import view.interfaces.IFenetreJeu;
import controller.CtrlFermeture;
import controller.CtrlJeu;

public class FenetreJeu extends JFrame implements IFenetreJeu{

	private JTextArea question;
	private JTextField reponse;
	private JButton valider;
	private ButtonGroup grChoix;
	private String questionEnCours;
	private CtrlJeu controleur;
	private int score;
	private JLabel labScore;
	private JPanel panelHaut;
	private JPanel panelCentre;
	private JPanel panelBas;
	private CtrlFermeture ctrlFermeture;
	
	
	public FenetreJeu(Connection connection,Joueur joueur){
		questionEnCours ="";
		controleur = new CtrlJeu();
		controleur.setJoueur(joueur);
		controleur.setVue(this);
		controleur.setConnection(connection);
		
		score = 0;
		labScore = new JLabel("Score: 0");
		panelHaut = new JPanel(new FlowLayout());
		panelCentre = new JPanel(new FlowLayout());
		panelBas = new JPanel(new FlowLayout());
		
		
		valider = new JButton("valider");
		valider.addActionListener(controleur);
		reponse = new JTextField();
		question = new JTextArea();
		question.setEditable(false);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		
		panelHaut.add(labScore);
		panelCentre.add(question);
		JPanel panRep = new JPanel();
		panRep.setLayout(new FlowLayout());
		panRep.add(reponse);
		panelCentre.add(panRep);
		panelBas.add(valider);
		
		this.setLayout(new BorderLayout());
		this.add(panelBas,BorderLayout.SOUTH);
		this.add(panelCentre,BorderLayout.CENTER);
		this.add(panelHaut,BorderLayout.NORTH);
		this.setLocationRelativeTo(null);
		ctrlFermeture = new CtrlFermeture();
		this.addWindowListener(ctrlFermeture);

		afficherSelection();
		this.setVisible(true);
	}
	
	/**
	 * Affiche le menu de selection des niveaux.
	 */
	public void afficherSelection(){
		this.panelCentre.removeAll();
		this.panelCentre.setLayout(new BoxLayout(panelCentre,BoxLayout.LINE_AXIS));
		
		JLabel selection = new JLabel("Selectionnez un mode de jeu: ");
		grChoix = new ButtonGroup();
		JRadioButton facile = new JRadioButton("Facile (10 question, temps illimité)");
		facile.setActionCommand("facile");
		facile.setSelected(true);
		grChoix.add(facile);
		
		panelCentre.add(selection);
		panelCentre.add(facile);

		valider.setActionCommand("difficulte");
		this.getRootPane().setDefaultButton(valider);

		this.panelCentre.repaint();		
		this.panelCentre.validate();
	}
	
	public String getChoix(){
		return grChoix.getSelection().getActionCommand();
	}

	@Override
	public String getQuestion() {
		return questionEnCours;
	}

	@Override
	public String getReponse() {
		return reponse.getText();
	}

	@Override
	public void poserQuestion(Question q, int numero) {
		this.panelCentre.removeAll();
		this.panelCentre.setLayout(new BoxLayout(panelCentre,BoxLayout.PAGE_AXIS));
		this.question.setText(q.getTexte());
		this.reponse.setText("");
		reponse.setPreferredSize(new Dimension(100,40));
		
		panelCentre.add(question);
		JPanel panRep = new JPanel();
		panRep.setLayout(new FlowLayout());
		panRep.add(reponse);
		panelCentre.add(panRep);
		reponse.requestFocus();
		
		valider.setActionCommand("valider"+numero);
		this.panelCentre.repaint();
		this.panelCentre.validate();
		this.pack();
	}

	@Override
	public void bonneReponse() {
		if (grChoix.getSelection().getActionCommand().equals("facile")){
			score ++;
		}
		
		majScore();
	}

	@Override
	public void mauvaiseReponse() {
		majScore();
	}
	
	private void majScore(){
		labScore.setText("Score: "+score);
	}
	
	
}
