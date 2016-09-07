package MinionManGood;

import java.awt.Color;
import java.awt.Graphics;

//class that creates the barriers to ensure the minion/enemies do not move through obstacles and off the screen
public class Barrier{
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setX(int x ){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	
	
	
	public Barrier(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.CYAN);
		g.drawRoundRect(getX(), getY(), getWidth(), getHeight(), 10, 10);
	}
	
	

}
