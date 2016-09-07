package MinionManGood;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {
	public Board main_frame;
	private Image minion;
	private Image enemy;
	final static int X_FRAME_SIZE = 900;
	final static int Y_FRAME_SIZE = 900;
	ArrayList<Coin> Coins = null;
	public ArrayList<Barrier> barriers = null;

	Minion m = null;
	Enemy e = null; 
	Enemy e1 = null;
	Enemy e2 = null;

	public Board() {
		Coins = new ArrayList();
		barriers = new ArrayList();
		// first column
		for (int i = 0; i < 9; i++) {
			Coins.add(new Coin(270, 60 + 70 * i));
		}
		// second column
		for (int i = 0; i < 11; i++) {
			Coins.add(new Coin(520, 20 + 60 * i));
		}
		// second row part 1
		for (int i = 0; i < 5; i++) {
			Coins.add(new Coin(60 * i, 100));
		}
		// second row part 2
		for (int i = 0; i < 4; i++) {
			Coins.add(new Coin(300 + 60 * i, 100));
		}
		// third row
		for (int i = 0; i < 3; i++) {
			Coins.add(new Coin(330 + 60 * i, 180));
		}
		for (int i = 0; i < 5; i++) {
			Coins.add(new Coin(580 + 60 * i, 200));
		}
		// fourth row part 1
		for (int i = 0; i < 4; i++) {
			Coins.add(new Coin(20 + 60 * i, 370));
		}
		// last row
		for (int i = 0; i < 15; i++) {
			Coins.add(new Coin(20 + 60 * i, 680));
		}
		// third column
		for (int i = 0; i < 8; i++) {
			Coins.add(new Coin(350, 220 + 60 * i));
		}
		// last column part 1
		for (int i = 0; i < 6; i++) {
			Coins.add(new Coin(870, 20 + 60 * i));
		}
		// last column part 2

		for (int i = 0; i < 4; i++) {
			Coins.add(new Coin(870, 415 + 65 * i));
		}
		// fourth row
		for (int i = 0; i < 5; i++) {
			Coins.add(new Coin(580 + 60 * i, 320));
		}

		for (int i = 0; i < 5; i++) {
			Coins.add(new Coin(580 + 60 * i, 415));
		}
		// first row part 1 and 2
		for (int i = 0; i < 8; i++) {
			Coins.add(new Coin(40+ 60 * i, 20));
		}
		// first row part 3
		for (int i = 0; i < 5; i++) {
			Coins.add(new Coin(580 + 60 * i, 20));
		}
		//fourth column
		for (int i = 0; i < 4; i++) {
			Coins.add(new Coin(670, 450 + 60 * i));
		}
		for (int i = 0; i < 2; i++) {
			Coins.add(new Coin(405 + 60 * i, 418));
		}

		//obstacle 1
    	barriers.add(new Barrier(-10,400,260,260));
    	
    	//obstacle 2
    	barriers.add(new Barrier(50,50,200,30));
    	
    	//obstacle 3
    	barriers.add(new Barrier(300,50,200,30));
    	
    	//obstacle 4
   	 	barriers.add(new Barrier(-10, 130, 260, 220));
    	
   	 	//obstacle 5
   	 	barriers.add( new Barrier(300, 130, 200, 30));
   	 	
   	 	//obstacle 6
   	 	barriers.add(new Barrier(300, 210, 30, 140));
   	 	
   	 	//obstacle 7 and 8
   	 	barriers.add(new Barrier(380,210,120, 190));
   	 	
   	 	//obstacle 9
   	 	barriers.add(new Barrier(380, 450, 120, 210));
   	 	
   	 	//obstacle 10
   	 	barriers.add(new Barrier(550, 50, 300, 130));
   	 	
   	 	//obstacle 11
   	 	barriers.add(new Barrier(550, 230, 300, 70));
   	 	
   	 	//obstacle 12
   	 	barriers.add(new Barrier(550, 350, 300, 50));
   	 	
   	 	//obstacle 13,14
   	 	barriers.add(new Barrier(700, 450, 150, 210));
   	 	
   	 	//obstacle 15
   	 	barriers.add(new Barrier(550, 450, 100, 210));
   	 	
   	 	//obstacle 16
   	 	barriers.add(new Barrier(300, 400, 30, 260));
    	
    	this.m = new Minion(0,0);

		this.e = new Enemy(600,675); 
		this.e1 = new Enemy(650,200);
		this.e2 = new Enemy(150,100); 

		
	}
	
	public void deathScreen(){
	
		
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.CYAN);
		g2.setBackground(Color.BLACK);
		m.paint(g2);
		e.paint(g2);
		e1.paint(g2);
		e2.paint(g2);
		if(m.getLives()<=0){
			g2.setColor(Color.BLACK);
			g2.clearRect(0, 0, 900, 900);
			g2.fillRect(0, 0, 900, 900);
			for(int i = 0; i<103; i++){
				Coins.get(i).setAlive(false);
			}
			g2.setColor(Color.CYAN);
			g2.drawString("Game Over", 400, 300);
			g2.drawString("Final Score: " + m.getScore(), 400, 315);
			g2.setColor(Color.BLACK);
			g2.drawString("Score = " + m.getScore(), 400, 250);
			g2.drawString("Lives = " + m.getLives(), 400, 275);
		}
		
		for (int i = 0; i < 103; i++) {
			if(Coins.get(i).getxCoor() > m.getX()-15 && Coins.get(i).getxCoor() < m.getX() + 15 &&
					Coins.get(i).getyCoor() > m.getY()-15 && Coins.get(i).getyCoor() < m.getY() + 15){
				Coins.get(i).setAlive(false);
				Coins.get(i).setxCoor(10000);
				m.setScore(m.getScore()+10); 
			}
			else{
				Coins.get(i).paint(g2);
			}
			if(Coins.get(i).getAlive() == false){
				g2.drawString("Score = " + m.getScore(), 400, 250);
				g2.drawString("Lives = " + m.getLives(), 400, 275);
			}		
		}	
		for (int i = 0; i < barriers.size(); i++){
			barriers.get(i).paint(g2);
		}
	}
}








