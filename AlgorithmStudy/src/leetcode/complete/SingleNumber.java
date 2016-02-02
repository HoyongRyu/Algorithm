package leetcode.complete;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		SingleNumber sn = new SingleNumber();
		
		System.out.println(sn.singleNumber(new int[]{2,1,2,4,1,3,9,9,3}));
	}

	public int singleNumber(int[] A) {
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		for (int a : A){
			if (map.containsKey(a)){
				map.remove(a);
				continue;
			}else {
				map.put(a, null);
			}
		}
		return map.keySet().iterator().next();
    }
}
