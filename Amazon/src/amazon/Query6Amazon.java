package amazon;

import java.awt.Label;
import java.util.HashMap;

import javax.swing.JLabel;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

/**
 * The Query6Amazon , sub class of {@link QueryAmazon}.
 * This class retrieves the three results from each data source, and displays the average salary of each company.
 
 * @see QueryAmazon 
 * @author Ben Mansour Fares, Chahboun Taha & Duliège Clément
 *
 */

public class Query6Amazon {
	
	/**
	 * display of the Gui
	 */
	
	private static String display;
	
	public static String query6() {
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("États-Unis", QueryDaoUSA.query6());
		query.put("France", QueryDaoFR.query6());
		query.put("Chine", QueryDaoCHN.query6());
		display = "Salaire moyen de chaque pays :\nÉtats-Unis : "+query.get("États-Unis")+"\n France : "+query.get("France")+"\n Chine : "+query.get("Chine");
		System.out.println(display);
	    return display;
	}
	
}
