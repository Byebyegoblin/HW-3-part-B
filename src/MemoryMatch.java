/**
 * 
 * @author Sarah
 * @version 1
 */

import java.util.Scanner;

public class MemoryMatch {
	private int cardValue =0;
	private boolean cardReveal = false;
	
	/** Create a MemoryMatch card with a value and boolean value
	 * of whether it is revealed or not
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
	 * @return		true or false whether the card is revealed or not
	 */
	public boolean isRevealed(){
		return cardReveal;
	}
	
	/** This mutator method changes whether the card is revealed or not
	 * 
	 * @param reveal	true or false whether the card is revealed
	 */
	public void setRevealed(boolean reveal){
		cardReveal = reveal;
	}
	
	

	
	
	
	
	
	
}