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

		label2 = new JLabel("<html>USA = États-Unis <br/> FRA = France <br/> CHN = Chine</html>");
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
			label.setText("<html> La requête 1 consiste à afficher les 10 salariés <br/> ayant les plus gros salaires parmi les sources de données <br/> d'Amazon France, Chine et États-Unis.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");
		}if(Gui.getQp().getCheck2().isSelected()) {
			label.setText("<html> La requête 2 consiste à afficher la somme de tout les congés pour tout les employés de chaque source de donnée.</html>");
			label3.setText("<html> Nous affichons également la somme de ses congés par pays <br/>(France, Chine et États-unis). </html>");

		}if(Gui.getQp().getCheck3().isSelected()) {
			label.setText("<html> La requête 3 consiste à afficher sous la forme d'un tableau <br/> les 5 employés parmi la France, les États-Unis et la Chine <br/> ayant les salaires les plus importants parmi les 5 plus gros congés. </html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}if(Gui.getQp().getCheck4().isSelected()) {
			label.setText("<html> La requête 4 consiste à afficher sous forme d'un tableau à 3 colonnes les 3 meilleurs salaires avec les bonus comprit. <br/> La première colonne affichera le prénom des employés, <br/> la deuxième affichera le salaire avec les bonus comprit <br/> et la troisième affichera ses bonus.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}if(Gui.getQp().getCheck5().isSelected()) {
			label.setText("<html> La requête 5 consiste à effectuer une comparaison entre deux requêtes à l'aide d'un tableau: <br/>on récupére le bonus des salariés qui ont prit le moins et le plus de congés parmi nos 3 entreprises, puis on compare pour chaque entreprise la différence entre le nombre de congés et le nombre de bonus. </html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}if(Gui.getQp().getCheck6().isSelected()) {
			label.setText("<html> La requête 6 consiste à afficher le salaire moyen des entreprises <br/> et les classer dans l’ordre. <br/>La moyenne pour chaque entreprise s'effectue en additionnant le salaire de chaque employé et en divisant cette somme par le nombre d'employés.<html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}if(Gui.getQp().getCheck7().isSelected()) {
			label.setText("<html> La requête 7 consiste à effectuer une comparaison entre plusieurs requêtes:<br/> a. Récupérer la somme des bonus de la première entreprise. <br/> b. Récupérer la somme des bonus de la seconde entreprise. <br/> c. Récupérer la somme des bonus de la troisième entreprise.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}if(Gui.getQp().getCheck8().isSelected()) {
			label.setText("<html> La requête 8 consiste à afficher le salarié ayant le meilleur bonus<br/> et le moins de congés.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}if(Gui.getQp().getCheck9().isSelected()) {
			label.setText("<html>La requête 9 consiste à afficher le plus gros salaire parmi les plus <br/>jeunes salariés de chaque entreprise.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}if(Gui.getQp().getCheck10().isSelected()) {
			label.setText("<html>La requête 10 consiste à afficher la moyenne d’âge qui a le<br/> meilleur salaire.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employé. </html>");

		}
	}

	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
