
package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.CtrlFermeture;
import controller.CtrlItem;
import controller.CtrlJoueur;
import controller.CtrlQuestion;
import controller.CtrlQuizz;
import controller.CtrlRequetes;


/**
 *	Fenetre Principale du logiciel de gestion des bases de données.
 * @author baptiste
 */
public class FenetreGestion extends JFrame {

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

    	this.setTitle("Outil de gestion de quizz");
		ctrlFermeture = new CtrlFermeture();
		this.addWindowListener(ctrlFermeture);
    	connection = con;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


	private void initComponents() throws ClassNotFoundException, SQLException {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(new Color(0xFFDA8C));
        
        onglets = new JTabbedPane();
        
        
        controleurRequetes = new CtrlRequetes();
        
        controleurQuestion = new CtrlQuestion(connection);

        controleurItem = new CtrlItem(connection);

        controleurJoueur = new CtrlJoueur(connection);

        controleurQuizz = new CtrlQuizz(connection);


        
        
        panQuizz = new PanelTableQuizz(controleurQuizz);
        panQuizz.setBackground(new Color(0x34393E));
        panItem = new PanelTableItem(controleurItem);
        panJoueur = new PanelTableJoueur(controleurJoueur);
        panQuestion = new PanelTableQuestion(controleurQuestion);
        panRequetes = new PanelRequetes(controleurRequetes);
        
        
        controleurRequetes.setVue(panRequetes);
    	controleurQuestion.setVue(panQuestion);
        controleurItem.setVue(panItem);
        controleurJoueur.setVue(panJoueur);
        controleurQuizz.setVue(panQuizz);
        



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



 

}
