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
		this.setVisible(true);

	}
	

	
	public static void DisplayDescription(){
		if(Gui.getQp().getCheck1().isSelected()) {
			label.setText("<html> La requ�te 1 consiste � afficher les 10 salari�s <br/> ayant les plus gros salaires parmi les sources de donn�es <br/> d'Amazon France, Chine et �tats-Unis.</html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�. </html>");
		}if(Gui.getQp().getCheck2().isSelected()) {
			label.setText("<html> La requ�te 2 consiste � afficher la somme de <br/> tout les cong�s pour tout les employ�s de chaque source de donn�e.</html>");
			label3.setText("<html> Nous affichons �galement la somme de ses cong�s par pays <br/>(France, Chine et �tats-unis). </html>");

		}if(Gui.getQp().getCheck3().isSelected()) {
			label.setText("<html> La requ�te 3 consiste � afficher sous la forme d'un tableau <br/> les 5 employ�s parmi la France, les �tats-Unis et la Chine <br/> ayant les salaires les plus importants parmi les 5 plus gros cong�s. </html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�. </html>");

		}if(Gui.getQp().getCheck4().isSelected()) {
			label.setText("<html> La requ�te 4 consiste � afficher sous forme d'un tableau � 3 colonnes les 3 meilleurs salaires avec les bonus comprit. <br/> La premi�re colonne affichera le pr�nom des employ�s, <br/> la deuxi�me affichera le salaire avec les bonus comprit <br/> et la troisi�me affichera ses bonus.</html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�. </html>");

		}if(Gui.getQp().getCheck5().isSelected()) {
			label.setText("<html> La requ�te 5 consiste � effectuer une comparaison entre deux requ�tes :<br/> a) on r�cup�re le bonus des salari�s qui ont prit le moins de cong�s <br/> b) on r�cup�re le bonus des salari�s qui ont prit le plus de cong�s <br/> Chaque requ�te dispose de 5 employ�s de chaque entreprise.</html>");
			label3.setText("<html> Tableau 1 : affiche la requ�te a) par ordre croissant en fonction des cong�s <br/> Tableau 2 : affiche la requ�te b) par ordre d�croissant en fonction des cong�s </html>");

		}if(Gui.getQp().getCheck6().isSelected()) {
			label.setText("<html> La requ�te 6 consiste � afficher le salaire <br/> moyen des employ�s de chaque entreprise. <br/> Nous afficherons �galement le nombre d'employ�s par entreprise. <html>");
			label3.setText("<html> Affichage textuelle de la requ�te. </html>");

		}if(Gui.getQp().getCheck7().isSelected()) {
			label.setText("<html> La requ�te 7 consiste � effectuer une comparaison entre plusieurs requ�tes:<br/> a. R�cup�rer la somme des bonus de la premi�re entreprise. <br/> b. R�cup�rer la somme des bonus de la seconde entreprise. <br/> c. R�cup�rer la somme des bonus de la troisi�me entreprise.</html>");
			label3.setText("<html> Affichage textuelle de la requ�te. </html>");

		}if(Gui.getQp().getCheck8().isSelected()) {
			label.setText("<html> La requ�te 8 consiste � afficher l'employ� du moi de chaque entreprise. <br/> L'employ� du moi � le meilleur bonus,<br/> le moins de cong�s et le meilleur salaire.</html>");
			label3.setText("<html> Affichage sous forme de tableau tri� par ordre d�croissant <br/> en fonction du salaire de chaque employ�. </html>");

		}if(Gui.getQp().getCheck9().isSelected()) {
			label.setText("<html>La requ�te 9 consiste � afficher l'employ� qui � le plus gros salaire. <br/> parmi les plus jeunes salari�s de chaque entreprise.</html>");
			label3.setText("<html> Ce tableau est tri� par ordre d�croissant <br/> en fonction de l'�ge de chaque employ�. </html>");

		}if(Gui.getQp().getCheck10().isSelected()) {
			label.setText("<html>La requ�te 10 consiste � afficher la moyenne d��ge qui a le<br/> meilleur salaire.</html>");
			label3.setText("<html> Affichage textuelle de la requ�te. </html>");

		}
	}

	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
