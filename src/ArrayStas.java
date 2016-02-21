/**The ArrayStas Class generates 300 random numbers from 1-100. The class then sorts and displays the 
 * numbers. The number of each is displayed for numbers 1-20, 21-40, 41-60, 61-80, 81-100.
 * 
 * @author Sarah Alspaugh
 * @version 1
 */

//Import Random Class
import java.util.Random;

public class ArrayStas {
	
	private int[] numbers;
	private int number;
	
	/**The Sort method checks the array for an empty array and if it is not empty is calls the quicksort
	 * 
	 * @param values	an array of integers
	 */
	public void sort(int[] values) {
		// check for empty array
		if (values ==null || values.length==0){
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}
	
	/**The quicksort method takes the array of integers and sorts it using a pivot method
	 * 
	 * @param low	the lowest index
	 * @param high	the highest index
	 */
	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];
		// Divide into two lists
		while (i <= j) {
		// If the current value from the left list is smaller then the pivot
		// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
		    // If the current value from the right list is larger then the pivot
		    // element then get the next element from the right list
		    while (numbers[j] > pivot) {
		        j--;
		    }
		    //If elements are out of order swap elements
		    if (i <= j) {
		    	swap(i, j);
		        i++;
		        j--;
		    }
		 }
		 // Recursively sort the numbers
		 if (low < j){
			 quicksort(low, j);
		 }
		 if (i < high){
		     quicksort(i, high);
		 }
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 */
	private void swap(int number1, int number2) {
		int temp = numbers[number1];
		numbers[number1] = numbers[number2];
		numbers[number2] = temp;
		}
	
	/** The Main method creates 300 random numbers in an array. The array is sorted and displayed. 
	 * The number of each value appearing in one of the five categories is then displayed. 
	 * 
	 */
	public static void main(String[] args){
		ArrayStas arrayMethods = new ArrayStas();
		Random rand = new Random();
		int[] array = new int[300];
		for (int index = 0; index <300; index++){
			int value = rand.nextInt(100) + 1;
			array[index] = value;
			System.out.println(array[index]);
		}
		arrayMethods.sort(array);
		for (int index = 0; index < 300; index++){
				System.out.print(array[index] + "   ");
				if (index == 19 || index == 39 || index == 59 || index == 79
						|| index == 99 || index == 119 || index == 139 
						|| index == 159 || index == 179 || index == 199
						|| index == 219 || index == 239 || index == 259
						|| index == 279 ){
					System.out.println();
				}
		}
		
	}
}
