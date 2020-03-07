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
 * The Query3Amazon , sub class of {@link QueryAmazon}.
 * This class retrieves the three results from each data source, and then displays the 5 employees with the highest salary among the 5 largest holidays.
 
 * @see QueryAmazon 
 * @author Ben Mansour Fares, Chahboun Taha & Duliège Clément
 *
 */

public class Query3Amazon {
	
	/**
	 * table columns of the Gui
	 */
	
	private static String col[] = { "Salaire","congés" ,"Prenom"};
	
	/**
	 * The main function, 
	 * first which collects the three results from each data source, 
	 * and then uses other functions to sort by salary
	 
	 * @return listFirstMaxSalary
	 */
	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();
		
		//We merge the three received lists into an unsorted list
		String[][] listMerge1 = QueryAmazonUsual.mergeArrayTwoDimension(usa.query3(), fr.query3());
		String[][] listMerge2 = QueryAmazonUsual.mergeArrayTwoDimension(listMerge1,chn.query3());		
		
		/*Then we create the list which will contain the maximum values
		 * The first will contain the biggest holidays among the elements provides
		 * And the second the 5 biggest salaries among the biggest vacation of the company
		*/
		String[][] listFirstMaxPaid_leave = new String[5][3];
		String[][] listFirstMaxSalary = new String[5][3];
		
		/*Later, we call the addListElementTwoDimension function for the first time in order to fill the first element of the sorted list, 
		and we don't forget to delete in the unsorted list the element that we just added */
		listFirstMaxPaid_leave = addListElementTwoDimension (listMerge2, listFirstMaxPaid_leave);
		String[][] listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMerge2, 1);
		
		//Here, we repeat the operation 4 times because we want to exit in all 5 lines
		for (int i=1; i<5; i++) {
			listFirstMaxPaid_leave = addListElementTwoDimension (listRemoveFirstA, listFirstMaxPaid_leave);	
			listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveFirstA, 1);
		  }
		
		/* Second creation of list */
		
		//We do the same thing as above, except that now we're going to be based on the list that we just filled
		listFirstMaxSalary = addListElementTwoDimensionSecond (listFirstMaxPaid_leave, listFirstMaxSalary);
		String[][] listRemovePaid_leave = getAndDeleteMaxElementTwoDimensionSecond(listFirstMaxPaid_leave);
		
		for (int i=1; i<5; i++) {
			listFirstMaxSalary = addListElementTwoDimensionSecond (listRemovePaid_leave, listFirstMaxSalary);	
			listRemovePaid_leave = getAndDeleteMaxElementTwoDimensionSecond(listRemovePaid_leave);
		  }
		
		
		return listFirstMaxSalary;
	
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

	
	
	/**
	 * The addListElementTwoDimensionSecond function, 
	 * which will find the maximum element of the double-dimensional list array, 
	 * then will insert it at the correct position in the double-dimensional list arrayMax.
	 * 
	 * In this query, we need two different functions because when we are looking for the maximum of the list, 
	 * in the case of the first list we are looking for it according to the longest leave, 
	 * and in the second according to the salary
	 * 
	 * @return arrayMax
	 */
	public static String[][] addListElementTwoDimensionSecond (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 0);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 0, 1);
		  String element2 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 0, 2);
		  
		//Ajout de la valeur maximum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 1) == false) {
				  arrayMax[i][0] = Integer.toString(max);
				  arrayMax[i][1] = element;
				  arrayMax[i][2] = element2;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}

	/**
	 * The addListElementTwoDimensionSecond function, 
	 * same principle as for the other function
	 * 
	 * @return array
	 */
	public static String[][] getAndDeleteMaxElementTwoDimensionSecond(String[][] array) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 0);
		  
		  int max_delete = max;
		  for (int i = 0; i<array.length ; i++) {
			 if (max_delete == Integer.parseInt(array[i][0])) {
				 array[i][0] = "-1";
				 break;
			 }
		  }
				
		  return array;	
				
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
		Query3Amazon.col = col;
	}

}
