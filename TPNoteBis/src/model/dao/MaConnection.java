package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MaConnection {


	private final String url ="jdbc:mysql://localhost/desgorces2u_projetjava?profileSQL=true";
	private final String utilisateur ="root";//"desgorce2u_appli";
	private final String motDePasse ="";// "31208714";
	private final String nomDriver = "com.mysql.jdbc.Driver";
	private static Connection connection;
	
	/**
	 * Le constructeur est privé car on applique le pattern singleton afin de n'avoir qu'une instance de la connection.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private MaConnection() throws ClassNotFoundException, SQLException{
		
			Class.forName(nomDriver);
			connection = DriverManager.getConnection(url,
					 utilisateur,
					 motDePasse);
		
	}
	
	public static void fermer(){
		if ( connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Retourne la seul instance de connection.
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection getInstance() throws ClassNotFoundException, SQLException{
		if (connection == null){
			new MaConnection();
		}
		return connection;
	}
}
