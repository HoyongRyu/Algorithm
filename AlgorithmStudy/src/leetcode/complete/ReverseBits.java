package leetcode.complete;

public class ReverseBits {

	public static void main(String[] args) {
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits2(1));
		System.out.println(r.reverseBits(1));
	}

	
	public int reverseBits(int n) {
		StringBuilder s = new StringBuilder(Integer.toString(n, 2));
		int lpadCount = 32-s.length();
		for (int i=0;i<lpadCount;i++){
			s.insert(0, "0");
		}
		return Integer.parseInt(s.reverse().toString(), 2);
    }
	
	public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i ++) {
            int lsb = n & 1; // returns right most digit of binary n
            int reverseLsb = lsb << (31 - i); // shifts lsb to opposite side 
            result = result | reverseLsb; // add up numbers lsb by lsb
            n = n >>> 1; // go to next lsb
        }
        return result;
    }

}
