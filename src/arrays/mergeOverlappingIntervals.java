package arrays;

import java.util.*;

public class mergeOverlappingIntervals {
	public static void main(String[] args) {
//		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {8, 9}, {9, 11}, {15, 18}, {2, 4}, {16, 17}};
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}

	static Comparator<int[]> comp = new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] - b[0];
		}
	};
	
	private static int[][] mergeIntervals(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		if(intervals.length == 0 || intervals == null)
			return res.toArray(new int[0][]);
		Arrays.sort(intervals, comp);
		
		int start = intervals[0][0];
		int end = intervals[0][1];
		for(int curr[] : intervals) {
			if(curr[0] <= end) {
				end = Math.max(end, curr[1]);
			}
			else {
				res.add(new int[] {start, end});
				start = curr[0];
				end = curr[1];
			}
		}
		res.add(new int[] {start, end});
		return res.toArray(new int[0][]);
	}
}
