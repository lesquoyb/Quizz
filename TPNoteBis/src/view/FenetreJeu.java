package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.Box;
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
	private JPanel panConteneurCentre;
	private JPanel panelBas;
	private CtrlFermeture ctrlFermeture;
	private int scoreNecessaire;
	
	
	public FenetreJeu(Connection connection,Joueur joueur){
		
		this.setTitle("Quizzator");
		questionEnCours ="";
		controleur = new CtrlJeu();
		controleur.setJoueur(joueur);
		controleur.setVue(this);
		controleur.setConnection(connection);
		
		
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
		question.setEnabled(true);
		question.setSize(new Dimension(100,100));
		question.setForeground(Color.black);
		
		panelHaut.add(labScore);
		panelCentre.add(question);
		JPanel panRep = new JPanel();
		panRep.setLayout(new FlowLayout());
		panRep.add(reponse);
		panelCentre.add(panRep);
		panelCentre.setPreferredSize(new Dimension(600,200));
		panelBas.add(valider);
		panConteneurCentre= new JPanel(new FlowLayout());
		panConteneurCentre.add(panelCentre);
		panConteneurCentre.setPreferredSize(new Dimension(500,300));
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
		this.add(panelHaut);
		this.add(panConteneurCentre);
		this.add(panelBas);
		this.setLocationRelativeTo(null);
		ctrlFermeture = new CtrlFermeture();
		this.addWindowListener(ctrlFermeture);

		afficherSelection();
		this.setSize(new Dimension(700,500));
		this.setVisible(true);

		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Affiche le menu de selection des niveaux.
	 */
	@Override
	public void afficherSelection(){
		
		score = 0;
		majScore();

		this.panelCentre.removeAll();
		panConteneurCentre.setBackground(new Color(0xFFDA8C));
		panelBas.setBackground(new Color(0xFFDA8C));
		panelHaut.setBackground(new Color(0xFFDA8C));
		this.panelCentre.setLayout(new BoxLayout(panelCentre,BoxLayout.LINE_AXIS));
		
		JLabel selection = new JLabel("Selectionnez un mode de jeu: ");
		grChoix = new ButtonGroup();
		JRadioButton facile = new JRadioButton("Facile (10 questions, 5 points pour gagner) victoire = 1");
		JRadioButton moyen = new JRadioButton("Moyen (15 questions, 21 points pour gagner) victoire = 3 , defaite = - 1");
		JRadioButton difficile = new JRadioButton("Difficile (15 questions, 30 points pour gagner) victoire = 5 , defaite = - 5");

		
		Box panneauRadio = Box.createVerticalBox();
		
		facile.setBackground(new Color(0x8CC6D7));
		moyen.setBackground(new Color(0x8CC6D7));
		difficile.setBackground(new Color(0x8CC6D7));

		facile.setActionCommand("facile");
		moyen.setActionCommand("moyen");
		difficile.setActionCommand("difficile");

		facile.setSelected(true);
		grChoix.add(facile);
		grChoix.add(moyen);
		grChoix.add(difficile);
		panneauRadio.add(facile);
		panneauRadio.add(moyen);
		panneauRadio.add(difficile);
		panneauRadio.setBackground(new Color(0x8CC6D7));
		panelCentre.add(selection);
		panelCentre.add(panneauRadio);

		
		valider.setActionCommand("difficulte");
		this.getRootPane().setDefaultButton(valider);
		panelCentre.setBackground(new Color(0xFF5B2B));
		this.panelCentre.repaint();		
		this.panelCentre.validate();

		panConteneurCentre.repaint();
		panConteneurCentre.validate();
	}
	
	@Override
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
		question.setBackground(new Color(0x8CC6D7));
		question.setFont(new Font("Helvetica",Font.BOLD,15));

		panelCentre.add(question);
		JPanel panRep = new JPanel();
		panRep.setLayout(new FlowLayout());
		panRep.add(reponse);
		panRep.setBackground(new Color(0x8CC6D7));
		panelCentre.add(panRep);
		reponse.requestFocus();
		
		
		
		valider.setActionCommand("valider"+numero);
		panelCentre.setBackground(Color.white);
		this.panelCentre.repaint();
		this.panelCentre.validate();

		panConteneurCentre.repaint();
		panConteneurCentre.validate();
	}

	@Override
	public void bonneReponse() {
		if (grChoix.getSelection().getActionCommand().equals("facile")){
			score ++;
		}
		else if (grChoix.getSelection().getActionCommand().equals("moyen")){
			score += 3;
		}		
		else if (grChoix.getSelection().getActionCommand().equals("difficile")){
			score +=5;
		}
		
		majScore();
	}

	@Override
	public void mauvaiseReponse() {
		if (grChoix.getSelection().getActionCommand().equals("moyen")){
			score -= 1;
		}		
		else if (grChoix.getSelection().getActionCommand().equals("difficile")){
			score -= 5;
		}
		majScore();
	}
	
	private void majScore(){
		labScore.setText("Score: "+score);
	}

	@Override
	public void victoire() {
		this.panelCentre.removeAll();
		panelCentre.add(new JLabel("Bravo vous avez gagné "));

		panelCentre.setBackground(new Color(0xFF5B2B));
		valider.setActionCommand("fin");

		panConteneurCentre.repaint();
		panConteneurCentre.validate();
		this.panelCentre.repaint();
		this.panelCentre.validate();
	}

	@Override
	public void defaite() {

		this.panelCentre.removeAll();
		panelCentre.add(new JLabel("Vous avez perdu, retentez votre chance"));

		panelCentre.setBackground(new Color(0xFF5B2B));
		valider.setActionCommand("fin");

		panConteneurCentre.repaint();
		panConteneurCentre.validate();
		this.panelCentre.repaint();
		this.panelCentre.validate();
	}

	@Override
	public int getScore() {
		return score;
	}
	
	
	
	
	
	
	
}
