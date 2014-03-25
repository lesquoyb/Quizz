
package view;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.interfaces.IFenetreGestion;
import controller.CtrlFermeture;
import controller.CtrlItem;
import controller.CtrlJoueur;
import controller.CtrlQuestion;
import controller.CtrlQuizz;
import controller.CtrlRequetes;


/**
 *
 * @author baptiste
 */
public class FenetreGestion extends JFrame implements IFenetreGestion {

	private CtrlItem controleurItem;
	private CtrlJoueur controleurJoueur;
	private CtrlQuizz controleurQuizz;
	private CtrlQuestion controleurQuestion;
	private CtrlRequetes controleurRequetes;
    private JTabbedPane onglets;
    private PanelTableItem panItem;
    private PanelTableJoueur panJoueur;
    private PanelTableQuestion panQuestion;
    private PanelTableQuizz panQuizz;
    private PanelRequetes panRequetes;
    private Connection connection;
    private CtrlFermeture ctrlFermeture;
	
    public FenetreGestion(Connection con) throws ClassNotFoundException, SQLException {

		ctrlFermeture = new CtrlFermeture();
		this.addWindowListener(ctrlFermeture);
    	connection = con;
        initComponents();
        majTableaux();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


	private void initComponents() throws ClassNotFoundException, SQLException {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        onglets = new JTabbedPane();
        
        controleurRequetes = new CtrlRequetes();
        
        controleurQuestion = new CtrlQuestion();
    	controleurQuestion.setVue(panQuestion);
        controleurItem = new CtrlItem(connection);
        controleurItem.setVue(panItem);
        controleurJoueur = new CtrlJoueur();
        controleurJoueur.setVue(panJoueur);
        controleurQuizz = new CtrlQuizz();
        controleurQuizz.setVue(panQuizz);

        
        
        panQuizz = new PanelTableQuizz(controleurQuizz);
        panItem = new PanelTableItem(controleurItem);
        panJoueur = new PanelTableJoueur(controleurJoueur);
        panQuestion = new PanelTableQuestion(controleurQuestion);
        panRequetes = new PanelRequetes(controleurRequetes);
        
        controleurRequetes.setVue(panRequetes);



        onglets.addTab("Quizz", null, panQuizz, "gestion des quizz");
        onglets.addTab("Items", null, panItem, "gestion des items");
        onglets.addTab("Joueurs", null, panJoueur, "gestion des joueurs");
        onglets.addTab("Questions", null, panQuestion, "gestion des questions");
        onglets.addTab("Requetes", null, panRequetes, "recherche dans la base");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onglets)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onglets)
                .addContainerGap())
        );

        onglets.getAccessibleContext().setAccessibleName("");
        onglets.getAccessibleContext().setAccessibleDescription("gestion des quizz");


    	
        pack();
    }




	@Override
	public void majTableaux() {
		panItem.rafraichirTable();
		panJoueur.rafraichirTable();
		panQuestion.rafraichirTable();
		panQuizz.rafraichirTable();
	}

	
	
 


 

}
