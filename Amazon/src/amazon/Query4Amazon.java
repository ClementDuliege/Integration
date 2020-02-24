package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query4Amazon {
	
	private static String col[] = { "Prenom", "Salaire", "Bonus"};

	public static String[][] mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();
		
		
		String[][] listFirstC = {{"aaa", "80", "31"}, {"bbb", "81", "32"}, {"ccc", "82", "33"}
		,{"ddd", "83", "34"}, {"eee", "84", "35"}, {"fff", "85", "36"}
		,{"ggg", "86", "37"}, {"hhh", "817", "38"}, {"iii", "88", "39"}
		,{"jjj", "89", "40"}, {"kkk", "90", "41"}, {"lll", "791", "42"}
		,{"mmm", "92", "43"}, {"nnn", "93", "44"}, {"ooo", "94", "45"}};

		String[][] listAll = new String[9][3];
		String[][] listAllSort = new String[9][3];
		
		
		/* Remplissage liste All */
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
		
		listAll = addListElementTwoDimension (listFirstC, listAll);
		listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstC, 2);	
		for (int i=1; i<3; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 2);
		}
		
		
		/*System.out.println("Liste entière non triée MAIS c les 5 plus gros bonus de chaque bdd: ");
		for (int i = 0; i < listAll.length == true ; i++) {
			System.out.println("Prenom: " + listAll[i][0] + ", Salaire: " + listAll[i][1] + ", Bonus: " + listAll[i][2]);
		}*/
		
		
		/* Remplissage liste All Sort */
		listAllSort = addListElementTwoDimension2 (listAll, listAllSort);	
		String[][] listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listAll, 1);	
		for (int i=1; i<9; i++) {
			listAllSort = addListElementTwoDimension2 (listRemoveSort, listAllSort);	
			listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveSort, 1);
		}
		
				
		/*System.out.println("Liste entière triée: ");
		for (int i = 0; i < listAllSort.length == true ; i++) {
			System.out.println("Prenom: " + listAllSort[i][0] + ", Salaire: " + listAllSort[i][1] + ", Bonus: " + listAllSort[i][2]);
		}*/
		
		for (int i = 0; i < chn.query4().length == true ; i++) {
			System.out.println("Prenom: " + chn.query4()[i][0] + ", Salaire: " + chn.query4()[i][1] + ", Bonus: " + chn.query4()[i][2]);
		}
	
	
		return listAllSort;
	
	}

	
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, 2);
		  String element = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 0);
		  String element2 = QueryAmazonUsual.getElementFromMaxTwoDimension (array, max, 2, 1);
		  
		//Ajout de la valeur maximum dans la liste
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
	
	public static String[][] addListElementTwoDimension2 (String[][] array, String[][] arrayMax) {
	  	
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


	public static void setCol(String[] col) {
		Query4Amazon.col = col;
	}
	
	

}
