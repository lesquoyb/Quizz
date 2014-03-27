package view;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import model.metier.Joueur;
import view.interfaces.IPanelTableJoueur;
import view.modelTable.ModelTableItem;
import view.modelTable.ModelTableJoueur;
import controller.CtrlJoueur;

public class PanelTableJoueur extends JPanel implements IPanelTableJoueur{




	private JButton btnSupprimerJoueur;
    private JButton btnValiderJoueur;
    private JScrollPane panScrollJoueur;
    private JTable tabJoueur;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
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
	        
	        controleurJoueur.setVue(this);
	        
	        jPanel3 = new JPanel();
	        jLabel7 = new JLabel();
	        jLabel8 = new JLabel();
	        mdp = new JTextField();
	        btnValiderJoueur = new JButton();
	        nom = new JTextField();
	        mail = new JTextField();
	        jLabel9 = new JLabel();
	        btnSupprimerJoueur = new JButton();

        tabJoueur.setModel(modelTable);
        panScrollJoueur.setViewportView(tabJoueur);

        jLabel7.setText("mail joueur");

        jLabel8.setText("mot de passe joueur");

        btnValiderJoueur.setText("Valider");
        btnValiderJoueur.setToolTipText("valide les informations entrées");
        btnValiderJoueur.addActionListener(controleurJoueur);

        jLabel9.setText("nom joueur");

        btnSupprimerJoueur.setText("Supprimer");
        btnSupprimerJoueur.setToolTipText("supprime la ligne selectionnée");
        btnSupprimerJoueur.addActionListener(controleurJoueur);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnValiderJoueur)
                        .addGap(118, 118, 118)
                        .addComponent(btnSupprimerJoueur))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mail, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mdp, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mdp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValiderJoueur)
                    .addComponent(btnSupprimerJoueur))
                .addGap(46, 46, 46))
        );

        GroupLayout panJoueurLayout = new GroupLayout(this);
        this.setLayout(panJoueurLayout);
        panJoueurLayout.setHorizontalGroup(
            panJoueurLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panJoueurLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panJoueurLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollJoueur, GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panJoueurLayout.setVerticalGroup(
            panJoueurLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panJoueurLayout.createSequentialGroup()
                .addGap(0, 433, Short.MAX_VALUE)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(panJoueurLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panJoueurLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollJoueur, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(196, Short.MAX_VALUE)))
        );
	}
	
	@Override
	public ArrayList<Joueur> getSelection() {
		int[] selected = tabJoueur.getSelectedRows();
		ArrayList<Joueur>listeRetour = new ArrayList<Joueur>();
		for (int i : selected){
			String mail_joueur = (String) tabJoueur.getValueAt(i, 0);
			String nom_joueur = (String) tabJoueur.getValueAt(i, 1);
			String mdp_joueur = (String) tabJoueur.getValueAt(i, 2);
			int code_joueur = (int) tabJoueur.getValueAt(i, 3);
			listeRetour.add(new Joueur(code_joueur,mail_joueur,nom_joueur,mdp_joueur));
		}
		return listeRetour;
	}
	
	
    @Override
	public void rafraichirTable() {
		// TODO Auto-generated method stub
		
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
