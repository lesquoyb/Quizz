package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.metier.Item;
import model.metier.Joueur;
import model.metier.Question;
import model.metier.Quizz;

import com.mysql.jdbc.Statement;

public class DAOQuizz extends DAO<Quizz>{

	public DAOQuizz(Connection con) {
		super(con);
	}
	
	
	@Override
	public void insert(Quizz objet) throws SQLException{
		String requete = "INSERT INTO quizz (date_quizz,nb_questions_quizz,code_joueur) VALUES(?,?,?)";
			PreparedStatement prep = connection.prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
			prep.setDate(1, objet.getDate());
			prep.setInt(2, objet.getNombreQuestion());
			prep.setInt(3, objet.getJoueur().getCode());
			prep.executeUpdate();
			ResultSet res = prep.getGeneratedKeys();
			res.next();
			objet.setCode(res.getInt(1));
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


	@Override
	public ArrayList<Quizz> getAll() {
		ArrayList<Quizz>liste= new ArrayList<Quizz>();
		String requete = "SELECT * FROM quizz";
		try {
			PreparedStatement prep = connection.prepareStatement(requete);
			ResultSet res = prep.executeQuery();
			while(res.next()){
				DAOJoueur j = new DAOJoueur(connection);
				Joueur joueur = j.get(res.getInt("code_joueur"));
				DAOItem items = new DAOItem(connection);
				ArrayList<Item> listeItem = items.getItemQuizz(res.getInt("code_quizz"));
				ArrayList<String> listeReponse = new ArrayList<String>();
				ArrayList<Question> listeQuestions = new ArrayList<Question>();
				for(Item item : listeItem){
					DAOQuestion questions = new DAOQuestion(connection);
					listeQuestions.add(questions.get(item.getCodeQuestion()));
					listeReponse.add(item.getReponseJoueur());
				}
				liste.add(new Quizz(res.getInt("code_quizz"),
									res.getInt("nb_question_quizz"), 
									res.getDate("date_quizz"),
									listeReponse,
									listeQuestions,
									joueur));
			}

			fermerStatement(prep);
			fermerResultat(res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}


	@Override
	public void delete(Quizz objet) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
