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

import data.PaySlipCHN;
import data.Salarier;
import data.Sortbyroll;




	public class QueryDaoCHN {
	
		
	
	private static String csvFile = "Amazon_CHINE.csv";
    private static String line = "";
    private static String cvsSplitBy = ";";
    private static String[][] tabPaySlip = new String[250][250];
    public static int sizeTab = 0;
		
	
		public QueryDaoCHN() {
			RecupTab();
		}
			
		
		public void ajouter (PaySlipCHN payslip, String separator ,String fileName) {
			
			    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))){
			        
			    	//We write and we put the separator		
			    	
			    	writer.append(payslip.getId());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getName());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getFirstname());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getAge());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getSalary());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getVacation());
			    	writer.append(separator);
			                
			    	writer.append(payslip.getBonus());
			    	writer.append(separator);
			                        
			    	writer.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			
		}
	
	
	public void CSVReader() {
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	
	            while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	            	//On stocke dans notre tableau nos différents éléments graçe à notre séparateur
	                String[]payslip = line.split(cvsSplitBy);
	                
	                System.out.println("payslip[id= " + payslip[0]+ " , name=" + payslip[1]+ "]");
	
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
	
	public void recupCSV() {
		
	    String payslip2[][] = new String [250][250];
	    sizeTab = 0;
	  
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la première ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos différents éléments grace à notre séparateur
		            String[]payslip = line.split(cvsSplitBy);
		            int j=0;
		            
		            while(j != 7) {
		            	payslip2[sizeTab][j]=payslip[j];
		            	j++;
		            }
		            sizeTab++;
				}
				
				System.out.println(payslip2[4][1]);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String[][] RecupTab() {
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la première ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos différents éléments graçe à notre séparateur
		            String[]payslip = line.split(cvsSplitBy);
		            int j=0;
		            
		            while(j != 7) {
		            	tabPaySlip[sizeTab][j]=payslip[j];
		            	j++;
		            }
		            sizeTab++;
				}
		
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return tabPaySlip;
		
}
	
/*Requête1----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/	
	public String[][] query1() {/*we recuperate the best salary*/

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
	
	    
	            for(int i = 0; i<sizeTab; i++) {
	            name[indice]=tabPaySlip[i][2];
	            salary[indice]=Integer.parseInt(tabPaySlip[i][4]);
	            
	            indice++;
	            
	            //On recherche le plus gros salaire
		             max = Integer.parseInt(tabPaySlip[i][4]); //converse Sting tab in Int tab 
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
	
	/*Requete 1*/
	public void highterSalary() {/*On récupère le plus haut salaire*/
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
	
	    
	            for(int i = 0; i<sizeTab; i++) {
	            name[indice]=tabPaySlip[i][2];
	            salary[indice]=Integer.parseInt(tabPaySlip[i][4]);
	            
	            indice++;
	            
	            //On recherche le plus gros salaire
		             max = Integer.parseInt(tabPaySlip[i][4]); //converse Sting tab in Int tab 
		             hightersalary [cpt] = max;//
		             Arrays.sort(hightersalary);// sort tab 
		            
	                        
	
			}
	        System.err.println("------Requête1--------------highterSalary-----------------------");
	        for(int i = hightersalary.length-1; i>=hightersalary.length-10; i--) {//on read the ten highter salarys 
	       	 for(int j=0; j < salary.length; j++) {
	       		 if(hightersalary[i]==salary[j]) {
	       			 firstname = name[j];	 
	       		 } 
	       	}
	       
			cont[debut][0] = hightersalary[i] + "";
	        cont[debut][1] = firstname;
	        debut++;
	        System.out.println("Highter salary : "+ hightersalary[i] + ", Firstname : " + firstname );
	        }	
	    
	   
		
	}
	
	public void selectPayslip() {
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    int max = 0;
	    int cpt = 0;
	    int [] hightersalary = new int [250];
	    int []salary = new int [100];
	    int debut=0;
	   
	    String col[] = { "Salaires" , "prenom"};
		String cont[][] = new String[10][3];
	
	
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	   	 reader.readLine();/*On lit la première ligne car c'est les infos des colonnes*/
	        while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	           //On stocke dans notre tableau nos différents éléments graçe à notre séparateur
	            String[]payslip = line.split(cvsSplitBy);
	
	            //On recherche le plus gros salaire
	          if(payslip[4]!=" salaire") {
		             max = Integer.parseInt(payslip[4]); //converse Sting tab in Int tab 
		             hightersalary [cpt] = max;//
		             Arrays.sort(hightersalary);// sort tab 
		            
	            }              
	
	        }
	        for(int tmp = hightersalary.length-1; tmp>=hightersalary.length-10; tmp--) {//on read the ten highter salarys 
	        //System.out.println(tmp);
	        	
	        	//salary[debut] = hightersalary[tmp];
	        	//debut++;
	        System.out.println("Highter salaryss : " +hightersalary[tmp] );
	        cont[debut][0] = hightersalary[tmp] + "";
	        cont[debut][1] = "prenom";
	        debut++;
	        }
	        
	        
	 //       int i = 0;
		 //     while (i<=10) {
		        //int id = result.getInt("salary");
		//        //String prenom = result.getString("firstname");
		  //      cont[i][0] = salary[i] + "";
		   //     cont[i][1] = "prenom";
		 //       i++;
		  //    }
	        
	         
	          DefaultTableModel model = new DefaultTableModel(cont,col);
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
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    
	
	}
		
		
	}
