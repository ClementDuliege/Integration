package amazon;

import java.awt.Label;
import java.util.HashMap;

import javax.swing.JLabel;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query6Amazon {
	private static String display;
	
	public static String query6() {
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("…tats-Unis", QueryDaoUSA.query6());
		query.put("France", QueryDaoFR.query6());
		query.put("Chine", QueryDaoCHN.query6());
		display = "Salaire moyen de chaque pays :\n…tats-Unis : "+query.get("…tats-Unis")+"\n France : "+query.get("France")+"\n Chine : "+query.get("Chine");
		System.out.println(display);
	    return display;
	}
	
}
