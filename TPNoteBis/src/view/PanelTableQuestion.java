package view;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import view.interfaces.IPanelTableQuestion;
import view.modelTable.ModelTableQuestion;
import controller.CtrlQuestion;

public class PanelTableQuestion extends JPanel implements IPanelTableQuestion{

	private JPanel panelSaisie;
	private JScrollPane panScroll;
	private JButton btnValiderQuestion;
	private JButton btnSupprimerQuestion;
	private JScrollPane scrollPane;
	private JTextArea texte;
	private JTextField reponseQuestion;
	private JScrollPane scrollTexte;
	private JTable tabQuestion;
	
	public PanelTableQuestion(CtrlQuestion controleur){
		tabQuestion = new JTable(new ModelTableQuestion());
		scrollTexte = new JScrollPane();
		texte = new JTextArea();
		texte.setColumns(5);
		texte.setRows(20);
		scrollTexte.setViewportView(texte);
		panelSaisie = new JPanel();
		panScroll = new JScrollPane();
		reponseQuestion = new JTextField();
        JLabel label = new JLabel("énoncé de la question:");
        JLabel jLabel11 = new JLabel("réponse");
        btnSupprimerQuestion = new JButton();
        btnValiderQuestion = new JButton();
        scrollPane = new JScrollPane();
        

        btnValiderQuestion.setText("Valider");
        btnValiderQuestion.setToolTipText("valide les informations entrées");
        btnValiderQuestion.addActionListener(controleur);

        btnSupprimerQuestion.setText("Supprimer");
        btnSupprimerQuestion.setToolTipText("supprime la ligne selectionnée");
        btnSupprimerQuestion.addActionListener(controleur);
        
        
        GroupLayout panelSaisieLayout = new GroupLayout(panelSaisie);
        panelSaisie.setLayout(panelSaisieLayout);
        panelSaisieLayout.setHorizontalGroup(
            panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelSaisieLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSaisieLayout.createSequentialGroup()
                        .addComponent(btnValiderQuestion)
                        .addGap(76, 76, 76))
                    .addGroup(panelSaisieLayout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addGroup(panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnSupprimerQuestion, GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelSaisieLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reponseQuestion, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(361, Short.MAX_VALUE))
        );
        panelSaisieLayout.setVerticalGroup(
            panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelSaisieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label)
                    .addGroup(panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(reponseQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValiderQuestion)
                    .addComponent(btnSupprimerQuestion))
                .addContainerGap(25, Short.MAX_VALUE))
        );

		
		  GroupLayout panQuestionLayout = new GroupLayout(this);
	        this.setLayout(panQuestionLayout);
	        panQuestionLayout.setHorizontalGroup(
	            panQuestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(panQuestionLayout.createSequentialGroup()
	                .addGap(10, 10, 10)
	                .addGroup(panQuestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(panScroll)
	                    .addComponent(panelSaisie,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        panQuestionLayout.setVerticalGroup(
	            panQuestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(panQuestionLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(panScroll, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(panelSaisie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap()));

	        panScroll.setViewportView(tabQuestion);
	        panelSaisie.add(scrollTexte);
	        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
	}
	
	public void supSelect(){
		int[] selectionne = tabQuestion.getSelectedRows();
		DefaultTableModel model = 	(DefaultTableModel) tabQuestion.getModel();
		for(int i : selectionne){
			model.removeRow(i);
		}	
	}

	@Override
	public void rafraichirTable() {
		
	}

	@Override
	public JTable getTable() {
		return tabQuestion;
	}
	
	
}
