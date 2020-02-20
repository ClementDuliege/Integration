package gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import amazon.QueryAmazon;
import chine.QueryDaoCHN;
import france.QueryDaoFR;
import usa.JdbcConnectionUSA;
import usa.QueryDaoUSA;


public class QueryBar extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel label = new JLabel("Requête SQL");
	
	private JButton button = new JButton("Valider");

	
	public QueryBar() {
		this.setSize(600,700);
		this.setOpaque(true);
		this.setBackground(Color.GRAY);
		this.setLayout(null);
        
       
        

        
		this.setSize(400, 730);

		
		
        label.setSize(100, 30);       
        label.setLocation(160, 10);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        
        button.addActionListener(this);
        button.setSize(100, 30);
        button.setLocation(150, 550);


        this.add(label);
        this.add(button);
        
        
        
	}
	
	public void usa() {
		QueryDaoUSA usa = new QueryDaoUSA();
		
		DefaultTableModel model = new DefaultTableModel(usa.query1(), QueryDaoUSA.getCol());
	    JTable table = new JTable(model);
	    table.setShowGrid(true);
	    table.setShowVerticalLines(true);
	    JFrame frame = new JFrame("Affichage JTable");
	    JPanel panel = new JPanel();
	    JScrollPane pane = new JScrollPane(table);
	    panel.add(pane);
	    frame.add(panel);
	    frame.setSize(500, 250);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
	}
	
	public void fr() {
		String col[] = { "je fait apr", "je fait apr", "je fait apr", "je fait apr", "je fait apr" };

		DefaultTableModel model = new DefaultTableModel(QueryDaoUSA.query8(), col);
	    JTable table = new JTable(model);
	   
	    table.setShowVerticalLines(true);
	    JFrame frame = new JFrame("Affichage JTable");
	    JPanel panel = new JPanel();
	    JScrollPane pane = new JScrollPane(table);
	    panel.add(pane);
	    frame.add(panel);
	    frame.setSize(500, 250);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}

	public void chn() {
		QueryDaoCHN chn = new QueryDaoCHN();
		DefaultTableModel model = new DefaultTableModel(chn.query1(), QueryDaoUSA.getCol());
	    JTable table = new JTable(model);
	    table.setShowGrid(true);
	    table.setShowVerticalLines(true);
	    JFrame frame = new JFrame("Affichage JTable");
	    JPanel panel = new JPanel();
	    JScrollPane pane = new JScrollPane(table);
	    panel.add(pane);
	    frame.add(panel);
	    frame.setSize(500, 250);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true); 
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == button){
			//usa();
			fr();
			//chn();
		} else if(source == button){
			System.out.println("Erreur");	
		}
	}
	
	
	
}
