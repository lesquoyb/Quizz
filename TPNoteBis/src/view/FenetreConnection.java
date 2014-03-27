package view;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.dao.MaConnection;


public class FenetreConnection extends JFrame {
	
	private final String logo = "./src/resources/logo_quizz.png";
	
	public FenetreConnection() throws ClassNotFoundException, SQLException{

		this.add(new JLabel(new ImageIcon(logo)));
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
		this.creerConnection();
	}
	
	/**
	 * Si la création réussi on lance la fenetre principale, sinon on demande si l'utilisateur veut réessayer
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void creerConnection() throws ClassNotFoundException, SQLException{
		 boolean reussite = false;
		 Connection connection = null;
		while(!reussite){
			try {
				connection = MaConnection.getInstance();
				reussite = true;
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
				int rep = JOptionPane.showConfirmDialog(null, "Voulez vous réessayer ?","Erreur",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) ;
				if ( rep == JOptionPane.CANCEL_OPTION){
					System.exit(0);
				}
				else{
					DialogChangementConnection dialog = new DialogChangementConnection();
				}
			}
		}
		FenetreGestion f = new FenetreGestion(connection);
		this.dispose();
	}

}
