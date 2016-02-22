/** The class MemoryMatch constructs a game for the user to select 2 cards. If they match, they turn face up.
 * If the cards do not match, they remain face down.The user continues to select two cards until all the cards
 * are face up. The user then wins the game.
 * 
 * @author Sarah Alspaugh
 * @version 1
 */

//Import Scanner in order to receive user input
import java.util.Scanner;

public class MemoryMatch {
	private int cardValue = 0;
	private boolean cardReveal = false;
	
	/** Create a MemoryMatch card with an integer value (1-8) and boolean value
	 * of whether it is revealed (or face up) or not
	 * 
	 * @param value		Value of the card
	 */
	public MemoryMatch(int value){
		cardValue = value;
		cardReveal = false;
	}
	
	/** This method returns the value of the card
	 * 
	 * @return		Value of the card
	 */
	public int getValue(){
		return cardValue;
	}
	
	/** This method returns whether or not the card is revealed or not
	 * 
	 * @return		return if card is revealed or not
	 */
	public boolean isRevealed(){
		return cardReveal;
	}
	
	/** This mutator method changes whether the card is revealed or not
	 * 
	 * @param reveal	true or false to reveal the card or not
	 */
	public void setRevealed(boolean reveal){
		cardReveal = reveal;
	}
	
	/** This method prints out the board for the card matching game
	 * 
	 * @param cards		array of cards to be displayed
	 */
	public static void printBoard(MemoryMatch[][] cards){
		//Create the board using tabs to space out the numbers
		System.out.println("\t\t1\t2\t3\t4");
		System.out.println("\t----------------------------------------");
		//Print out the values on the Board
		for(int count = 0; count < cards.length; count++){
			System.out.print((count + 1) + "\t|\t");
			for (int count1 = 0; count1 < cards[0].length; count1++){
				//If the card is revealed, print the value of the card
				if (cards[count][count1].isRevealed()){
					System.out.print(cards[count][count1].getValue() + "\t");
				}
				//If the card is not revealed, print a star in its place
				else {
					System.out.print("*\t");
				}
			} 
			System.out.println();
		}	
	}
	
	/** This method creates the board and creates the values for the cards
	 * 
	 * @return	the created Memory Match board game
	 */
	public static MemoryMatch[][] createBoard(){
		//Create a 2D array of 4 x 4 size
		MemoryMatch[][] board = new MemoryMatch[4][4];
		//Create the numbers for the board
		for (int index = 1; index <= 8; index++){
			for (int index1 = 1; index1 <= 2; index1 ++){
				boolean cardPicked = false;
				while (!cardPicked){
					int row = (int)(Math.random()*4);
					int column = (int)(Math.random()*4);
					if (board[row][column]==null){
						cardPicked = true;
						board[row][column] = new MemoryMatch(index);
					}
				}
			}
		}
		return board;
	}
	
	/** This method tests to see if the game has been won
	 * 
	 * @param board		the game being tested
	 * @return			true or false whether the game has been won
	 */
	public static boolean isGameWon(MemoryMatch[][] board){
		for (int index = 0; index < board.length; index++){
			for (int index1 = 0; index1 < board[0].length; index1++){
				if (!board[index][index1].isRevealed()){
					return false;
				}
			}
		}
		return true;
	}

	/** The main method creates a board. It continually loops asking the user to pick two cards until the 
	 * game is over. Print numerous lines between choices to remove board from the screen.
	 * 
	 */
	public static void main(String[] args){
		//Create a game
		MemoryMatch[][] board = createBoard();
		Scanner keyboard = new Scanner(System.in);
		
		while(!isGameWon(board)){
			//Display board and ask the user to enter column and row of 2 cards
			printBoard(board);
			System.out.print("Enter the column for the first card");
			int column1 = keyboard.nextInt();
			System.out.print("Enter the row for the first card");
			int row1 = keyboard.nextInt();
			
			System.out.print("Enter the column for the second card");
			int column2 = keyboard.nextInt();
			System.out.print("Enter the row for the second card");
			int row2 = keyboard.nextInt();
			
			//Create 2 cards from the data input by user
			MemoryMatch card1 = board[row1-1][column1-1];
			MemoryMatch card2 = board[row2-1][column2-1];
			
			//If the cards match, display the two cards face up (show their value)
			if ((card1.getValue()== card2.getValue()) &&
				(!(row1 == row2 && column1 == column2))){
				card1.setRevealed(true);
				card2.setRevealed(true);
				for (int count = 0; count < 15; count++){
					System.out.println();
				}
			}
			
			//If the user picks the same card twice, display an error message
			else if (row1 == row2 && column1 == column2){
				for (int count = 0; count < 15; count++){
					System.out.println();
					}
				System.out.println("You cannot pick the same card");
			}
			
			//If the user picks two cards that do not match, state the values do not match and
			// continue the game
			else {
				for (int count = 0; count < 15; count++){
					System.out.println();
				}
				System.out.println("Sorry, " + card1.getValue() + " and " + card2.getValue() + " do not mach");
			}
		}
		
		//Print the board and a winning message when the user has won the game
		printBoard(board);
		System.out.println("You have Won");
	}
}