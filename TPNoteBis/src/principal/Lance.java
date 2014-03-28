package principal;

import java.sql.SQLException;

import model.dao.MaConnection;
import model.metier.Joueur;
import view.FenetreConnection;
import view.FenetreJeu;

public class Lance {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		FenetreJeu f = new FenetreJeu(MaConnection.getInstance(),new Joueur(1,"Baptiste","motdepasse","email@fai.fr"));
		//FenetreConnection f1 = new FenetreConnection();
		
	}

	
}
