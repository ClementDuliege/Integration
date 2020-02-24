package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

import amazon.Query1Amazon;
import amazon.Query6Amazon;
import amazon.Query7Amazon;




public class Gui extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static QueryPanel qp = new QueryPanel();
	private static DescriptionPanel dp = new DescriptionPanel();
	private static ResultPanel rp = new ResultPanel();
	
	private static JPanel resultpanel = new JPanel();
	private JPanel title = new JPanel();

	private JLabel label = new JLabel("Amazon");

	private Font police = new Font(Font.MONOSPACED, Font.ITALIC, 16);
	private Color amazon = new Color(0,0,80);
	
	public Gui() {
		this.setTitle("Amazon");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		rp.setBorder(new LineBorder(Color.black));
		
		//dp.setBorder(new LineBorder(Color.BLACK));
		this.getContentPane().add(rp, BorderLayout.CENTER);
		this.getContentPane().add(qp, BorderLayout.WEST);
		this.getContentPane().add(dp, BorderLayout.SOUTH);
		this.add(title, BorderLayout.NORTH);
				
		label.setFont(police);
        label.setForeground(Color.WHITE);
		
		title.setBackground(amazon);
		title.setBorder(BorderFactory.createEmptyBorder(40,40,40,40)); 
        title.add(label);
        
        
		title.add(label);
        
        
        this.setSize(1200, 700);
		this.setLocationByPlatform(true);
		this.setVisible(true);
 	    	  
	}
	
	
	public static void DisplayDescription(){
		if(qp.getCheck1().isSelected()) {
			dp.getLabel().setText("La requête 1 consiste à afficher Les 10 plus gros salaires.");
		
		}if(qp.getCheck2().isSelected()) {
			dp.getLabel().setText("La requête 2 consiste à afficher La somme des congés.");
		
		}if(qp.getCheck3().isSelected()) {
			dp.getLabel().setText("La requête 3 consiste à afficher Les plus gros salaires parmit les 5 plus gros congés.");
		
		}if(qp.getCheck4().isSelected()) {
			dp.getLabel().setText("La requête 4 consiste à afficher Les 3 meilleurs salaires avec les bonus comprit.");
		
		}if(qp.getCheck5().isSelected()) {
			dp.getLabel().setText("La requête 5 consiste à effectuer une Comparaison entre deux requêtes : a. Récupérer le bonus des salariés qui ont pris le plus de congés (on compare pour chaqueentreprise la différence entre le nombre de congés et le nombre de bonus) b. Récupérer le bonus des salariés qui ont prit le moins de congés.");
		
		}if(qp.getCheck6().isSelected()) {
			dp.getLabel().setText("La requête 6 consiste à afficher le salaire moyen des entreprises et les classer dans l’ordre.");
		
		}if(qp.getCheck7().isSelected()) {
			dp.getLabel().setText("La requête 7 consiste à effectuer Comparaison entre plusieurs requêtes :  a. Récupérer la somme des bonus de la première entreprise.  b. Récupérer la somme des bonus de la seconde entreprise.  c. Récupérer la somme des bonus de la troisième entreprise.");
		
		}if(qp.getCheck8().isSelected()) {
			dp.getLabel().setText("La requête 8 consiste à afficher le salarié qui a les meilleurs bonus et le moins de congés.");
		
		}if(qp.getCheck9().isSelected()) {
			dp.getLabel().setText("La requête 9 consiste à afficher Le plus gros salaires parmis les plus jeunes salariés de chaque entreprise.");
		
		}if(qp.getCheck10().isSelected()) {
			dp.getLabel().setText("La requête 10 consiste à afficher a moyenne d’âge qui a le meilleur salaire.");
		}
	}

	public static ResultPanel getRp() {
		return rp;
	}

	public static void setRp(ResultPanel rp) {
		Gui.rp = rp;
	}


		
}
