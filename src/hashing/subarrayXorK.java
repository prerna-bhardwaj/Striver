package hashing;
import java.util.*;

public class subarrayXorK {
	public static int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int xor = 0, count = 0;
        map.put(0, 1);
        for(int i = 0; i < A.length; i++) {
            xor ^= A[i];
            if(map.containsKey(xor^B))
                count += map.get(xor^B);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
	
	public static void main(String[] args) {
		int arr[] = {4, 2, 2, 6, 4};
		int k = 6;
		// Answer = 4
		System.out.println(solve(arr, k));
	}
}
