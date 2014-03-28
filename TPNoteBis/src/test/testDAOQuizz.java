package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.DAOQuizz;
import model.dao.MaConnection;
import model.metier.Joueur;
import model.metier.Question;
import model.metier.Quizz;

import org.junit.Test;

public class testDAOQuizz {
	
	private Connection connection;
	private DAOQuizz daoQuizz;
	
	
	
	public testDAOQuizz() {
		MaConnection.setBase("desgorces2u_projetjavaTest");
		try {
			connection = MaConnection.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		daoQuizz = new DAOQuizz(connection);
	}
	
	@Test
	public void testGetAll(){
		Joueur joueur1 = new Joueur(1,"Baptiste","motdepasse","email@fai.com");
		Joueur joueur2 = new Joueur(2,"Alexandre","mdp","alex@lol.com");
		
		ArrayList<String> listeReponses1 = new ArrayList<String>();
		ArrayList<String> listeReponses2 = new ArrayList<String>();
		ArrayList<String> listeReponses3 = new ArrayList<String>();
		ArrayList<String> listeReponses4 = new ArrayList<String>();
		
		ArrayList<Question> listeQuestions1 = new ArrayList<Question>();
		ArrayList<Question> listeQuestions2 = new ArrayList<Question>();
		ArrayList<Question> listeQuestions3 = new ArrayList<Question>();
		ArrayList<Question> listeQuestions4 = new ArrayList<Question>();
		
		String reponse1 = "Bastide";
		String reponse2 = "Highlander";
		
		listeReponses1.add(reponse1);
		listeReponses2.add(reponse2);
		
		Question question1 = new Question(51,"Au Moyen-Âge, comment appelait-on les villages fortifiés ?","Bastide");
		Question question2 = new Question(52,"Dans quel film un couple en croisière va-t-il recueillir un naufragé qui va les terrifier ?","Calme blanc");
		
		listeQuestions1.add(question1);
		listeQuestions2.add(question2);
		
		Date date1 = Date.valueOf("2014-03-12");
		Date date2 = Date.valueOf("2014-03-01");
		Date date3 = Date.valueOf("2014-05-09");
		Date date4 = Date.valueOf("2014-02-03");
		
		Quizz quizz1 = new Quizz(1,10,date1,listeReponses1,listeQuestions1,joueur1);
		Quizz quizz2 = new Quizz(2,2,date2,listeReponses2,listeQuestions2,joueur2);
		Quizz quizz3 = new Quizz(3,15,date3,listeReponses3,listeQuestions3,joueur1);
		Quizz quizz4 = new Quizz(4,3,date4,listeReponses4,listeQuestions4,joueur1);
		
		ArrayList<Quizz> listeQuizz = new ArrayList<Quizz>();
		listeQuizz.add(quizz1);
		listeQuizz.add(quizz2);
		listeQuizz.add(quizz3);
		listeQuizz.add(quizz4);
		
		assertTrue(daoQuizz.getAll().equals(listeQuizz));
	}
	
	@Test
	public void testGetAllFail(){
		Joueur joueur1 = new Joueur(1,"Baptiste","motdepasse","email@fai.com");
		Joueur joueur2 = new Joueur(2,"Alexandre","mdp","alex@lol.com");
		
		ArrayList<String> listeReponses1 = new ArrayList<String>();
		ArrayList<String> listeReponses2 = new ArrayList<String>();
		ArrayList<String> listeReponses3 = new ArrayList<String>();
		ArrayList<String> listeReponses4 = new ArrayList<String>();
		
		ArrayList<Question> listeQuestions1 = new ArrayList<Question>();
		ArrayList<Question> listeQuestions2 = new ArrayList<Question>();
		ArrayList<Question> listeQuestions3 = new ArrayList<Question>();
		ArrayList<Question> listeQuestions4 = new ArrayList<Question>();
		
		String reponse1 = "Bastide";
		String reponse2 = "Highlander";
		
		listeReponses1.add(reponse1);
		listeReponses2.add(reponse2);
		
		Question question1 = new Question(53,"Quel acteur français avait le premier rôle dans le film de Luchino Visconti \"Le Guépard\" ?","Alain Delon");
		Question question2 = new Question(52,"Dans quel film un couple en croisière va-t-il recueillir un naufragé qui va les terrifier ?","Calme blanc");
		
		listeQuestions1.add(question1);
		listeQuestions2.add(question2);
		
		Date date1 = Date.valueOf("2014-03-12");
		Date date2 = Date.valueOf("2014-03-01");
		Date date3 = Date.valueOf("2014-05-09");
		Date date4 = Date.valueOf("2014-02-03");
		
		Quizz quizz1 = new Quizz(1,10,date1,listeReponses1,listeQuestions1,joueur1);
		Quizz quizz2 = new Quizz(2,2,date2,listeReponses2,listeQuestions2,joueur2);
		Quizz quizz3 = new Quizz(3,15,date3,listeReponses3,listeQuestions3,joueur1);
		Quizz quizz4 = new Quizz(4,3,date4,listeReponses4,listeQuestions4,joueur1);
		
		ArrayList<Quizz> listeQuizz = new ArrayList<Quizz>();
		listeQuizz.add(quizz1);
		listeQuizz.add(quizz2);
		listeQuizz.add(quizz3);
		listeQuizz.add(quizz4);
		
		assertFalse(daoQuizz.getAll().equals(listeQuizz));
	}
	
	@Test
	public void testInsert() throws SQLException {
		
		Joueur joueur1 = new Joueur(1,"Baptiste","motdepasse","email@fai.com");
		ArrayList<String> listeReponses1 = new ArrayList<String>();
		ArrayList<Question> listeQuestions1 = new ArrayList<Question>();
		Date date1 = Date.valueOf("2014-03-12");
		
		Quizz quizz = new Quizz(10,date1,listeReponses1,listeQuestions1,joueur1);
		daoQuizz.insert(quizz);
		int code = daoQuizz.getAll().get(4).getCode();
		quizz.setCode(code);
		assertTrue(daoQuizz.getAll().get(4).equals(quizz));

		daoQuizz.delete(quizz);
	}
	
	@Test
	public void testSupprimeQuizzJoueur() throws SQLException {
		int taille = daoQuizz.getAll().size();
		
		Joueur joueur = new Joueur(3,"Alexandre","sunshine","alex.alex@alex.fr");
		
		ArrayList<String> listeReponses = new ArrayList<String>();
		ArrayList<Question> listeQuestions = new ArrayList<Question>();
		
		Date date1 = Date.valueOf("2014-03-12");
		Date date2 = Date.valueOf("2014-03-01");
		
		Quizz quizz1 = new Quizz(17,date1,listeReponses,listeQuestions,joueur);
		Quizz quizz2 = new Quizz(5,date2,listeReponses,listeQuestions,joueur);
		
		daoQuizz.insert(quizz1);
		int code1 = daoQuizz.getAll().get(4).getCode();
		daoQuizz.insert(quizz2);
		int code2 = daoQuizz.getAll().get(5).getCode();
		
		quizz1.setCode(code1);
		quizz2.setCode(code2);
		
		daoQuizz.supprimerQuizzJoueur(joueur);
		
		assertTrue(daoQuizz.getAll().size() == taille);
		
		
	}
	
	@Test
	public void testDelete() throws SQLException {
	
		int taille = daoQuizz.getAll().size();

		Joueur joueur = new Joueur(3,"Alexandre","sunshine","alex.alex@alex.fr");

		ArrayList<String> listeReponses = new ArrayList<String>();
		ArrayList<Question> listeQuestions = new ArrayList<Question>();

		Date date = Date.valueOf("2014-03-12");


		Quizz quizz = new Quizz(17,date,listeReponses,listeQuestions,joueur);

		daoQuizz.insert(quizz);
		int code = daoQuizz.getAll().get(4).getCode();

		quizz.setCode(code);

		daoQuizz.delete(quizz);

		assertTrue(daoQuizz.getAll().size() == taille);
	}
}