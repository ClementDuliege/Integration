package amazon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query3Amazon {
	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();
		
		
		String[][] listFirstC = {{"30", "7", "hh"}, {"40", "9", "ii"}, {"60", "10", "jj"}, 
				{"15", "6", "kk"}, {"201", "4", "ll"},};
		// Je laisse la list C en attendant d'avoir la requête 3 fonctionnelle de Clément


		String[][] listMerge1 = QueryAmazonUsual.mergeArrayTwoDimension(usa.query3(), fr.query3());
		String[][] listMerge2 = QueryAmazonUsual.mergeArrayTwoDimension(listMerge1,chn.query3());		
		
		String[][] listFirstMaxPaid_leave = new String[5][3];
		String[][] listFirstMaxSalary = new String[5][3];
		
		listFirstMaxPaid_leave = addListElementTwoDimension (listMerge2, listFirstMaxPaid_leave);
		String[][] listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMerge2, 1);
		
	
		for (int i=1; i<5; i++) {
			listFirstMaxPaid_leave = addListElementTwoDimension (listRemoveFirstA, listFirstMaxPaid_leave);	
			listRemoveFirstA = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveFirstA, 1);
		  }
		
		/* Second creation of list */
		
		listFirstMaxSalary = addListElementTwoDimensionSecond (listFirstMaxPaid_leave, listFirstMaxSalary);
		String[][] listRemovePaid_leave = getAndDeleteMaxElementTwoDimensionSecond(listFirstMaxPaid_leave);
		
		for (int i=1; i<5; i++) {
			listFirstMaxSalary = addListElementTwoDimensionSecond (listRemovePaid_leave, listFirstMaxSalary);	
			listRemovePaid_leave = getAndDeleteMaxElementTwoDimensionSecond(listRemovePaid_leave);
		  }
		
		/*System.out.println("Toutes les 5 valeurs avec les congés au max et triés par les plus grands salaires sont dans cette liste: ");
		for (int i = 0; i < listFirstMaxSalary.length == true ; i++) {
			System.out.println("Salaire: " + listFirstMaxSalary[i][0] + ", Congé: " + listFirstMaxSalary[i][1] + ", Prenom:" + listFirstMaxSalary[i][2]);
		}*/
		
		System.out.println("TEST: ");
		for (int i = 0; i < chn.query3().length == true ; i++) {
			System.out.println("Salaire: " + chn.query3()[i][0] + ", Congé: " + chn.query3()[i][1] + ", Prenom:" + chn.query3()[i][2]);
		}
		
	
		return listFirstMaxSalary;
	
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

}
