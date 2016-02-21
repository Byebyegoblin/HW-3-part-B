import java.util.Random;

public class ArrayStas {
	
	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		// check for empty array
		if (values ==null || values.length==0){
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

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
	private void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		}
	
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

				System.out.print(array[index] + "  ");
				if (index == 20 || index == 40 || index == 60 || index == 80
						|| index == 100 || index == 120 || index == 140 
						|| index == 160 || index == 180 || index == 200
						|| index == 220 || index == 240 || index == 260
						|| index == 280 ){
					System.out.println();
				}
		} 
	}
}
