package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.dao.MaConnection;


public class FenetreConnection extends JFrame {
	
	private final String logo = "./src/resources/logo_quizz.png";
	
	public FenetreConnection(){

		this.add(new JLabel(new ImageIcon(logo)));
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
		this.creerConnection();
	}
	
	/**
	 * Si la cr�ation r�ussi on lance la fenetre principale, sinon on demande si l'utilisateur veut r�essayer
	 */
	private void creerConnection(){
		 boolean reussite = false;
		 Connection connection = null;
		while(!reussite){
			try {
				connection = MaConnection.getInstance();
				reussite = true;
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
				int rep = JOptionPane.showConfirmDialog(null, "Voulez vous r�essayer ?","Erreur",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) ;
				if ( rep == JOptionPane.NO_OPTION){
					System.exit(0);
				}
			}
		}

		FenetrePrincipale f = new FenetrePrincipale(connection);
		this.dispose();
	}

}
