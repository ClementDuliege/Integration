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
	}
	

	
	public static void DisplayDescription(){
		if(Gui.getQp().getCheck1().isSelected()) {
			label.setText("<html> La requête 1 consiste à afficher Les 10 salariés <br/> ayant les plus gros salaire parmis les base de données <br/> d'Amazon France, Chine et États-Unis.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");
		}if(Gui.getQp().getCheck2().isSelected()) {
			label.setText("<html> La requête 2 consiste à afficher La somme des congés de chaque employés d'Amazon <br/> Nous affichons également la somme de ses congés par Pays (France Chine États-unis).</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck3().isSelected()) {
			label.setText("<html> La requête 3 consiste à afficher sous la forme d'un tableau <br/> Les 5 employés Parmit La France, États-Unis et la chine <br/> qui ont les plus gros salaires  parmit les 5 plus gros congés. </html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck4().isSelected()) {
			label.setText("<html> La requête 4 consiste à afficher sous forme d'un tableau à 3 colonnes <br/> Les 3 meilleurs salaires avec les bonus comprit. <br/> La 1ére colonne affichera le prenom des employés <br/> La 2éme Affichera le salaire avec les bonus compris <br/> et la 3éme affichera ses bonus.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck5().isSelected()) {
			label.setText("<html> La requête 5 consiste à effectuer une Comparaison entre deux requêtes à l'aide d'un tableau : <br/> On Récupérer le bonus des salariés qui ont prit le moins et le plus de congés parmis nos 3 entreprises <br/> on compare pour chaque entreprise la différence entre le nombre de congés et le nombre de bonus </html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck6().isSelected()) {
			label.setText("<html> La requête 6 consiste à afficher le salaire moyen des entreprises <br/> et les classer dans l’ordre. La moyenne pour chaque entreprise s'effectue <br/> en additionnant le salaire de chaque employés et en divisant cette somme par le nombre d'employés.<html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck7().isSelected()) {
			label.setText("<html> La requête 7 consiste à effectuer une Comparaison entre plusieurs requêtes :<br/> a. Récupérer la somme des bonus de la première entreprise. <br/> b. Récupérer la somme des bonus de la seconde entreprise. <br/> c. Récupérer la somme des bonus de la troisième entreprise.</html>");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck8().isSelected()) {
			label.setText("La requête 8 consiste à afficher le salarié qui a les meilleurs bonus et le moins de congés.");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck9().isSelected()) {
			label.setText("La requête 9 consiste à afficher Le plus gros salaires parmis les plus jeunes salariés de chaque entreprise.");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}if(Gui.getQp().getCheck10().isSelected()) {
			label.setText("La requête 10 consiste à afficher a moyenne d’âge qui a le meilleur salaire.");
			label3.setText("<html> Ce tableau est trié par ordre décroissant <br/> en fonction du salaire de chaque employés </html>");

		}
	}

	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
