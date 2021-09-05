package arrays;

import java.util.Arrays;

public class setMatrixZeros {
	
	// O(nm*(n+m)) time | O(nm) space
	static void bruteForce(int[][] arr) {
		int n = arr.length, m = arr[0].length;
		int[][] temp = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m ; j++)
				temp[i][j] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				if(arr[i][j] == 0) {
					for(int k = 0; k < m ; k++)
						temp[i][k] = 0;
					for(int k = 0; k < n ; k++)
						temp[k][j] = 0;
				}
			}
		}
		arr = temp;
		System.out.println(Arrays.deepToString(temp));
	}
	
	// O(nm) time | O(n + m) space
	static void usingHashing(int[][] arr) {
		int n = arr.length, m = arr[0].length;
		boolean[] row = new boolean[n], col = new boolean[m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				if(arr[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(row[i] == true || col[j] == true)
					arr[i][j] = 0;
			}
		}
		System.out.println(Arrays.deepToString(arr));
	}
	
	// O(nm) time | O(1) space
	static void inPlaceHashing(int[][] arr) {
		int n = arr.length, m = arr[0].length;
		boolean firstRow = false, firstCol = false;
		for(int i = 0; i < n ; i++) {
			if(arr[i][0] == 0)
				firstCol = true;
		}
		for(int i = 0 ; i < m ; i++) {
			if(arr[0][i] == 0)
				firstRow = true;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				if(arr[i][j] == 0) {
					arr[i][0] = 0;
					arr[0][j] = 0;
				}
			}
		}
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m ; j++) {
				if(arr[i][0] == 0 || arr[0][j] == 0) 
					arr[i][j] = 0;
			}
		}
		
		if(firstRow) {
			for(int i = 0 ; i < m ; i++) {
				arr[0][i] = 0;
			}
		}
		if(firstCol) {
			for(int i = 0 ; i < n ;i++) {
				arr[i][0] = 0;
			}
		}
		System.out.println(Arrays.deepToString(arr));

	}
	
	public static void main(String[] args) {
		int[][] arr = {{1, 0, 1}, 
						{1, 1, 1}, 
						{1, 1, 1}, 
						{0, 1, 1}};
//		bruteForce(arr);
//		usingHashing(arr);
		inPlaceHashing(arr);
	}
}
