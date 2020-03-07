package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


import data.Convert;

public class ConverterPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private String[] elements = new String[]{" Euros", " Dollars", " Yen"};
	private JComboBox<String> liste = new JComboBox<String>(elements);
	private static JTextField tf = new JTextField();
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private static JLabel convert;
	
	private Color amazon = new Color(0,0,80);
	private Color amazon2 = new Color(245,195,79);

	
	public ConverterPanel() {
		this.setLayout(null);
		this.setBorder(new LineBorder(Color.BLACK, 30));
		this.setBackground(amazon);
		this.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
	    this.setPreferredSize(new Dimension(250,200));
		
		label = new JLabel("Convertisseur");
		label.setBounds(30,0,500,50);
		label.setForeground(amazon2);
	    label.setFont(new Font(Font.SERIF,Font.BOLD,28));

	    label3 = new JLabel("Saississez votre montant :");
		label3.setBounds(20,100,500,50);
		label3.setForeground(Color.WHITE);
	    label3.setFont(new Font(Font.SERIF,Font.BOLD,18));
	    
		tf.setBounds(70,150,100,40);
		tf.setFont(new Font(Font.SERIF,Font.BOLD,17));
	    
		label2 = new JLabel("Choisissez votre monnaie :");
		label2.setBounds(20,270,500,50);
		label2.setForeground(Color.WHITE);
	    label2.setFont(new Font(Font.SERIF,Font.BOLD,18));
	    
	    liste.addActionListener(new ItemAction());
		liste.setBounds(70,330,100,40);
		liste.setFont(new Font(Font.SERIF,Font.BOLD,18));
		
		convert = new JLabel("------------");
		convert.setBounds(76,450,500,50);
		convert.setForeground(amazon2);
	    convert.setFont(new Font(Font.SERIF,Font.BOLD,20));
	    
		this.add(label);
		this.add(label2);
		this.add(label3);
		this.add(tf);
		this.add(liste);
		this.add(convert);
		this.setVisible(true);
	}


	class ItemAction implements ActionListener{            
		public void actionPerformed(ActionEvent e) {
			Convert c = new Convert();
			if(e.getSource() == liste){
				if(liste.getSelectedItem().equals(" Euros")) {
					c.convertEuros();
				}
				else if(liste.getSelectedItem().equals(" Dollars")) {
					c.convertDollars();
				}
				else if(liste.getSelectedItem().equals(" Yen")) {
					c.convertYen();
				}
			}
			
		}
	
	}


	public static JTextField getTf() {
		return tf;
	}


	public static void setTf(JTextField tf) {
		ConverterPanel.tf = tf;
	}


	public static JLabel getConvert() {
		return convert;
	}


	public static void setConvert(JLabel convert) {
		ConverterPanel.convert = convert;
	}


	
}
