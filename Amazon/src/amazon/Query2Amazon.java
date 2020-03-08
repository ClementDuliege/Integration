package amazon;

import java.util.HashMap;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

/**
 * The Query2Amazon , sub class of {@link QueryAmazon}.
 * This class retrieves the three results from each data source, and then displays the sum of leaves for each company.
 
 * @see QueryAmazon 
 * @author Ben Mansour Fares, Chahboun Taha & Duli�ge Cl�ment
 *
 */

public class Query2Amazon {

	/**
	 * display of the Gui
	 */
	
	private static String display;
	
	public static String query6() {
		int sum=0;
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("�tats-Unis", QueryDaoUSA.query2());
		query.put("France", QueryDaoFR.query2());
		query.put("Chine", QueryDaoCHN.query2());
		
		sum = query.get("�tats-Unis") + query.get("France") + query.get("Chine");
		
		display = "<html> SOMME DES CONG�S : <br/>�tats-Unis : "+query.get("�tats-Unis")+"<br/> France : "+query.get("France")+"<br/> Chine : "+query.get("Chine")+" <br/>Somme des cong�s totales : "+sum+"</html>";
		System.out.println(display);
	    return display;
	}
}
