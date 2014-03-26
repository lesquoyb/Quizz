package view.interfaces;

import java.util.ArrayList;

import model.metier.Joueur;

public interface IPanelTableJoueur extends IPanelTable{
	
	public ArrayList<Joueur>getSelection();
	
	public String getNomJoueur();
	
	public String getMdpJoueur();
	
	public String getMailJoueur();


}
