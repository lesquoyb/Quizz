package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.DAOItem;
import model.dao.MaConnection;
import model.metier.Item;

import org.junit.Test;

public class testDAOItem {
	
	private Connection connection;
	private DAOItem daoItem;
	
	
	
	public testDAOItem() {
		MaConnection.setBase("desgorces2u_projetjavaTest");
		try {
			connection = MaConnection.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		daoItem = new DAOItem(connection);
	}
	
	@Test
	public void testGetItemQuizz() {
		
		
		Item item = new Item(51,1,"Bastide");
		ArrayList<Item> listeItem = new ArrayList<Item>();
		listeItem.add(item);
		
		
		assertTrue(daoItem.getItemQuizz(1).equals(listeItem));
	}
	
	@Test
	public void testGetItemQuizzFail() {
		
		Item item = new Item(52,2,"Highlander");
		ArrayList<Item> listeItem = new ArrayList<Item>();
		listeItem.add(item);
		
		assertFalse(daoItem.getItemQuizz(1).equals(listeItem));
	}

	
	@Test
	public void testGetAll(){
		Item item1 = new Item(51,1,"Bastide");
		Item item2 = new Item(52,2,"Highlander");


		
		ArrayList<Item> listeItem = new ArrayList<Item>();
		listeItem.add(item1);
		listeItem.add(item2);
		
		assertTrue(daoItem.getAll().equals(listeItem));
		
	}
	
	@Test
	public void testInsert() throws SQLException {
		Item item = new Item(60,3,"Vicomte");
		
		ArrayList<Item> listeItem = new ArrayList<Item>();
		listeItem.add(item);
		daoItem.insert(item);
		assertTrue(daoItem.getItemQuizz(3).equals(listeItem));
		daoItem.delete(item);
	}
	
	
	@Test
	public void testGetAllFail(){
		Item item1 = new Item(53,1,"Bastide");
		Item item2 = new Item(54,2,"Diabolique");
		
		ArrayList<Item> listeItem = new ArrayList<Item>();
		listeItem.add(item1);
		listeItem.add(item2);

		
		assertFalse(daoItem.getAll().equals(listeItem));
		
	}
	
	@Test
	public void testDelete() throws SQLException {
		int taille = daoItem.getAll().size();
		Item item = new Item(60,3,"Vicomte");

		daoItem.insert(item);
		
		daoItem.delete(item);
		assertTrue(daoItem.getAll().size() == taille);
		
		
	}
	
}
