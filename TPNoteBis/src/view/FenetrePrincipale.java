package view;

import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.interfaces.IFenetrePrincipale;
import controller.CtrlFenetrePrincipale;
import controller.CtrlFermeture;

public class FenetrePrincipale extends JFrame implements IFenetrePrincipale{

	
	private CtrlFermeture ctrlFermeture;
	private CtrlFenetrePrincipale controleur;
	private JTextField saisieCode;
	private JTextField saisiePass;
	private JButton bouton;
	
	public FenetrePrincipale(Connection c){

		controleur = new CtrlFenetrePrincipale();
		controleur.setVue(this);
		controleur.setConnection(c);
		
		saisieCode = new JTextField();
		saisiePass = new JTextField();
		bouton = new JButton("obtenir joueur");
		bouton.addActionListener(controleur);
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel,BoxLayout.PAGE_AXIS);
		panel.setLayout(layout);
		panel.add(saisieCode);
		panel.add(saisiePass);
		panel.add(bouton);
		this.add(panel);
		ctrlFermeture = new CtrlFermeture();
		this.addWindowListener(ctrlFermeture);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
	}

	@Override
	public String getSaisieNom() {
		return saisieCode.getText();
	}

	@Override
	public String getSaisiePass() {
		return saisiePass.getText();
	}
	

}
