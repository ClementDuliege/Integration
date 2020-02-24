package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query7Amazon {
	
	private static String col[] = { "Bonus", "Congé", "Prenom"};
	
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

		String[][] listAll = new String[30][3];
		String[][] listAllSort = new String[30][3];
		String[][] listFinal = new String[10][3];

		
		//String[][] listMaxFinal = new String[5][3];
		//String[][] listMinFinal = new String[5][3];
		
		
		/* Remplissage liste All */
		/* Partie Max paid_leave */
		listAll = addListElementTwoDimension (listFirstA, listAll);	
		String[][] listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstA, 1);	
		for (int i=1; i<5; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 1);
		}
		
		listAll = addListElementTwoDimension (listFirstB, listAll);
		listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstB, 1);	
		for (int i=1; i<5; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 1);
		}
		
		listAll = addListElementTwoDimension (listFirstC, listAll);
		listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstC, 1);	
		for (int i=1; i<5; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 1);
		}
		
		
			
		/* Partie Min paid_leave */
		listAll = addListMinElementTwoDimension (listFirstA, listAll);	
		listRemove = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listFirstA, 1);	
		for (int i=1; i<5; i++) {
			listAll = addListMinElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemove, 1);
		}
		
		listAll = addListMinElementTwoDimension (listFirstB, listAll);	
		listRemove = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listFirstB, 1);	
		for (int i=1; i<5; i++) {
			listAll = addListMinElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemove, 1);
		}
		
		
		listAll = addListMinElementTwoDimension (listFirstC, listAll);	
		listRemove = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listFirstC, 1);	
		for (int i=1; i<5; i++) {
			listAll = addListMinElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemove, 1);
		}
		
		System.out.println("Liste All non trié: ");
		for (int i = 0; i < listAll.length == true ; i++) {
			System.out.println("Bonus: " + listAll[i][0] + ", Congé: " + listAll[i][1] + ", Prenom: " + listAll[i][2]);
		}
		
		/* Partie Sort */
		
		listAllSort = addListElementTwoDimension (listAll, listAllSort);	
		String[][] listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listAll, 1);	
		for (int i=1; i<30; i++) {
			listAllSort = addListElementTwoDimension (listRemoveSort, listAllSort);	
			listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveSort, 1);
		}
		
		System.out.println("Liste All trié par congé: ");
		for (int i = 0; i < listAllSort.length == true ; i++) {
			System.out.println("Bonus: " + listAllSort[i][0] + ", Congé: " + listAllSort[i][1] + ", Prenom: " + listAllSort[i][2]);
		}
		
		/* Remplissage liste Final */
		
		listFinal = addListElementTwoDimension (listAllSort, listFinal);	
		String[][] listRemoveFinal = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listAllSort, 1);	
		for (int i=1; i<5; i++) {
			listFinal = addListElementTwoDimension (listRemoveFinal, listFinal);	
			listRemoveFinal = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveFinal, 1);
		}
		
		listFinal = addListMinElementTwoDimension (listAllSort, listFinal);	
		listRemoveFinal = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listAllSort, 1);	
		for (int i=1; i<5; i++) {
			listFinal = addListMinElementTwoDimension (listRemoveFinal, listFinal);	
			listRemoveFinal = QueryAmazonUsual.getAndDeleteMinElementTwoDimension(listRemoveFinal, 1);
		}
		
		System.out.println("Liste Final trié et avec les 5 prem et 5 dern: ");
		for (int i = 0; i < listFinal.length == true ; i++) {
			System.out.println("Bonus: " + listFinal[i][0] + ", Congé: " + listFinal[i][1] + ", Prenom: " + listFinal[i][2]);
		}
		
		return listFinal;
	

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
	
	public static String[] getCol() {
		return col;
	}


	public static void setCol(String col[]) {
		Query7Amazon.col = col;
	}

}
