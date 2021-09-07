package arrays;

import java.util.Arrays;

public class reversePairs {
static int count = 0;
    
    public static int reversePairs(int[] nums) {
        count = 0;
        mergeSort(nums, 0, nums.length-1);    
        return count;
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
        int m = mid - left + 1;
        int n = right - mid;
        int[] a = new int[m], b = new int[n];
        
        for(int i = left; i <= mid; i++)
            a[i - left] = arr[i];
        for(int i = mid + 1; i <= right; i++) 
            b[i-mid-1] = arr[i];
        System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
        count += getCount(a, b);
        
        int i = 0, j = 0, k = left;
        while(i < m && j < n) {
            if(a[i] >= b[j])
                arr[k++] = b[j++];
            else 
                arr[k++] = a[i++];
        }
        while(i < m)
            arr[k++] = a[i++];
        while(j < n)
            arr[k++] = b[j++];
    }
    
    public static int getCount(int[] a, int[] b) {
    	int i = 0, j = 0;
    	int res = 0;
    	while(i < a.length && j < b.length) {
    		double u = (double)a[i];
    		double v = (double)b[j];
    		if(u > 2*v) {
    			res += a.length-i;
    			i++;
    			j++;
    		}
    		else
    			i++;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	int arr[] = {2,4,3,5,1};
    	System.out.println(reversePairs(arr));
    }
}
