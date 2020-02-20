package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JdbcConnectionCHN {

	
	public static void getRead() throws IOException {
		try
		{
			String fichier = "Amazon_CHINE.csv";
		  // fichier = "C:\Users\Xavier\Desktop\Documents\fichier.csv";
		   BufferedReader fichier_source = new BufferedReader(new FileReader(fichier));
		   String chaine;
		   int i = 1;
		 
		   while((chaine = fichier_source.readLine())!= null)
		   {
		      if(i > 1)
		      {
		         String[] tabChaine = chaine.split(";");
		         //Tu effectues tes traitements avec les données contenues dans le tableau
		         //La première information se trouve à l'indice 0
		      }
		      i++;
		   }
		   fichier_source.close();                 
		}
		catch (FileNotFoundException e)
		{
		   System.out.println("Le fichier est introuvable !");
		}
		}
		public static BufferedWriter write(String fileName) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))){
				return bw;
			} catch (IOException e) {
		        e.printStackTrace();
		    }
			return null;
			
			
		}
}
