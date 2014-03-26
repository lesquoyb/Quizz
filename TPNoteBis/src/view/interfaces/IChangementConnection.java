package view.interfaces;

public interface IChangementConnection  {

	public String getAdresse();
	
	public String getBase();
	
	public String getIdentifiant();
	
	public String getMotDePasse();
	
	public String getNomDriver();
	
	public void setNomDriver(String nom);
	
	public void setAdresse(String adresse);
	
	public void fermer();
	
	public void setBase(String base);
	
	public void setIdentifiant(String id);
	
	public void setMotDePasse(String mdp);
}
