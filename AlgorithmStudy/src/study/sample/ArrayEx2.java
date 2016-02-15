package study.sample;

public class ArrayEx2 {

	public static void main(String[] args) {
		System.out.println("### ArrayEx2 ");
		
		int[] jumsu = {90,89,76,80,45,89,89,94,55,90};
		
		Q1(jumsu);
		Q2(jumsu);
	}

	
	static void Q1(int[] jumsu){
		System.out.println(" # Question 1 #");
		int[] result = new int[101];
		
		for (int engScore : jumsu){
			result[engScore]++;
		}
		
		for (int i=1;i<=100;i++){
			if (result[i] > 0){
				System.out.println("점수: " + i + " - " + result[i]);
			}
		}
	}
	
	static void Q2(int[] jumsu){
		System.out.println(" # Question 2 #");
		int[] counting = new int[101];
		
		for (int engScore : jumsu){
			counting[engScore]++;
		}
		
		int maxCount = 0, result = 0;
		for (int i=1;i<=100;i++){
			if (counting[i] > maxCount){
				maxCount = counting[i];
				result = i;
			}
		}
		
		System.out.println(result);
	}
}
