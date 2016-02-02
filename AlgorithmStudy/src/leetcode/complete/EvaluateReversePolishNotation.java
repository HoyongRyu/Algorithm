package leetcode.complete;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation{

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
		EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
//		System.out.println(erpn.evalRPN(new String[]{"2", "1", "+", "3", "*"}));  // ((2 + 1) * 3) -> 9
//		System.out.println(erpn.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // (4 + (13 / 5)) -> 6
//		System.out.println(erpn.evalRPN(new String[]{"4","-2","/","2","-3","-","-"})); // (4 / (-2)) - (2 - (-3)) -> -7

		System.out.println(erpn.evalRPN(new String[]{"18"}));
		System.out.println(erpn.evalRPN(new String[]{"-78","-33","196","+","-19","-","115","+","-","-99","/"})); // (-78 - ((-33 + 196) -(-19) + 115)) / -99 -> 3
		System.out.println(erpn.evalRPN(new String[]{"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"})); //
		System.out.println(erpn.evalRPN(new String[]{"3","11","+","5","-"})); // (3+11)-5 = 9
	}

	public static Map<String, Integer> OPERATOR_MAP = new HashMap<String, Integer>(){
		private static final long serialVersionUID = -3795265784962492627L;
	{
		put("+",1);put("-",2);put("*",3);put("/",4);
	}};
	
	public int evalRPN(String[] tokens) {
		if (tokens.length == 1){
			return Integer.parseInt(tokens[0]);
		}
		
		Stack<Integer> nums = new Stack<Integer>(); 
		Integer operatorMapValue = 0;
		int first = 0, second = 0;
		for (int i=0;i<tokens.length;i++) {
			operatorMapValue = OPERATOR_MAP.get(tokens[i]);
			if (operatorMapValue != null) {
				second = nums.pop();
				first = nums.pop();
				nums.push(operate(first, second, operatorMapValue));
			}else {
				nums.push(Integer.parseInt(tokens[i]));
			}
		}
		
		return nums.pop();
    }
	
	public int operate(int firstValue, int secondValue, int operatorValue){
		int result = 0;
		switch (operatorValue) {
			case 1:
				result = firstValue + secondValue; break;
			case 2:
				result = firstValue - secondValue; break;
			case 3:
				result = firstValue * secondValue; break;
			case 4:
				result = firstValue / secondValue; break;
		}
		return result;
	}
}
	
