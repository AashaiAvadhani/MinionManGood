package MinionManGood;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

//class that creates the minion(main character)
 class Minion extends Character{
	 private int score; 
	 private int lives = 3;
	 private boolean alive = true;

	 
	public Minion(int x11, int y11){
		 this.x = x11;
		 this.y = y11;
		 score = 0;
	}
	public Boolean checkAlive(){
		if(lives==0){
			alive = false;
		}
		return alive;
	}
	public int getLives(){
		return lives;
	}
	public void setLives(int lives){
		this.lives = lives;
	}
	public int getScore(){
		return score; 
	}
	public void setScore(int score1){
		score = score1;
	}

	public void paint(Graphics g) {
		ImageIcon  imageIcon = new ImageIcon("minion.png");
		Image image = imageIcon.getImage();
		checker(x,y, 30,30, new Board().barriers);
		g.drawImage(image, x, y, 30, 30, null);			
	}
	public void loseLife(int x, int y){
		if(((this.getX()+15>=x)&&(this.getX()-15<=x))&&((this.getY()+15>=y)&&(this.getY()-15<=y))){
			lives--;
			this.setX(0);
			this.setY(0);
		}
	}
	 void moveUP(){
		 int temp = getY();
		y -= 10;
	}
	
	 void moveDown(){
		 int temp = getY();
		y += 10;
		
	}
	
	 void moveRight(){
		 int temp = getX();
		x += 10;
		
	}
	
	 void moveLeft(){
		 int temp = getX();
		x -= 10;
		
	}
}



