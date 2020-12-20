import java.util.InputMismatchException;
import java.util.Scanner;				// Scanner required for player input

/**
 * The main class for the game Tic-Tac-Toe. Commit test
 * Controls the flow of the game, allowing each player to enter an option until the game ends.
 */

public class GameMain {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input
	
	private boolean gameOver = false;	// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player (enum)
 
   /**
    * Constructor
    * Sets up the game. Creates the grid and sets the values of the variables before calling the play method.
    */
   public GameMain() {
	   // Create the grid
	   Grid.getInstance();
	   
	   // Reset the game variables to their defaults
	   
	   currentPlayer = Player.X;
	   winner = Player.EMPTY;
	   Grid.clearBoard();

	   // Begin playing the game
	   Grid.display();
	   play();   
   }
   
   /**
    * Controls the game play, rotates between player turns until a winner is decided.
    */
   public void play() {
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         Grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won
	         
	         // Display results if game is over
	         if(gameOver) {
	        	 if(winner == Player.X) {
		        	 System.out.println("Player X wins!");
		         } else if(winner == Player.O ) {
		        	 System.out.println("Player O wins!");
		         } else if(winner == Player.EMPTY) {
		        	 System.out.println("It's a draw!");
		         }
	         }
	         
	         // Switch turn to the next player
	         if(currentPlayer == Player.X) {
	        	 currentPlayer = Player.O;
	         } else {
	        	 currentPlayer = Player.X;
	         }
	         
	      } while (!gameOver);  // repeat until game-over
   }
 
   /** 
    * Handles the player making their move, checks if the move is valid before making it.
    */
   public void playerMove(Player turnPlayer) {
	   
      boolean validInput = false;
      
      do {
    	  
    	  // Display instructions to the player
         if (turnPlayer == Player.X) {
            System.out.println("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
        	 System.out.println("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         
         // Obtains input from the player for both row and column
         int row = 0, col = 0;
         while (row == 0 || col == 0) {
         try {
				//Read the next integer on the console.
	            row = scanner.nextInt();
			}
			//If an integer is not entered, catch the exception, and inform the user.
			catch(InputMismatchException e) {
				//Checks that only an integer is entered.
				System.err.println("Please enter integer numbers (row space column).");
				//The following line is required because otherwise the newline character produced when the user hits enter is read and the 
				//program enters an infinite loop... 
				scanner.nextLine();
				row = 0; 
				break;
			}
        
         try {
				//Read the next integer on the console.
				col = scanner.nextInt();
			}
			//If an integer is not entered, catch the exception, and inform the user.
			catch(InputMismatchException e) {
				//Checks that only an integer is entered.
				System.err.println("Please enter integer numbers (row space column).");
				//The following line is required because otherwise the newline character produced when the user hits enter is read and the 
				//program enters an infinite loop... 
				scanner.nextLine();
				col = 0;
				break;
			}
         }
         
         // Decrease the value entered by 1 to compensate for the array index starting at 0
         row--;
         col--;
         
         
         // Verify the values the player entered are valid (position is valid and empty)
         if (row >= 0 && row < Grid.getROWS() && col >= 0 && col < Grid.getCOLUMNS() && Grid.getBoard(row, col) == Player.EMPTY) {
        	 Grid.setBoard(row, col, turnPlayer);
        	 Grid.setCurrentRow(row);
        	 Grid.setCurrentCol(col);
        	 validInput = true;
         } else {
        	 //Display an error message that the move was not valid.
         	 System.out.println("Please reenter your move, making sure the square you want is empty.");
         }  
      } while (!validInput);   // Repeat until input is valid
   }
 
   /**
    * Checks if the game has ended
    */
   public void checkForWinner(Player turnPlayer) {
      if (Grid.hasWon(turnPlayer)) {
    	  winner = turnPlayer;
    	  gameOver = true;
      } else if (Grid.isDraw()) {
    	  winner = Player.EMPTY;
    	  gameOver = true;
      }
   }
 
   /**
    * The main() method
    */
   public static void main(String[] args) {
	   
	   boolean exitGame = false;
	   
	   while (!exitGame) {
		   new GameMain();
		   //ask the player if they want to play again, exit if they do not
		   System.out.print("Do you want to play another game? (y/n): ");
		   char response = scanner.next().charAt(0);
		   if (response == 'y' || response == 'Y') {
			   exitGame = false;
			} else {
				exitGame = true;
			}
		   
	   } 
	   scanner.close();
	}
}