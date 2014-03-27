package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.CtrlConnection;
import model.dao.MaConnection;
import view.interfaces.IChangementConnection;

/**
 * Dialogue permettant de regler la connection si elle a échouée.
 * @author baptiste
 *
 */
public class DialogChangementConnection  extends JDialog implements IChangementConnection{

	private JTextField adresse;
	private JTextField base;
	private JTextField id;
	private JPasswordField mdp;
	private JTextField nomDriver;
	private JOptionPane optionPane;
	
	

	public DialogChangementConnection(){	
		this.setModal(true);
		this.setTitle("configuration de la connection");
		adresse= new JTextField(MaConnection.getAdresse());
		adresse.setPreferredSize(new Dimension(175,30));
		base = new JTextField(MaConnection.getBase());
		base.setPreferredSize(new Dimension(175,30));
		id = new JTextField(MaConnection.getUtilisateur());
		id.setPreferredSize(new Dimension(175,30));
		mdp= new JPasswordField(MaConnection.getMotDePasse());
		mdp.setPreferredSize(new Dimension(175,30));
		nomDriver= new JTextField(MaConnection.getNomDriver());
		nomDriver.setPreferredSize(new Dimension(175,30));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JPanel panAdr = new JPanel(new FlowLayout());
		panAdr.add(new JLabel("adresse: "));
		panAdr.add(adresse);
		JPanel panBase = new JPanel(new FlowLayout());
		panBase.add(new JLabel("base de données: "));
		panBase.add(base);
		JPanel panId= new JPanel(new FlowLayout());
		panId.add(new JLabel("Identifiant: "));
		panId.add(id);
		JPanel panMdp = new JPanel(new FlowLayout());
		panMdp.add(new JLabel("mot de passe: "));
		panMdp.add(mdp);
		JPanel panNomDriver = new JPanel(new FlowLayout());
		panNomDriver.add(new JLabel("nom driver: "));
		panNomDriver.add(nomDriver);
		
		panel.add(panAdr);
		panel.add(panBase);
		panel.add(panId);
		panel.add(panMdp);
		panel.add(panNomDriver);
		JPanel panelBouton = new JPanel(new FlowLayout());
		JButton annuler = new JButton("Annuler");
		JButton ok = new JButton("OK");
		ok.setActionCommand("ok");
		annuler.setActionCommand("annuler");
		ok.addActionListener(new CtrlConnection(this));
		annuler.addActionListener(new CtrlConnection(this));
		panelBouton.add(ok);
		panelBouton.add(annuler);
		
		panel.add(panelBouton);
		this.getRootPane().setDefaultButton(ok);
        this.add(panel);
        this.setSize(400,400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	
	@Override
	public void fermer() {
		this.dispose();
	}


	@Override
	public String getAdresse() {
		return adresse.getText();
	}

	@Override
	public String getBase() {
		return base.getText();
	}

	@Override
	public String getIdentifiant() {
		return id.getText();
	}

	@Override
	public String getMotDePasse() {
		return String.valueOf(mdp.getPassword());
	}

	@Override
	public void setAdresse(String adresse) {
		this.adresse.setText(adresse);		
	}

	@Override
	public void setBase(String base) {
		this.base.setText(base);
		
	}

	@Override
	public void setIdentifiant(String id) {
		this.id.setText(id);
		
	}

	@Override
	public void setMotDePasse(String mdp) {
		this.mdp.setText(mdp);
		
	}


	@Override
	public String getNomDriver() {
		return nomDriver.getText();
	}


	@Override
	public void setNomDriver(String nom) {
		this.nomDriver.setText(nom);
		
	}

	
	
}
