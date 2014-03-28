package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.DAOJoueur;
import model.dao.MaConnection;
import model.metier.Joueur;

import org.junit.Test;

public class testDAOJoueur {
	
	private Connection connection;
	private DAOJoueur daoJoueur;
	
	
	
	public testDAOJoueur() {
		MaConnection.setBase("desgorces2u_projetjavaTest");
		try {
			connection = MaConnection.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		daoJoueur = new DAOJoueur(connection);
	}
	
	@Test
	public void testGetCode() {
		
		assertTrue(daoJoueur.get(2).equals(new Joueur(2,"Alexandre","mdp","alex@lol.com")));
	}
	
	@Test
	public void testGetCodeFail() {
		assertFalse(daoJoueur.get(1).equals(new Joueur(2,"Alexandre","mdp","alex@lol.com")));
	}
	
	@Test
	public void testGetNomMdp() {
		assertTrue(daoJoueur.get("Alex","sunshine").equals(new Joueur(3,"Alex","sunshine","alex.alex@alex.fr")));
	}
	
	@Test
	public void testGetNomMdpFail() {
		assertFalse(daoJoueur.get("Alex","sunshine").equals(new Joueur(2,"Alexandre","mdp","alex@lol.com")));
	}
	
	@Test
	public void testGetAll(){
		Joueur joueur1 = new Joueur(1,"Baptiste","motdepasse","email@fai.com");
		Joueur joueur2 = new Joueur(2,"Alexandre","mdp","alex@lol.com");
		Joueur joueur3 = new Joueur(3,"Alex","sunshine","alex.alex@alex.fr");
		Joueur joueur4 = new Joueur(4,"octodad","blblbl","bl.blblblbl@bl.bl");
		
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
		listeJoueur.add(joueur1);
		listeJoueur.add(joueur2);
		listeJoueur.add(joueur3);
		listeJoueur.add(joueur4);
		
		assertTrue(daoJoueur.getAll().equals(listeJoueur));
		
	}
	
	@Test
	public void testInsert() throws SQLException {
		Joueur joueur = new Joueur();
		joueur.setNom("Test");
		joueur.setPasswd("test");
		joueur.setMail("test@test.com");
		daoJoueur.insert(joueur);
		joueur.setCode(daoJoueur.get("Test","test").getCode());
		assertTrue(daoJoueur.get("Test","test").equals(joueur));
		daoJoueur.delete(joueur);
		connection.setAutoCommit(true);
		
	}
	
	
	@Test
	public void testGetAllFail(){
		Joueur joueur1 = new Joueur(1,"Baptiste","motdepasse","email@fai.com");
		Joueur joueur2 = new Joueur(2,"Alex","mdp","alex@lol.com");
		Joueur joueur3 = new Joueur(3,"Alexandre","sunshine","alex.alex@alex.fr");
		Joueur joueur4 = new Joueur(4,"octodad","blblbl","bl.blblblbl@bl.bl");
		
		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
		listeJoueur.add(joueur1);
		listeJoueur.add(joueur2);
		listeJoueur.add(joueur3);
		listeJoueur.add(joueur4);
		
		assertFalse(daoJoueur.getAll().equals(listeJoueur));
		
	}
	
	@Test
	public void testDelete() throws SQLException {
		int taille = daoJoueur.getAll().size();
		Joueur joueur = new Joueur();
		joueur.setNom("Test");
		joueur.setPasswd("test");
		joueur.setMail("test@test.com");
		
		daoJoueur.insert(joueur);
		joueur.setCode(daoJoueur.get("Test","test").getCode());
		
		daoJoueur.delete(joueur);
		connection.setAutoCommit(true);
		assertTrue(daoJoueur.getAll().size() == taille);
		
		
	}
	
}
