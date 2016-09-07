package MinionManGood;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

// Main driver class
public class Main extends JFrame implements KeyListener {
	final static int X_FRAME_SIZE = 900;
	final static int Y_FRAME_SIZE = 900;
	Board b = null;
		
	public Main(){
		addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setSize(X_FRAME_SIZE, Y_FRAME_SIZE);
		setBackground(Color.BLACK);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout( new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		b = new Board();
		this.add(b);

		
	}
	
	public static void main(String[] args){
		
		JFrame frame = new Main();
		
		
	            }
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
		  if (c==KeyEvent.VK_UP) {
			  b.m.moveUP();
	        } else if(c==KeyEvent.VK_DOWN) {                
	          b.m.moveDown();
	        } else if(c==KeyEvent.VK_LEFT) { 
	        	b.m.moveLeft();
	        } else if(c==KeyEvent.VK_RIGHT) {                
	        	b.m.moveRight();
	        } 
			b.e.enemyMove(b.m);
			b.e1.enemyMove(b.m);
			b.e2.enemyMove(b.m);
			b.m.loseLife(b.e.getX(), b.e.getY());
			b.m.loseLife(b.e1.getX(), b.e1.getY());
			b.m.loseLife(b.e2.getX(), b.e2.getY());
			repaint();
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		b.e.enemyMove(b.m);
		b.e1.enemyMove(b.m);
		b.e2.enemyMove(b.m);
		b.m.loseLife(b.e.getX(), b.e.getY());
		b.m.loseLife(b.e1.getX(), b.e1.getY());
		b.m.loseLife(b.e2.getX(), b.e2.getY());
		repaint();
	}
}




