package leetcode.complete;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

	public static void main(String[] args) {
		ContainsNearbyDuplicate c = new ContainsNearbyDuplicate();
		System.out.println(c.containsNearbyDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,20}, 1));
		System.out.println(c.containsNearbyDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,20}, 2));
		System.out.println(c.containsNearbyDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 1));
		System.out.println(c.containsNearbyDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,11,12,13,14,15,16,17,18,19,34},20));
		System.out.println(c.containsNearbyDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,11,12,13,14,15,16,17,18,19,34},15));
		System.out.println(c.containsNearbyDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,12,13,14,15,16,17,18,19,34},20));
		System.out.println(c.containsNearbyDuplicate(new int[]{0,1,2,34,45,6,7,8,9,10,11,12,13,14,15,16,17,18,19,34},15));
	}

	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
		
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for (int i=0;i<nums.length;i++) {
        	if (map.containsKey(nums[i])){
        		System.out.println("이전 위치 : " + map.get(nums[i]) + ", 지금 위치 : " + i);
        		if (i - map.get(nums[i]) <= k){
        			result = true;
        			break;
        		}else {
        			map.put(nums[i], i);
        		}
        	}else{
        		map.put(nums[i], i);
        	}
        }
        
		
		return result;
    }
}
