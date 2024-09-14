package application;

public class Test {
	// Main driver method
		public static void main(String[] args) {
			int arr[] = { 783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94 };
			int n = arr.length;
			
			// Function call
			RadixSort.radixsort(arr, n);
			RadixSort.print(arr, n);
		}
}
