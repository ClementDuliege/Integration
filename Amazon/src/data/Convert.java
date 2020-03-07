package data;

import gui.ConverterPanel;

public class Convert {
	
	public static int convertIntCHNtoUSA(double salary) {
		double quotient = 0.47;
		salary*=quotient;
		return (int)salary;
		
	}
	public static int convertIntFRtoUSA(double salary) {
		double quotient = 0.89;
		salary/=quotient;
		return (int)salary;
	}
	
	public static String convertStringCHNtoUSA(String value) {
		double quotient = 0.47;
		double salary = Double.parseDouble(value);
		salary*=quotient;
		int intSalary = (int)salary;
		String strSalary = Integer.toString(intSalary);
		return strSalary;
		
	}
	public static String convertStringFRtoUSA(String value) {
		double quotient = 0.89;
		double salary = Double.parseDouble(value);
		salary/=quotient;
		int intSalary = (int)salary;
		String strSalary = Integer.toString(intSalary);
		return strSalary;
	}
	
	public void convertEuros() {
		double quotientdollars=1.13;
		double quotientyen=0.47;
		int dollars = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotientdollars);
		int yen = (int) (Integer.parseInt(ConverterPanel.getTf().getText())/quotientyen);

		ConverterPanel.getConvert().setText("<html>"+ dollars+" Dollars <br/>" +yen+" Yen </html>");
	
	}
	
	public void convertDollars() {
		double quotienteuros=0.89;
		double quotientyen=0.47;
		int euros = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotienteuros);
		int yen = (int) (Integer.parseInt(ConverterPanel.getTf().getText())/quotientyen);

		ConverterPanel.getConvert().setText("<html>"+ euros+" Euros <br/>" +yen+" Yen </html>");
	
	}
	
	public void convertYen() {
		double quotientdollars=0.47;
		double quotienteuros=0.36;
		int dollars = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotienteuros);
		int euros = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotientdollars);
		
		ConverterPanel.getConvert().setText("<html>"+ euros+" Euros <br/>" +dollars+" Dollars </html>");
	
	}
	
}