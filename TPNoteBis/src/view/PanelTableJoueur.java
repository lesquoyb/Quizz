package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.metier.Joueur;
import view.interfaces.IPanelTableJoueur;
import view.modelTable.ModelTableJoueur;
import controller.CtrlJoueur;

public class PanelTableJoueur extends JPanel implements IPanelTableJoueur{




	private JButton btnSupprimerJoueur;
    private JButton btnValiderJoueur;
    private JScrollPane panScrollJoueur;
    private JTable tabJoueur;
    private JLabel labMail;
    private JLabel labMdp;
    private JLabel labNom;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JTextField mail;
    private JTextField mdp;
    private JTextField nom;
    private ModelTableJoueur modelTable;
    
	public PanelTableJoueur(CtrlJoueur controleurJoueur){
		
		modelTable = new ModelTableJoueur();
        panScrollJoueur = new JScrollPane();
        tabJoueur = new JTable();
        

        tabJoueur.setModel(modelTable);
        panScrollJoueur.setViewportView(tabJoueur);
        
        controleurJoueur.setVue(this);
        
        jPanel3 = new JPanel();
        labMail = new JLabel("mail joueur");
        labMdp = new JLabel("mot de passe joueur");
        labNom = new JLabel("nom joueur");
        mdp = new JTextField();
        btnValiderJoueur = new JButton();
        nom = new JTextField();
        mail = new JTextField();
        btnSupprimerJoueur = new JButton();

        btnValiderJoueur.setText("Valider");
        btnValiderJoueur.setToolTipText("valide les informations entrées");
        btnValiderJoueur.addActionListener(controleurJoueur);


        btnSupprimerJoueur.setText("Supprimer");
        btnSupprimerJoueur.setToolTipText("supprime la ligne selectionnée");
        btnSupprimerJoueur.addActionListener(controleurJoueur);
        initComposants();
	}
	
	  private void initComposants(){ 
   	   this.setLayout(new BorderLayout());
   	   JPanel panCentre = new JPanel();
   	panScrollJoueur.setPreferredSize(new Dimension(1200, 500));
   	   panCentre.add(panScrollJoueur);
   	   this.add(panCentre,BorderLayout.CENTER);
   	   
   	   JPanel panSud = new JPanel();
   	   
   	   nom.setPreferredSize(new Dimension(100,20));
   	   mail.setPreferredSize(new Dimension(200,20));
   	   mdp.setPreferredSize(new Dimension(150,20));
   	   panSud.setPreferredSize(new Dimension(this.getWidth()-4,110));
   	   JPanel interm = new JPanel();
   	   BoxLayout box = new BoxLayout(interm, BoxLayout.PAGE_AXIS);
   	   interm.setLayout(box);
   	   JPanel entrees = new JPanel();
   	   JPanel boutons = new JPanel();
   	   boutons.add(btnValiderJoueur);
   	   boutons.add(btnSupprimerJoueur);
   	   entrees.add(labNom);
   	   entrees.add(nom);
   	   entrees.add(labMail);
   	   entrees.add(mail);
   	   entrees.add(labMdp);
   	   entrees.add(mdp);
   	   interm.add(entrees);
   	   interm.add(boutons);
   	   JTabbedPane onglet = new JTabbedPane();
          onglet.addTab("Ajouter / Supprimer", null, interm, "saisir un élément à ajouter à la base de données ou selectionner dans le tableau un/des éléments à supprimer.");
   	   panSud.add(onglet);

       panCentre.setBackground(new Color(0x34393E));
       tabJoueur.getTableHeader().setBackground(new Color(0xFF5B2B));
       panSud.setBackground(new Color(0x34393E));
   	   this.add(panSud,BorderLayout.SOUTH);
	  }
   	   
	
	@Override
	public ArrayList<Joueur> getSelection() {
		int[] selected = tabJoueur.getSelectedRows();
		ArrayList<Joueur>listeRetour = new ArrayList<Joueur>();
		for (int i : selected){
			String mail_joueur = (String) tabJoueur.getValueAt(i, 2);
			String nom_joueur = (String) tabJoueur.getValueAt(i, 1);
			String mdp_joueur = (String) tabJoueur.getValueAt(i, 3);
			int code_joueur = (int) tabJoueur.getValueAt(i, 0);
			listeRetour.add(new Joueur(code_joueur,mail_joueur,nom_joueur,mdp_joueur));
		}
		return listeRetour;
	}
	
	


	@Override
	public void viderChamps() {
		mail.setText("");;
	    mdp.setText("");;
	    nom.setText("");;
		
	}

	@Override
	public JTable getTable() {
		return tabJoueur;
	}

	@Override
	public String getNomJoueur() {
		return nom.getText();
	}

	@Override
	public String getMdpJoueur() {
		return mdp.getText();
	}

	@Override
	public String getMailJoueur() {
		return mail.getText();
	}

	@Override
	public ModelTableJoueur getModel() {
		return modelTable;
	}
	
	
}
