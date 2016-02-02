package leetcode.complete;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		HappyNumber h = new HappyNumber();
//		System.out.println(h.isHappy(19));
//		System.out.println(h.isHappy(1));
//		System.out.println(h.isHappy(3));
//		System.out.println(h.isHappy(4));
//		System.out.println(h.isHappy(100));
//		System.out.println(h.isHappy(101));
//		
		System.out.println(h.isHappy(13));
		// 13 => 1 + 9 = 10 => 1 + 0 = true
	}

	public static Set<Integer> set = new HashSet<Integer>();
	
	public boolean isHappy(int n) {
		char[] nums = String.valueOf(n).toCharArray();
        int sum = 0;
        for (char num : nums){
        	sum += Math.pow(num-48, 2);
        }
        if (sum == 1){
            set.clear();
        	return true;
        }else if (set.contains(sum)){
            set.clear();
        	return false;
        }else {
        	set.add(sum);
        	return isHappy(sum);
        }
    }
}
