package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.interfaces.IAuthent;
import controller.CtrlAuthent;

/**
 * Fenetre permettant d'authentifier un joueur.
 * @author baptiste
 *
 */
public class FenetreAuthent extends JFrame implements IAuthent {

	private CtrlAuthent controleur;
	private JLabel labNom;
	private JLabel labMdp;
	private JTextField saisieNom;
	private JPasswordField saisieMdp;
	private JButton valider;
	
	public FenetreAuthent(Connection c){
	
		controleur = new CtrlAuthent();
		controleur.setVue(this);
		controleur.setConnection(c);
		valider =new JButton("Se connecter");
		valider.setPreferredSize(new Dimension(100,40));
		valider.addActionListener(controleur);
		labNom= new JLabel("Nom:");
		labMdp = new JLabel("Mot de passe:");
		saisieNom = new JTextField();
		saisieNom.setPreferredSize(new Dimension(75, 40));
		saisieMdp = new JPasswordField();
		saisieMdp.setPreferredSize(new Dimension(75, 40));
		JPanel pan1 = new JPanel(new FlowLayout());
		JPanel pan2 = new JPanel(new FlowLayout());
		pan1.add(labNom);
		pan1.add(saisieNom);
		pan2.add(labMdp);
		pan2.add(saisieMdp);
		
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
		this.add(pan1);
		this.add(pan2);
		this.add(valider);
		this.setSize(500, 400);
		this.getRootPane().setDefaultButton(valider);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public String getNom() {
		return saisieNom.getText();
	}

	@Override
	public String getMdp() {
		return String.valueOf(saisieMdp.getPassword());
	}

	@Override
	public void fermer() {
		this.dispose();
	}

	
	
}