/*Requête2----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/	
	public static int query2() {
		int paidLeave=0;
	    int sumPaidLeave=0;
	    for(int i=0; i<sizeTab; i++) {
	    	paidLeave = Integer.parseInt(tabPaySlip[i][6]);
	    	sumPaidLeave += paidLeave;
	    }
		
	
		return sumPaidLeave;
	}
	
	//Requête 2
	/**
	 * Method allowing to get the sum of paid leave.
	 */
	public void sumPaidLeave() {
		
	    int paidLeave=0;
	    int sumPaidLeave=0;
	    for(int i=0; i<sizeTab; i++) {
	    	paidLeave = Integer.parseInt(tabPaySlip[i][6]);
	    	sumPaidLeave += paidLeave;
	    }
	    System.err.println("------Requête2--------------sumPaidLeave-----------------------");
	    System.out.println("sumPaidLeave");
		System.out.println("Somme des congés : " + sumPaidLeave);
	}
/*Requête3----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/
	public static String[][] query3() {
		  	int paidLeave = 0, paidLeaveMax = 0;
		    int salary = 0, salaryMax = 0;
		    int tmp = 0;
		    int[] tabPaidLeave = new int[250];
		    int[] id = new int[250];
		    String[][] querytab3 = new String[5][3];
		    HashMap<Integer,Integer> mapPaidLeave = new HashMap<Integer,Integer>();
		    for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
		    	paidLeave = Integer.parseInt(tabPaySlip[k][6]);
		    	if(paidLeave > paidLeaveMax) {
		    		paidLeaveMax = paidLeave;
		    	}
		    }
		    for(int j=0; j<sizeTab; j++) {/*we shearch the smallest paidleave*/
				salary = Integer.parseInt(tabPaySlip[j][4]);
				paidLeave = Integer.parseInt(tabPaySlip[j][6]);
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
				 querytab3[i][0] = tabPaySlip[id[i]][2];//prénom
		    	 querytab3[i][1] = tabPaySlip[id[i]][4];//salaire
		    	 querytab3[i][2] = tabPaySlip[id[i]][6];//paidLeave	    		 
		    	 i++;
				/*we post the 5 biggest salary with max paid leave */
				System.out.println("salarywithpaidLeave");
				System.out.println("id : " + tabPaySlip[id[i]][0] + " salaire :" + tabPaySlip[id[i]][4]);
			}
		
		return querytab3;
		
	}
	//Requête 3
	/**
	 * Method allowing to get the 5 best salaries with biggest paid leave.
	 */
	public void salarywithpaidLeave() {
	    int paidLeave = 0, paidLeaveMax = 0;
	    int salary = 0, salaryMax = 0;
	    int tmp = 0;
	    int[] tabPaidLeave = new int[250];
	    int[] id = new int[250];
	    HashMap<Integer,Integer> mapPaidLeave = new HashMap<Integer,Integer>();
	    for(int k=0; k<sizeTab; k++) {/*we shearch the biggest paidleave*/
	    	paidLeave = Integer.parseInt(tabPaySlip[k][6]);
	    	if(paidLeave > paidLeaveMax) {
	    		paidLeaveMax = paidLeave;
	    	}
	    }
	    for(int j=0; j<sizeTab; j++) {/*we shearch the biggest salary with the biggest paidleave*/
			salary = Integer.parseInt(tabPaySlip[j][4]);
			paidLeave = Integer.parseInt(tabPaySlip[j][6]);
			if(paidLeave == paidLeaveMax) {
				if(salary > salaryMax) {
					id[tmp] = j;
					tabPaidLeave[tmp] = salary;
					salaryMax = salary;
					tmp++;
				}
			}
		} 
	    System.err.println("------Requête3--------------salarywithpaidLeave-----------------------");
		for(int i=tmp; i>tmp-6; i--) {
			/*we post the 5 biggest salary with max paid leave */
			System.out.println("salarywithpaidLeave");
			System.out.println("id : " + tabPaySlip[id[i]][0] + " salaire :" + tabPaySlip[id[i]][4]);
		}
	}
