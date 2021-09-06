package arrays;

import java.util.*;

public class countInversionsMergeSort {
	static int count = 0;
	
	public static void mergeSort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int n = mid - left + 1;
		int m = right - mid;
		int a[] = new int[n];
		int b[] = new int[m];
		for(int i = left; i <= mid; i++)
			a[i-left] = arr[i];
		for(int i = mid+1; i <= right; i++)
			b[i-mid-1] = arr[i];
		System.out.println(Arrays.toString(a) + " - " + Arrays.toString(b));
		
		int i = 0, j = 0, k = left;
		while(i < n && j < m) { 
			if(a[i] <= b[j]) 
				arr[k++] = a[i++];
			else {
				count += (n-i);
				arr[k++] = b[j++];
			}
		}
		while(i < n)
			arr[k++] = a[i++];
		while(j < m) 
			arr[k++] = b[j++];
	}
	
	// O(nlogn) time | O(n) space
	public static void mergeSort(List<Integer> arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    
    public static void merge(List<Integer> arr, int left, int mid, int right) {
        int n = mid - left + 1;
        int m = right - mid;
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        for(int i = left; i <= mid; i++)
            a.add(arr.get(i));
        for(int i = mid+1; i <= right; i++)
            b.add(arr.get(i));
		System.out.println(a + " - " + b);

        int i = 0, j = 0, k = left;
        while(i < n && j < m) { 
            if(a.get(i) <= b.get(j)) 
                arr.set(k++, a.get(i++));
            else {
                count += (n-i);
                arr.set(k++, b.get(j++));
            }
        }
        while(i < n)
            arr.set(k++, a.get(i++));
        while(j < m) 
            arr.set(k++, b.get(j++));
    }
    
	
	public static void main(String[] args) {
		int arr[] = {2, 1, 3, 1, 2};
		List<Integer>list = new ArrayList<Integer>();
		list.add(7);
		list.add(5);
		list.add(3);
		list.add(1);
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr) + " - " +  count);
		mergeSort(list, 0, list.size() - 1);
		System.out.println(list + " - " + count);
	}
}
