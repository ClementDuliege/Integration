package data;

public class Convert {
	
	public static double convertCHNtoUSA(double salary) {
		double quotient = 0.47;
		salary*=quotient;
		return (int)salary;
		
	}
	public static double convertFRtoUSA(double salary) {
		double quotient = 0.89;
		salary/=quotient;
		return (int)salary;
	}
	
}