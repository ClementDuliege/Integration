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
	

		public static void query1Amazon() {
			Query1Amazon.mainSort();
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
		Query3Amazon.mainSort();
	}
	
	
	
	
	     //guygyu
	
	public static void query4Amazon() {
		/*
	 DANS MA REQUETE JE SORT TOUT LES ELEMENT DE LA TABLES SALAIRE MAIS TRIER TU LA VERRA JAI MI DES COMMENTAIR
	 DU COUP TU PPREND LES 3 PREMIER DE CHAQUE BDD DONC DE CHAQUE TABLEAU TU FUSIONNE TOUT SA ET TU ME RENVOIE UN TABLEAU
	 AVEC LES NOM, LES SALAIRE; LES BONUS ET FAUT QUE SA SOIT UN TABLEAU RANGER PAR ORDRE DECROISSANT EN FONCTION DES SALIRE
	*/	
		Query4Amazon.mainSort();
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
		Query5Amazon.mainSort();
	 
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
		Query9Amazon.mainSort();
	}
	
	
	
	/* TU RECUPE LES TAB DE CHAQUE BDD DU COUP TA 120 ELT ET TU PREND LES 40 QUI ON LE PLUS GROS SALAIRE
	 * ENSUITE TU RECUPERE LAGE DE C 40 SALAIRE ET TU FAIT LA MOYENNE JE TAI MIT LE TRUC MEME SI JE SAIS QUE TU SAIS LE FAIRE
	 * DONC JATTEND JUSTE L'AGE MOYEN (ENTIER)
	 */
	public static void query10Amazon() {
		
		Query10Amazon.mainSort();
		/*CALCULE DE LAGE MOYEN
	    ageSom += age;
	    ageMoy = ageSom/40;
	    */
	}
	
	
	
	public static void main (String [] args) {				
		
		//mainSort();	
		query10Amazon();
		
	}

	
}