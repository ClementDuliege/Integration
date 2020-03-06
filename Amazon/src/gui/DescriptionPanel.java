package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DescriptionPanel extends JPanel{
	private static JLabel label;
	private static JLabel label2;
	private static JLabel label3;

	private Color amazon2 = new Color(245,195,79);
	
	
	public DescriptionPanel() {
		GridLayout gl = new GridLayout(1,1);
		this.setLayout(gl);
        this.setBackground(amazon2);
		this.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
		this.setVisible(true);
		
		label = new JLabel("Description");
		label.setForeground(Color.BLACK);
	    label.setFont(new Font(Font.SERIF,Font.BOLD,17));

		label2 = new JLabel("<html>USA = �tats-Unis <br/> FRA = France <br/> CHN = Chine</html>");
		label2.setForeground(Color.BLACK);
	    label2.setFont(new Font(Font.SERIF,Font.BOLD,14));
	    
	    label3 = new JLabel("Affichage");
		label3.setForeground(Color.BLACK);
	    label3.setFont(new Font(Font.SERIF,Font.BOLD,17));
	    		
		label.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		
		this.add(label);
		this.add(label3);
		this.add(label2);
	}
	

	
	public static void DisplayDescription(){
		if(Gui.getQp().getCheck1().isSelected()) {
			label.setText("<html> La requ�te 1 consiste � afficher Les 10 salari�s <br/> ayant les plus gros salaire parmis les base de donn�es <br/> d'Amazon France, Chine et �tats-Unis.</html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");
		}if(Gui.getQp().getCheck2().isSelected()) {
			label.setText("<html> La requ�te 2 consiste � afficher La somme des cong�s de chaque employ�s d'Amazon <br/> Nous affichons �galement la somme de ses cong�s par Pays (France Chine �tats-unis).</html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck3().isSelected()) {
			label.setText("<html> La requ�te 3 consiste � afficher sous la forme d'un tableau <br/> Les 5 employ�s Parmit La France, �tats-Unis et la chine <br/> qui ont les plus gros salaires  parmit les 5 plus gros cong�s. </html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck4().isSelected()) {
			label.setText("<html> La requ�te 4 consiste � afficher sous forme d'un tableau � 3 colonnes <br/> Les 3 meilleurs salaires avec les bonus comprit. <br/> La 1�re colonne affichera le prenom des employ�s <br/> La 2�me Affichera le salaire avec les bonus compris <br/> et la 3�me affichera ses bonus.</html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck5().isSelected()) {
			label.setText("<html> La requ�te 5 consiste � effectuer une Comparaison entre deux requ�tes � l'aide d'un tableau : <br/> On R�cup�rer le bonus des salari�s qui ont prit le moins et le plus de cong�s parmis nos 3 entreprises <br/> on compare pour chaque entreprise la diff�rence entre le nombre de cong�s et le nombre de bonus </html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck6().isSelected()) {
			label.setText("<html> La requ�te 6 consiste � afficher le salaire moyen des entreprises <br/> et les classer dans l�ordre. La moyenne pour chaque entreprise s'effectue <br/> en additionnant le salaire de chaque employ�s et en divisant cette somme par le nombre d'employ�s.<html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck7().isSelected()) {
			label.setText("<html> La requ�te 7 consiste � effectuer une Comparaison entre plusieurs requ�tes :<br/> a. R�cup�rer la somme des bonus de la premi�re entreprise. <br/> b. R�cup�rer la somme des bonus de la seconde entreprise. <br/> c. R�cup�rer la somme des bonus de la troisi�me entreprise.</html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck8().isSelected()) {
			label.setText("La requ�te 8 consiste � afficher le salari� qui a les meilleurs bonus et le moins de cong�s.");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck9().isSelected()) {
			label.setText("La requ�te 9 consiste � afficher Le plus gros salaires parmis les plus jeunes salari�s de chaque entreprise.");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}if(Gui.getQp().getCheck10().isSelected()) {
			label.setText("La requ�te 10 consiste � afficher a moyenne d��ge qui a le meilleur salaire.");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�s </html>");

		}
	}

	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
