package leetcode.complete;


public class RemoveElement{

	
	/*
	 * 
		Given an array and a value, remove all instances of that value in place and return the new length. 

		The order of elements can be changed. It doesn't matter what you leave beyond the new length. 

	 */
	public static void main(String[] args){
		RemoveElement re = new RemoveElement();
		
		System.out.println(re.removeElement(new int[]{4,5,897,4,5,3,1,5,6,4,8,7,9,4,3,1,6,5,9}, 4));
		
		System.out.println(re.removeElement(new int[]{4,5}, 4));
	}

	public int removeElement(int[] A, int elem) {
		int result = A.length;
		int cnt = 0;
		for (int i=0;i<A.length;i++){
			if (A[i] == elem){
				result--;
			}else {
				A[cnt++] = A[i];				
			}
		}
		return result;
    }
}
