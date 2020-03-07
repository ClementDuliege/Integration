package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import amazon.Query10Amazon;
import amazon.Query1Amazon;
import amazon.Query2Amazon;
import amazon.Query3Amazon;
import amazon.Query4Amazon;
import amazon.Query5Amazon;
import amazon.Query6Amazon;
import amazon.Query7Amazon;
import amazon.Query8Amazon;
import amazon.Query9Amazon;
import query.QueryDaoFR;
import query.QueryDaoUSA;

public class QueryPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Query6Amazon amazon6 = new Query6Amazon();
	private JLabel label;
	private Color amazon2 = new Color(245,195,79);
	
	private JTable table = new JTable();
    private JScrollPane pane = new JScrollPane();

	
	private JButton button = new JButton("Valider");
	
	private JRadioButton check1 = new JRadioButton("Requête 1");
	private JRadioButton check2 = new JRadioButton("Requête 2");
	private JRadioButton check3 = new JRadioButton("Requête 3");
	private JRadioButton check4 = new JRadioButton("Requête 4");
	private JRadioButton check5 = new JRadioButton("Requête 5");
	private JRadioButton check6 = new JRadioButton("Requête 6");
	private JRadioButton check7 = new JRadioButton("Requête 7");
	private JRadioButton check8 = new JRadioButton("Requête 8");
	private JRadioButton check9 = new JRadioButton("Requête 9");
	private JRadioButton check10 = new JRadioButton("Requête 10");
    private ButtonGroup group = new ButtonGroup();
	
    
    public QueryPanel() {
    	GridLayout gl = new GridLayout(11,1);
        this.setLayout(gl);
        this.setBackground(amazon2);
		this.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
				
		label = new JLabel();
		label.setForeground(Color.BLACK);
		
		button.setBackground(Color.white);
        button.addActionListener(this);
        
        
        check1.addActionListener(this);
        check2.addActionListener(this);
        check3.addActionListener(this);
        check4.addActionListener(this);
        check5.addActionListener(this);
        check6.addActionListener(this);
        check7.addActionListener(this);
        check8.addActionListener(this);
        check9.addActionListener(this);
        check10.addActionListener(this);
        

        
        check1.setBackground(amazon2);
        check2.setBackground(amazon2);
        check3.setBackground(amazon2);
        check4.setBackground(amazon2);
        check5.setBackground(amazon2);
        check6.setBackground(amazon2);
        check7.setBackground(amazon2);
        check8.setBackground(amazon2);
        check9.setBackground(amazon2);
        check10.setBackground(amazon2);
        
        check1.setActionCommand("1");
        check2.setActionCommand("2");
        check3.setActionCommand("3");
        check4.setActionCommand("4");
        check5.setActionCommand("5");
        check6.setActionCommand("6");
        check7.setActionCommand("7");
        check8.setActionCommand("8");
        check9.setActionCommand("9");
        check10.setActionCommand("10");

        group.add(check1);
        group.add(check2);
        group.add(check3);
        group.add(check4);
        group.add(check5);
        group.add(check6);
        group.add(check7);
        group.add(check8);
        group.add(check9);
        group.add(check10);
       
        
		this.add(check1);
        this.add(check2);
        this.add(check3);
        this.add(check4);
        this.add(check5);
        this.add(check6);
        this.add(check7);
        this.add(check8);
        this.add(check9);
        this.add(check10);
        this.add(button);
        this.setLayout(gl);
        
	}
    
    
    public void displayJlabel() {
    	Gui.getRp().add(label, BorderLayout.CENTER);
		Gui.getRp().validate();
		label.setVisible(true);	
		pane.setVisible(false);
    }
    
    public void displayJtable() {
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		pane.getViewport().add(table);
		Gui.getRp().add(pane);
		pane.setVisible(true);
		label.setVisible(false);
		Gui.getRp().validate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	try {
	    	Object source = e.getSource();
	    	DescriptionPanel.DisplayDescription();
			if(source == button){
				String str = group.getSelection().getActionCommand();
				System.out.println(str);
				switch (str) {
					case "1":
					    table = new JTable(new DefaultTableModel(Query1Amazon.mainSort(), Query1Amazon.getCol()));				    
					    displayJtable();
						System.out.println("requete 1");
						break;
					case "2":
						label.setText(Query2Amazon.query6());
						displayJlabel();
						System.out.println("requete 2");
						break;
					case "3":
						table = new JTable(new DefaultTableModel(Query3Amazon.mainSort(), Query3Amazon.getCol()));
					    displayJtable();
						System.out.println("requete 3");
						break;
					case "4":
						table = new JTable(new DefaultTableModel(Query4Amazon.mainSort(), Query4Amazon.getCol()));
					    displayJtable();
						System.out.println("requete 4");
						break;
					case "5":
						table = new JTable(new DefaultTableModel(Query5Amazon.mainSort(), Query5Amazon.getCol()));
					    displayJtable();
						System.out.println("requete 5");
						break;
					case "6":
						label.setText(Query6Amazon.query6());
						displayJlabel();
						break;
					case "7":
						label.setText(Query7Amazon.mainSort());
						displayJlabel();
						break;
					case "8":
						table = new JTable(new DefaultTableModel(Query8Amazon.mainSort(), Query8Amazon.getCol()));
					    displayJtable();
						System.out.println("requete 8");
						break;
					case "9":
						table = new JTable(new DefaultTableModel(Query9Amazon.mainSort(), Query9Amazon.getCol()));
					    displayJtable();
						System.out.println("requete 8");
						break;
					case "10":
						label.setText(Query10Amazon.mainSort());
						displayJlabel();
						break;
							
					default:
						System.out.println("ERREUR DANS LE SWITCH");
				}
			}
    	}catch (NullPointerException se) {
    		//System.err.println(se.getMessage());
    	}
	}


    
    
	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JRadioButton getCheck1() {
		return check1;
	}

	public void setCheck1(JRadioButton check1) {
		this.check1 = check1;
	}
	
	public JRadioButton getCheck2() {
		return check2;
	}


	public void setCheck2(JRadioButton check2) {
		this.check2 = check2;
	}


	public JRadioButton getCheck3() {
		return check3;
	}


	public void setCheck3(JRadioButton check3) {
		this.check3 = check3;
	}


	public JRadioButton getCheck4() {
		return check4;
	}


	public void setCheck4(JRadioButton check4) {
		this.check4 = check4;
	}


	public JRadioButton getCheck5() {
		return check5;
	}


	public void setCheck5(JRadioButton check5) {
		this.check5 = check5;
	}


	public JRadioButton getCheck6() {
		return check6;
	}


	public void setCheck6(JRadioButton check6) {
		this.check6 = check6;
	}


	public JRadioButton getCheck7() {
		return check7;
	}


	public void setCheck7(JRadioButton check7) {
		this.check7 = check7;
	}


	public JRadioButton getCheck8() {
		return check8;
	}


	public void setCheck8(JRadioButton check8) {
		this.check8 = check8;
	}


	public JRadioButton getCheck9() {
		return check9;
	}


	public void setCheck9(JRadioButton check9) {
		this.check9 = check9;
	}


	public JRadioButton getCheck10() {
		return check10;
	}


	public void setCheck10(JRadioButton check10) {
		this.check10 = check10;
	}


	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

}
