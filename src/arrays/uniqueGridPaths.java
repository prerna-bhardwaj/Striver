package arrays;

import java.util.Arrays;

public class uniqueGridPaths {
	static int m = 2, n = 3;
	// O(2^n) time | O(n) space - call stack
	public static int countPaths(int i, int j) {
		if(i == m-1 && j == n-1)
			return 1;
		if(i >= m || j >= n) 
			return 0;
		else
			return countPaths(i+1, j) + countPaths(i, j + 1);
	}
	
	public static int countPathsDP(int i, int j) {
		int[][] paths = new int[m][n];
		paths[0][0] = 1;
		for(int row = 0; row < m; row++) {
			for(int col = 0; col < n; col++) {
				if(row == 0 && col == 0)
					continue;
				int left = (row>0) ? paths[row-1][col] : 0;
				int up = (col > 0) ? paths[row][col-1] : 0;
				paths[row][col] = left + up;
			}
		}
		System.out.println(Arrays.deepToString(paths));
		return paths[m-1][n-1];
	}
	
	// O(min(m, n)) time | O(1) space
	public static int countPathsLinear() {
		// Use double for integer overflow
		double paths = 1;
		int total = m + n - 2;
		int val = Math.min(m, n);
		
		for(int i = 1; i < val; i++) {
			paths *= total - i + 1;
			paths /= i;
		}
		return (int)paths;
	}
	
	public static void main(String[] args) {
		System.out.println(countPaths(0, 0));
		System.out.println(countPathsDP(0, 0));
		System.out.println(countPathsLinear());
	}
}
