package query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.JdbcConnectionFR;
import connection.JdbcConnectionUSA;

/**
 * 
 * @author Ben Mansour Fares, Chahboun Taha, Duliege Clément
 *
 */
public class QueryDaoUSA{
	private static String db = "		  [USA]";
	
	public QueryDaoUSA() {
		
		
	}
	
	
	
	public void selectPayslip() {
		try {
			String selectQuery = "SELECT firstname, salary FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC LIMIT 10;";                
			String[] tab = new String[10];
	
			Connection dbConnection = JdbcConnectionUSA.getConnection();
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
		    		 System.out.print("\t" + result.getObject(i).toString() + "\t |");
		    	 } 
		    	 System.out.println("\n---------------------------------------------------------------------------------");

		    }

		    result.close();
		    state.close();
		         
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	
	}
	
	/**
	 * Method allowing to get the higher salary.
	 */
	/**
	 * @return tab with higher salary and the name to the person associated.
	 */
	public static String[][] query1() {
		String cont[][] = new String[10][2];
		try {
			String selectQuery = "SELECT firstname, salary FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC LIMIT 10;";                
			
			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
					
			ResultSet result = state.executeQuery(selectQuery);
			
			 int i = 0;
		      while (result.next()) {		    	
		        int id = result.getInt("salary");
		        String prenom = result.getString("firstname");
		        cont[i][0] = Integer.toString(id);
		        cont[i][1] = prenom + db;
		        
		        i++;      
		      }
		 	      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return cont;
	}
	
	/**
	 * Method allowing to get the sum of paid leave.
	 */
	/**
	 * @return the sum of paid leave with number of persons in the society.
	 */
	public static int query2() {	
		int sum = 0;
		try {
			String selectQuery = "SELECT SUM(paid_leave) FROM payslip;";                
		
			Connection dbConnection = JdbcConnectionUSA.getConnection();
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

	
	
	/**
	 * Method allowing to get the 5 best salaries with biggest paid leave.
	 */
	/**
	 * @return tab of the 5 best salaries with biggest paid leave.
	 */
	public static String[][] query3() {
		String[][] querytab3 = new String[5][3];
		try {
			String selectQuery = "SELECT firstname, salary, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY paid_leave DESC, salary DESC LIMIT 5;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int salaire = result.getInt("salary");
		    	 int paidLeave = result.getInt("paid_leave");
		    	 String prenom = result.getString("firstname");
		    	 querytab3[i][0] = Integer.toString(salaire);
		    	 querytab3[i][1] = Integer.toString(paidLeave);
		    	 querytab3[i][2] = prenom + db;	    		 
		    	 i++;
		   	    }
		    
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab3;
	}
	

	/**
	 * Method allowing to get the 3 best salaries with bonus included.
	 */
	/**
	 * @return tab of the 3 best salaries with bonus included.
	 */
		public static String[][] query4() {
			String[][] querytab = new String[100][3];
			try {
				String selectQuery = "SELECT firstname, salary, bonus FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC;";                
			
				Connection dbConnection = JdbcConnectionUSA.getConnection();
				Statement state = dbConnection.createStatement();
				ResultSet result = state.executeQuery(selectQuery);
				
				int i=0;
			    while(result.next()){ 
			    	 int salaire = result.getInt("salary");
			    	 int bonus = result.getInt("bonus");
			    	 String prenom = result.getString("firstname");
			    	 salaire =salaire + (salaire * bonus)/100;
			    	 querytab[i][0] = prenom + db;
			    	 querytab[i][1] = Integer.toString(salaire);
			    	 querytab[i][2] = Integer.toString(bonus);	    		 
			    	 i++;
			   	    }
			    
			    result.close();
			    state.close();
			      
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return querytab;
		}
	
		

		/**
		 * Method allowing to get the average bonus for the biggest paid leave and the smallest paid leave
		 */
		/**
		 * @return the average bonus for the biggest paid leave and the smallest paid leave
		 */
	public static String[][] query5() {
		String[][] querytab = new String[100][3];
		try {
			String selectQuery = "SELECT firstname, bonus, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY paid_leave ASC;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int bonus = result.getInt("bonus");
		    	 int paidLeave = result.getInt("paid_leave");
		    	 String prenom = result.getString("firstname");
		    	 querytab[i][0] = Integer.toString(bonus);
		    	 querytab[i][1] = Integer.toString(paidLeave);
		    	 querytab[i][2] = prenom + db;	    		 
		    	 i++;
		   	    }
		    
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab;
	}
	
	/**
	 * Method allowing to get the meduim salary to the society
	 */
	/**
	 * @return the meduim salary to the society
	 */
	public static int query6() {
		int averageSalary = 0;
		int allSalary = 0;
		try {
			String selectQuery = "SELECT salary FROM payslip;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int salary = result.getInt("salary");
		    	 allSalary += salary;
		    	 i++;
		    	 averageSalary = allSalary/i;
		    }
		    	
		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return averageSalary;
	}

	

	/**
	 * Method allowing to get the sum of employees of society
	 */
	/**
	 * @return the sum of employees of society
	 */
	public static int query7() {
		int allBonus = 0;
		try {
			String selectQuery = "SELECT bonus FROM payslip;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int bonus = result.getInt("bonus");
		    	 allBonus += bonus;
		    	 i++;
		    }
		    	
		    System.out.println(allBonus);

		    result.close();
		    state.close();
		      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return allBonus;
	}
	

	/**
	 * Method allowing to get the best employee in function of his bonus and paid leave
	 */
	/**
	 * @return the best employee in function of his bonus and paid leave
	 */
	public static String[][] query8() {
		String[][] querytab = new String[1][5];
		try {
			String Query1 = "SELECT MAX(bonus) FROM payslip;";                

			Connection dbConnection = JdbcConnectionUSA.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(Query1);
			
		   result.next();
		   int bonus = result.getInt("MAX(bonus)");
		   System.out.println(bonus);
		
		   String Query2 = "SELECT MIN(paid_leave) FROM payslip WHERE bonus="+bonus+"";
		   ResultSet result2 = state.executeQuery(Query2);
		   result2.next();
		   int paid_leave = result2.getInt("MIN(paid_leave)");
		   System.out.println(paid_leave);
		   
		   String Query3 = "SELECT lastname, firstname, salary, bonus, paid_leave FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip WHERE paid_leave = "+paid_leave+" AND bonus="+bonus+" ORDER by salary DESC LIMIT 1; ";
		   ResultSet result3 = state.executeQuery(Query3);
		   result3.next();
		   int salary = result3.getInt("salary");
		   int bonus1 = result3.getInt("bonus");
		   int paidLeave = result3.getInt("paid_leave");
		   String prenom = result3.getString("firstname");
		   String nom = result3.getString("lastname");
		   querytab[0][0] = nom + db;
		   querytab[0][1] = prenom;
		   querytab[0][2] = Integer.toString(salary); 
		   querytab[0][3] = Integer.toString(bonus1);  		 
		   querytab[0][4] = Integer.toString(paidLeave); 
		
		    
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return querytab;
	}
	
	

	/**
	 * Method allowing to get the 3 best salary for the youngest peoples
	 */
	/**
	 * @return tab of the 3 best salaries for the youngest peoples
	 */
		public static String[][] query9() {
			String[][] querytab = new String[1][3];
			try {
				String selectQuery = "SELECT lastname, salary, age FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY age ASC, salary DESC LIMIT 1;";
				
				
				Connection dbConnection = JdbcConnectionUSA.getConnection();
				Statement state = dbConnection.createStatement();
				ResultSet result = state.executeQuery(selectQuery);
				
				int i=0;
			    while(result.next()){ 
			    	 int age = result.getInt("age");
			    	 int salary = result.getInt("salary");
			    	 String nom = result.getString("lastname");
			    	 querytab[i][0] = nom + db;
			    	 querytab[i][1] = Integer.toString(age);  		 
			    	 querytab[i][2] = Integer.toString(salary);  		 
			    	 i++;
			   	}
			    
			    result.close();
			    state.close();
			      
				} catch (SQLException se) {
					System.err.println(se.getMessage());
				}
				return querytab;
		}
			

		/**
		 * Method allowing to get the medium age with the best salary
		 */
		/**
		 * @return tab of 40 salaries with age corresponding 
		 */
		public static String[][] query10() {
			String[][] querytab = new String[40][2];
			try {
				String selectQuery = "SELECT salary, age FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC LIMIT 40;";
					
				
				Connection dbConnection = JdbcConnectionUSA.getConnection();
				Statement state = dbConnection.createStatement();
				ResultSet result = state.executeQuery(selectQuery);
					
				int i=0;
				while(result.next()){ 
					int age = result.getInt("age");
				    int salary = result.getInt("salary");
				    querytab[i][0] = Integer.toString(salary) + db;
				    querytab[i][1] = Integer.toString(age);  		 
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
