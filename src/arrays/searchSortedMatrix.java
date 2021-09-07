package arrays;

public class searchSortedMatrix {
	// Matrix is sorted row-wise only
	// O(n) time | O(1) space
	public static boolean searchMatrix(int[][] mat, int target) {
        if(target < mat[0][0])      
            return false;
        int rowIndex = searchRow(mat, target);
        System.out.println(rowIndex);
        int m = mat[0].length;
        if(mat[rowIndex][0] > target || mat[rowIndex][m-1] < target)
        	return false;
        int colIndex = searchCol(mat, rowIndex, target);
        System.out.println(colIndex);
        if(mat[rowIndex][colIndex] == target)
            return true;
        return false;
    }
    
    public static int searchRow(int[][]mat, int val) {
        int left = 0, right = mat.length-1;
        int index = -1;
        while(left <= right) {
            int mid = (left + right)/ 2;
            if(mat[mid][0] < val) {
                index = mid;
                left = mid+1;
            }
            else if(mat[mid][0] > val) {
                right = mid - 1;
            }
            else
                return mid;
        }
        return index;
    }

    public static int searchCol(int[][]mat, int row, int val) {
        int left = 0, right = mat[0].length-1;
        int index = -1;
        while(left <= right) {
            int mid = (left + right)/ 2;
            if(mat[row][mid] < val) {
                index = mid;
                left = mid+1;
            }
            else if(mat[row][mid] > val) {
                right = mid - 1;
            }
            else
                return mid;
        }
        return index;
    }
    
    // Matrix is row-wise sorted
    // O(log(n*m)) time | O(1) space
    public static boolean searchMatrixOptimized(int[][] mat, int target) {
        if(mat.length == 0) return false;
        int n = mat.length, m = mat[0].length;
        int left = 0, right = (m*n)-1;

        while(left <= right) {
            int mid = (left + right)/ 2;
            int row = mid / m;
            int col = mid % m;
            if(mat[row][col] == target)
                return true;
            if(mat[row][col] < target)
                left = mid + 1;
            else
                right = mid - 1;
            
        }
        return false;       
    }

    // Matrix is row-wise and column-wise sorted
    public static boolean searchMatrix2(int[][] mat, int target) {
        int row = 0, col = mat[0].length - 1;
        while(isValid(row, col, mat)) {
            System.out.println(row + " " + col + " " + mat[row][col]);
            if(mat[row][col] < target) 
                row++;
            else if(mat[row][col] > target)
                col--;
            else
                return true;
        }
        return false;
    }
    
    public static boolean isValid(int row, int col, int[][]mat) {
        int n = mat.length, m = mat[0].length;
        if(row < 0 || col < 0 || row >= n || col >= m)
            return false;
        return true;
    }
    
    
	public static void main(String[] args) {
		int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(searchMatrix(mat, 5));
		System.out.println(searchMatrixOptimized(mat, 5));
		
		int[][]mat2 = {{1,4,7,11,15},
						{2,5,8,12,19},
						{3,6,9,16,22},
						{10,13,14,17,24},
						{18,21,23,26,30}};
		System.out.println(searchMatrix2(mat2, 5));
	}
} 