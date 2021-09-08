package hashing;
/*
 * 3ptr + binary search = O(n^3logn) time 
 * Use HashSet for removing duplicate solutions.
 */
import java.util.*;

public class fourSum {
	
	// O(n^3) time | O(1) space
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		// Sort the array 
		Arrays.sort(nums);
        ArrayList<List<Integer>>res = new ArrayList<List<Integer>>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int target2 = target - nums[i] - nums[j];
                
                // Initialize left and right ptrs
                int left = j + 1;
                int right = n - 1;
                
                // left <= right is not used, since we don't have to use the same element twice.
                while(left < right) {
                    int sum = nums[left] + nums[right];
                    if(target2 > sum)
                        left++;
                    else if(target2 < sum)
                        right--;
                    else {
                        List<Integer>quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        res.add(quad);
                        
                        // Remove duplicates for the 3rd number
                        while(left < right && nums[left] == quad.get(2))
                            left++;
                        // Remove duplicates for the 4th number
                        while(left < right && nums[right] == quad.get(3))
                            right--;
                    }
                }
                // Remove duplicates for the 2nd number
                while(j < n-1 && nums[j] == nums[j+1])
                    j++;
            }
            
            // Remove duplicates for the 1st number
            while(i < n-1 && nums[i] == nums[i+1])
                i++;
        }
        return res;
    }
	
	public static void main(String[] args) {
		int arr[] = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(fourSum(arr, target));
	}
}
