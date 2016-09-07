package MinionManGood;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

//creates the enemies that try to kill the character(minion)
public class Enemy extends Character{
	public Enemy(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void paint(Graphics g){
		ImageIcon imageIcon = new ImageIcon("enemy.png"); 
		Image image = imageIcon.getImage(); 
		checker(x ,y, 30,30, new Board().barriers);
		g.drawImage(image, getX(), getY(), 30,30 ,Color.BLACK, null);
	}
	 void moveUP(){
		 int temp = getY();
		y -= 5;
	}
	
	 void moveDown(){
		 int temp = getY();
		y += 5;
		
	}
	
	 void moveRight(){
		 int temp = getX();
		x += 5;
		
	}
	
	 void moveLeft(){
		 int temp = getX();
		x -= 5;
		
	}
	 				//same method as the checker function in the character class
					public Boolean moveCheck(int x1, int y1, int width, int height, ArrayList<Barrier> barriers){
					Boolean canMove = true;
					int two = 2;
					Barrier temp1 = barriers.get(1);
					int left2 = temp1.getX();
					for (int i = 0; i < barriers.size(); i++){
			    		Barrier temp = barriers.get(i);
			    		int top = temp.getY();
			    		int bottom = temp.getY() + barriers.get(i).getHeight();
			    		int left = temp.getX();
			    		int right = temp.getX() + temp.getWidth();
			    		
			    		//bottom side of all obstacles
			    		if ((x1<= right && x1  + 30 >= left) && (y1 == bottom)){
			    			canMove = false;
			    			}
			    		
			    		//top side of all obstacles
			    		if ((x1 <= right && x1 +30 >= left) && (y1 + height == top)){
			    			canMove = false;
			    			}
			    		
			    		//right side of obstacles
			    		if ((x1 == right) && ( y1 + 30 >=  top && y1 <= bottom)){
			    			canMove = false;
			    			}
			    		
			    		//left side of obstacles
			    		if ((x1 + 30 == left) && (y1 + 30 >= top && y1 <= bottom)){
			    			canMove = false;
			    			}
			    		
			    		
			    		
			    		//for screen
			    		if (x1 < 0){
			    			canMove = false;
			    			}
			    		if (y1 < 0){
			    			canMove = false;
			    		}
			    		
			    		if (x1 > 900){
			    			canMove = false;
			    		}			    		
			    		if(y1 >= 900){
			    			canMove = false;
			    		}	
			    	}
					
					return canMove;
				}
	public void enemyMove(Minion man){
		if(Math.abs(man.getX() - this.getX()) > Math.abs(man.getY() - this.getY())){
			if((man.getX()>this.getX())&&
				(this.moveCheck(x+10,y,30,30,new Board().barriers))){
				this.moveRight();
				}
			else if((man.getX()<this.getX())&&
					(this.moveCheck(x-10,y,30,30,new Board().barriers))){
				//System.out.println(this.moveCheck(x-10,y,30,30,new Board().barriers) + "brarrir");
					this.moveLeft();
					}
			else{
				if((man.getY()>this.getY())&&
					(this.moveCheck(x,y+10,30,30,new Board().barriers))){
					this.moveDown();
				}
				else{
					this.moveUP();
				}
			}
		}
		else{
			if((man.getY()>this.getY())
				&&(this.moveCheck(x,y+10,30,30,new Board().barriers))){
				this.moveDown();
				}
				else if((man.getX()>this.getX())
					&&(this.moveCheck(x+10,y,30,30,new Board().barriers))){
					this.moveRight();
				}
				else if(this.moveCheck(x,y-10,30,30,new Board().barriers)){
					this.moveUP();
				}
				else{
					this.moveLeft();
				}
		}
	}
}








