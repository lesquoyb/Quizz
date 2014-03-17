package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class DAO<Exemple> {
	
	protected Connection connection ;	
	
	public DAO(Connection con){
		connection = con;
	}

	/**
	 * Ferme un ResultSet.
	 * @param res
	 */
	protected void fermerResultat(ResultSet res){
		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ferme un PreparedStatement.
	 * @param prep
	 */
	protected void fermerStatement(PreparedStatement prep){
		try {
			prep.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setConnection(Connection connexion) {
		this.connection = connexion;
	}

	public Connection getConnection() {
		return connection;
	}

}
