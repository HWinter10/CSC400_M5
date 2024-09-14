package application;
//-------------------------------------------
//Pseudocode
//Author: Hailey King-Winterton
//Due Date: 09/15/2024
//-------------------------------------------
//Start
//		1. RadixSort class:
//			- Max number function:
//				- find and return largest number in array
//			- Count & sort function:
//				- count digit and sort array based on digit
//			- Radix sort function:
//				- use max to find largest number
//				- sort array by each digit from count & sort
//			- Print funtion
//				- print all elements in sorted array
// 		2. Test class: Main
//			- call radix sort to sort array
//			- call print to display sorted array
//End
//-------------------------------------------

import java.util.*;

public class RadixSort {
	// Function gets max value in array
	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}
	// Function to count sort of arr[] according to digit represented by exp.
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		// Stores count of occurences in count
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
		
		// Change count[i] to contain position of didgit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		
		// Builds output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		
		// Copy output array to arr[] so it contains sorted nums according 2 current digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}
	// Main function to sort arr[] of size n using Radix sort
	static void radixsort(int arr[], int n) {
		// Find max num
		int m = getMax(arr, n);
		
		// Count to sort every digit. 
		// Exp is passed instead of digit number. 
		// Exp is 10^i, i = current digit number.
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}
	// Print method
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}


