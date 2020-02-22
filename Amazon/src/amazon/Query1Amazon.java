package amazon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query1Amazon {
	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();


		String[][] listMerge1 = QueryAmazonUsual.mergeArrayTwoDimension(usa.query1(),fr.query1());
		String[][] listMerge2 = QueryAmazonUsual.mergeArrayTwoDimension(listMerge1,chn.query1());		
		
		String[][] listFirstMax = new String[10][2];
		
		listFirstMax = addListElementTwoDimension (listMerge2, listFirstMax);
		String[][] listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMerge2, 0);
		
	
		for (int i=1; i<10; i++) {
			listFirstMax = addListElementTwoDimension (listRemoveFirstA, listFirstMax);	
			listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveFirstA, 0);
		  }
		
		System.out.println("Toutes les 10 valeurs max sont dans cette liste: ");
		for (int i = 0; i < listFirstMax.length == true ; i++) {
			System.out.println("Salaire: " + listFirstMax[i][0] + ", Prenom: " + listFirstMax[i][1]);
		}
		
	
		return listFirstMax;
	
	}

	
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 0);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 0, 1);
		  
		//Ajout de la valeur maximum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 0) == false) {
				  arrayMax[i][0] = Integer.toString(max);
				  arrayMax[i][1] = element;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}
	
	
	

}
