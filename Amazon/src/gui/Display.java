package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import usa.QueryDaoUSA;



public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel label = new JLabel("TEST");
	
	public Display() {
		this.setTitle("Amazon");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));

        
        label.setSize(100, 30);       
        label.setLocation(800, 10);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        
        QueryBar qb = new QueryBar();
       		
        
        
        this.getContentPane().add(label);
        this.getContentPane().add(qb);

		this.setSize(1200, 700);
		this.setLocationByPlatform(true);
		this.setVisible(true);
 	    	  
	}
	

	
	
	

}
