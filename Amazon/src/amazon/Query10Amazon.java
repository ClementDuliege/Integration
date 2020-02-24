package amazon;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class Query10Amazon {
	
	private static String col[] = { "Moyenne"};
	
	public static String mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();


		String[][] listMerge1 = QueryAmazonUsual.mergeArrayTwoDimension(usa.query10(), fr.query10());
		String[][] listMerge2 = QueryAmazonUsual.mergeArrayTwoDimension(listMerge1,chn.query10());		
			

		int valueA = 0, valueB = 0, valueC = 0, moyenneA = 0, moyenneB = 0, moyenneC = 0;
		for (int i = 0; i < usa.query10().length == true ; i++) {
			valueA = valueA + Integer.parseInt(usa.query10()[i][1]);
		}
		moyenneA = valueA / 40;
		System.out.println("la moyenne de l'age dans l'entreprise Américaine: " + moyenneA);
		
		for (int i = 0; i < fr.query10().length == true ; i++) {
			valueB = valueB + Integer.parseInt(fr.query10()[i][1]);
		}
		moyenneB = valueB / 40;
		System.out.println("la moyenne de l'age dans l'entreprise Française vaut: " + moyenneB);
		
		for (int i = 0; i < chn.query10().length == true ; i++) {
			valueC = valueC + Integer.parseInt(chn.query10()[i][1]);
		}
		moyenneC = valueC / 40;
		System.out.println("la moyenne de l'age dans l'entreprise Chinoise vaut: " + moyenneC);
		
		
		String valueFinal = "La moyenne 1 est : "+moyenneA+ "La moyenne 1 est : "+ moyenneB + "La moyenne 1 est : "+ moyenneC;
			
		return valueFinal;
	
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
	
	public static String[] getCol() {
		return col;
	}


	public static void setCol(String col[]) {
		Query10Amazon.col = col;
	}

}
