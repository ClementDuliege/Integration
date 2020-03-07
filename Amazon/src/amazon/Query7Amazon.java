package amazon;

import java.util.HashMap;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query7Amazon {
	
	private static String col[] = { "Bonus", "Congé", "Prenom"};
	
	public static String mainSort() {
		String display = "";
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("États-Unis", QueryDaoUSA.query7());
		query.put("France", QueryDaoFR.query7());
		query.put("Chine", QueryDaoCHN.query7());
		display = "<html> Les Bonus Des États-Unis : "+query.get("États-Unis")+"<br/> Les Bonus De La France : "+query.get("France")+"<br/> Les Bonus De La Chine : "+query.get("Chine");
		
		return display;
	}

}
