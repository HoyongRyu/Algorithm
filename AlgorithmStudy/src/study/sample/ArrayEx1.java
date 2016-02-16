package study.sample;

public class ArrayEx1 {
	public static void main(String[] args){
		int[] jumsu = {90,89,76,80,45,89,89,94,55,90};
		
		System.out.println(Q1(jumsu));
	}
	
	static int Q1(int[] jumsu){
		int result = 0;
		for (int engScore : jumsu){
			if (engScore >= 80){
				result++;
			}
		}
		return result;
	} 
	
}
