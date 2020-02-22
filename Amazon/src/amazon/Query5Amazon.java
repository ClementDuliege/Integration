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
	
	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();
		
		String[][] listFirstA = {{"1", "500", "a"}, {"2", "51", "b"}, {"3", "52", "c"}
		,{"4", "53", "d"}, {"5", "54", "e"}, {"6", "55", "f"}
		,{"7", "56", "g"}, {"8", "57", "h"}, {"9", "58", "i"}
		,{"10", "59", "j"}, {"11", "60", "k"}, {"12", "61", "l"}
		,{"13", "62", "m"}, {"14", "63", "n"}, {"15", "64", "o"}};
		String[][] listFirstB = {{"16", "65", "aa"}, {"17", "66", "bb"}, {"18", "67", "cc"}
		,{"19", "68", "dd"}, {"20", "69", "ee"}, {"21", "70", "ff"}
		,{"22", "71", "gg"}, {"23", "72", "hh"}, {"24", "73", "ii"}
		,{"25", "74", "jj"}, {"26", "75", "kk"}, {"27", "76", "ll"}
		,{"28", "77", "mm"}, {"29", "78", "nn"}, {"30", "79", "oo"}};
		String[][] listFirstC = {{"31", "80", "aaa"}, {"32", "81", "bbb"}, {"33", "82", "ccc"}
		,{"34", "83", "ddd"}, {"35", "84", "eee"}, {"36", "85", "fff"}
		,{"37", "86", "ggg"}, {"38", "87", "hhh"}, {"39", "88", "iii"}
		,{"40", "89", "jjj"}, {"41", "90", "kkk"}, {"42", "91", "lll"}
		,{"43", "92", "mmm"}, {"44", "93", "nnn"}, {"45", "94", "ooo"}};

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
		
		listMax = addListElementTwoDimension (listFirstC, listMax);
		listRemoveMax = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstC, 1);	
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
		
		
		listMin = addListMinElementTwoDimension (listFirstC, listMin);	
		listRemoveMin = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listFirstC, 1);	
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
		String[][] listRemoveTotAll = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listMerge, 1);	
		for (int i=1; i<10; i++) {
			listTotFinal = addListMinElementTwoDimension (listRemoveTotAll, listTotFinal);	
			listRemoveTotAll = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemoveTotAll, 1);
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
		  
		//Ajout de la valeur maximum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (QueryAmazonUsual.isStringInt(arrayMax, i, 0) == false) {
				  arrayMax[i][0] = element;
				  arrayMax[i][1] = Integer.toString(min);
				  arrayMax[i][2] = element2;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}

}
