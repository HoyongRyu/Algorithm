package leetcode.complete;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings i = new IsomorphicStrings();
		System.out.println(i.isIsomorphic("egg", "add"));
		System.out.println(i.isIsomorphic("foo", "bar"));
		System.out.println(i.isIsomorphic("paper", "title"));
		System.out.println(i.isIsomorphic("ab", "aa"));
	}
	
	public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
        	return false;
        }
        
        Map<Character,Character> smap = new HashMap<Character,Character>();
        Map<Character,Character> tmap = new HashMap<Character,Character>();
        
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        for (int i=0;i<sChar.length;i++){
        	if (smap.containsKey(sChar[i])){
        		if (smap.get(sChar[i]) != tChar[i]){
        			return false;
        		}
        	}else if (tmap.containsKey(tChar[i])){
        		if (tmap.get(tChar[i]) != sChar[i]){
        			return false;
        		}
        	}else {
        		smap.put(sChar[i], tChar[i]);
        		tmap.put(tChar[i], sChar[i]);
        	}
        }
        
		return true;
    }

}
