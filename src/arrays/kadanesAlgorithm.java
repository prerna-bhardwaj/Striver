package arrays;
/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which 
 * has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */

public class kadanesAlgorithm {
	
	// O(n^3) time | O(1) space
	public static int maxSubArrayNaive(int[] nums) {
		int max = 0, n = nums.length;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				int sum = 0;
				for(int k = i; k <= j; k++)
					sum += nums[k];
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	
	// O(n^2) time | O(1) space
	public static int maxSubArrayEfficient(int[] nums) {
		int max = 0, n = nums.length;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {	
				sum += nums[j];
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	
	// O(n) time | O(1) space
	public static int kadanesAlgorithm(int[] nums) {
        int sum = 0, max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            /*
             *  We want to maximize the sum, so if it is -ve, it will further decrease upon adding 
             *  the next element. Therefore we reset it.
             */
            if(sum < 0) 
                sum = 0;
        }
        return max;
    }
	
	// O(n) time | O(1) space
	// Returns the start and end index of the sub array with max sum.
	public static int kadanesAlgorithmModified(int[] nums) {
        int sum = 0, max = nums[0];
        int start = 0, end = 0, curr = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max) {
            	max = sum;
            	start = curr;
            	end = i;
            }
            if(sum < 0) {
                sum = 0;
                curr = i+1;
            }
        }
        System.out.println(start + " " + end);
        System.out.println(nums[start] + " " + nums[end]);
        return max;
    }
	
	public static void main(String[] args) {
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArrayNaive(nums));
		System.out.println(maxSubArrayEfficient(nums));
		System.out.println(kadanesAlgorithm(nums));
		System.out.println(kadanesAlgorithmModified(nums));
	}
}

/*
 * [-2,1,-3,4,-1,2,1,-5,4]
 * [1]
 * [5,4,-1,7,8]
 */