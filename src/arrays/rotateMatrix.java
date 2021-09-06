package arrays;

import java.util.*;

public class rotateMatrix {
	// O(n^2) time | O(1) space
	public static void rotate(int[][] mat) {
        System.out.println(Arrays.deepToString(mat));
        for(int i = 0; i < mat.length; i++) {
        	// NOTE : j starts from i+1 and not 0. Else the matrix is restored to its initial state.
            for(int j = i+1; j < mat.length; j++) {
            	int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(mat));
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length/2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat[0].length-j-1];
                mat[i][mat[0].length - j - 1] = temp;
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }
	
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, 
						{4, 5, 6}, 
						{7, 8, 9}};
		rotate(arr);
	}
}
