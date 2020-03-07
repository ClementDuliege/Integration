package data;

import java.util.Comparator;

public class SortByPaidLeave implements Comparator<DataPaidLeave> {
	 public int compare(DataPaidLeave a, DataPaidLeave b) 
	    { 
	        return a.getPaidLeave() - b.getPaidLeave(); 
	    }  
}
