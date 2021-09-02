package arrays;

import java.util.Arrays;

// Dutch National Flag Algorithm
public class sort012Array {
	
	// Solved using Counting Sort
	// O(n) time | O(1) space
	// Works in 2 passes
	public static void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                zero++;
            else if(nums[i] == 1)
                one++;
            else
                two++;
        }
        int index = 0;
        while(zero > 0) {
            nums[index++] = 0;
            zero--;
        }
        while(one > 0) {
            nums[index++] = 1;
            one--;
        }
        while(two > 0) {
            nums[index++] = 2;
            two--;
        }
        System.out.println(Arrays.toString(nums));
    }
	
	// Zero => 0 ------ (low-1) 
	//  One => low ------ (mid-1) / (high-1), since mid=high eventually
	//  Two => (high+1) -------- n
	// O(n) time | O(1) space
	// Works in 1 pass
	public static void sortColorsEfficient(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        
        while(mid <= high) {
            switch(nums[mid]) {
            	// Swap values at mid and low
                case 0: nums[mid++] = nums[low];
                        nums[low++] = 0;
                        break;
                case 1: mid++;
                        break;
                // Swap values at mid and high
                case 2: nums[mid] = nums[high];
                        nums[high--] = 2;
                        break;
            }    
        }
        System.out.println(Arrays.toString(nums));
    }
	
	// O(n) time | O(1) space
	// Works in 1 pass
	public static void sortColorsUsingSwap(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        
        while(mid <= high) {
            switch(nums[mid]) {
            	// Swap values at mid and low
                case 0: swap(nums, low++, mid++);
                        break;
                case 1: mid++;
                        break;
                // Swap values at mid and high
                case 2: swap(nums, mid, high--);
                        break;
            }    
        }        
        System.out.println(Arrays.toString(nums));
    }
    
    public static void swap(int[]nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
	
	public static void main(String[] args) {
		int nums[] = {0, 2, 1, 1 ,0, 2, 2, 0, 1};
		sortColors(nums);
		sortColorsEfficient(nums);
		sortColorsUsingSwap(nums);
	}
}