/*Requête4----------------------------------------------------------------------------------------------------------------------------------------------	
 
-----------------------------------------------------------------------------------------------------------------------------------------------*/
	public static String[][] query4() {
		
		 	int salary = 0, salaryBonus = 0;
		    int bonus = 0;
		    int[] id = new int[250];
		    String[] tabSalaryBonus = new String[250];
		    int i = 0, salaryMax = 0;
		    String[][] querytab3 = new String[100][3];
		    HashMap<Integer,Integer> mapSalaryBonus= new HashMap<Integer,Integer>(); 
		    
				for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
					salary = Integer.parseInt(tabPaySlip[k][4]);
					bonus = Integer.parseInt(tabPaySlip[k][5]);
					salaryBonus = salary +(salary * bonus)/100;/*We add bonus in percent*/
					mapSalaryBonus.put(k, salaryBonus);
				}
				for (Map.Entry mapentry : mapSalaryBonus.entrySet()) {
					salary = (int) mapentry.getValue();
					if(salary>salaryMax) {/*We put best salary with bonus in tab and the id correspondding*/
						id[i] = (int) mapentry.getKey();
						tabSalaryBonus[i] = (String) mapentry.getValue();
						salaryMax = (int) mapentry.getValue();
						i++;
					}
				}		
				for(int j=i-1; j>i-4; j--) {
					querytab3[j][0] = tabPaySlip[id[j]][1];
			   	 	querytab3[j][1] = tabSalaryBonus[j];
			   	 	querytab3[j][2] = tabPaySlip[id[j]][5];
					/*We post the 3 best salary with bonus include */
					System.out.println("salaryBonus");
					System.out.println("Nom : " + tabPaySlip[id[j]][1] + " : salaire avec bonus: "+tabSalaryBonus[j]);
				}

   	 	return querytab3;
	}
	//Requête 4
	/**
	 * Method allowing to get the 3 best salaries with bonus included.
	 */
	public void salaryBonus() {	    
	    int salary = 0, salaryBonus = 0;
	    int bonus = 0;
	    int[] id = new int[250];
	    int[] tabSalaryBonus = new int[250];
	    int i = 0, salaryMax = 0;
	    HashMap<Integer,Integer> mapSalaryBonus= new HashMap<Integer,Integer>(); 
	    
			for(int k=0; k<sizeTab; k++) {/*we shearch the smallest paidleave*/
				salary = Integer.parseInt(tabPaySlip[k][4]);
				bonus = Integer.parseInt(tabPaySlip[k][5]);
				salaryBonus = salary +(salary * bonus)/100;/*We add bonus in percent*/
				mapSalaryBonus.put(k, salaryBonus);
			}
			for (Map.Entry mapentry : mapSalaryBonus.entrySet()) {
				salary = (int) mapentry.getValue();
				if(salary>salaryMax) {/*We put best salary with bonus in tab and the id correspondding*/
					id[i] = (int) mapentry.getKey();
					tabSalaryBonus[i] = (int) mapentry.getValue();
					salaryMax = (int) mapentry.getValue();
					i++;
				}
			}
			System.err.println("------Requête4--------------salaryBonus-----------------------");
			for(int j=i-1; j>i-4; j--) {
				/*We post the 3 best salary with bonus include */
				System.out.println("salaryBonus");
				System.out.println("Nom : " + tabPaySlip[id[j]][1] + " : salaire avec bonus: "+tabSalaryBonus[j]);
			}

	}
/*Requête6----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/
	
	//Requête 6
	/**
	 * Method allowing to get the meduim salary to the society
	 */
	public void meduimSalary() {
	    int sommeSalary=0, salary = 0;
	    int meduimSalary=0;
	    
		for(int k=0; k<sizeTab; k++) {/*we make the average to the salaries of the company's employees*/
			salary = Integer.parseInt(tabPaySlip[k][4]);
			sommeSalary = sommeSalary + salary;
		}
	          
	       meduimSalary = sommeSalary/(sizeTab);
	       System.err.println("------Requête6--------------meduimSalary-----------------------");
	       System.out.println("salaire moyen : " + meduimSalary);

	
	}
