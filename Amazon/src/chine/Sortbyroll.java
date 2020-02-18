package chine;

import java.util.Comparator;

public class Sortbyroll implements Comparator<Salarier>{
	    // Used for sorting in ascending order of 
	    // roll number 
	    public int compare(Salarier a, Salarier b) 
	    { 
	        return a.getSalary() - b.getSalary(); 
	    }  
}
