package arrays;

/*
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
 * You may assume that the majority element always exists in the array.
 */

/*
 * Approach 1 - Brute Force - O(n^2) time
 * Approach 2 - Hashing using Hashmap - O(n)time | O(nlogn) space
 * 				Hashing using Arrays - O(n) time | O(n) space
 * Approach 3 - Boyer-Moore Voting Algo - O(n) time | O(1) space
 * Approach 4 - Sorting and returning nums[nums.length/2] - O(nlogn)time | O(1) space 
 */

public class majorityElement {
	/*
	 * Boyer-Moore Voting Algorithm
	 * O(n) time | O(1) space
	 */
	public static int findMajorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        for(int num : nums) {
            if(count == 0)
                ele = num;
            if(ele == num)
                count++;
            else
                count--;
        }
        return ele;
    }
	
	public static void main(String[] args) {
		int arr[] = {3, 3, 2, 2, 4, 2, 3, 3, 3,};
		System.out.println(findMajorityElement(arr));
	}
}
/*
 * If we had some way of counting instances of the majority element as +1+1 and 
 * instances of any other element as -1−1, summing them would make it obvious that the 
 * majority element is indeed the majority element.
 * https://leetcode.com/problems/majority-element/solution/
 */