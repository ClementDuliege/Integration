package query;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.org.glassfish.gmbal.ParameterNames;

import data.PaySlipCHN;
import data.Salarier;
import data.Sortbyroll;
import data.RecupTab;




	public class QueryDaoCHN {
	

/*Requête1----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * Method allowing to get the higher salary.
	 */
	/**
	 * @return tab with higher salary and the name to the person associated.
	 */
	public static String[][] query1() {
		RecupTab.recupTab();
	    int max = 0;
	    String firstname = null;
	    int cpt = 0;
	    int indice =0;
	    int [] hightersalary = new int [250];
	    String[]name = new String [250];
	    int[]salary = new int [250];
	    
		int debut=0;
	    String col[] = { "Salaires" , "prenom"};
		String cont[][] = new String[10][2];
	
	    
	            for(int i = 0; i<RecupTab.sizeTab; i++) {
	            name[indice]=RecupTab.tabPaySlip[i][2];
	            salary[indice]=Integer.parseInt(RecupTab.tabPaySlip[i][4]);
	            
	            indice++;
	            
	            //On recherche le plus gros salaire
		             max = Integer.parseInt(RecupTab.tabPaySlip[i][4]); //converse Sting tab in Int tab 
		             hightersalary [cpt] = max;//
		             Arrays.sort(hightersalary);// sort tab            
			}
	   
	        for(int i = hightersalary.length-1; i>=hightersalary.length-10; i--) {//on read the ten highter salarys 
	       	 for(int j=0; j < salary.length; j++) {
	       		 if(hightersalary[i]==salary[j]) {
	       			 firstname = name[j];	 
	       		 } 
	       	}
	       
			cont[debut][0] = hightersalary[i] + "";
	        cont[debut][1] = firstname;
	        debut++;
	        //System.out.println("Highter salary : "+ hightersalary[i] + ", Firstname : " + firstname );
	        }	
	    
		return cont;
	}
	
	
/*Requête2----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * Method allowing to get the sum of paid leave.
	 */
	/**
	 * @return the sum of paid leave with number of persons in the society.
	 */
	public static int query2() {
		RecupTab.recupTab();
		int paidLeave=0;
	    int sumPaidLeave=0;
	    for(int i=0; i<RecupTab.sizeTab; i++) {
	    	paidLeave = Integer.parseInt(RecupTab.tabPaySlip[i][6]);
	    	sumPaidLeave += paidLeave;
	    }
		
	
		return sumPaidLeave;
	}
	


/*Requête3----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/
	/**
	 * Method allowing to get the 5 best salaries with biggest paid leave.
	 */
	/**
	 * @return tab of the 5 best salaries with biggest paid leave.
	 */
	public static String[][] query3() {
		RecupTab.recupTab();
		int paidLeave = 0, paidLeaveMax = 0;
		int salary = 0, salaryMax = 0;
		int tmp = 0;
		int[] tabPaidLeave = new int[250];
		int[] id = new int[250];
		String[][] querytab3 = new String[5][3];
		   for(int k=0; k<RecupTab.sizeTab; k++) {/*we shearch the smallest paidleave*/
			   paidLeave = Integer.parseInt(RecupTab.tabPaySlip[k][6]);
			   if(paidLeave > paidLeaveMax) {
				   paidLeaveMax = paidLeave;
		    	}
		    }
		    for(int j=0; j<RecupTab.sizeTab; j++) {/*we shearch the smallest paidleave*/
				salary = Integer.parseInt(RecupTab.tabPaySlip[j][4]);
				paidLeave = Integer.parseInt(RecupTab.tabPaySlip[j][6]);
				if(paidLeave == paidLeaveMax) {
					if(salary > salaryMax) {
						id[tmp] = j;
						tabPaidLeave[tmp] = salary;
						salaryMax = salary;
						tmp++;
					}
				}
			}           
			for(int i=tmp; i>tmp-6; i--) {
				 querytab3[i][0] = RecupTab.tabPaySlip[id[i]][2];//prénom
		    	 querytab3[i][1] = RecupTab.tabPaySlip[id[i]][4];//salaire
		    	 querytab3[i][2] = RecupTab.tabPaySlip[id[i]][6];//paidLeave	    		 
		    	 i++;
				/*we post the 5 biggest salary with max paid leave */
				System.out.println("salarywithpaidLeave");
				System.out.println("id : " + RecupTab.tabPaySlip[id[i]][0] + " salaire :" + RecupTab.tabPaySlip[id[i]][4]);
			}
		
		return querytab3;
		
	}
	

/*Requête4----------------------------------------------------------------------------------------------------------------------------------------------	
 
-----------------------------------------------------------------------------------------------------------------------------------------------*/
	/**
	 * Method allowing to get the 3 best salaries with bonus included.
	 */
	/**
	 * @return tab of the 3 best salaries with bonus included.
	 */
	@SuppressWarnings("rawtypes")
	public static String[][] query4() {
		RecupTab.recupTab();
		int salary = 0, salaryBonus = 0;
		int bonus = 0;
		int[] id = new int[250];
		String[] tabSalaryBonus = new String[250];
		int i = 0, salaryMax = 0;
		int value = 0;
		String[][] querytab3 = new String[100][3];
		HashMap<Integer,Integer> mapSalaryBonus= new HashMap<Integer,Integer>(); 
		    
				for(int k=0; k<RecupTab.sizeTab; k++) {/*we shearch the smallest paidleave*/
					salary = Integer.parseInt(RecupTab.tabPaySlip[k][4]);
					bonus = Integer.parseInt(RecupTab.tabPaySlip[k][5]);
					salaryBonus = salary +(salary * bonus)/100;/*We add bonus in percent*/
					mapSalaryBonus.put(k, salaryBonus);
				}
				for (Map.Entry mapentry : mapSalaryBonus.entrySet()) {
					salary = (int) mapentry.getValue();
					if(salary>salaryMax) {/*We put best salary with bonus in tab and the id correspondding*/
						id[i] = (int) mapentry.getKey();
						value = (int) mapentry.getValue();
						tabSalaryBonus[i] = Integer.toString(value);
						salaryMax = (int) mapentry.getValue();
						i++;
					}
				}		
				for(int j=i-1; j>i-4; j--) {
					querytab3[j][0] = RecupTab.tabPaySlip[id[j]][1];
			   	 	querytab3[j][1] = tabSalaryBonus[j];
			   	 	querytab3[j][2] = RecupTab.tabPaySlip[id[j]][5];
					/*We post the 3 best salary with bonus include */
					System.out.println("salaryBonus");
					System.out.println("Nom : " + RecupTab.tabPaySlip[id[j]][1] + " : salaire avec bonus: "+tabSalaryBonus[j]);
				}

   	 	return querytab3;
	}
	
	
	/*Requête5----------------------------------------------------------------------------------------------------------------------------------------------	
	 
	-----------------------------------------------------------------------------------------------------------------------------------------------*/
	/**
	 * Method allowing to get the average bonus for the biggest paid leave and the smallest paid leave
	 */
	/**
	 * @return the average bonus for the biggest paid leave and the smallest paid leave
	 */
	public static String[][] query5() {
			RecupTab.recupTab();
			String[][] querytab = new String[100][3];
			int paidLeaveMin=30, paidLeaveMax = 0, paidLeave = 0;
			int sommeBonusMin = 0, moyBonusMin = 0;
			int sommeBonusMax = 0, moyBonusMax = 0;
			int cptMin = 0, cptMax = 0;
			
			for(int i=0; i<RecupTab.sizeTab; i++) {//we shearch the smallest paidleave
				paidLeave = Integer.parseInt(RecupTab.tabPaySlip[i][6]);
				if (paidLeave < paidLeaveMin) {
					paidLeaveMin = paidLeave;
				}
			}
			
			for(int i=0; i<RecupTab.sizeTab; i++) {//we shearch the smallest paidleave
				paidLeave = Integer.parseInt(RecupTab.tabPaySlip[i][6]);
				if (paidLeave > paidLeaveMax) {
					paidLeaveMax = paidLeave;
				}
			}
			
			for(int i=0; i<RecupTab.sizeTab; i++) {
				paidLeave = Integer.parseInt(RecupTab.tabPaySlip[i][6]);
				if(paidLeaveMin == paidLeave) {
					sommeBonusMin += Integer.parseInt(RecupTab.tabPaySlip[i][5]);
					cptMin ++;
				}
				if(paidLeaveMax == paidLeave) {
					sommeBonusMax += Integer.parseInt(RecupTab.tabPaySlip[i][5]);
					cptMax ++;
				}
			}
			moyBonusMin = sommeBonusMin/cptMin;
			moyBonusMax = sommeBonusMax/cptMax;
			querytab[0][0] = Integer.toString(paidLeaveMin);
	   	 	querytab[0][1] = Integer.toString(paidLeaveMax);
	   	 	querytab[0][2] = Integer.toString(moyBonusMin);
			return querytab;
		}
		
		
	/*Requête6----------------------------------------------------------------------------------------------------------------------------------------------	
		 
	-----------------------------------------------------------------------------------------------------------------------------------------------*/
		/**
		 * Method allowing to get the meduim salary to the society
		 */
		/**
		 * @return the meduim salary to the society
		 */
		public static int query6() {
			RecupTab.recupTab();
			int sommeSalary=0, salary = 0;
		    int averageSalary=0;
		    
			for(int k=0; k<RecupTab.sizeTab; k++) {/*we make the average to the salaries of the company's employees*/
				salary = Integer.parseInt(RecupTab.tabPaySlip[k][4]);
				sommeSalary = sommeSalary + salary;
			}
		          
		       averageSalary = sommeSalary/(RecupTab.sizeTab);
		       System.out.println(salary);
		       return averageSalary;
		}
		
		
		
		
	/*Requête7----------------------------------------------------------------------------------------------------------------------------------------------	
		 
	-----------------------------------------------------------------------------------------------------------------------------------------------*/
		/**
		 * Method allowing to get the sum of employees of society
		 */
		/**
		 * @return the sum of employees of society
		 */
		public static int query7() {
			RecupTab.recupTab();
			int bonus=0;
		    int sumBonus=0;
		    for(int i=0; i<RecupTab.sizeTab; i++) {
		    	bonus = Integer.parseInt(RecupTab.tabPaySlip[i][5]);
		    	sumBonus += bonus;
		    }
		    return sumBonus;
		}
		
	
	/*Requête8----------------------------------------------------------------------------------------------------------------------------------------------	
		 
	-----------------------------------------------------------------------------------------------------------------------------------------------*/
		/**
		 * Method allowing to get the best employee in function of his bonus and paid leave
		 */
		/**
		 * @return the best employee in function of his bonus and paid leave
		 */
		public static String[][] query8() {
			RecupTab.recupTab();
			String[][] querytab = new String[1][5];
			int paidleaveMin=30, paidleave = 0;
			int	bonusMax = 0, bonus = 0;
			int salaryMax = 0, salary = 0;
			int tmp = 0;
			
		    
					for(int k=0; k<RecupTab.sizeTab; k++) {//we shearch the smallest paidleave
						paidleave = Integer.parseInt(RecupTab.tabPaySlip[k][6]);
						if (paidleave < paidleaveMin) {
							paidleaveMin = paidleave;
						}
					}
					
					for(int m=0; m<RecupTab.sizeTab; m++) {//we shearch the biggest bonus among the smallest paidleave*
						bonus = Integer.parseInt(RecupTab.tabPaySlip[m][5]);
						if(Integer.parseInt(RecupTab.tabPaySlip[m][6])==paidleaveMin) {
							if(bonus > bonusMax) {
								bonusMax = bonus;
							}
						}
					}
					
					for(int l=0; l<RecupTab.sizeTab; l++) {/*we shearch the biggest salary among the biggest bonus and the smallest paidleave*/
						if((Integer.parseInt(RecupTab.tabPaySlip[l][5])==bonusMax) &&(Integer.parseInt(RecupTab.tabPaySlip[l][6])==paidleaveMin)) {
							salary = Integer.parseInt(RecupTab.tabPaySlip[l][4]);
							if(salary > salaryMax) {
								salaryMax = salary;
								tmp = l;
							}
						}
					}
					 querytab[0][0] = RecupTab.tabPaySlip[tmp][1];//name
			    	 querytab[0][1] = RecupTab.tabPaySlip[tmp][2];//firstname
			    	 querytab[0][2] = RecupTab.tabPaySlip[tmp][4];//salary
			    	 querytab[0][3] = RecupTab.tabPaySlip[tmp][5];//bonus
			    	 querytab[0][4] = RecupTab.tabPaySlip[tmp][6];//paid leave
			return querytab;
		}
		

	/*Requête9----------------------------------------------------------------------------------------------------------------------------------------------	
		 
	-----------------------------------------------------------------------------------------------------------------------------------------------*/
		/**
		 * Method allowing to get the 3 best salary for the youngest peoples
		 */
		/**
		 * @return tab of the 3 best salaries for the youngest peoples
		 */
		public static String[][] query9() {
			RecupTab.recupTab();
			String[][] querytab = new String[3][3];
			int minAge = 50, age = 0;
			int salary = 0;
			ArrayList<Salarier> ar = new ArrayList<Salarier>();
			
				for(int i=0; i<RecupTab.sizeTab; i++) {//we shearch the smallest age
					age = Integer.parseInt(RecupTab.tabPaySlip[i][3]);
					if (age < minAge) {
						minAge = age;
					}
				}
				
				for(int j=0; j<RecupTab.sizeTab; j++) {//we shearch the biggest salary
					salary = Integer.parseInt(RecupTab.tabPaySlip[j][4]);
					if(Integer.parseInt(RecupTab.tabPaySlip[j][3])==minAge) 
						ar.add(new Salarier(j,salary));
				}
				
				Collections.sort(ar, new Sortbyroll());//Sort the ArrayList in function of salary with id corresponding
				System.err.println("------Requête9--------------minAgeSalary-----------------------");
				
				for (int i=ar.size()-1; i>=ar.size()-3; i--) {  
					age =Integer.parseInt(RecupTab.tabPaySlip[ar.get(i).getId()][3]);//we recuperate age with the id of ArrayList
			        String nom = RecupTab.tabPaySlip[ar.get(i).getId()][1]; 
			        //String prenom = tabPaySlip[ar.get(i).getId()][1];
			        salary = ar.get(i).getSalary();
			        querytab[i][0] = nom;
			    	querytab[i][1] = Integer.toString(age);  		 
			    	querytab[i][2] = Integer.toString(salary);
				} 
			return querytab;
		}
		

	/*Requête10----------------------------------------------------------------------------------------------------------------------------------------------	
		 
	-----------------------------------------------------------------------------------------------------------------------------------------------*/
		/**
		 * Method allowing to get the medium age with the best salary
		 */
		/**
		 * @return tab of 40 salaries with age corresponding 
		 */
		public static String[][] query10() {
			RecupTab.recupTab();
			String[][] querytab = new String[40][2];
			int salary = 0;
			int age = 0;
			int sommeAge = 0, moyAge = 0;
			ArrayList<Salarier> ar = new ArrayList<Salarier>();
				for(int i=0; i<RecupTab.sizeTab; i++) {//we recuperate the id and salary associated */
					salary = Integer.parseInt(RecupTab.tabPaySlip[i][4]);
					ar.add(new Salarier(i,salary));
				}	
				Collections.sort(ar, new Sortbyroll());//Sort the ArrayList in function of salary with id corresponding
				for (int i=ar.size()-1; i>=ar.size()-40; i--) {  
		            age =Integer.parseInt(RecupTab.tabPaySlip[ar.get(i).getId()][3]);//we recuperate age with the id of ArrayList
		            salary = Integer.parseInt(RecupTab.tabPaySlip[ar.get(i).getId()][4]);
		            sommeAge += age;
		            moyAge = sommeAge/40;   
		            querytab[i][0] = Integer.toString(salary);
				    querytab[i][1] = Integer.toString(age);
		    } 
			return querytab;
		}
		

}
