package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.metier.Item;

public class DAOItem extends DAO<Item> {

	
	
	public DAOItem(Connection con) {
		super(con);
	}

	@Override
	public void insert(Item objet) throws SQLException{
		String requete = "INSERT INTO item (code_question,code_quizz,reponse_joueur) VALUES(?,?,?)";
		PreparedStatement prep = connection.prepareStatement(requete);
		prep.setInt(1, objet.getCodeQuestion());
		prep.setInt(2, objet.getCodeQuizz());
		prep.setString(3, objet.getReponseJoueur());
		prep.executeUpdate();
		fermerStatement(prep);
	}
	
	@Override
	public ArrayList<Item> getAll(){
		ArrayList<Item>liste= new ArrayList<Item>();
		String requete = "SELECT * FROM item";
		try {
			PreparedStatement prep = connection.prepareStatement(requete);
			ResultSet res = prep.executeQuery();
			while(res.next()){
				liste.add(new Item(res.getInt("code_question"), 
									res.getInt("code_quizz"),
									res.getString("reponse_joueur")));
			}

			fermerStatement(prep);
			fermerResultat(res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

	/**
	 * Retourne tous les items appartenant à un quizz.
	 * @param codeQuizz
	 * @return
	 */
	public ArrayList<Item> getItemQuizz(int codeQuizz){
		ArrayList<Item> listeRetour = new ArrayList<Item>();
		String requete = "SELECT * FROM item WHERE code_quizz=?";
		try {
			PreparedStatement prep = connection.prepareStatement(requete);
			prep.setInt(1,codeQuizz);
			ResultSet res = prep.executeQuery();
			while(res.next()){
				listeRetour.add(new Item(res.getInt("code_question"), 
									res.getInt("code_quizz"),
									res.getString("reponse_joueur")));
			}

			fermerStatement(prep);
			fermerResultat(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return listeRetour;
	}

	@Override
	public void delete(Item objet) throws SQLException {

		if (objet != null && objet.getCodeQuestion() != -1 && objet.getCodeQuizz() != -1){
			String requete ="DELETE FROM item WHERE code_quizz=? AND code_question=?";
			PreparedStatement prep = connection.prepareStatement(requete);
			prep.setInt(1, objet.getCodeQuizz());
			prep.setInt(2, objet.getCodeQuestion());
			prep.executeUpdate();
			fermerStatement(prep);
			objet.setCodeQuestion(-1);
			objet.setCodeQuizz(-1);
		}
	}
	
	
	
	
}
