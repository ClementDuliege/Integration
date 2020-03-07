package amazon;

import java.util.HashMap;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

/**
 * The Query7Amazon , sub class of {@link QueryAmazon}.
 * This class retrieves the three results from each data source, and compare the sum of bonuses from each company.
 
 * @see QueryAmazon 
 * @author Ben Mansour Fares, Chahboun Taha & Duli�ge Cl�ment
 *
 */

public class Query7Amazon {
	
	/**
	 * table columns of the Gui
	 */
	
	private static String col[] = { "Bonus", "Cong�", "Prenom"};
	
	public static String mainSort() {
		String display = "";
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("�tats-Unis", QueryDaoUSA.query7());
		query.put("France", QueryDaoFR.query7());
		query.put("Chine", QueryDaoCHN.query7());
		display = "<html> Les Bonus Des �tats-Unis : "+query.get("�tats-Unis")+"<br/> Les Bonus De La France : "+query.get("France")+"<br/> Les Bonus De La Chine : "+query.get("Chine");
		
		return display;
	}

}
