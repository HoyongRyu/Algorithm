package leetcode.complete;

import java.util.HashMap;
import java.util.Map;

public class TwoSum{

	/**
	 * @name_ko 간단한 메소드 설명 (short description about method)
	 * <pre>
	 * 자세한 메소드 설명 (full description about the method)
	 * </pre>
	 * @author  SDS
	 * @param args
	 *
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub

		
	}

}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{0, 0}; 
		
        if (numbers == null || numbers.length < 2) {
        	return result;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length;i++) {
        	if (map.containsKey(target - numbers[i])){
        		result[0] = map.get(target - numbers[i]);
        		result[1] = i+1;
        		return result;
        	}
        	map.put(numbers[i], i+1);
        }
        return result;
    }
}