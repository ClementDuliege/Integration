package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DescriptionPanel extends JPanel{

	private JLabel label;
	private Color amazon2 = new Color(245,195,79);

	
	public DescriptionPanel() {
		this.setLayout(new BorderLayout());
        this.setBackground(amazon2);
		this.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
		this.setVisible(true);
		
		
		label = new JLabel("-----------------");
		label.setForeground(Color.BLACK);
		
		
		
		this.add(label);
	}


	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	
}
