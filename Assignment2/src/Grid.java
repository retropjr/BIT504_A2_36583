/**
 * The Grid class represents the game board.
 * It is important that we only have one instance of the Grid. 
 * A singleton pattern is used to create the Grid class and global access is provided.
 */
public class Grid {
	//
	private static Grid instance = null;
	//Define the number of rows and columns
	private final static int ROWS = 3;			// Rows
	private final static int COLUMNS = 3;		// Columns
 
	private static  Box[][] board = new Box[ROWS][COLUMNS];	    // Represents the game board as a grid
	private static int currentRow;								// Row that was played last
	private static int currentCol;								// Column that was played last
 
	/**
	 * 
	 * If there is no other instance of a Grid (i.e. Only one game board) a 
	 * Grid instance is created and instance will no longer be null.
	 */ 
	public static Grid getInstance() {
		if (instance == null) {
			instance = new Grid();
		}
		return instance;
	}
	
	
	/**
	 * Constructor
	 */
   public Grid() {
      //Initialise the board array using ROWS and COLUMNS
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = new Box();
         }    
      }
   }
   
   
   
   
   //Getter methods
   public static int getROWS() {
		return ROWS;
	}
   
   public static int getCOLUMNS() {
		return COLUMNS;
	}
   
   public static Player getBoard(int row, int col) {
		return board[row][col].content;
   }
   
   //Setter methods
   public static void setBoard(int row, int col, Player player) {
		board[row][col].content = player;
	}
   
   
   
   
   public static void setCurrentRow( int row) {
	   currentRow = row;
   }
   
   public static void setCurrentCol( int col) {
	   currentCol = col;
   }

   //Other methods
   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */
   public static boolean isDraw() {
	   
	   // TODO: Check whether the game has ended in a draw. 
	   
	   // Using a nested loop. Check whether any of the Boxes in the board grid are Player.Empty. If they are, it is not a draw.
	   for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLUMNS; ++col) {
	            if(board[row][col].content == Player.EMPTY) {
	            	return false; //There are still empty positions on the grid, a win might still be possible.
	            }
	         }    
	      }
	   return true;  //All grid positions a full, a win is not possible, it is a draw.
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
	   if(board[0][currentCol].content == player && board[1][currentCol].content == player && board[2][currentCol].content == player) {
		   return true;
	   }
	   // Diagonal check (check both directions
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {
		   return true;
	   }

	   // TODO: Check the diagonal in the other direction
	   if(board[0][2].content == player && board[1][1].content == player && board[2][0].content == player) {
		   return true;
	   }
	   // No one has won yet
	   return false;
	   
   }
   
   
   /**
    * Clears the board before a new game.
    */
   public static void clearBoard() {
	   for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLUMNS; ++col) {
	            board[row][col].content = Player.EMPTY;
	         }
	   }
   }
 
   /**
    * Draws the tic-tac-toe board to the screen
    */
   public static void display() {
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

