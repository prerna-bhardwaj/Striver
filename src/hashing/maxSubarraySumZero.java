package hashing;

import java.util.*;

public class maxSubarraySumZero {
	
	// O(n) time | O(n) space
	public static int maxLen(int arr[], int n)
    {
        int max_len = 0, sum = 0;
        HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
        	// Update the value of sum
            sum += arr[i];
            // If sum = 0, then 0 to index i forms a zero-sum-subarray. Thus, update max_len
            if(sum == 0) {
                max_len = i + 1;
                continue;                
            }
            // Check is hashmap contains sum. If not add it.
            if(!map.containsKey(sum))
                map.put(sum, i);
            // Else you hv obtained a zero-sum-subarray. Update max_len accordingly.
            else {
                int index = map.get(sum);
                max_len = Math.max(max_len, i-index);
            }
        }
        return max_len;
    }
	
	public static void main(String[] args) {
		int arr[] = {15,-2,2,-8,1,7,10,23};
		System.out.println(maxLen(arr, arr.length));
	}
}

/*
 * Naive solution : 
 * Consider all sub-arrays one by one and check the sum of every sub-array.
 * Run two loops: the outer loop picks the starting point i and the inner loop tries all 
 * 	sub-arrays starting from i.
 * O(n^2) time | O(1) space
 * 
 * Optimal Solution:
 * Improve the time complexity by taking an extra space of 'n' length. 
 * The new array will store the sum of all the elements up to that index. 
 * The sum-index pair will be stored in a hash-map. Since a Hash map allows insertion and deletion 
 * of key-value pair in constant time. Therefore, the time complexity remains unaffected. 
 * So, if the same value appears twice in the array, it will be guaranteed that the particular array will be
 *  a zero-sum sub-array. 
 *  
 *  Time Complexity: O(n), as use of the good hashing function, will allow insertion and retrieval operations in O(1) time.
 *  Space Complexity: O(n), for the use of extra space to store the prefix array and hashmap.
 */

