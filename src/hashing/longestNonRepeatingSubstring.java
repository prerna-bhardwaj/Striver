package hashing;
import java.util.*;

public class longestNonRepeatingSubstring {
	// O(n) time | O(n) space
	// You are going to directly hop to the required position, instead of ++ by 1.
	public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer>map = new HashMap<Character, Integer>();
        int max = 0, start = 0, end = 0;
        
        while(end < s.length()) {
            Character c = s.charAt(end);
            // Dry run - 'abba' for clear understanding
            if(map.containsKey(c))
                start = Math.max(map.get(c)+1, start);
            map.put(c, end);            
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }
	
	// O(n) time | O(n) space
	// Critically speaking, O(2n) = TC
	// start ptr is ++ by 1 in case of duplicates
	public static int lengthOfLongestSubstringSet(String s) {
        if(s.equals(""))
            return 0;
        HashSet<Character>set = new HashSet<Character>();
        int max = 0, start = 0, end = 0;
        
        while(end < s.length()){
            Character c = s.charAt(end);
            if(set.contains(c)) {
                while(set.contains(c)) {
                    Character temp = s.charAt(start);
                    set.remove(temp);
                    start++;
                }
            }
            set.add(c);
            max = Math.max(max, end-start+1);
            end++;
        }
        return max;
    }
	
	public static void main(String[] args) {
		String s = "abcaabcdba";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstringSet(s));
	}
	
}