/*Requête7----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/

	//Requête 7
	/**
	 * Method allowing to get the best employee in function of his bonus and paid leave
	 */
	public void bestEmployees() {
	    int paidleaveMin=30, paidleave = 0;
		int	bonusMax = 0, bonus = 0;
		int salaryMax = 0, salary = 0;
		int tmp = 0;
		
	    
				for(int k=0; k<sizeTab; k++) {//we shearch the smallest paidleave
					paidleave = Integer.parseInt(tabPaySlip[k][6]);
					if (paidleave < paidleaveMin) {
						paidleaveMin = paidleave;
					}
				}
				
				for(int m=0; m<sizeTab; m++) {//we shearch the biggest bonus among the smallest paidleave*
					bonus = Integer.parseInt(tabPaySlip[m][5]);
					if(Integer.parseInt(tabPaySlip[m][6])==paidleaveMin) {
						if(bonus > bonusMax) {
							bonusMax = bonus;
						}
					}
				}
				
				for(int l=0; l<sizeTab; l++) {/*we shearch the biggest salary among the biggest bonus and the smallest paidleave*/
					if((Integer.parseInt(tabPaySlip[l][5])==bonusMax) &&(Integer.parseInt(tabPaySlip[l][6])==paidleaveMin)) {
						salary = Integer.parseInt(tabPaySlip[l][4]);
						if(salary > salaryMax) {
							salaryMax = salary;
							tmp = l;
						}
					}
				}
				System.err.println("------Requête7--------------bestEmployees-----------------------");
				System.out.println("bestEmployees");
				System.out.println("The best employees : " +tabPaySlip[tmp][2]);
	    
}
/*Requête9----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/
	//Requête9
	/**
	 * Method allowing to get the 3 best salary for the youngest peoples
	 */
	public void minAgeSalary() {
	int minAge = 50, age = 0;
	int salary = 0;
	ArrayList<Salarier> ar = new ArrayList<Salarier>();
	
		for(int i=0; i<sizeTab; i++) {/*we shearch the smallest age*/
			age = Integer.parseInt(tabPaySlip[i][3]);
			if (age < minAge) {
				minAge = age;
			}
		}
		
		for(int j=0; j<sizeTab; j++) {/*we shearch the biggest salary*/
			salary = Integer.parseInt(tabPaySlip[j][4]);
			if(Integer.parseInt(tabPaySlip[j][3])==minAge) 
				ar.add(new Salarier(j,salary));
		}
		
		Collections.sort(ar, new Sortbyroll());
		System.err.println("------Requête9--------------minAgeSalary-----------------------");
		
		for (int i=ar.size()-1; i>=ar.size()-3; i--) {  
			age =Integer.parseInt(tabPaySlip[ar.get(i).getId()][3]);//we recuperate age with the id of ArrayList
	        String nom = tabPaySlip[ar.get(i).getId()][1]; 
	        String prenom = tabPaySlip[ar.get(i).getId()][1];
	        salary = ar.get(i).getSalary();
			System.out.println("Nom : " + nom + "\tPrenom : " + prenom + "\tage : " + age + "\tsalary : " + salary);
		} 

}
/*Requête10----------------------------------------------------------------------------------------------------------------------------------------------	
	 
-----------------------------------------------------------------------------------------------------------------------------------------------*/
	//requête 10
	/**
	 * Method allowing to get the medium age with the best salary
	 */
	public void bestAge() {
	int salary = 0;
	int age = 0;
	int cpt = 0;
	int sommeAge = 0, moyAge = 0;
	ArrayList<Salarier> ar = new ArrayList<Salarier>();
		for(int i=0; i<sizeTab; i++) {//we recuperate the id and salary associated */
			salary = Integer.parseInt(tabPaySlip[i][4]);
			ar.add(new Salarier(i,salary));
		}	
		Collections.sort(ar, new Sortbyroll());//Sort the ArrayList in function of salary with id corresponding
		System.err.println("------Requête10--------------bestAge-----------------------");
		for (int i=ar.size()-1; i>=ar.size()-40; i--) {  
            age =Integer.parseInt(tabPaySlip[ar.get(i).getId()][3]);//we recuperate age with the id of ArrayList
            sommeAge += age;
            moyAge = sommeAge/40;    
    } 
		System.out.println("Age with best meduim salary : " + moyAge);
	}
	public void ajouter(PaySlipCHN payslip) {
		// TODO Auto-generated method stub
		
	}
	}
