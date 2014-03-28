package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.DAOQuestion;
import model.dao.MaConnection;
import model.metier.Question;

import org.junit.Test;

public class testDAOQuestion {
	
	private Connection connection;
	private DAOQuestion daoQuestion;
	
	
	
	public testDAOQuestion() {
		MaConnection.setBase("desgorces2u_projetjavaTest");
		try {
			connection = MaConnection.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		daoQuestion = new DAOQuestion(connection);
	}
	
	@Test
	public void testGet() {
		
		assertTrue(daoQuestion.get(51).equals(new Question(51,"Au Moyen-Âge, comment appelait-on les villages fortifiés ?","Bastide")));
	}
	
	@Test
	public void testGetFail() {
		assertFalse(daoQuestion.get(51).equals(new Question(52,"Dans quel film un couple en croisière va-t-il recueillir un naufragé qui va les terrifier ?","Calme blanc")));
	}
	
	@Test
	public void testGetAll(){
		Question question1 = new Question(51,"Au Moyen-Âge, comment appelait-on les villages fortifiés ?","Bastide");
		Question question2 = new Question(52,"Dans quel film un couple en croisière va-t-il recueillir un naufragé qui va les terrifier ?","Calme blanc");
		Question question3 = new Question(53,"Quel acteur français avait le premier rôle dans le film de Luchino Visconti \"Le Guépard\" ?","Alain Delon");
		Question question4 = new Question(54,"Quel film à succès a réuni sur les écrans Sean Connery et Christophe Lambert ?","Highlander");
		Question question5 = new Question(55,"Comment appelle-t-on le fruit du plaqueminier ?","Kaki");
		Question question6 = new Question(56,"Qui était le compagnon de saint Paul ?","Saint-Luc");
		Question question7 = new Question(57,"Dans quel film John Travolta incarne-t-il un ange tombé du ciel ?","Michael");
		Question question8 = new Question(58,"Quel titre de noblesse est immédiatement inférieur à celui de comte ?","Vicomte");
		Question question9 = new Question(59,"De quelle série de six films un champion de boxe est-il la vedette ?","Rocky");
		Question question10 = new Question(60,"Quelle est la capitale de la Nouvelle-Zélande ?","Wellington");
		
		
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		listeQuestion.add(question1);
		listeQuestion.add(question2);
		listeQuestion.add(question3);
		listeQuestion.add(question4);
		listeQuestion.add(question5);
		listeQuestion.add(question6);
		listeQuestion.add(question7);
		listeQuestion.add(question8);
		listeQuestion.add(question9);
		listeQuestion.add(question10);
		
		
		assertTrue(daoQuestion.getAll().equals(listeQuestion));
		
	}
	
	@Test
	public void testInsert() throws SQLException {
		Question question = new Question(61,"Que font les shadoks ?","Pomper");
		daoQuestion.insert(question);
		int code = daoQuestion.getAll().get(10).getCode();
		question.setCode(code);
		assertTrue(daoQuestion.get(code).equals(question));

		daoQuestion.delete(question);
	}
	
	
	@Test
	public void testGetAllFail(){
		Question question1 = new Question(51,"Au Moyen-Âge, comment appelait-on les villages fortifiés ?","Bastide");
		Question question2 = new Question(52,"Dans quel film un couple en sibérie va-t-il recueillir un naufragé qui va les terrifier ?","Calme blanc");

		
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		listeQuestion.add(question1);
		listeQuestion.add(question2);
		
		assertFalse(daoQuestion.getAll().equals(listeQuestion));
		
	}
	
	@Test
	public void testDelete() throws SQLException {
		int taille = daoQuestion.getAll().size();
		Question question = new Question(61,"Que font les shadoks ?","Pomper");
		
		daoQuestion.insert(question);
		
		daoQuestion.delete(question);
		assertTrue(daoQuestion.getAll().size() == taille);
		
		
	}
	
}
