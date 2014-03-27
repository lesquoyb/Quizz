package view;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import model.metier.Question;
import view.interfaces.IPanelTableQuestion;
import view.modelTable.ModelTableQuestion;
import controller.CtrlQuestion;

public class PanelTableQuestion extends JPanel implements IPanelTableQuestion{

	private JPanel panelSaisie;
	private JScrollPane panScroll;
	private JButton btnValiderQuestion;
	private JButton btnSupprimerQuestion;
	private JTextArea texte;
	private JTextField reponseQuestion;
	private JScrollPane scrollTexte;
	private JTable tabQuestion;
	
	private ModelTableQuestion modelTable;
	
	public PanelTableQuestion(CtrlQuestion controleur){
		
        modelTable = new ModelTableQuestion();
		controleur.setVue(this);
		tabQuestion = new JTable(modelTable);
		scrollTexte = new JScrollPane();
		texte = new JTextArea();
		texte.setColumns(5);
		texte.setRows(20);
		texte.setWrapStyleWord(true);
		scrollTexte.setViewportView(texte);
		panelSaisie = new JPanel();
		panScroll = new JScrollPane();
		reponseQuestion = new JTextField();
        JLabel label = new JLabel("énoncé de la question:");
        JLabel jLabel11 = new JLabel("réponse");
        btnSupprimerQuestion = new JButton();
        btnValiderQuestion = new JButton();
        

        

        btnValiderQuestion.setText("Valider");
        btnValiderQuestion.setToolTipText("valide les informations entrées");
        btnValiderQuestion.addActionListener(controleur);

        btnSupprimerQuestion.setText("Supprimer");
        btnSupprimerQuestion.setToolTipText("supprime la ligne selectionnée");
        btnSupprimerQuestion.addActionListener(controleur);
        
        panelSaisie.add(scrollTexte);

        GroupLayout panelSaisieLayout = new GroupLayout(panelSaisie);
        panelSaisie.setLayout(panelSaisieLayout);
        
       ParallelGroup groupPara = panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.TRAILING);
       SequentialGroup seqHoriz1 = panelSaisieLayout.createSequentialGroup();
       seqHoriz1.addComponent(btnValiderQuestion);
       seqHoriz1.addGap(76, 76, 76);
       
       SequentialGroup seqHoriz2 = panelSaisieLayout.createSequentialGroup();
       
       
       seqHoriz2.addComponent(label);
       seqHoriz2.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
       seqHoriz2.addComponent(scrollTexte, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE);
       seqHoriz2.addGap(58, 58, 58);
       
       groupPara.addGroup(seqHoriz1);
       groupPara.addGroup(seqHoriz2);
       

       SequentialGroup seqGroup =  panelSaisieLayout.createSequentialGroup();
       seqGroup.addComponent(jLabel11);
       seqGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
       seqGroup.addComponent(reponseQuestion, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE);
       
       ParallelGroup groupPara2 = panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.TRAILING);
       groupPara2.addComponent(btnSupprimerQuestion, GroupLayout.Alignment.TRAILING);
       groupPara2.addGroup(GroupLayout.Alignment.TRAILING,seqGroup);
       
       
       SequentialGroup sequHoriz = panelSaisieLayout.createSequentialGroup();
       sequHoriz.addGap(116, 116, 116);
       sequHoriz.addGroup(groupPara) ;
       sequHoriz.addGroup(groupPara2);
       sequHoriz.addContainerGap(361, Short.MAX_VALUE);

       
        ParallelGroup groupHoriz = panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        groupHoriz.addGroup(sequHoriz);
        
        panelSaisieLayout.setHorizontalGroup(groupHoriz);
       
        panelSaisieLayout.setVerticalGroup(
            panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelSaisieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label)
                    .addGroup(panelSaisieLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(reponseQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(scrollTexte, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
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
	        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
	}
	
	@Override
	public void viderChamps() {
		texte.setText("");
		reponseQuestion.setText("");
		
	}

	public void supSelect(){
		int[] selectionne = tabQuestion.getSelectedRows();
		DefaultTableModel model = 	(DefaultTableModel) tabQuestion.getModel();
		for(int i : selectionne){
			model.removeRow(i);
		}	
	}


	@Override
	public JTable getTable() {
		return tabQuestion;
	}

	@Override
	public ArrayList<Question> getSelection() {
		int[] selected = tabQuestion.getSelectedRows();
		ArrayList<Question>listeRetour = new ArrayList<Question>();
		for (int i : selected){
			int code = (int) modelTable.getValueAt(i, 0);
			String texte = (String) tabQuestion.getValueAt(i, 1);
			String reponse = (String) tabQuestion.getValueAt(i, 2);
			listeRetour.add(new Question(code,texte,reponse));
		}
		return listeRetour;
	}

	@Override
	public String getTexte() {
		return this.texte.getText();
	}

	@Override
	public String getReponse() {
		return this.reponseQuestion.getText();
	}

	@Override
	public ModelTableQuestion getModel() {
		return modelTable;
	}
	
	
}
