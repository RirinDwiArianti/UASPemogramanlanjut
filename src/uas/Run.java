package uas;

import javax.swing.*;

public class Run {

	public static void main(String[] args) {
		JFrame frame = new JFrame("UAS PL Ririn Dwi Arianti");
		frame.setContentPane(new MainFrame().rootpanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}