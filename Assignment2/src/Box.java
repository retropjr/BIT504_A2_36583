/**
 * The Box class models each individual box of the Grid
 */
public class Box {

   Player content;			// The move this box holds (Empty, X, or O)
   //int row, col; 			// Row and column of this box (Not currently used but possibly useful in future updates)
 
   /**
    * Constructor
    */
   public Box() {
	   
	   content = Player.EMPTY;
  
   }
 
   /**
    * Clear the box content to EMPTY
    */
   public void clear() {
	   
      content = Player.EMPTY;
	   
   }
 
   /**
    * Display the content of the box " X " if it Player.X, " O " for Player.O and "   " for Player.Empty)
    */   public void display() {
	   
    	switch(content) {
		case EMPTY: {
			System.out.print("   ");
			break;
		}
		case X: {
			System.out.print(" X ");
			break;
		}
		case O: {
			System.out.print(" O ");
			break;
		}
		default: {
			System.out.println("Invalid box content!");
			break;
		}
	}
    	
    		   
   }
}