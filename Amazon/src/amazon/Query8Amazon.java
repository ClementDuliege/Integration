package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query8Amazon {

	private static String col[] = { "Nom", "Prenom", "Salaire", "Bonus", "Congés"};

	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();


		String[][] listMerge1 = QueryAmazonUsual.mergeArrayTwoDimension(usa.query8(),fr.query8());
		String[][] listMerge2 = QueryAmazonUsual.mergeArrayTwoDimension(listMerge1,chn.query8());		
		
		String[][] listFirstMax = new String[3][5];
		
		listFirstMax = addListElementTwoDimension (listMerge2, listFirstMax);
		String[][] listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMerge2, 2);
		
	
		for (int i=1; i<3; i++) {
			listFirstMax = addListElementTwoDimension (listRemoveFirstA, listFirstMax);	
			listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveFirstA, 2);
		  }
		
		System.out.println("Toutes les 10 valeurs max sont dans cette liste: ");
		for (int i = 0; i < listFirstMax.length == true ; i++) {
			System.out.println("Nom: " + listFirstMax[i][0] + ", Prenom: " + listFirstMax[i][1] + ", Salaire: " + listFirstMax[i][2] + ", Bonus: " + listFirstMax[i][3] + ", Congés: " + listFirstMax[i][4]);
		}
		
	
		return listFirstMax;
	
	}

	
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 2);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 0);
		  String element2 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 1);
		  String element3 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 3);
		  String element4 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 4);
		  
		//Ajout de la valeur maximum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 2) == false) {
				  arrayMax[i][0] = element;
				  arrayMax[i][1] = element2;
				  arrayMax[i][2] = Integer.toString(max);
				  arrayMax[i][3] = element3;
				  arrayMax[i][4] = element4;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}
	
	
	public static String[] getCol() {
		return col;
	}

	public static void setCol(String[] col) {
		Query8Amazon.col = col;
	}

	
	
}
