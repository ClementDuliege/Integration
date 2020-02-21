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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import amazon.Query6Amazon;

public class QueryPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	private Query6Amazon amazon6 = new Query6Amazon();
	private JLabel label;
	private Color amazon2 = new Color(245,195,79);
	
	private JButton button = new JButton("Valider");
	
	private JRadioButton check1 = new JRadioButton("Requête 1");
	private JRadioButton check2 = new JRadioButton("Requête 2");
	private JRadioButton check3 = new JRadioButton("Requête 3");
	private JRadioButton check4 = new JRadioButton("Requête 4");
	private JRadioButton check5 = new JRadioButton("Requête 5");
	private JRadioButton check6 = new JRadioButton("Requête6");
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
		
		
		
		button.setBackground(Color.white);
        button.addActionListener(this);
		
        
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
    
    /*
    public void display() {
		if(group.getSelection().getActionCommand()!="1") {
			
		}else if(group.getSelection().getActionCommand()!="2") {
			
		}
		else if(group.getSelection().getActionCommand()!="3") {
			
		}
		else if(group.getSelection().getActionCommand()!="4") {
			
		}
		else if(group.getSelection().getActionCommand()!="5") {
			
		}
		else if(group.getSelection().getActionCommand()!="6") {
			
		}
		else if(group.getSelection().getActionCommand()!="7") {
			
		}
		else if(group.getSelection().getActionCommand()!="8") {
			
		}
		else if(group.getSelection().getActionCommand()!="9") {
			
		}
		else if(group.getSelection().getActionCommand()!="10") {
			
		}
	}
    */
    
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	try {
	    	Object source = e.getSource();
			if(source == button){
				label = new JLabel(amazon6.toString());
				label.setForeground(Color.RED);
				label.setSize(5, 50);
				Gui.getRp().add(label);
				label.setVisible(true);
				Gui.getRp().validate();
				String str = group.getSelection().getActionCommand();
				System.out.println(str);
				switch (str) {
					case "1":
						System.out.println("requete 1");
						break;
					case "2":
						System.out.println("requete 2");
						break;
					case "3":
						System.out.println("requete 3");
						break;
					case "4":
						System.out.println("requete 4");
						break;
					case "5":
						System.out.println("requete 5");
						break;
					case "6":
							
						break;
					case "7":
						System.out.println("requete 7");
						break;
					case "9":
						System.out.println("requete 8");
						break;
					case "10":
						System.out.println("requete 9");
						break;
							
					default:
						System.out.println("ERREUR DANS LE SWITCH");
				}
			} else {
				System.out.println("Erreur button");	
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
