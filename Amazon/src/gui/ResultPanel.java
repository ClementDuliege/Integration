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

	
	public ResultPanel() {
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 30));
		this.setLayout(null);
	
		this.setVisible(true);
	}
}
