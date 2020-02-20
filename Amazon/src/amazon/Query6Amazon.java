package amazon;

import java.util.HashMap;

import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query6Amazon {

	public static String query6Amazon() {
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("…tats-Unis", QueryDaoUSA.query6());
		query.put("France", QueryDaoFR.query6());
		//query.put("Chine", QueryDaoCHN.query6());  CLEMENT JAI BESOIN DE RECUP TA REQUETE 6 JUSTE EN L'APPELANT STP

	    String display = "Salaire moyen de chaque pays :\n…tats-Unis : "+query.get("…tats-Unis")+"\nFrance : "+query.get("France")+"\nChine : "+query.get("Chine");
		return display;
	}
}
