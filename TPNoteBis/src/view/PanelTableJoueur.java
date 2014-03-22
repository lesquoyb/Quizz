package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import view.interfaces.IPanelTableJoueur;
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
    
	public PanelTableJoueur(CtrlJoueur controleurJoueur){
	        panScrollJoueur = new JScrollPane();
	        tabJoueur = new JTable();
	        jPanel3 = new JPanel();
	        jLabel7 = new JLabel();
	        jLabel8 = new JLabel();
	        mdp = new JTextField();
	        btnValiderJoueur = new JButton();
	        nom = new JTextField();
	        mail = new JTextField();
	        jLabel9 = new JLabel();
	        btnSupprimerJoueur = new JButton();

        tabJoueur.setModel(new ModelTableJoueur());
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnValiderJoueur)
                        .addGap(118, 118, 118)
                        .addComponent(btnSupprimerJoueur))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mdp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValiderJoueur)
                    .addComponent(btnSupprimerJoueur))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout panJoueurLayout = new javax.swing.GroupLayout(this);
        this.setLayout(panJoueurLayout);
        panJoueurLayout.setHorizontalGroup(
            panJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panJoueurLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollJoueur, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panJoueurLayout.setVerticalGroup(
            panJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panJoueurLayout.createSequentialGroup()
                .addGap(0, 433, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panJoueurLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(196, Short.MAX_VALUE)))
        );
	}
	
	
    @Override
	public void rafraichirTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JTable getTable() {
		return tabJoueur;
	}
	
	
}
