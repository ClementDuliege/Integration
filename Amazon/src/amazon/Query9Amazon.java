package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query9Amazon {
	
	private static String col[] = { "Nom", "Age", "Salaire"};
	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();


		String[][] listMerge1 = QueryAmazonUsual.mergeArrayTwoDimension(usa.query9(), fr.query9());
		String[][] listMerge2 = QueryAmazonUsual.mergeArrayTwoDimension(listMerge1,chn.query9());		
		
		String[][] listAge = new String[3][3];
		
		listAge = addListElementTwoDimension (listMerge2, listAge);
		String[][] listRemoveAge = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMerge2, 1);
		
	
		for (int i=1; i<3; i++) {
			listAge = addListElementTwoDimension (listRemoveAge, listAge);	
			listRemoveAge = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveAge, 1);
		  }
		
		System.out.println("Liste triée en fonction de l'âge: ");
		for (int i = 0; i < listAge.length == true ; i++) {
			System.out.println("Nom: " + listAge[i][0] + ", Age: " + listAge[i][1] + ", Salaire: " + listAge[i][2]);
		}
			
		return listAge;
	
	}
	
	
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 1);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 1, 0);
		  String element2 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 1, 2);
		  
		//Ajout de la valeur maximum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 1) == false) {
				  arrayMax[i][0] = element;
				  arrayMax[i][1] = Integer.toString(max);
				  arrayMax[i][2] = element2;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
	}
	
	public static String[] getCol() {
		return col;
	}


	public static void setCol(String col[]) {
		Query9Amazon.col = col;
	}

	
}
