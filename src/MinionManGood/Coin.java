package MinionManGood;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

//creates the coins, makes sure the coins dissapear
public class Coin {
	
	
	private int xCoor;
	private int yCoor;
	private Boolean alive;
	public int getxCoor() {
		return xCoor;
	}
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}
	public int getyCoor() {
		return yCoor;
	}
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}
	public void setAlive(Boolean alive){
		this.alive = alive;
	}
	public Boolean getAlive(){
		return alive; 
	}
	public Coin(int x, int y){
		xCoor = x;
		yCoor = y;
		alive = true;
		
	}
	
	public void paint(Graphics g){
		if(alive){
			g.drawOval(getxCoor(), getyCoor(), 8, 8);
			g.setColor(Color.yellow);
			g.fillOval(getxCoor(), getyCoor(), 8, 8);
		}
		
		
		
	}

		
	}

	



