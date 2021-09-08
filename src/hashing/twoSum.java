package hashing;
/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that 
 * they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * NOTE : The array is not sorted. Therefore 2 pointer approach won't work unless you sort it.
 */
import java.util.*;

public class twoSum {
	// O(n) time | O(n) space
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>hm = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if(hm.containsKey(val)) 
                return new int[] {i, hm.get(val)};
            hm.put(nums[i], i);
        }
        return new int[]{};
    }
	
	public static void main(String[] args) {
		int arr[] = {2, 7, 6, 11, 15};
		int target = 17;
		System.out.println(Arrays.toString(twoSum(arr, target)));
	}
}
