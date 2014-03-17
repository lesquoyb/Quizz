
package view;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.DAOItem;
import model.dao.MaConnection;
import model.metier.Item;
import view.interfaces.IFenetreGestion;
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
	
    /**
     * Creates new form NewJFrame
     */
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
        this.btnSupprimerItem.addActionListener(controleurItem);
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




	private void initComponents() {

        onglets = new javax.swing.JTabbedPane();
        panQuizz = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabQuizz = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnValider = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        date = new javax.swing.JTextField();
        nbQuestion = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panItem = new javax.swing.JPanel();
        panScrollItem = new javax.swing.JScrollPane();
        tabItem = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSupprimerItem = new javax.swing.JButton();
        codeQuestion = new javax.swing.JTextField();
        codeQuizz = new javax.swing.JTextField();
        reponseJoueur = new javax.swing.JTextField();
        btnValiderItem = new javax.swing.JButton();
        panJoueur = new javax.swing.JPanel();
        panScrollJoueur = new javax.swing.JScrollPane();
        tabJoueur = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mdp = new javax.swing.JTextField();
        btnValiderJoueur = new javax.swing.JButton();
        nom = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnSupprimerJoueur = new javax.swing.JButton();
        panQuestion = new javax.swing.JPanel();
        panScrollQuestion = new javax.swing.JScrollPane();
        tabQuestion = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        reponseQuestion = new javax.swing.JTextField();
        btnValiderQuestion = new javax.swing.JButton();
        btnSupprimerQuestion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        texte = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabQuizz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {  },
            new String [] {
                "code_quizz", "date_quizz", "nb_question_quizz", "code_joueur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabQuizz.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabQuizz);

        btnValider.setText("Valider");
        btnValider.setToolTipText("valide les informations entrés");
        btnValider.addActionListener(controleurQuizz);

        btnSupprimer.setText("Supprimer");
        btnSupprimer.setToolTipText("supprime la ligne selectionnée");
        btnSupprimer.addActionListener(controleurQuizz);

        jLabel1.setText("date");

        jLabel2.setText("nombre de questions");

        jLabel3.setText("numero joueur");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(btnValider)
                        .addGap(118, 118, 118)
                        .addComponent(btnSupprimer)))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValider)
                    .addComponent(btnSupprimer))
                .addContainerGap())
        );

        javax.swing.GroupLayout panQuizzLayout = new javax.swing.GroupLayout(panQuizz);
        panQuizz.setLayout(panQuizzLayout);
        panQuizzLayout.setHorizontalGroup(
            panQuizzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panQuizzLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panQuizzLayout.setVerticalGroup(
            panQuizzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panQuizzLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        onglets.addTab("Quizz", null, panQuizz, "gestion des quizz");

        tabItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {             },
            new String [] {
                "code_question", "code_quizz", "reponse_joueur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panScrollItem.setViewportView(tabItem);

        jLabel4.setText("reponse");

        jLabel5.setText("code quizz");

        jLabel6.setText("code question");

        btnSupprimerItem.setText("Supprimer");
        btnSupprimerItem.setToolTipText("supprime la ligne selectionnÃ©e");

        btnValiderItem.setText("Valider");
        btnValiderItem.setToolTipText("valide les informations entrÃ©s");

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

        javax.swing.GroupLayout panItemLayout = new javax.swing.GroupLayout(panItem);
        panItem.setLayout(panItemLayout);
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

        onglets.addTab("Items", null, panItem, "gestion des items");

        tabJoueur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {        },
            new String [] {
                "code_joueur", "nom_joueur", "mail_joueur", "passwd_joueur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        javax.swing.GroupLayout panJoueurLayout = new javax.swing.GroupLayout(panJoueur);
        panJoueur.setLayout(panJoueurLayout);
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

        onglets.addTab("Joueurs", null, panJoueur, "gestion des joueurs");

        tabQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {     },
            new String [] {
                "code_question", "texte_question", "reponse_question"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panScrollQuestion.setViewportView(tabQuestion);

        jLabel10.setText("énoncé de la question:");

        jLabel11.setText("réponse");

        btnValiderQuestion.setText("Valider");
        btnValiderQuestion.setToolTipText("valide les informations entrées");
        btnValiderQuestion.addActionListener(controleurQuestion);

        btnSupprimerQuestion.setText("Supprimer");
        btnSupprimerQuestion.setToolTipText("supprime la ligne selectionnée");
        btnSupprimerQuestion.addActionListener(controleurQuestion);

        texte.setColumns(20);
        texte.setRows(5);
        jScrollPane2.setViewportView(texte);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnValiderQuestion)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSupprimerQuestion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reponseQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(361, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reponseQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValiderQuestion)
                    .addComponent(btnSupprimerQuestion))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panQuestionLayout = new javax.swing.GroupLayout(panQuestion);
        panQuestion.setLayout(panQuestionLayout);
        panQuestionLayout.setHorizontalGroup(
            panQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panQuestionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panScrollQuestion)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panQuestionLayout.setVerticalGroup(
            panQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panQuestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panScrollQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JButton btnSupprimerItem;
    private javax.swing.JButton btnSupprimerJoueur;
    private javax.swing.JButton btnSupprimerQuestion;
    private javax.swing.JButton btnValider;
    private javax.swing.JButton btnValiderItem;
    private javax.swing.JButton btnValiderJoueur;
    private javax.swing.JButton btnValiderQuestion;
    private javax.swing.JTextField codeQuestion;
    private javax.swing.JTextField codeQuizz;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField mdp;
    private javax.swing.JTextField nbQuestion;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numero;
    private javax.swing.JTabbedPane onglets;
    private javax.swing.JPanel panItem;
    private javax.swing.JPanel panJoueur;
    private javax.swing.JPanel panQuestion;
    private javax.swing.JPanel panQuizz;
    private javax.swing.JScrollPane panScrollItem;
    private javax.swing.JScrollPane panScrollJoueur;
    private javax.swing.JScrollPane panScrollQuestion;
    private javax.swing.JTextField reponseJoueur;
    private javax.swing.JTextField reponseQuestion;
    private javax.swing.JTable tabItem;
    private javax.swing.JTable tabJoueur;
    private javax.swing.JTable tabQuestion;
    private javax.swing.JTable tabQuizz;
    private javax.swing.JTextArea texte;
    // End of variables declaration//GEN-END:variables
}
