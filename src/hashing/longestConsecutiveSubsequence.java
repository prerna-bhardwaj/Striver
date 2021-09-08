package hashing;
import java.util.*;

public class longestConsecutiveSubsequence {
	// Using Sorting
	// O(nlogn) time | O(n) space
	public static int longestSequenceSorting(int[] nums) {
	 if(nums.length == 0)
			return 0;
		Arrays.sort(nums);
		
		int currStreak = 1;
		int maxStreak = 1;
		for(int i = 1; i < nums.length; i++) {
			
			if(nums[i] != nums[i-1]) {
				if(nums[i] == nums[i-1] + 1) 
					currStreak++;
				else {
					maxStreak = Math.max(maxStreak, currStreak);
					currStreak = 1;
				}
			}
		}
		/*
		 *  NOTE : you return max of both values, since it might happen that u get a strictly inc 
		 *  and consecutive array as input. In that case you won't ever enter the else case.
		 *  Thus currStreak will be greater than maxStreak at the end.
		 */
		return Math.max(maxStreak, currStreak);
	}
	
	// Using hashset
	// O(n) time | O(n) space
	public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int num : nums)
            hs.add(num);
        
        int maxLen = 0;
        for(int num : nums) {
            if(!hs.contains(num-1)) {
                int curr = num, len = 1;
                while(hs.contains(curr+1)) {
                    len++;
                    curr++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		int arr[] = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(arr));
	}
}
/* 
 * Explanation for approach 1 : 
 * Before we do anything, we check for the base case input of the empty array. 
 * The longest sequence in an empty array is, of course, 0, so we can simply return that. 
 * For all other cases, we sort nums and consider each number after the first (because we need to 
 * compare each number to its previous number). If the current number and the previous are equal, 
 * then our current sequence is neither extended nor broken, so we simply move on to the next number. 
 * If they are unequal, then we must check whether the current number extends the sequence 
 * (i.e. nums[i] == nums[i-1] + 1). If it does, then we add to our current count and continue. 
 * Otherwise, the sequence is broken, so we record our current sequence and reset it to 1 (to include 
 * the number that broke the sequence). It is possible that the last element of nums is part of the 
 * longest sequence, so we return the maximum of the current sequence and the longest one.
 * 
 */