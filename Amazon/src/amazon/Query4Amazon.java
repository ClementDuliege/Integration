package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

/**
 * The Query4Amazon , sub class of {@link QueryAmazon}.
 * This class retrieves the three results from each data source, and then displays the 9 best salaries with bonuses included.
 
 * @see QueryAmazon 
 * @author Ben Mansour Fares, Chahboun Taha & Duliège Clément
 *
 */

public class Query4Amazon {
	
	/**
	 * table columns of the Gui
	 */
	
	private static String col[] = { "Prenom", "Salaire", "Bonus"};

	/**
	 * The main function, 
	 * first which collects the three results from each data source, 
	 * and then uses other functions to sort by salary
	 
	 * @return listAllSort
	 */
	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();
		
		/* We create the list which will contain the maximum values
		 * The first will contain the elements with the greatest bonus
		 * And the second the 9 biggest salaries among the biggest bonuses
		*/
		String[][] listAll = new String[9][3];
		String[][] listAllSort = new String[9][3];
		
		

		listAll = addListElementTwoDimension (usa.query4(), listAll);	
		String[][] listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(usa.query4(), 2);	
		for (int i=1; i<3; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 2);
		}
		
		listAll = addListElementTwoDimension (fr.query4(), listAll);
		listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(fr.query4(), 2);	
		for (int i=1; i<3; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 2);
		}
		
		listAll = addListElementTwoDimension (chn.query4(), listAll);
		listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(chn.query4(), 2);	
		for (int i=1; i<3; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 2);
		}
		

		listAllSort = addListElementTwoDimension2 (listAll, listAllSort);	
		String[][] listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listAll, 1);	
		for (int i=1; i<9; i++) {
			listAllSort = addListElementTwoDimension2 (listRemoveSort, listAllSort);	
			listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveSort, 1);
		}
		
				
		System.out.println("Liste entière triée: ");
		for (int i = 0; i < listAllSort.length == true ; i++) {
			System.out.println("Prenom: " + listAllSort[i][0] + ", Salaire: " + listAllSort[i][1] + ", Bonus: " + listAllSort[i][2]);
		}
		
		return listAllSort;
	
	}

	
	/**
	 * The addListElementTwoDimension function, 
	 * which will find the maximum element of the double-dimensional list array, 
	 * then will insert it at the correct position in the double-dimensional list arrayMax.
	 * 
	 * @return arrayMax
	 */
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 2);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 0);
		  String element2 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 1);
		  
		  
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 2) == false) {
				  arrayMax[i][0] = element;
				  arrayMax[i][1] = element2;
				  arrayMax[i][2] = Integer.toString(max);
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}
	
	
	/**
	 * The addListElementTwoDimension2 function, 
	 * which will find the maximum element of the double-dimensional list array, 
	 * then will insert it at the correct position in the double-dimensional list arrayMax.
	 * 
	 * In this query, we need two different functions because when we are looking for the maximum of the list, 
	 * in the case of the first list we are looking for it according to the biggest bonuses, 
	 * and in the second according to the salary
	 * 
	 * @return arrayMax
	 */
	public static String[][] addListElementTwoDimension2 (String[][] array, String[][] arrayMax) {
	  	
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
	public static void setCol(String[] col) {
		Query4Amazon.col = col;
	}
	
	

}
