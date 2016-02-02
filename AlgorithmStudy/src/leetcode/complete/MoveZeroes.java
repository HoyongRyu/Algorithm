package leetcode.complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MoveZeroes {

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		
		int[] arr = new int[]{0, 1, 0, 3, 12};
		m.moveZeroes(arr);
		
		print(arr);
		
		arr = new int[]{2,1};
		m.moveZeroes(arr);
		print(arr);
		
	}

	private static void print(int[] arr) {
		for (int n : arr) {
			System.out.print(n + ",");
		}
		System.out.println();
	}
	
	public void moveZeroes(int[] nums) {
        List<Integer> s = new ArrayList<Integer>();
        
        for (int num : nums) {
        	if (num != 0){
        		s.add(num);
        	}
        }
        
        Arrays.fill(nums, 0);
        
        Iterator<Integer> itr = s.iterator();
        int i=0;
        while (itr.hasNext()){
        	nums[i++] = itr.next();
        }
        
    }

}
