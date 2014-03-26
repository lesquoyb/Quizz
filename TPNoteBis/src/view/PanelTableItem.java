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

import model.metier.Item;
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
        btnSupprimerItem = new JButton();
        codeQuestion = new JTextField();
        codeQuizz = new JTextField();
        reponseJoueur = new JTextField();
        btnValiderItem = new JButton();

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

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeQuestion, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeQuizz, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reponseJoueur, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(btnValiderItem)
                        .addGap(118, 118, 118)
                        .addComponent(btnSupprimerItem)))
                .addContainerGap(358, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(codeQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeQuizz, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(reponseJoueur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValiderItem)
                    .addComponent(btnSupprimerItem))
                .addGap(36, 36, 36))
        );

        GroupLayout panItemLayout = new GroupLayout(this);
        this.setLayout(panItemLayout);
        panItemLayout.setHorizontalGroup(
            panItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panItemLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollItem, GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panItemLayout.setVerticalGroup(
            panItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panItemLayout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panItemLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panScrollItem, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
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


	@Override
	public ArrayList<Item> getSelection() {
		int[] selected = tabItem.getSelectedRows();
		ArrayList<Item>listeRetour = new ArrayList<Item>();
		for (int i : selected){
			int code_question = (int) tabItem.getValueAt(i, 0);
			int code_quizz = (int) tabItem.getValueAt(i, 1);
			String reponse_joueur = (String) tabItem.getValueAt(i, 2);
			listeRetour.add(new Item(code_question,code_quizz,reponse_joueur));
		}
		return listeRetour;
	}
	
	public String getCodeQuestion() {
		return this.codeQuestion.getText();
	}
	
	public String getCodeQuizz() {
		return this.codeQuizz.getText();
	}
	
	public String getReponseJoueur() {
		return this.reponseJoueur.getText();
	}
}
