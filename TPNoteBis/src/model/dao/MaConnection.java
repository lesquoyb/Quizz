package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MaConnection {


	//private static String url ="jdbc:mysql://localhost/desgorces2u_projetjava?profileSQL=true";
	private static String adresse = "localhost";
	private static String base = "desgorces2u_projetjava";
	private static String utilisateur ="root";			//"desgorce2u_appli";
	private static String motDePasse = "";//"31208714";
	private static String nomDriver = "com.mysql.jdbc.Driver";
	private static Connection connection;
	
	/**
	 * Le constructeur est privé car on applique le pattern singleton afin de n'avoir qu'une instance de la connection.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private MaConnection() throws ClassNotFoundException, SQLException{
		
			Class.forName(nomDriver);
			connection = DriverManager.getConnection(	"jdbc:mysql://"+adresse+"/"+base+"?profileSQL=true",
														utilisateur,
														motDePasse);
		
	}
	
	public static String getAdresse() {
		return adresse;
	}

	public static void setAdresse(String adresse) {
		MaConnection.adresse = adresse;
	}

	public static String getBase() {
		return base;
	}

	public static void setBase(String base) {
		MaConnection.base = base;
	}

	public static String getUtilisateur() {
		return utilisateur;
	}

	public static void setUtilisateur(String utilisateur) {
		MaConnection.utilisateur = utilisateur;
	}

	public static String getMotDePasse() {
		return motDePasse;
	}

	public static void setMotDePasse(String motDePasse) {
		MaConnection.motDePasse = motDePasse;
	}

	public static String getNomDriver() {
		return nomDriver;
	}

	public static void setNomDriver(String nomDriver) {
		MaConnection.nomDriver = nomDriver;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		MaConnection.connection = connection;
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
