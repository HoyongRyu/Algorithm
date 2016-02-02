package leetcode.ing;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		
		MaximumProductSubarray m = new MaximumProductSubarray();
		System.out.println(m.maxProduct(new int[]{2,3,-2,4}));
		System.out.println(m.maxProduct(new int[]{-2}));
		System.out.println(m.maxProduct(new int[]{-4,-3}));
		System.out.println(m.maxProduct(new int[]{0,2}));
	}

	
	public int maxProduct(int[] nums) {
		int result = Integer.MIN_VALUE;
		
		int temp = 1;
		int tempPrev = Integer.MIN_VALUE;
		
		for (int i=0;i<nums.length;i++){
			temp = temp * nums[i];
			if (result < temp) {
				result = temp;
			}
			if (temp < tempPrev){
				temp = 1;
			}
			tempPrev = temp;
			System.out.println(tempPrev + " -> " + temp);
		}
		
		return result;
    }
}
