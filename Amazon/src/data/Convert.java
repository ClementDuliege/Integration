package data;

import gui.ConverterPanel;

/**
 * 
 * @author Ben Mansour Fares, Chahboun Taha, Duliege Clément
 *
 */
public class Convert {
	
	/**
	 * @param double
	 * 		the salary to convert
	 * @return the salary in Yen convert in Dollars.
	 */
	public static int convertIntCHNtoUSA(double salary) {
		double quotient = 0.47;
		salary*=quotient;
		return (int)salary;
		
	}
	/**
	 *  @param double
	 * 		the salary to convert
	 * @return the salary in Euro convert in Dollars.
	 */
	public static int convertIntFRtoUSA(double salary) {
		double quotient = 0.89;
		salary/=quotient;
		return (int)salary;
	}
	/**
	 *  @param String
	 * 		the salary to convert
	 * @return the salary in Yen convert in Dollars.
	 */
	public static String convertStringCHNtoUSA(String value) {
		double quotient = 0.47;
		double salary = Double.parseDouble(value);
		salary*=quotient;
		int intSalary = (int)salary;
		String strSalary = Integer.toString(intSalary);
		return strSalary;
		
	}
	/**
	 *  @param double
	 * 		the salary to convert
	 * @return the salary in Euro convert in Dollars.
	 */
	public static String convertStringFRtoUSA(String value) {
		double quotient = 0.89;
		double salary = Double.parseDouble(value);
		salary/=quotient;
		int intSalary = (int)salary;
		String strSalary = Integer.toString(intSalary);
		return strSalary;
	}
	/**
	 * Method allowing to convert Euro in dollars or yen 
	 */
	public void convertEuros() {
		double quotientdollars=0.89;
		double quotientyen=0.418;
		int dollars = (int) (Integer.parseInt(ConverterPanel.getTf().getText())/quotientdollars);
		int yen = (int) (Integer.parseInt(ConverterPanel.getTf().getText())/quotientyen);

		ConverterPanel.getConvert().setText("<html>"+ dollars+" Dollars <br/>" +yen+" Yen </html>");
	
	}
	/**
	 * Method allowing to convert Dollars in euro or yen 
	 */
	public void convertDollars() {
		double quotienteuros=0.89;
		double quotientyen=0.47;
		int euros = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotienteuros);
		int yen = (int) (Integer.parseInt(ConverterPanel.getTf().getText())/quotientyen);

		ConverterPanel.getConvert().setText("<html>"+ euros+" Euros <br/>" +yen+" Yen </html>");
	
	}
	/**
	 * Method allowing to convert Yen in dollars or Euro 
	 */
	public void convertYen() {
		double quotientdollars=0.47;
		double quotienteuros=0.418;
		int euros = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotienteuros);
		int dollars = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotientdollars);
		
		ConverterPanel.getConvert().setText("<html>"+ euros+" Euros <br/>" +dollars+" Dollars </html>");
	
	}
	
}