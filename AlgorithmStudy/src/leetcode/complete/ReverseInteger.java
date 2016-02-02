package leetcode.complete;

public class ReverseInteger{

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
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(-123));
		System.out.println(r.reverse(321));
		System.out.println(r.reverse(100));
		System.out.println(r.reverse(1000000003));
	}

	public int reverse(int x) {
        String s = String.valueOf(x);
        boolean isMinus = false;
        if (s.startsWith("-")){
        	isMinus = true;
        	s = s.replace("-", "");
        }
        
        StringBuffer sb = new StringBuffer();
        String[] preReverse = s.split("");
        for (int i=preReverse.length-1;i>=0;i--){
        	sb.append(preReverse[i]);
        }
		
		return Integer.parseInt((isMinus ? "-":"") + sb.toString());
    }
}
