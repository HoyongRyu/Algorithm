package leetcode.ing;

import java.util.regex.Pattern;

public class WildcardMatching{

	public static void main(String[] args){
		WildcardMatching w = new WildcardMatching();
		
		System.out.println(w.isMatch("aa", "a"));		//false
		System.out.println(w.isMatch("aa", "aa"));		//true
		System.out.println(w.isMatch("aaa", "aa"));		//false
		System.out.println(w.isMatch("a b", "a*b"));	//true
		System.out.println(w.isMatch("aa", "*"));		//true
		System.out.println(w.isMatch("aa", "a*"));		//true
		System.out.println(w.isMatch("ab", "?*"));		//true
		System.out.println(w.isMatch("aab", "c*a*b"));	//false
		System.out.println(w.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));	//true
		
		//FIXME Time Limit Exceeded
		System.out.println(w.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));	//
		
	}
	
	public boolean isMatch(String s, String p) {
		char prevChar = ' ';
		StringBuffer sb = new StringBuffer(); 
		for (char c : p.toCharArray()){
			if (prevChar == c && (c == '*')) {
				continue;
			}
			if (c == '?') {
				c = '.';
			}
			sb.append(c);
			prevChar = c;
		}
		return Pattern.matches(sb.toString().replace("?", ".").replace("*", ".*"), s);
    }

}
