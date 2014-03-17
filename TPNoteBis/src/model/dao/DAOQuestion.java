package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.metier.Question;

public class DAOQuestion extends DAO<Question> {

	public DAOQuestion(Connection con) {
		super(con);
	}

	/**
	 * Retourne un objet Question correspondant au code donné, retourne null s'il n'existe pas.
	 * @param code
	 * @return
	 */
	public Question get(int code) {
		String requete = "SELECT * FROM question WHERE code_question =?";
		Question retour = null;
		try {
			PreparedStatement rq = connection.prepareStatement(requete);
			rq.setInt(1, code);
			ResultSet res = rq.executeQuery();
			if (res.next()){
				retour = new Question(res.getInt("code_question"), 
									res.getString("texte_question"),
									res.getString("reponse_question"));
			}
			fermerStatement(rq);
			fermerResultat(res);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return retour;
	}

	/**
	 * Retourne la liste de toutes les question dont l'énoncé contient l'argument passé en paramètre.
	 * @param expression
	 * @return
	 */
	public ArrayList<Question> listeQuestion(String expression){
		ArrayList<Question>liste= new ArrayList<Question>();
		String requete = "SELECT * FROM question WHERE texte_question LIKE ?";
		try {
			PreparedStatement prep = connection.prepareStatement(requete);
			prep.setString(1, "%"+expression+"%");
			ResultSet res = prep.executeQuery();
			while(res.next()){
				liste.add(new Question(res.getInt("code_question"), 
									res.getString("texte_question"),
									res.getString("reponse_question")));
			}

			fermerStatement(prep);
			fermerResultat(res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	/**
	 * Retourne une liste contenant toutes les questions de la bdd.
	 * @return
	 */
	public ArrayList<Question> listeQuestion(){
		ArrayList<Question>liste= new ArrayList<Question>();
		String requete = "SELECT * FROM question";
		try {
			PreparedStatement prep = connection.prepareStatement(requete);
			ResultSet res = prep.executeQuery();
			while(res.next()){
				liste.add(new Question(res.getInt("code_question"), 
									res.getString("texte_question"),
									res.getString("reponse_question")));
			}

			fermerStatement(prep);
			fermerResultat(res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	/**
	 * Retourne le nombre de questions dans la base de données.
	 * @return
	 */
	public int nombreQuestions(){
		return listeQuestion().size();
	}
	
	/**
	 * Ajoute un objet de type Question à la base de données.
	 * @param objet
	 */
	public void insert(Question objet) {
		String requete = "INSERT INTO question (texte_question,reponse_question) VALUES(?,?)";
		try {
			PreparedStatement prep = connection.prepareStatement(requete);
			prep.setString(1, objet.getTexte());
			prep.setString(2, objet.getReponse());
			prep.executeUpdate();
			objet.setCode(listeQuestion(objet.getTexte()).get(0).getCode());
			fermerStatement(prep);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
