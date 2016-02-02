package leetcode.complete;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2{

	public static void main(String[] args){
		SingleNumber2 s = new SingleNumber2();
		
		System.out.println(s.singleNumber(new int[]{2,1,2,4,9,1,4,1,4,2}));
	}

	public int singleNumber(int[] A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt;
		for (int a : A){
			if (map.containsKey(a)){
				cnt = map.get(a) + 1;
				if (cnt >= 3) {
					map.remove(a);
				}else {
					map.put(a, cnt);
				}
				continue;
			}else {
				map.put(a, 1);
			}
		}
		return map.keySet().iterator().next();
    }
}
