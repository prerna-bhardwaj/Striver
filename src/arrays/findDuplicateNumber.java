package arrays;
/*
 * Given an array of integers nums containing n + 1 integers where each integer is in the 
 * range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * NOTE : All the integers in nums appear only once except for precisely one integer which appears two or 
 * 			more times.
 * */

/*
 * Approach 1 : sorting => O(nlogn) time | O(1) space
 * Approach 2 : hashing => O(nl) time | O(n) space
 * Approach 3 : linked list cycle method => O(n) time | O(1) space
 */

public class findDuplicateNumber {
	
	// O(n) time | O(1) space
	static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		// Obtain the point of collision
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(fast != slow);

		// Reposition the fast ptr to the first element
		fast = nums[0];
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		// Or you could return fast
		return slow;
	}
	
	public static void main(String[] args) {
		int nums[] = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
//		int nums[] = {2, 2, 2, 2, 2, 2};
		System.out.println(findDuplicate(nums));
	} 
}
