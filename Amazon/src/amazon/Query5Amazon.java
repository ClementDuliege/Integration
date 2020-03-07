package amazon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query5Amazon {
	
	private static String col[] = { "Bonus", "Congé", "Prenom"};

	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();		

		String[][] listMax = new String[15][3];
		
		
		/* Remplissage liste Max */
		listMax = addListElementTwoDimension (usa.query5(), listMax);	
		String[][] listRemoveMax = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(usa.query5(), 1);	
		for (int i=1; i<5; i++) {
			listMax = addListElementTwoDimension (listRemoveMax, listMax);	
			listRemoveMax = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveMax, 1);
		}
		
		listMax = addListElementTwoDimension (fr.query5(), listMax);
		listRemoveMax = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(fr.query5(), 1);	
		for (int i=1; i<5; i++) {
			listMax = addListElementTwoDimension (listRemoveMax, listMax);	
			listRemoveMax = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveMax, 1);
		}
		
		listMax = addListElementTwoDimension (chn.query5(), listMax);
		listRemoveMax = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(chn.query5(), 1);	
		for (int i=1; i<5; i++) {
			listMax = addListElementTwoDimension (listRemoveMax, listMax);	
			listRemoveMax = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveMax, 1);
		}
		
				
		System.out.println("Liste Max congé, que les 15 premières valeurs: ");
		for (int i = 0; i < listMax.length == true ; i++) {
			System.out.println("Bonus: " + listMax[i][0] + ", Congé: " + listMax[i][1] + ", Prenom: " + listMax[i][2]);
		}
		
		
		return listMax;
	
	
	}
	
	public static String[][] mainSort2() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();

		String[][] listMin = new String[15][3];

		/* Remplissage liste Min */
		listMin = addListMinElementTwoDimension (usa.query5(), listMin);	
		String[][] listRemoveMin = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(usa.query5(), 1);	
		for (int i=1; i<5; i++) {
			listMin = addListMinElementTwoDimension (listRemoveMin, listMin);	
			listRemoveMin = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemoveMin, 1);
		}
		
		listMin = addListMinElementTwoDimension (fr.query5(), listMin);	
		listRemoveMin = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(fr.query5(), 1);	
		for (int i=1; i<5; i++) {
			listMin = addListMinElementTwoDimension (listRemoveMin, listMin);	
			listRemoveMin = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemoveMin, 1);
		}
		
		
		listMin = addListMinElementTwoDimension (chn.query5(), listMin);	
		listRemoveMin = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(chn.query5(), 1);	
		for (int i=1; i<5; i++) {
			listMin = addListMinElementTwoDimension (listRemoveMin, listMin);	
			listRemoveMin = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemoveMin, 1);
		}
		

		System.out.println("Liste Min congé, que les 5 dernières valeurs: ");
		for (int i = 0; i < listMin.length == true ; i++) {
			System.out.println("Bonus: " + listMin[i][0] + ", Congé: " + listMin[i][1] + ", Prenom: " + listMin[i][2]);
		}
		
		return listMin;
	
	
	}

	
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 1);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 1, 0);
		  String element2 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 1, 2);
		  
		//Ajout de la valeur maximum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 0) == false) {
				  arrayMax[i][0] = element;
				  arrayMax[i][1] = Integer.toString(max);
				  arrayMax[i][2] = element2;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}
	
	public static String[][] addListMinElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int min = QueryAmazonUsual.minValueTwoDimension(array, 1);
		  String element = QueryAmazonUsual.getElementFromMinTwoDimension (array, min, 1, 0);
		  String element2 = QueryAmazonUsual.getElementFromMinTwoDimension (array, min, 1, 2);
		  
		//Ajout de la valeur minimum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 1) == false) {
				  arrayMax[i][0] = element;
				  arrayMax[i][1] = Integer.toString(min);
				  arrayMax[i][2] = element2;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}


	public static String[] getCol() {
		return col;
	}


	public static void setCol(String[] col) {
		Query5Amazon.col = col;
	}

}
