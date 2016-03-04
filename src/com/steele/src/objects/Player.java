package com.steele.src.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.steele.src.GlobalPosition;

public class Player extends GlobalPosition{

	private String playerimage = "/images/player.png";
	
	private LinkedList<Enemy> e = Controller.getEnemyBounds();
	
	int velX = 0;
	int velY = 0;
	
	public Player(int x, int y) {
		super(x, y);	
	}
	
	public void update(){
		x += velX;
		y += velY;
		
		//collision with outside
		if(x < 0)
			x=0;
		if(y < 0)
			y=0;
		if(x > 500)
			x = 500;
		if(y > 380)
			y=380;
		
		Collision();
		
	}
	
	public void Collision(){
		
		for(int i = 0; i < e.size(); i++){
			
			if(getBounds().intersects(e.get(i).getBounds())){
				System.out.println("Collision!!");
				
			}
		}
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			velX = 5;
		}else if(key == KeyEvent.VK_LEFT){
			velX = -5;
		}else if(key == KeyEvent.VK_DOWN){
			velY = 5;
		}else if(key == KeyEvent.VK_UP){
			velY = -5;
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			velX = 0;
		}else if(key == KeyEvent.VK_LEFT){
			velX = 0;
		}else if(key == KeyEvent.VK_DOWN){
			velY = 0;
		}else if(key == KeyEvent.VK_UP){
			velY = 0;
		}
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y , 32, 32);
		
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getPlayerImage(), x, y, null);
		
		
	}
	
	public Image getPlayerImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
}
