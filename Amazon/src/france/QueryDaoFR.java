package france;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import usa.JdbcConnectionUSA;
import usa.QueryDaoUSA;


public class QueryDaoFR{
	
	
	public String[][] query1() {
		String cont[][] = new String[10][2];
		try {
			String selectQuery = "SELECT firstname, salary FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC LIMIT 10;";                
		
			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			
			ResultSet result = state.executeQuery(selectQuery);

			 int i = 0;
		      while (result.next()) {
		        int id = result.getInt("salary");
		        String prenom = result.getString("firstname");
		        cont[i][0] = Integer.toString(id);
		        cont[i][1] = prenom;
		        i++;
		      }
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return cont;
	}
	
	public static int query2() {	
		int sum = 0;
		try {
			String selectQuery = "SELECT SUM(paid_leave) FROM payslip;";                
		
			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			
			ResultSet result = state.executeQuery(selectQuery);
			ResultSetMetaData resultMeta = result.getMetaData();

			System.out.println("\n*************************************************************************************************");
			for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
		    	 System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			}    	 
			System.out.println("\n*************************************************************************************************");
		         
		    while(result.next()){         
		    	 for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
		    		 sum = Integer.parseInt(result.getObject(i).toString());		    				 
		    		 System.out.print("\t" + sum + "\t |");
		    	 } 
		    	 System.out.println("\n---------------------------------------------------------------------------------");
		    }

		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return sum;
	}

	
	// Requête 3 : Affichage croissant des 5 salaires les plus gros en fonction des plus gros congés.
	public static String[][] query3() {
		String[][] querytab3 = new String[5][3];
		try {
			String selectQuery = "SELECT firstname, salary, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY paid_leave DESC, salary DESC LIMIT 5;";                

			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int salaire = result.getInt("salary");
		    	 int paidLeave = result.getInt("paid_leave");
		    	 String prenom = result.getString("firstname");
		    	 querytab3[i][0] = prenom;
		    	 querytab3[i][1] = Integer.toString(salaire);
		    	 querytab3[i][2] = Integer.toString(paidLeave);	    		 
		    	 i++;
		   	    }
		    
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab3;
	}
	
	// Affichage TRIER des salaires ayant les bonus compris dedans
		public static String[][] query4() {
			String[][] querytab3 = new String[100][3];
			try {
				// Affichage decroissant du nom, salire, bonus en fonction du salaire calculer avec les bonus
				String selectQuery = "SELECT firstname, (salary+(salary*bonus)/100)AS salary, bonus FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC;";                
				
				Connection dbConnection = JdbcConnectionFR.getConnection();
				Statement state = dbConnection.createStatement();
				ResultSet result = state.executeQuery(selectQuery);
				
				int i=0;
			    while(result.next()){ 
			    	 // initialisation des colonne qu'on utilise
			    	 int salaire = result.getInt("salary");
			    	 int bonus = result.getInt("bonus");
			    	 String prenom = result.getString("firstname");
			    	 // Remplissag du tableau avec pour colonnes : 1=prenom, 2=salaire, 3=bonus
			    	 querytab3[i][0] = prenom;
			    	 querytab3[i][1] = Integer.toString(salaire);
			    	 querytab3[i][2] = Integer.toString(bonus);	    		 
			    	 i++;
			   	}
			    				    
			    result.close();
			    state.close();
			      
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return querytab3;
		}
	
		
	// LA YA UN AFFICHAGE CROISSANT EN FONCTION DES CONGES
	public static String[][] query5() {
		String[][] querytab = new String[100][3];
		try {
			String selectQuery = "SELECT firstname, bonus, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY paid_leave ASC;";                

			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int bonus = result.getInt("bonus");
		    	 int paidLeave = result.getInt("paid_leave");
		    	 String prenom = result.getString("firstname");
		    	 // Remplissage du tableau avec pour colonnes : 1=prenom, 2=bonus, 3=conges
		    	 querytab[i][0] = prenom;
		    	 querytab[i][1] = Integer.toString(bonus);
		    	 querytab[i][2] = Integer.toString(paidLeave);	    		 
		    	 i++;
		   	}
		    
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab;
	}
	
	// Retourn un entier qui serat la moyenne
	public static int query6() {
		int averageSalary = 0;
		int allSalary = 0;
		try {
			String selectQuery = "SELECT salary FROM payslip;";                

			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	// Moyenne des salaires de la colonne 'salary'
		    	 int salary = result.getInt("salary");
		    	 allSalary += salary;
		    	 i++;
		    	 averageSalary = allSalary/i;
		    }
		    	
		    System.out.println(averageSalary);

		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return averageSalary;
	}
	
	// Somme des bonus
	public static int query7() {
		int averageSalary = 0;
		int allSalary = 0;
		try {
			String selectQuery = "SELECT salary FROM payslip;";                

			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	// Moyenne des salaires de la colonne 'salary'
		    	 int salary = result.getInt("salary");
		    	 allSalary += salary;
		    	 i++;
		    	 averageSalary = allSalary/i;
		    }
		    	
		    System.out.println(averageSalary);

		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return averageSalary;
	}
	
	
	public static String[][] query8() {
		String[][] querytab = new String[100][4];
		try {
			String selectQuery = "SELECT lastname, salary, bonus, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY bonus DESC, paid_leave;";                

			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int bonus = result.getInt("bonus");
		    	 int paidLeave = result.getInt("paid_leave");
		    	 int salary = result.getInt("salary");
		    	 String prenom = result.getString("lastname");
		    	 // Remplissage du tableau avec pour colonnes : 1=prenom, 2=bonus, 3=conges
		    	 querytab[i][0] = prenom;
		    	 querytab[i][1] = Integer.toString(salary);	    
		    	 querytab[i][2] = Integer.toString(bonus);
		    	 querytab[i][3] = Integer.toString(paidLeave);	    		 
		    	 i++;
		   	}
		    
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab;
	}
	
}
