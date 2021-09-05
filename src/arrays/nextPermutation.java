package arrays;

import java.util.Arrays;

public class nextPermutation {
	
	static void findNextPermutation(int[] a) {
		if(a.length <= 1)		return;
		int i = a.length - 2;
		while(i >= 0 && a[i] >= a[i+1])	  i--;
		if(i >= 0) {
			int j = a.length - 1;
			// There's definitely a value of j. Worst case me j = i+1
			while(a[j] <= a[i]) 	j--;
			swap(a, i, j);
		}
		reverse(a, i+1, a.length - 1);
	}
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void reverse(int[] a, int start, int end) {
		while(start < end) 	swap(a, start++, end--);
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};
		int i = 0;
		while(i < 20) {
			i++;
			System.out.println(Arrays.toString(arr));			
			findNextPermutation(arr);
		}
	}
}
