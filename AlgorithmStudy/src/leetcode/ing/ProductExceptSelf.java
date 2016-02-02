package leetcode.ing;

public class ProductExceptSelf {

	public static void main(String[] args) {
		ProductExceptSelf p = new ProductExceptSelf();
		
		p.output(p.productExceptSelf(new int[]{1,2,3,4}));
		
		p.output(p.productExceptSelf(new int[]{0, 0}));
		
		p.output(p.productExceptSelf(new int[]{1, 0}));  //1, 0
		
		p.output(p.productExceptSelfWithDivision(new int[]{1,2,3,4}));
		
		p.output(p.productExceptSelfWithDivision(new int[]{0, 0}));
		
		p.output(p.productExceptSelfWithDivision(new int[]{1, 0}));
	}
	
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        //TODO 나누기 없이 O(n)으로 문제 풀기
        for (int i=0;i<nums.length;i++){
        	
        }
        
        return result;
    }

	public int[] productExceptSelfWithDivision(int[] nums) {
        int[] result = new int[nums.length];
		int allProducts = 1;
		for (int i=0;i<nums.length;i++){
			if (nums[i] > 0){
				allProducts = allProducts * nums[i];
			}
		}
		for (int i=0;i<nums.length;i++){
			if (nums[i] > 0){
				result[i] = allProducts / nums[i];
			}
		}
		return result;
    }
	
	public void output(int[] nums){
		for (int i=0;i<nums.length;i++){
			System.out.print(nums[i] + ", ");
		}
		System.out.println();
	}
}
