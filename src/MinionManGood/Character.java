package MinionManGood;

import java.util.ArrayList;

public class Character {
	protected int x;
	protected int y;
	protected boolean iscontactBarrier = false;
	//checks whether the minion is moving towards an obstacle or not
	
	
		//method that makes sures that the minion does not go into the obstacles/ off the screen
		public  void checker(int x1, int y1, int width, int height, ArrayList<Barrier> barriers){
			
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
	    			setY(y1 + 10);
	    			setisContact(true);
	    		}
	    		
	    		//top side of all obstacles
	    		if ((x1 <= right && x1 +30 >= left) && (y1 + height == top)){
	    		
	    			setY(y1 - 10);
	    			setisContact(true);
	    		}
	    		
	    		//right side of obstacles
	    		if ((x1 == right) && ( y1 + 30 >=  top && y1 <= bottom)){
	    			setX(x1 + 10);
	    			setisContact(true);
	    		}
	    		
	    		//left side of obstacles
	    		if ((x1 + 30 == left) && (y1 + 30 >= top && y1 <= bottom)){
	    			setX(x1 - 10);
	    			setisContact(true);
	    		}
	    		
	    		
	    		
	    		//for screen
	    		if (x1 < 0){
	    			setX(x1 + 10);
	    			setisContact(true);
	    		}
	    		if (y1 < 0){
	    			setY(y1 + 10);
	    			setisContact(true);
	    		}
	    		
	    		if (x1 > 860){
	    			setX(x1 - 10);
	    			setisContact(true);
	    		}
	    		
	    		if(y1 > 670){
	    			setY(y1 - 10);
	    			setisContact(true);
	    		}
	    		

	    		
	    	
	    		
	    	}
		
			
			

		}
		
		
		

		// have methods that move the minion
		

		
			public void setX(int x1){
				this.x = x1;
			}
			
			public void setY(int y1){
				this.y = y1;
			}
		public void setisContact(boolean yes){
			this.iscontactBarrier = yes;
		}
		
		public int getX(){
			return this.x;
		}
		public int getY(){
			return this.y;
		}
		
		public boolean getisContact(){
			return this.iscontactBarrier;
		}
		

}


