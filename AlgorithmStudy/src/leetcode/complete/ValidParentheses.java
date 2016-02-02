package leetcode.complete;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ValidParentheses v = new ValidParentheses();
		System.out.println(v.isValid("(asfdkjhjkasf{asdfasd}aslkjfasf[asdfasd][asfd][]asdfas{})"));	//true
		System.out.println(v.isValid("(asfd(kjhjkasf{asdfasd}aslkjfasf[asdfasd][asfd][]asdfas{})")); //false
		System.out.println(v.isValid("(asfd()kjhjkas{f{asdfasd}aslkjfasf[asdfasd][asfd][]asdfas{})}")); //false
		System.out.println(v.isValid("(asfdk[][][]{}{}{jhjkasf{asdfasd}aslkjfasf[asdfasd][asfd][]asdfas{}})")); //true
		System.out.println(v.isValid("[])"));
	}

	final static Map<String, String> PARENTHESE = new HashMap<String, String>(){{
		put("}","{");
		put("]","[");
		put(")","(");
	}};
	
	public boolean isValid(String s) {
		if (s == null || s.trim().length() == 0){
			return true;
		}
		
        Stack<String> parentheses = new Stack<String>();
        for (String b : s.split("")){
        	if (PARENTHESE.containsValue(b)){
        		parentheses.push(b);
        	}else if (PARENTHESE.containsKey(b)){
        		if (parentheses.isEmpty()){
        			return false;
        		}else if (!PARENTHESE.get(b).equals(parentheses.pop())){
        			return false;
        		}
        	}
        }
        
        if (parentheses.size() > 0){
        	return false;
        }
		
		return true; 
    }
}
