package arrays;
import java.util.*;
/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 */

public class pascalsTriangle {
	
	// O(n^2) time | O(n^2) space - required for storing
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr, pre = null;
        for(int i = 0; i < numRows; i++) {
            curr = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    curr.add(1);
                else
                    curr.add(pre.get(j-1) + pre.get(j));
            }
            pre = curr;
            res.add(curr);
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(generate(5));
		System.out.println(generate(2));
		System.out.println(generate(10));
	}
}
