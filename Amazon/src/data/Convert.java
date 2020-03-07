package data;

import gui.ConverterPanel;

public class Convert {
	
	public static double convertCHNtoUSA(double salary) {
		double quotient = 0.47;
		salary*=quotient;
		//int value = salary;
		return salary;
		
	}
	public static double convertFRtoUSA(double salary) {
		double quotient = 0.89;
		salary/=quotient;
		return (int)salary;
	}
	
	public void convertEuros() {
		double quotientdollars=1.13;
		double quotientyen=118.85;
		int dollars = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotientdollars);
		int yen = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotientyen);

		ConverterPanel.getConvert().setText("<html>"+ dollars+" Dollars <br/>" +yen+" Yen </html>");
	
	}
	
	public void convertDollars() {
		double quotienteuros=0.89;
		double quotientyen=105.30;
		int euros = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotienteuros);
		int yen = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotientyen);

		ConverterPanel.getConvert().setText("<html>"+ euros+" Euros <br/>" +yen+" Yen </html>");
	
	}
	
	public void convertYen() {
		double quotientdollars=0.0095;
		double quotienteuros=0.0084;
		int dollars = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotienteuros);
		int euros = (int) (Integer.parseInt(ConverterPanel.getTf().getText())*quotientdollars);
		
		ConverterPanel.getConvert().setText("<html>"+ euros+" Euros <br/>" +dollars+" Dollars </html>");
	
	}
	
}