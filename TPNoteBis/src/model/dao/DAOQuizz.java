package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.metier.Item;
import model.metier.Joueur;
import model.metier.Quizz;

import com.mysql.jdbc.Statement;

public class DAOQuizz extends DAO<Quizz>{

	public DAOQuizz(Connection con) {
		super(con);
	}
	
	
	private void insert(Quizz q) throws SQLException{
		String requete = "INSERT INTO quizz (date_quizz,nb_questions_quizz,code_joueur) VALUES(?,?,?)";
			PreparedStatement prep = connection.prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			prep.setDate(1, q.getDate());
			prep.setInt(2, q.getNombreQuestion());
			prep.setInt(3, q.getJoueur().getCode());
			prep.executeUpdate();
			ResultSet res = prep.getGeneratedKeys();
			res.next();
			q.setCode(res.getInt(1));
			fermerStatement(prep);
	}

	/**
	 * Ajoute un quizz et les items correspondants
	 * @param q
	 * @param items
	 */
	public void insert(Quizz q, ArrayList<Item> items){
		try {
			connection.setAutoCommit(false);
			insert(q);
			DAOItem item = new DAOItem(connection);
			for(Item i : items){
				i.setCodeQuizz(q.getCode());
				item.insert(i);
			}
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	
	/**
	 * Supprime tout les quizz fait par un joueur.
	 * @param joueur
	 */
	public void supprimerQuizzJoueur(Joueur joueur){
		String requete = "DELETE FROM quizz WHERE code_joueur=?";
		try {
			PreparedStatement prep = connection.prepareStatement(requete);
			prep.setInt(1, joueur.getCode());
			prep.executeUpdate();
			fermerStatement(prep);

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
