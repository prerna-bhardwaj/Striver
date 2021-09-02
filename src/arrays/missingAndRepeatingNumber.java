package arrays;

public class missingAndRepeatingNumber {
	public static void main(String[] args) {
		int nums[] = {3, 1, 4, 6, 2, 4};
		findNumbers(nums);
	}
	
	// O(n) time | O(1) space
	public static void findNumbers(int nums[]) {
		int xor = 0;
		for(int i = 0; i < nums.length; i++)
			xor = xor^ nums[i] ^(i+1);
		// xor = a^b
		/* Get the rightmost set bit in xor */
		int set_bit = xor & ~(xor-1);
		
		int bucket1 = 0, bucket2 = 0;
		for(int i = 0; i < nums.length; i++) {
			if((nums[i] & set_bit) != 0)
				bucket1 ^= nums[i];
			else
				bucket2 ^= nums[i];
			int temp = i+1;
			if((temp & set_bit) != 0) 
				bucket1 ^= temp;
			else
				bucket2 ^= temp;
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == bucket1) {
				System.out.println("Repeating number : " + bucket1);
				System.out.println("Missing number : " + bucket2);
				break;
			}
			else if(nums[i] == bucket2) {
				System.out.println("Repeating number : " + bucket2);
				System.out.println("Missing number : " + bucket1);
				break;
			}
		}
	}
}
