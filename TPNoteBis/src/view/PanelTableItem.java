package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import view.interfaces.IPanelTableItem;
import view.modelTable.ModelTableItem;
import controller.CtrlItem;

public class PanelTableItem extends JPanel implements IPanelTableItem{

	



	private JButton btnSupprimerItem;
    private JButton btnValiderItem;
    private JTextField codeQuestion;
    private JTextField codeQuizz;
    private JScrollPane panScrollItem;
    private JTextField reponseJoueur;
    private JTable tabItem;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel2;
	
	public PanelTableItem(CtrlItem controleurItem	){
		
        panScrollItem = new JScrollPane();
        tabItem = new JTable();

        jPanel2 = new JPanel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        btnSupprimerItem = new javax.swing.JButton();
        codeQuestion = new javax.swing.JTextField();
        codeQuizz = new javax.swing.JTextField();
        reponseJoueur = new javax.swing.JTextField();
        btnValiderItem = new javax.swing.JButton();

        this.btnSupprimerItem.addActionListener(controleurItem);
        tabItem.setModel(new ModelTableItem());
        
        panScrollItem.setViewportView(tabItem);

        jLabel4.setText("reponse");

        jLabel5.setText("code quizz");

        jLabel6.setText("code question");

        btnSupprimerItem.setText("Supprimer");
        btnSupprimerItem.setToolTipText("supprime la ligne selectionnée");

        btnValiderItem.setText("Valider");
        btnValiderItem.setToolTipText("valide les informations entrées");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeQuizz, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reponseJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(btnValiderItem)
                        .addGap(118, 118, 118)
                        .addComponent(btnSupprimerItem)))
                .addContainerGap(358, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeQuizz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reponseJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValiderItem)
                    .addComponent(btnSupprimerItem))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout panItemLayout = new javax.swing.GroupLayout(this);
        this.setLayout(panItemLayout);
        panItemLayout.setHorizontalGroup(
            panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panItemLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollItem, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panItemLayout.setVerticalGroup(
            panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panItemLayout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panItemLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollItem, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(196, Short.MAX_VALUE)))
        );
	}
	
	
    @Override
	public void rafraichirTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JTable getTable() {
		return tabItem;
	}
}
