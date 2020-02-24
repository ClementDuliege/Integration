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
		String[][] listMin = new String[15][3];
		
		String[][] listMaxFinal = new String[5][3];
		String[][] listMinFinal = new String[5][3];
		String[][] listTotFinal = new String[10][3];
		
		
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
		
		
		/* Remplissage liste Max Finale */
		listMaxFinal = addListElementTwoDimension (listMax, listMaxFinal);	
		String[][] listRemoveMaxAll = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMax, 1);	
		for (int i=1; i<5; i++) {
			listMaxFinal = addListElementTwoDimension (listRemoveMaxAll, listMaxFinal);	
			listRemoveMaxAll = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveMaxAll, 1);
		}
				
		System.out.println("Liste Max All, que les 5 premières valeurs: ");
		for (int i = 0; i < listMaxFinal.length == true ; i++) {
			System.out.println("Bonus: " + listMaxFinal[i][0] + ", Congé: " + listMaxFinal[i][1] + ", Prenom: " + listMaxFinal[i][2]);
		}
		
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
		
		
		/* Remplissage liste Min Finale */
		listMinFinal = addListMinElementTwoDimension (listMin, listMinFinal);	
		String[][] listRemoveMinAll = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listMin, 1);	
		for (int i=1; i<5; i++) {
			listMinFinal = addListMinElementTwoDimension (listRemoveMinAll, listMinFinal);	
			listRemoveMinAll = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemoveMinAll, 1);
		}
		
		System.out.println("Liste Min All, que les 5 dernières valeurs: ");
		for (int i = 0; i < listMinFinal.length == true ; i++) {
			System.out.println("Bonus: " + listMinFinal[i][0] + ", Congé: " + listMinFinal[i][1] + ", Prenom: " + listMinFinal[i][2]);
		}
		
		/* Fusion en une liste */
		String[][] listMerge = QueryAmazonUsual.mergeArrayTwoDimension(listMaxFinal,listMinFinal);
		listTotFinal = addListElementTwoDimension (listMerge, listTotFinal);
		String[][] listRemoveTotAll = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listMerge, 1);	
		for (int i=1; i<10; i++) {
			listTotFinal = addListElementTwoDimension (listRemoveTotAll, listTotFinal);	
			listRemoveTotAll = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveTotAll, 1);
		}
		
		System.out.println("Liste Total: ");
		for (int i = 0; i < listTotFinal.length == true ; i++) {
			System.out.println("Bonus: " + listTotFinal[i][0] + ", Congé: " + listTotFinal[i][1] + ", Prenom: " + listTotFinal[i][2]);
		}
		
		
		
		
		return listTotFinal;
	
	
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
