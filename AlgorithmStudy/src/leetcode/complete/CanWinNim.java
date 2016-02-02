package leetcode.complete;

public class CanWinNim {

	public static void main(String[] args) {
		CanWinNim cwn = new CanWinNim();
		
		System.out.println(cwn.canWinNim(4));
		System.out.println(cwn.canWinNim(5));
		System.out.println(cwn.canWinNim(6));
		System.out.println(cwn.canWinNim(7));
		System.out.println(cwn.canWinNim(8));

	}

	
	public boolean canWinNim(int n) {
        if (n%4 == 0){
            return false;
        }
        
        return true;
    }
}
