
package view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.DAOItem;
import model.dao.MaConnection;
import model.metier.Item;
import view.interfaces.IFenetreGestion;
import view.modelTable.ModelTableItem;
import controller.CtrlItem;
import controller.CtrlJoueur;
import controller.CtrlQuestion;
import controller.CtrlQuizz;


/**
 *
 * @author baptiste
 */
public class FenetreGestion extends JFrame implements IFenetreGestion {

	private CtrlItem controleurItem;
	private CtrlJoueur controleurJoueur;
	private CtrlQuizz controleurQuizz;
	private CtrlQuestion controleurQuestion;
	

    public FenetreGestion() {

    	controleurQuestion = new CtrlQuestion();
    	controleurQuestion.setVue(this);
        controleurItem = new CtrlItem();
        controleurItem.setVue(this);
        controleurJoueur = new CtrlJoueur();
        controleurJoueur.setVue(this);
        controleurQuizz = new CtrlQuizz();
        controleurQuizz.setVue(this);
        
        initComponents();
        majTabItem();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    
    
    @Override
	public JTable getTableItem() {
		return tabItem;
	}


    


	@Override
	public void majTabItem() {
		try {
			DAOItem i = new DAOItem(MaConnection.getInstance());
			DefaultTableModel model = (DefaultTableModel) tabItem.getModel();
			for(Item item : i.listeItem()){
				model.addRow(new String[]{String.valueOf(item.getCodeQuestion()),String.valueOf(item.getCodeQuizz()),item.getReponseJoueur()});
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}

	



	@Override
	public void supQuizzSelect() {
		int[] selectionne = tabQuizz.getSelectedRows();
		DefaultTableModel model = 	(DefaultTableModel) tabQuizz.getModel();
		for(int i : selectionne){
			model.removeRow(i);
		}
	}




	@Override
	public void supItemSelect() {
		int[] selectionne = tabItem.getSelectedRows();
		DefaultTableModel model = 	(DefaultTableModel) tabItem.getModel();
		for(int i : selectionne){
			model.removeRow(i);
		}	
	}



	@Override
	public void supQuestionSelect() {
		panQuestion.supSelect();
	
	}




	@Override
	public void supJoueurSelect() {
		int[] selectionne = tabJoueur.getSelectedRows();
		DefaultTableModel model = 	(DefaultTableModel) tabJoueur.getModel();
		for(int i : selectionne){
			model.removeRow(i);
		}			
	}




	private void initComponents() {

        onglets = new javax.swing.JTabbedPane();
        panQuizz = new javax.swing.JPanel();
     
        panItem = new PanelTableItem(controleurItem);

        panJoueur = new PanelTableJoueur(controleurJoueur);

   
        panQuestion = new PanelTableQuestion(controleurQuestion);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        onglets.addTab("Quizz", null, panQuizz, "gestion des quizz");
        
        onglets.addTab("Items", null, panItem, "gestion des items");


        onglets.addTab("Joueurs", null, panJoueur, "gestion des joueurs");




      

        onglets.addTab("Questions", null, panQuestion, "gestion des questions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onglets)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onglets)
                .addContainerGap())
        );

        onglets.getAccessibleContext().setAccessibleName("");
        onglets.getAccessibleContext().setAccessibleDescription("gestion des quizz");

        pack();
    }

 


    // Variables declaration - do not modify//GEN-BEGIN:variables
 
    private javax.swing.JTabbedPane onglets;
    private PanelTableItem panItem;
    private PanelTableJoueur panJoueur;
    private PanelTableQuestion panQuestion;
    private javax.swing.JPanel panQuizz;
    // End of variables declaration//GEN-END:variables
}
