package amazon;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.postgresql.core.Query;

import query.QueryDaoCHN;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class QueryAmazon {
	
	
	
	public static void mainSort() {
		QueryDaoUSA usa = new QueryDaoUSA();
		QueryDaoFR fr = new QueryDaoFR();
		QueryDaoCHN chn = new QueryDaoCHN();

		String[][] listFirstA = {{"121", "aa"}, {"4", "bb"}, {"7", "cc"}};
		String[][] listFirstB = {{"2", "dd"}, {"5", "ee"}, {"8", "gg"}};
		String[][] listFirstC = {{"3", "hh"}, {"4", "ii"}, {"6", "jj"}};
		
		String[][] listMerge1 = mergeArrayTwoDimension(usa.query1(),fr.query1());
		String[][] listMerge2 = mergeArrayTwoDimension(listMerge1,chn.query1());		
		
		String[][] listFirstMax = new String[10][2];
		
		listFirstMax = addListElementTwoDimension (listMerge2, listFirstMax);
		String[][] listRemoveFirstA = getAndDeleteMaxElementTwoDimension(listMerge2);
		
	
		for (int i=0; i<8; i++) {
			listFirstMax = addListElementTwoDimension (listRemoveFirstA, listFirstMax);	
			listRemoveFirstA = getAndDeleteMaxElementTwoDimension(listRemoveFirstA);
		  }
		
		System.out.println("Toutes les valeurs max sont dans cette liste: ");
		for (int i = 0; isStringInt(listFirstMax, i) == true ; i++) {
			System.out.println(listFirstMax[i][0]);
		}
		
		System.out.println("Et voici la liste de base (là ou y a '-1' c'était la place de valeur max): ");
		for (int i = 0; i < listRemoveFirstA.length ; i++) {
			System.out.println(listRemoveFirstA[i][0]);
		}
	
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
	    frame.setVisible(true);
	
	}
	
	public static String maxValueTwoDimension (String array[][]) {
		int max = Integer.parseInt(array[0][0]);
		for (int i = 1; i<array.length ; i++) {
			if (max < Integer.parseInt(array[i][0])) {
				max = Integer.parseInt(array[i][0]);
			}
		}
		String max_final = Integer.toString(max);
		
		return max_final;
	}
	
	public static String[][] addListElementTwoDimension (String[][] array, String[][] arrayMax) {
	  	
		  String max = maxValueTwoDimension(array);
		  
		//Ajout de la valeur maximum dans la liste
		  for (int i = 0; i < arrayMax.length; i++) {
			  if (isStringInt(arrayMax, i) == false) {
				  arrayMax[i][0] = max;
				  break;
			  }
		  }
			
		  return arrayMax;	
				
		}
	
	public static boolean isStringInt(String[][] array, int i)
	{
	    try
	    {
	        Integer.parseInt(array[i][0]);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
	public static String[][] getAndDeleteMaxElementTwoDimension(String[][] array) {
	  	
		  String max = maxValueTwoDimension(array);
		  
		  int max_delete = Integer.parseInt(max);
		  for (int i = 0; i<array.length ; i++) {
			 if (max_delete == Integer.parseInt(array[i][0])) {
				 array[i][0] = "-1";
				 break;
			 }
		  }
				
		  return array;	
				
		}
	
	public static String[][] mergeArrayTwoDimension(String[][] array1, String[][] array2) {
		String[][] result = new String[array1.length + array2.length][];

		System.arraycopy(array1, 0, result, 0, array1.length);
		System.arraycopy(array2, 0, result, array1.length, array2.length);
	      
	  return result;
	}
	
	
	
	// Requête N°2 DEJA FINI
	public static void query2Amazon() {
		int paid_leave;
		paid_leave = QueryDaoFR.query2() + QueryDaoUSA.query2();
		System.out.println("Requête 2 : l'addition des congés = " + paid_leave + "\n");
	}
	
	
	
	public static void query3Amazon() {
		/*
	 LA ON FAIT CE QUE LE PROF A DIT DU COUP JE SORT TT LES ELT NON TRIE DE CHAQUE BDD
	 DONC TOI TU VAS TOUT FUSIONNER ENSUITE TU RECUPERE LES 5 PLUS GROS CONGES ET QUE PARMIS SES 5 LA BAH TU LES TRIE  
	 EN FONCTION DE LEUR SALAIRE
	 */
	}
	
	
	
	
	     //guygyu
	
	public static void query4Amazon() {
		/*
	 DANS MA REQUETE JE SORT TOUT LES ELEMENT DE LA TABLES SALAIRE MAIS TRIER TU LA VERRA JAI MI DES COMMENTAIR
	 DU COUP TU PPREND LES 3 PREMIER DE CHAQUE BDD DONC DE CHAQUE TABLEAU TU FUSIONNE TOUT SA ET TU ME RENVOIE UN TABLEAU
	 AVEC LES NOM, LES SALAIRE; LES BONUS ET FAUT QUE SA SOIT UN TABLEAU RANGER PAR ORDRE DECROISSANT EN FONCTION DES SALIRE
	*/	
	}
	
	
	
	
	// REGARD CE QUE JAFFICHE AVC LA REQUETE PR COMPRENDRE
	// C LA REQUETE LA PLUS DUR ELLE EST LONGUE DU COUP JE VAIS TAIDER A LA FAIRE ON SE PARTAGERA LE TRUC
	public static void query5Amazon() {
		/*
	 TU VA RECUPERER LES 5 PREMIER ET LES 5 DERNIER ELT DE CHAQUE BDD VU QUELLE SERONT TRIER par ordre CROISSANT
	 ENSUITE TA DEUX CHOIX SOIT 
			1) TU CREER 2 TAB, UN AVC LES 15 PREM ET LAUTRE AVC LES 15 DER ET TU PREND PR LES DEUX LES 5 PREM/DER
			2) TU MET TT DANS UN TAB TU LES TRI EN FCT DU CONGES ET TU RECUP LES 5PREM ET LES 5DER QUE TU FOU DS UN TAB
	 DANS TOUT LES CAS ON DEVRA FAIRE LES DEUX POUR LAUTRE REQUETE DE COMPARAISON
	  */
	 
	}
	

	
	/*
	 *  CLEMENT FAIT LA STP ELLE EST VITE FAIT TU RECUP JUSTE LES METHODE QUERY6 DE CHAQUE BDD ET TU LES FOU DANS UN
	 *  TABLEAU TRIER PAR ORDRE DECROISSANT EN FCT DE LEUR SALAIRE TAURA QUE 3 ELT TFACON
	 */
	public static void query7Amazon() {
	}
	
	// JE BUG DESSUS MAIS JVAIS REGLER SA EN BALLE 
	public static void query8Amazon() {
	}
	
	/*
	 * TU RECUP 1 ELT PAR TAB DE CHAQUE BDD DU COUP TU ME CREER 1 TAB EN FONCTION DE LAGE ET SI
	 * YEN A QUI ON LE MEME AGE IL FAUT QUE TU ME RECUP LE GARS QUI A LE PLUS GROS SALAIRES TU ME RETOURNE SA SOUS FORME DE TABLEAU DU COUP TA 1 ELTM DEDANS
	 */
	public static void query9Amazon() {
		
	}
	
	
	
	/* TU RECUPE LES TAB DE CHAQUE BDD DU COUP TA 120 ELT ET TU PREND LES 40 QUI ON LE PLUS GROS SALAIRE
	 * ENSUITE TU RECUPERE LAGE DE C 40 SALAIRE ET TU FAIT LA MOYENNE JE TAI MIT LE TRUC MEME SI JE SAIS QUE TU SAIS LE FAIRE
	 * DONC JATTEND JUSTE L'AGE MOYEN (ENTIER)
	 */
	public static void query10Amazon() {
		
		
		/*CALCULE DE LAGE MOYEN
	    ageSom += age;
	    ageMoy = ageSom/40;
	    */
	}
	
	
	
	public static void main (String [] args) {				
		
		mainSort();	
		query2Amazon();
		
	}

	
}