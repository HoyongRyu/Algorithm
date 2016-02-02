package leetcode.complete;

public class HammingWeight {

	public static void main(String[] args) {
		HammingWeight h = new HammingWeight();
		System.out.println(h.hammingWeight(1));
		System.out.println(h.hammingWeight(5));
		System.out.println(h.hammingWeight(10));
		System.out.println(h.hammingWeight(8));
		
	}

	public int hammingWeight(int n) {
		int result = 0;
		
		char[] chars = Integer.toBinaryString(n).toCharArray();
		for (char ch : chars ){
			if (ch == '1'){
				result++;
			}
		}
		return result;
    }
}
