package amazon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

 /**
 * The Query1Amazon , sub class of {@link QueryAmazon}.
 * This class retrieves the three results from each data source, then displays the 10 highest salaries.
 
 * @see QueryAmazon 
 * @author Ben Mansour Fares, Chahboun Taha & Duliège Clément
 *
 */

public class Query1Amazon {
	
	/**
	 * table columns of the Gui
	 */
	
	private static String col[] = { "Salaire", "Prenom"};
	
	/**
	 * The main function, 
	 * first which collects the three results from each data source, 
	 * and then uses other functions to sort by salary
	 
	 * @return listFirstMax
	 */

	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();


		//We merge the three received lists into an unsorted list
		String[][] listMerge1 = QueryAmazonUsual.mergeArrayTwoDimension(usa.query1(),fr.query1());
		String[][] listMerge2 = QueryAmazonUsual.mergeArrayTwoDimension(listMerge1,chn.query1());		
		
		//Then we create the list which will contain the maximum values
		String[][] listFirstMax = new String[10][2];
		
		
		/*Later, we call the addListElementTwoDimension function for the first time in order to fill the first element of the sorted list, 
		and we don't forget to delete in the unsorted list the element that we just added */
		 
		listFirstMax = addListElementTwoDimension (listMerge2, listFirstMax);
		String[][] listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMerge2, 0);
		
	
		//Here, we repeat the operation 9 times because we want to exit in all 10 lines
		for (int i=1; i<10; i++) {
			listFirstMax = addListElementTwoDimension (listRemoveFirstA, listFirstMax);	
			listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveFirstA, 0);
		  }		
	
		return listFirstMax;
	
	}

	
	/**
	 * The addListElementTwoDimension function, 
	 * which will find the maximum element of the double-dimensional list array, 
	 * then will insert it at the correct position in the double-dimensional list arrayMax.
	 * 
	 * @return arrayMax
	 */
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 0);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 0, 1);
		  
		//Addition of the maximum value in the list
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 0) == false) {
				  arrayMax[i][0] = Integer.toString(max);
				  arrayMax[i][1] = element;
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
		Query1Amazon.col = col;
	}
	
	
	

}
