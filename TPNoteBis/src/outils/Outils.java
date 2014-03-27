package outils;

import java.sql.Date;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Outils {
	
	/**
	 * Transforme une chaine en date, retourne null si il y a une erreur.
	 * @param s
	 * @return
	 */
	public static Date createDate(String s) {
		StringTokenizer st = new StringTokenizer(s,"/");
		int	jour, mois, annee;
		
		if (!st.hasMoreTokens())
			return null;
		else
			jour = Integer.parseInt(st.nextToken());
		
		if (!st.hasMoreTokens())
			return null;
		else
			mois = Integer.parseInt(st.nextToken());
		
		if (!st.hasMoreTokens())
			return null;
		else
			annee = Integer.parseInt(st.nextToken());
		
		Calendar	cal = Calendar.getInstance();
		cal.set(annee, mois, jour);
		
		return new Date(cal.getTimeInMillis());
	}
}