package chine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


	public class QueryDaoCHN {
	
		
	private String line = "";
		
	
		public QueryDaoCHN() {
			
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
	
	   
	
	        String csvFile = "Amazon_CHINE.csv";
	        String line = "";
	        String cvsSplitBy = ";";
	
	        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	
	            while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	            	//On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
	                String[]payslip = line.split(cvsSplitBy);
	                
	                System.out.println("payslip[id= " + payslip[0]+ " , name=" + payslip[1]+ "]");
	
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        
	
	    }
	
	}
	public void recupCSV() {
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    String payslip2[][] = new String [250][250];
	    int i = 0;
	  
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la premi�re ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos diff�rents �l�ments grace � notre s�parateur
		            String[]payslip = line.split(cvsSplitBy);
		            int j=0;
		            
		            while(j != 7) {
		            	payslip2[i][j]=payslip[j];
		            	j++;
		            }
		            i++;
				}
				for(int k=0; k<202; k++) {
					for(int l=0; l<=6; l++) {
						//System.out.println(payslip2[k][l]);
					}
					//System.out.println("\n");
				}
				System.out.println(payslip2[4][1]);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void highterSalarya() {/*On r�cup�re le plus haut salaire*/
		 String csvFile = "Amazon_CHINE.csv";
	     String line = "";
	     String cvsSplitBy = ";";
	     int max = 0;
	     int cpt = 0;
	     //int hightsalary[] = null ;
	     //new hightsalary[100];
	     int [] hightersalary = new int [250];
	
	     try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	    	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
	         while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	            //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
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
	         System.out.println("Highter salary : "+ hightersalary[tmp] );
	         }
	     } catch (IOException e) {
	         e.printStackTrace();
	     
	
	 }
	}
	
	public String[][] query1() {/*On r�cup�re le plus haut salaire*/
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
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
	
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	   	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
	        while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
	            String[]payslip = line.split(cvsSplitBy);
	            name[indice]=payslip[2];
	            salary[indice]=Integer.parseInt(payslip[4]);
	            
	            indice++;
	            //On recherche le plus gros salaire
	          if(payslip[4]!=" salaire") {
		             max = Integer.parseInt(payslip[4]); //converse Sting tab in Int tab 
		             hightersalary [cpt] = max;//
		             Arrays.sort(hightersalary);// sort tab 
		            
	            }              
	
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
	    
	    } catch (IOException e) {
	        e.printStackTrace();
	    	}
		return cont;
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
	   	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
	        while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
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
	
	public void sumPaidLeave() {
		
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    String[]paidLeave;
	    int[]intpPaidLeave;
	    int indice;
	    int paidleave=0;
	    int sumPaidLeave=0;
	    
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
		        while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
		            String[]payslip = line.split(cvsSplitBy);
		            paidleave = Integer.parseInt(payslip[6]);
		            sumPaidLeave += paidleave;
					
		            
		            
		            
			            
		            }              
	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	public void salarywithpaidLeave() {
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    String[] name = new String[250];
	    int[] salary = new int [250];
	    int []hg = new int [250];
	    int paidleave;
	    int indice=0,cpt=0;
	    int[] highterPaidLeave = new int [20];
	    String firstname = null;
	    int salarys = 0;
	    
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
		            String[]payslip = line.split(cvsSplitBy);
		            paidleave = Integer.parseInt(payslip[6]);//les cong�s
		            
					
		          
					name[indice]=payslip[2];//remplir les noms avec leur indice
					hg[indice] = Integer.parseInt(payslip[6]);//remplit les cong�s avec leur indices
		            salary[indice]=Integer.parseInt(payslip[4]);//remplit les salires avec leur indices
		            
		            indice++;
		            //On recherche les plus gros cong�s
		          if(payslip[6]!=" conges") {
			             //converse Sting tab in Int tab 
			             highterPaidLeave [cpt] = Integer.parseInt(payslip[6]);;//
			             Arrays.sort(highterPaidLeave);// sort tab 
			            
		            }              
		            
		            
			            
		            }
		        for(int i = highterPaidLeave.length-1; i>=highterPaidLeave.length-5; i--) {
		          	 for(int j=0; j < salary.length; j++) {
		          		 if(highterPaidLeave[i]==hg[j]) {
		          			 firstname = name[j];
		          			 salarys = salary[j];
		          		 } 
		          	}
		          	 System.out.println("Nom : "+ firstname +"\tsalaire : " + salarys + "\tcong�s :" + highterPaidLeave[i]);
		        }
	
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void salaryBonus() {
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    String[] name = new String[250];
	    int[] salary = new int [250];
	    int []hg = new int [250];
	    int bonus;
	    int salaire;
	    int indice=0,cpt=0;
	    int[] highterSalary = new int [250];
	    String firstname = null;
	    int salarys = 0;
	    
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la premi�re ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
		            String[]payslip = line.split(cvsSplitBy);
		            bonus = Integer.parseInt(payslip[5]);//les cong�s
		            salaire = Integer.parseInt(payslip[4]);
		            highterSalary[indice] = salaire +(salaire * bonus)/100;
		            salary[indice] = salaire +(salaire * bonus)/100;
		            name[indice]= payslip[2];
		            indice++;
				}
				Arrays.sort(highterSalary);
				  for(int i = highterSalary.length-1; i>=highterSalary.length-3; i--) {//on read the ten highter salarys 
			          	 for(int j=0; j < salary.length; j++) {
			          		 if(highterSalary[i]==salary[j]) {
			          			 firstname = name[j];
			          			 
			          		 } 
			          	}
			          	 System.out.println("Nom : "+ firstname +"\tsalaire : " + highterSalary[i] );
			        }
				
				
				
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void meduimSalary() {
		 String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    int computer = 0;
	    int sommeSalary=0;
	    int meduimSalary=0;
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
	  	 reader.readLine();/*On lit la premi�re ligne car c'est les infos des colonnes*/
	       while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
	          //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
	           String[]payslip = line.split(cvsSplitBy);
	           sommeSalary = sommeSalary + Integer.parseInt(payslip[4]);
	           computer ++;
	              
	          
	
			}
	       meduimSalary = sommeSalary/(computer);
	       System.out.println(meduimSalary);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void bestEmployees() {
		String csvFile = "Amazon_CHINE.csv";
	    String line = "";
	    String cvsSplitBy = ";";
	    String payslip2[][] = new String [250][250];
	    int i = 0;
	    int paidleaveMin=30, paidleave = 0;
		int	bonusMax = 0, bonus = 0;
		int salaryMax = 0, salary = 0;
		int tmp = 0;
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la premi�re ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos diff�rents �l�ments gra�e � notre s�parateur
		            String[]payslip = line.split(cvsSplitBy);
		            int j=0;
		            
		            while(j != 7) {
		            	payslip2[i][j]=payslip[j];
		            	j++;
		            }
		            i++;
				}
				for(int k=0; k<i; k++) {/*we shearch the smallest paidleave*/
					paidleave = Integer.parseInt(payslip2[k][6]);
					if (paidleave < paidleaveMin) {
						paidleaveMin = paidleave;
					}
				}
				
				for(int m=0; m<i; m++) {/*we shearch the biggest bonus among the smallest paidleave*/
					bonus = Integer.parseInt(payslip2[m][5]);
					if(Integer.parseInt(payslip2[m][6])==paidleaveMin) {
						if(bonus > bonusMax) {
							bonusMax = bonus;
						}
					}
				}
				
				for(int l=0; l<i; l++) {/*we shearch the biggest salary among the biggest bonus and the smallest paidleave*/
					if((Integer.parseInt(payslip2[l][5])==bonusMax) &&(Integer.parseInt(payslip2[l][6])==paidleaveMin)) {
						salary = Integer.parseInt(payslip2[l][4]);
						if(salary > salaryMax) {
							salaryMax = salary;
							tmp = l;
						}
					}
				}
				System.out.println(payslip2[tmp][0]);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ajouter(PaySlipCHN payslip) {
		// TODO Auto-generated method stub
		
	}
	}
