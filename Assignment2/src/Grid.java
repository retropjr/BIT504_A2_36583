/**
 * The Grid class represents the game board.
 * It is important that we only have one instance of the Grid. 
 * A singleton pattern is used to create the Grid class and global access is provided.
 */
public class Grid {
	// Define the amount of rows and columns
	//private static Grid instance = null;
	private final static int ROWS = 3;			// Rows
	private final static int COLUMNS = 3;		// Columns
 
	public static  Box[][] board = new Box[ROWS][COLUMNS];								// Represents the game board as a grid
	private static int currentRow;								// Row that was played last
	private static int currentCol;								// Column that was played last
 
	
		
	
	/**
	 * Constructor
	 */
   public Grid() {
      
      // TODO: Initialise the board array using ROWS and COLUMNS
     
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = new Box();
         }
         
      }
   }
   
   /**
    * 
    * If there is no other instance of a Grid (i.e. Only one game board) a Grid instance is created
    
   public static Grid getInstance() {
		if (instance == null) {
			instance = new Grid();
		}
		return instance;
	}
   */
   
   
   
   
   //Getter methods
   public  int getROWS() {
		return ROWS;
	}
   
   public int getCOLUMNS() {
		return COLUMNS;
	}
   
   public Player getBoard(int row, int col) {
		return board[row][col].content;
   }
   
   //Setter methods
   public void setBoard(int row, int col, Player player) {
		board[row][col].content = player;
	}
   
   public void setCurrentRow( int row) {
	   currentRow = row;
   }
   
   public void setCurrentCol( int col) {
	   currentCol = col;
   }

   
   
   
 
   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */
   public static boolean isDraw() {
	   
	   // TODO: Check whether the game has ended in a draw. 
	   // Hint: Use a nested loop (see the constructor for an example). Check whether any of the Boxes in the board grid are Player.Empty. If they are, it is not a draw.
	   // Hint: Return false if it is not a draw, return true if there are not empty positions left
	   return true;  // or false TODO code

   }
 
   /**
    * Return true if the turn player has won after making their move at the coordinate given
    */
   public static boolean hasWon(Player player) {
	   // Row check
	   if(board[currentRow][0].content == player && board[currentRow][1].content == player && board[currentRow][2].content == player) {
		   return true;
	   }
	   // Column check

	   // TODO: Check if the currentCol is filled.
	   // Hint: Use the row code above as a starting point, remember that it goes board[row][column].
	   
	   // Diagonal check (check both directions
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {
		   return true;
	   }

	   // TODO: Check the diagonal in the other direction
	   
	   // No one has won yet
	   return false;
   }
 
   /**
    * Draws the tic-tac-toe board to the screen
    */
   public void display() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
        	 
        	 // Draw the contents of the box
        	 board[row][col].display();
        	 
        	 // Draw the vertical line
        	 if (col < COLUMNS - 1) System.out.print("|");
        	 
    	 }
         System.out.println();
         
         // Draw the horizontal line
         if (row < ROWS - 1) {
        	 System.out.println("-----------");
         }
      }
   }
}


/*



public static int getBiscuitSize() {
	return biscuitSize;
}

public static void setBiscuitSize(int biscuitSize) {
	BiscuitProduction.biscuitSize = biscuitSize;
}

public static int getProductionSpeed() {
	return productionSpeed;
}

public static void setProductionSpeed(int productionSpeed) {
	BiscuitProduction.productionSpeed = productionSpeed;
}

public static int getChocolateChipAmount() {
	return chocolateChipAmount;
}

public static void setChocolateChipAmount(int chocolateChipAmount) {
	BiscuitProduction.chocolateChipAmount = chocolateChipAmount;
}

}
*/