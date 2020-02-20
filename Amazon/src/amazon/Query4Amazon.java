package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query4Amazon {
	
	public static void mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();
		
		String[][] listFirstA = {{"a", "500", "1"}, {"b", "51", "2"}, {"c", "52", "3"}
		,{"d", "53", "4"}, {"e", "54", "5"}, {"f", "55", "6"}
		,{"g", "56", "7"}, {"h", "57", "8"}, {"i", "58", "9"}
		,{"j", "59", "10"}, {"k", "60", "11"}, {"l", "61", "12"}
		,{"m", "62", "13"}, {"n", "63", "14"}, {"o", "64", "15"}};
		String[][] listFirstB = {{"aa", "654", "16"}, {"bb", "66", "17"}, {"cc", "67", "18"}
		,{"dd", "68", "19"}, {"ee", "69", "20"}, {"ff", "70", "21"}
		,{"gg", "271", "22"}, {"hh", "72", "23"}, {"ii", "73", "24"}
		,{"jj", "74", "25"}, {"kk", "75", "26"}, {"ll", "746", "27"}
		,{"mm", "77", "28"}, {"nn", "78", "29"}, {"oo", "79", "30"}};
		String[][] listFirstC = {{"aaa", "80", "31"}, {"bbb", "81", "32"}, {"ccc", "82", "33"}
		,{"ddd", "83", "34"}, {"eee", "84", "35"}, {"fff", "85", "36"}
		,{"ggg", "86", "37"}, {"hhh", "817", "38"}, {"iii", "88", "39"}
		,{"jjj", "89", "40"}, {"kkk", "90", "41"}, {"lll", "791", "42"}
		,{"mmm", "92", "43"}, {"nnn", "93", "44"}, {"ooo", "94", "45"}};

		String[][] listAll = new String[15][3];
		String[][] listAllSort = new String[15][3];


		
		//String[][] listMaxFinal = new String[5][3];
		//String[][] listMinFinal = new String[5][3];
		
		
		/* Remplissage liste All */
		listAll = addListElementTwoDimension (listFirstA, listAll);	
		String[][] listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstA, 2);	
		for (int i=1; i<5; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 2);
		}
		
		listAll = addListElementTwoDimension (listFirstB, listAll);
		listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstB, 2);	
		for (int i=1; i<5; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 2);
		}
		
		listAll = addListElementTwoDimension (listFirstC, listAll);
		listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listFirstC, 2);	
		for (int i=1; i<5; i++) {
			listAll = addListElementTwoDimension (listRemove, listAll);	
			listRemove = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemove, 2);
		}
		
		
		System.out.println("Liste All non triée (mais c les 5 plus gros bonus de chaque bdd): ");
		for (int i = 0; i < listAll.length == true ; i++) {
			System.out.println("Prenom: " + listAll[i][0] + ", Salaire: " + listAll[i][1] + ", Bonus: " + listAll[i][2]);
		}
		
		
		/* Remplissage liste All Sort */
		listAllSort = addListElementTwoDimension2 (listAll, listAllSort);	
		String[][] listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listAll, 1);	
		for (int i=1; i<15; i++) {
			listAllSort = addListElementTwoDimension2 (listRemoveSort, listAllSort);	
			listRemoveSort = QueryAmazonUsual.getAndDeleteMaxElementTwoDimension(listRemoveSort, 1);
		}
		
				
		System.out.println("Liste All triée: ");
		for (int i = 0; i < listAllSort.length == true ; i++) {
			System.out.println("Prenom: " + listAllSort[i][0] + ", Salaire: " + listAllSort[i][1] + ", Bonus: " + listAllSort[i][2]);
		}
	
	/*
		DefaultTableModel model = new DefaultTableModel(listFirstMax, QueryDaoUSA.getCol());
	    JTable table = new JTable(model);
	    table.setShowGrid(true);
	    table.setShowVerticalLines(true);
	    JFrame frame = new JFrame("Affichage JTable");
	    JPanel panel = new JPanel();
	    JScrollPane pane = new JScrollPane(table);
	    panel.add(pane);
	    frame.add(panel);
	    frame.setSize(500, 250);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);*/
	
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

}
