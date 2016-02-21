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
	
	/**The quicksort method takes the array of integers and sorts it using a pivot method.
	 * 
	 * @param low	the lowest index
	 * @param high	the highest index
	 */
	private void quicksort(int low, int high) {
		int number1 = low, number2 = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];
		// Divide into two lists
		while (number1 <= number2) {
		// If the current value from the left list is smaller then the pivot
		// element then get the next element from the left list
			while (numbers[number1] < pivot) {
				number1++;
			}
		    // If the current value from the right list is larger then the pivot
		    // element then get the next element from the right list
		    while (numbers[number2] > pivot) {
		        number2--;
		    }
		    //If elements are out of order swap elements
		    if (number1 <= number2) {
		    	swap(number1, number2);
		        number1++;
		        number2--;
		    }
		 }
		 // Recursively sort the numbers
		 if (low < number2){
			 quicksort(low, number2);
		 }
		 if (number1 < high){
		     quicksort(number, high);
		 }
	}
	
	/**The method is a simple swap method that exchanges the two values
	 * 
	 * @param number1	first number to swap
	 * @param number2	second number to swap
	 */
	private void swap(int number1, int number2) {
		int temp = numbers[number1];
		numbers[number1] = numbers[number2];
		numbers[number2] = temp;
		}
	
	/**Short method called printStar uses recursion to print stars
	 * 
	 * @param count		number of stars to print
	 */
	private static void printStar(int count){
		if (count > 0){
			System.out.print("*");
			printStar(count-1);
		}
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
						|| index == 279 || index == 299){
					System.out.println();
				}
		}
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
		for (int index = 0; index <300; index++){
			if (array[index] <= 20){
				count1 += 1;
			}
			else if (array[index] <= 40){
				count2 += 1;
			}
			else if (array[index] <= 60){
				count3 += 1;
			}
			else if (array[index] <= 80){
				count4 += 1;
			}
			else {
				count5 += 1;
			}
		}
		System.out.print(" 1 -  20: ");
		printStar(count1);
		System.out.println(" " + count1);
		System.out.print("21 -  40: ");
		printStar(count2);
		System.out.println(" " + count2);
		System.out.print("41 -  60: ");
		printStar(count3);
		System.out.println(" " + count3);
		System.out.print("61 -  80: ");
		printStar(count4);
		System.out.println(" " + count4);
		System.out.print("81 - 100: ");
		printStar(count5);
		System.out.println(" " + count5);
	}
}
