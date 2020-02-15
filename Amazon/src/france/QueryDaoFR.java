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

	private static String col[] = { "Prenom", "Salaires", "Bonus" };
	
	public QueryDaoFR() {
		
		
	}
	
	
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
	
	public int query2() {	
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

	public String[][] query3() {
		String[][] querytab3 = new String[3][3];
		try {
			String selectQuery = "SELECT firstname, salary, bonus FROM payslip INNER JOIN employees ON employees.id_employees = payslip.id_payslip ORDER BY salary DESC LIMIT 3;";                
		
			Connection dbConnection = JdbcConnectionFR.getConnection();
			Statement state = dbConnection.createStatement();
			ResultSet result = state.executeQuery(selectQuery);
			
			int i=0;
		    while(result.next()){ 
		    	 int salaire = result.getInt("salary");
		    	 int bonus = result.getInt("bonus");
		    	 String prenom = result.getString("firstname");
		    	 salaire =salaire + (salaire * bonus)/100;
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
	
	
	
	
	
	
}
