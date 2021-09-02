package arrays;

import java.util.Arrays;

public class mergeSortedArrays {
	
	private static void mergeArraysNaive(int[] a1, int[] a2) {
		int a3[] = new int[a1.length + a2.length];
		int index = 0;
		for(int i = 0; i < a1.length; i++)
			a3[index++] = a1[i];
		for(int i = 0; i < a2.length; i++)
			a3[index++] = a2[i];
		Arrays.sort(a3);
		index = 0;
		for(int i = 0; i < a1.length; i++)
			a1[i] = a3[index++];
		for(int i = 0; i < a2.length; i++)
			a2[i] = a3[index++];		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
	}

	private static void mergeArraysInsertionSort(int[] a1, int[] a2) {
		int i = 0;
		while(i < a1.length) {
			if(a1[i] <= a2[0]) {
				i++;
			}
			else {
				int temp = a1[i];
				a1[i] = a2[0];
				a2[0] = temp;
				sort(a2);
				i++;
			}
		}
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
	}
	
	
	private static void sort(int[] ar) {
		int index = 1;
		int value = ar[0];
		while(index < ar.length) {
			if(value < ar[index]) {
				break;
			}
			ar[index-1] = ar[index];
			index++;
		}
		ar[index-1] = value;
	}

	// O(n) time | O(1) space
	private static void mergeArraysGapMethod(int[] a1, int[] a2) {
		int i, j, gap = a1.length + a2.length;
		for(gap = getGap(gap); gap > 0; gap = getGap(gap)) {
			// Comparing elements in the first array
			for(i = 0; i+gap < a1.length; i++) {
				if(a1[i] > a1[i+gap])
					swapArray(a1, i, i+gap);
			}
			
			// Comparing elements in both arrays simultaneously
			for(j = 0; i < a1.length && j < a2.length; j++, i++) { 
				if(a1[i] > a2[j]) 
					swapArray(a1, a2, i, j);
			}
			
			if(j < a2.length) {
				// Comparing elements in the second array
				for(j = 0; j+gap < a2.length; j++) {
					if(a2[j] > a2[j+gap])
						swapArray(a2, j, j+gap);
				}	
			}
		}
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
	}
	
	
	private static void swapArray(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void swapArray(int[] a, int[] b, int i, int j) {
		int temp = a[i];
		a[i] = b[j];
		b[j] = temp;
	}

	private static int getGap(int gap) {
		// This case is handled separately since, it might again return 1 if we take mod.
		if(gap <= 1)
			return 0;
		return (gap/2) + (gap%2);
	}

	public static void main(String[] args) {
		int a1[] = {1, 4, 7, 8, 10};
		int a2[] = {2, 3, 9};
//		mergeArraysNaive(a1, a2);
//		mergeArraysInsertionSort(a1, a2);
		mergeArraysGapMethod(a1, a2);
	}

}
