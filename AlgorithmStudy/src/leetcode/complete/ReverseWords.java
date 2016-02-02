package leetcode.complete;

public class ReverseWords{

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

	public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
		
		if (s == null || s.trim().length() == 0) {
			return result.toString();
		}
		
		String[] arrStr = s.trim().split(" ");
		
		for (int i=arrStr.length - 1; i>=0;i--) {
			if ("".equals(arrStr[i])){
				continue;
			}
			result.append(arrStr[i]).append(" ");
		}
		
		return result.toString().trim();
    }
}
