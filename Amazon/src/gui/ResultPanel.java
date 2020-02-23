package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.mysql.cj.Query;

import amazon.Query6Amazon;

public class ResultPanel extends JPanel{
	private Query6Amazon amazon6 = new Query6Amazon();
	private JLabel label = new JLabel();

	
	public ResultPanel() {
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 30));
		this.setLayout(new BorderLayout());
		this.add(label);
	
		this.setVisible(true);
	}
}
