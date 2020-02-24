package amazon;

import java.util.HashMap;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query2Amazon {
	
	private static String display;
	
	public static String query6() {
		int sum=0;
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("�tats-Unis", QueryDaoUSA.query2());
		query.put("France", QueryDaoFR.query2());
		query.put("Chine", QueryDaoCHN.query2());
		
		sum = query.get("�tats-Unis") + query.get("France") + query.get("Chine");
		
		display = "Somme des cong�s :\n�tats-Unis : "+query.get("�tats-Unis")+"\n France : "+query.get("France")+"\n Chine : "+query.get("Chine")+" \nSomme des cong�s totales : "+sum;
		System.out.println(display);
	    return display;
	}
}
