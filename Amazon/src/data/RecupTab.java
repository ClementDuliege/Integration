package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RecupTab {
	
	private static String csvFile = "Amazon_CHINE.csv";
    private static String line = "";
    private static String cvsSplitBy = ";";
    public static String[][] tabPaySlip = new String[250][250];
    public static int sizeTab;
    
    
    
    public static String[][] recupTab() {
		sizeTab = 0;	
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		   	 try {
				reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*On lit la première ligne car c'est les infos des colonnes*/
		        
				
				while ((line = reader.readLine()) != null) {/*On lit toutes les lignes de notre fichier*/
	
		           //On stocke dans notre tableau nos différents éléments graçe à notre séparateur
		            String[]payslip = line.split(cvsSplitBy);
		            int j=0;
		            
		            while(j != 7) {
		            	tabPaySlip[sizeTab][j]=payslip[j];
		            	j++;
		            }
		            sizeTab++;
				}
		
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return tabPaySlip;
		
}
    
}
