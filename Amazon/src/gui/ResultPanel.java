package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.mysql.cj.Query;

import amazon.Query6Amazon;

public class ResultPanel extends JPanel{
	private Query6Amazon amazon6 = new Query6Amazon();
	private JLabel label = new JLabel("Result Panel");
	//private JLabel label2 = new JLabel(amazon6.toString());

//	private JLabel amazon1 = new JLabel(query6.getDisplay());
//	private JLabel amazon2 = new JLabel(query6.getDisplay());
//	private JLabel amazon3 = new JLabel(query6.getDisplay());
//	private JLabel amazon4 = new JLabel(query6.getDisplay());
//	private JLabel amazon5 = new JLabel(query6.getDisplay());
//	private JLabel amazon6 = new JLabel(query6.toString());
//	private JLabel amazon7 = new JLabel(query6.getDisplay());
//	private JLabel amazon8 = new JLabel(query6.getDisplay());
//	private JLabel amazon9 = new JLabel(query6.getDisplay());
//	private JLabel amazon10 = new JLabel(query6.getDisplay());	
	
	
	public ResultPanel() {
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 30));
		this.setLayout(new FlowLayout());
		this.add(label);
		
		//this.add(label2);
		
		
//		this.add(amazon6);
//		
//		amazon1.setVisible(false);
//		amazon2.setVisible(false);
//		amazon3.setVisible(false);
//		amazon4.setVisible(false);
//		amazon5.setVisible(false);		
//		amazon6.setVisible(false);
//		amazon7.setVisible(false);
//		amazon8.setVisible(false);
//		amazon9.setVisible(false);
//		amazon10.setVisible(false);
		this.setVisible(true);
	}


	
//	public JLabel getAmazon1() {
//		return amazon1;
//	}
//
//
//	public void setAmazon1(JLabel amazon1) {
//		this.amazon1 = amazon1;
//	}
//
//
//	public JLabel getAmazon2() {
//		return amazon2;
//	}
//
//
//	public void setAmazon2(JLabel amazon2) {
//		this.amazon2 = amazon2;
//	}
//
//
//	public JLabel getAmazon3() {
//		return amazon3;
//	}
//
//
//	public void setAmazon3(JLabel amazon3) {
//		this.amazon3 = amazon3;
//	}
//
//
//	public JLabel getAmazon4() {
//		return amazon4;
//	}
//
//
//	public void setAmazon4(JLabel amazon4) {
//		this.amazon4 = amazon4;
//	}
//
//
//	public JLabel getAmazon5() {
//		return amazon5;
//	}
//
//
//	public void setAmazon5(JLabel amazon5) {
//		this.amazon5 = amazon5;
//	}
//
//
//	public JLabel getAmazon6() {
//		return amazon6;
//	}
//
//
//	public void setAmazon6(JLabel amazon6) {
//		this.amazon6 = amazon6;
//	}
//
//
//	public JLabel getAmazon7() {
//		return amazon7;
//	}
//
//
//	public void setAmazon7(JLabel amazon7) {
//		this.amazon7 = amazon7;
//	}
//
//
//	public JLabel getAmazon8() {
//		return amazon8;
//	}
//
//
//	public void setAmazon8(JLabel amazon8) {
//		this.amazon8 = amazon8;
//	}
//
//
//	public JLabel getAmazon9() {
//		return amazon9;
//	}
//
//
//	public void setAmazon9(JLabel amazon9) {
//		this.amazon9 = amazon9;
//	}
//
//
//	public JLabel getAmazon10() {
//		return amazon10;
//	}
//
//
//	public void setAmazon10(JLabel amazon10) {
//		this.amazon10 = amazon10;
//	}
//	
	
}
