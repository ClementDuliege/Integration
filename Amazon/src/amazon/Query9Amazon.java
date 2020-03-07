package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

/**
 * The Query9Amazon , sub class of {@link QueryAmazon}.
 * This class retrieves the three results from each data source, and displays the highest salary among the youngest employees of each company.
 
 * @see QueryAmazon 
 * @author Ben Mansour Fares, Chahboun Taha & Duliège Clément
 *
 */

public class Query9Amazon {
	
	/**
	 * table columns of the Gui
	 */
	
	private static String col[] = { "Nom", "Age", "Salaire"};
	
	/**
	 * The main function, 
	 * first which collects the three results from each data source, 
	 * and then uses other functions to sort by longest leave
	 
	 * @return listAge
	 */
	
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
	
	
	/**
	 * The addListElementTwoDimension function, 
	 * which will find the maximum element of the double-dimensional list array, 
	 * then will insert it at the correct position in the double-dimensional list arrayMax.
	 * 
	 * @return arrayMax
	 */
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 1);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 1, 0);
		  String element2 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 1, 2);
		  

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
	
	/**
	 * @return col
	 */
	public static String[] getCol() {
		return col;
	}

	/**
	 * can modify the content of the column
	 *@param col
	 */	
	public static void setCol(String col[]) {
		Query9Amazon.col = col;
	}

	
}
