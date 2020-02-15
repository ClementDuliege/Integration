package usa;

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


import gui.Display;

public class QueryDaoUSA{
	private static String cont[][] = new String[10][2];
	private static String col[] = { "Prenom", "Salaires" };
	
	public QueryDaoUSA() {
		
		
		
		
		//guiQuery();
		//selectPayslip();
		
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
	
	public String[][] query1() {
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
		        cont[i][1] = prenom;
		        
		        i++;      
		      }
		 	      
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		return cont;
	}
	
	public void query2() {
		
	}
	

	public static String[][] getCont() {
		return cont;
	}

	public static void setCont(String[][] cont) {
		QueryDaoUSA.cont = cont;
	}

	public static String[] getCol() {
		return col;
	}

	public static void setCol(String[] col) {
		QueryDaoUSA.col = col;
	}

	
	
}
