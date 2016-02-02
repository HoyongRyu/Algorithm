package leetcode.complete;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		ContainsDuplicate c = new ContainsDuplicate();
		System.out.println(c.containsDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,20}));
		System.out.println(c.containsDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));
		System.out.println(c.containsDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,11,12,13,14,15,16,17,18,19,34}));
	}

	
	public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums) {
        	if (set.contains(num)){
        		result = true;
        		break;
        	}else {
        		set.add(num);
        	}
        }
        
        
        return result;
    }
}
