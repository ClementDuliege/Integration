package amazon;

import java.awt.Label;
import java.util.HashMap;

import javax.swing.JLabel;

import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query6Amazon {
	private String display;
	
	public String toString() {
		HashMap<String, Integer> query = new HashMap<String, Integer>();
		
		query.put("…tats-Unis", QueryDaoUSA.query6());
		query.put("France", QueryDaoFR.query6());
		//query.put("Chine", QueryDaoCHN.query6());  CLEMENT JAI BESOIN DE RECUP TA REQUETE 6 JUSTE EN L'APPELANT STP
		display = "Salaire moyen de chaque pays :\n…tats-Unis : "+query.get("…tats-Unis")+"\nFrance : "+query.get("France")+"\nChine : "+query.get("Chine");
		System.out.println(display);
	    return display;
	}
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	
}
