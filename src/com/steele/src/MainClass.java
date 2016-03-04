package com.steele.src;

import javax.swing.JFrame;

public class MainClass {
	
	public static final int WIDTH = 640, HEIGHT = 480;
	public static final String TITLE = "T-REX game";
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame();
		frame.pack();
		frame.setSize(WIDTH,HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Game());
		frame.setVisible(true);
	}
}
