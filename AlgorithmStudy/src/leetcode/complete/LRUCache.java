package leetcode.complete;

import java.util.LinkedHashMap;
import java.util.Set;

public class LRUCache{
    
	public static void main(String[] args){
		LRUCache c = new LRUCache(10);
//		c.set(1, 1);
//		c.set(2, 2);
//		c.set(3, 3);
//		c.set(4, 4);
//		c.set(5, 5);
//		c.set(6, 6);
//		c.set(7, 7);
//		c.set(8, 8);
//		c.get(1);
//		c.set(9, 9);
//		c.set(10, 10);
//		c.set(11, 11);
		
//		for (int i : c.map.keySet()){
//			System.out.println(i);
//		}
		
		c = new LRUCache(2);
		c.get(2);
		c.set(2, 6);
		c.get(1);
		c.set(1, 5);
		c.set(1, 2);
		c.get(1);
		c.get(2);
		for (int i : c.map.keySet()){
			System.out.println(i);
		}
	}
	
	private int capacity;
	
	private LinkedHashMap<Integer, Integer> map;
	
    public LRUCache(int capacity) {
    	map = new LinkedHashMap<Integer, Integer>(capacity+1, 1, true);
		this.capacity = capacity;
    }
    
    public int get(int key) {
    	return map.containsKey(key) ? map.get(key) : -1;
    }
    
    public void set(int key, int value) {
    	map.put(key, value);
    	if (map.size() > capacity) {
    		map.remove(map.keySet().iterator().next());
    	}
    }
}