package amazon;

public class QueryAmazonUsual {
	public static String[][] mergeArrayTwoDimension(String[][] array1, String[][] array2) {
		String[][] result = new String[array1.length + array2.length][];

		System.arraycopy(array1, 0, result, 0, array1.length);
		System.arraycopy(array2, 0, result, array1.length, array2.length);
	      
	  return result;
	}
	
	public static int maxValueTwoDimension (String array[][], int indexOfMax) {
		int max = Integer.parseInt(array[0][indexOfMax]);
		for (int i = 1; i<array.length ; i++) {
			if (max < Integer.parseInt(array[i][indexOfMax])) {
				max = Integer.parseInt(array[i][indexOfMax]);
			}
		}

		return max;
	}
	
	public static int minValueTwoDimension (String array[][], int indexOfMin) {
		int min = 100000; /* Pour éviter d'avoir que des "-1" */
		for (int i = 0; i<array.length ; i++) {
			if (min > Integer.parseInt(array[i][indexOfMin]) && (Integer.parseInt(array[i][indexOfMin]) != -1)) {
				min = Integer.parseInt(array[i][indexOfMin]);
			}
		}

		return min;
	}
	
	
	public static String getElementFromMaxTwoDimension (String array[][], int max, int indexOfMaxElement, int indexOfElementToAdd) {
		String element = null;
		for (int i = 0; i<array.length ; i++) {
			if (max == Integer.parseInt(array[i][indexOfMaxElement])) {
				element = array[i][indexOfElementToAdd];
				break;
			}
		}
		
		return element;
	}
	
	public static String getElementFromMinTwoDimension (String array[][], int min, int indexOfMaxElement, int indexOfElementToAdd) {
		String element = null;
		for (int i = 0; i<array.length ; i++) {
			if (min == Integer.parseInt(array[i][indexOfMaxElement])) {
				element = array[i][indexOfElementToAdd];
				break;
			}
		}
		
		return element;
	}
	
	public static boolean isStringInt(String[][] array, int i, int indexToCheck)

	{
	    try
	    {
	        Integer.parseInt(array[i][indexToCheck]);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
	public static String[][] getAndDeleteMaxElementTwoDimension(String[][] array, int indexOfMax) {
	  	
		  int max = QueryAmazonUsual.maxValueTwoDimension(array, indexOfMax);
		  
		  int max_delete = max;
		  for (int i = 0; i<array.length ; i++) {
			 if (max_delete == Integer.parseInt(array[i][indexOfMax])) {
				 array[i][indexOfMax] = "-1";
				 break;
			 }
		  }
				
		  return array;	
				
		}
	
	public static String[][] getAndDeleteMinElementTwoDimension(String[][] array, int indexOfMin) {
	  	
		  int min = QueryAmazonUsual.minValueTwoDimension(array, indexOfMin);
		  
		  int min_delete = min;
		  for (int i = 0; i<array.length ; i++) {
			 if (min_delete == Integer.parseInt(array[i][indexOfMin])) {
				 array[i][indexOfMin] = "99999";
				 break;
			 }
		  }
				
		  return array;	
				
		}

}
