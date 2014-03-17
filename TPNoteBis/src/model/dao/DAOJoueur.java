package model.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.metier.Joueur;


public class DAOJoueur extends DAO<Joueur> {

	
	public DAOJoueur(Connection con) {
		super(con);
	}

	
	/**
	 * Retourne un joueur correspondant au code passé en paramètre, s'il n'existe pas retourne null.
	 * @param code
	 * @return
	 */
	public Joueur get(int code) {
		String requete = "SELECT * FROM joueur WHERE code_joueur =?";
		Joueur retour = null;
		try {
			PreparedStatement rq = connection.prepareStatement(requete);
			rq.setInt(1, code);
			ResultSet res = rq.executeQuery();
			if (res.next()){
				retour = new Joueur(Integer.valueOf(res.getString("code_joueur")), 
									res.getString("nom_joueur"),
									res.getString("passwd_joueur"),
									res.getString("mail_joueur"));
			}
			fermerStatement(rq);
			fermerResultat(res);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return retour;
	}

	
	/**
	 * Retourne un joueur dont le nom et le mot de passe correspondent aux paramètre.
	 * S'il n'existe pas, on retourne null.
	 * @param nom
	 * @param mdp
	 * @return
	 */
	public Joueur get(String nom, String mdp){
		String requete = "SELECT * FROM joueur WHERE nom_joueur=? AND passwd_joueur=?";
		Joueur retour = null;
		try {
			PreparedStatement rq = connection.prepareStatement(requete);
			rq.setString(1, nom);
			rq.setString(2, mdp);
			ResultSet res = rq.executeQuery();
			if (res.next()){
				retour = new Joueur(Integer.valueOf(res.getString("code_joueur")), 
									res.getString("nom_joueur"),
									res.getString("passwd_joueur"),
									res.getString("mail_joueur"));
			}
			fermerStatement(rq);
			fermerResultat(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return retour;
	}
	
	/**
	 * Supprime un joueur de la table joueur ainsi que tous ses quizz.
	 * Verifie d'abord si le code est correct.
	 * @param j
	 */
	public void supprimerJoueur(Joueur j){
		if (j != null && j.getCode() != -1){
			DAOQuizz q = new DAOQuizz(connection);
			try {
				connection.setAutoCommit(false);
				q.supprimerQuizzJoueur(j);
				String requete ="DELETE FROM joueur WHERE code_joueur=?";
				PreparedStatement prep = connection.prepareStatement(requete);
				prep.setInt(1, j.getCode());
				prep.executeUpdate();
				fermerStatement(prep);
				 if (JOptionPane.showConfirmDialog(null,"Êtes vous sur de vouloir supprimer ce joueur ainsi que les quizz qu'il a effectué?","joueur trouvé",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					 connection.commit();
				 }
				 else{
					 connection.rollback();
				 }
				 connection.setAutoCommit(true);
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	}


}
