package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.metier.Item;
import model.metier.Question;

public class DAOItem extends DAO<Item> {

	
	
	public DAOItem(Connection con) {
		super(con);
	}

	public void insert(Item i) throws SQLException{
		String requete = "INSERT INTO item (code_question,code_quizz,reponse_joueur) VALUES(?,?,?)";
		PreparedStatement prep = connection.prepareStatement(requete);
		prep.setInt(1, i.getCodeQuestion());
		prep.setInt(2, i.getCodeQuizz());
		prep.setString(3, i.getReponseJoueur());
		prep.executeUpdate();
		fermerStatement(prep);

		
	}
	
	public ArrayList<Item> listeItem(){
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
	
}
