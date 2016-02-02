package exam;
import java.util.Scanner;


/*
6 9
4 1 -1 4 2 0
1 2 0 0 7 1 
1 5 4 2 8 2
2 1 1 0 2 2
0 0 3 2 -2 1
1 1 4 7 6 1
 */

public class Main_1008 {
	
	static int N;
	static int T;
	static Block[][] MAP;
	static int RESULT;
	
	public static void main(String[] args) {
		/* 입력 */
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		T = sc.nextInt();
		
		MAP = new Block[N][N];
		int rowStart = 0;
		int colStart = 0;
		
		for (int i=0;i<N;i++){
			for (int j=0;j<N;j++){
				MAP[i][j] = new Block();
				MAP[i][j].insolation = sc.nextInt();
				if (MAP[i][j].insolation == -1){
					rowStart = i;
					colStart = j;
					MAP[i][j].insolation = 0;
				}
			}
		}
		
		/* 자... 시작해볼까 */
		RESULT = Integer.MAX_VALUE;
		next(rowStart, colStart, -1, 0);
		
		/* 출력 */
//		System.out.println("!@# 결과 : " + RESULT);
		if (RESULT == Integer.MAX_VALUE){
			RESULT = -1;
		}
		System.out.println(RESULT);
		
	}
	
	static void next(int row, int col, int elapsed, int tempSumOfInsolation){
//		System.out.println(String.format("%" + (elapsed+2) +"s", (elapsed + 1))
//				 + " -> prevSum=" + tempSumOfInsolation
//				 + ", current : (" + row + "," + col + ") = "
//				 + MAP[row][col].insolation);
		
		// 문 닫는 시간보다 초과하면 그 길은 아님. 걍 리턴.
		if (elapsed + 1 > T){
			return;
		}
		
		// 중간합계가 이미 MIN 값보다 크면 의미 없음. 걍 리턴.
		if (tempSumOfInsolation + MAP[row][col].insolation >= RESULT) {
			return;
		}
		
		// 도착했으면 현재 MIN 일사량과 비교해서 작으면 바꿔치기
		if (MAP[row][col].insolation == -2){
			if (RESULT > tempSumOfInsolation){
				RESULT = tempSumOfInsolation;
			}
			return;
		}
		
		//한칸 이동시간 +
		elapsed++;
		
		//방문표시
		MAP[row][col].isVisit = true;		
				
		//현재 일사량을 합계에 더함
		if (MAP[row][col].insolation > 0){
			tempSumOfInsolation += MAP[row][col].insolation;
		}
		
		if (row + 1 < N && MAP[row+1][col].insolation != 0 && !MAP[row+1][col].isVisit){ //아래
			next(row + 1, col, elapsed, tempSumOfInsolation);
		}
		if (col + 1 < N && MAP[row][col+1].insolation != 0 && !MAP[row][col+1].isVisit) { //오른쪽
			next(row, col + 1, elapsed, tempSumOfInsolation);
		}
		if (row - 1 >= 0 && MAP[row-1][col].insolation != 0 && !MAP[row-1][col].isVisit) { //위
			next(row - 1, col, elapsed, tempSumOfInsolation);
		}
		if (col - 1 >= 0 && MAP[row][col-1].insolation != 0 && !MAP[row][col-1].isVisit) { //왼쪽
			next(row, col - 1, elapsed, tempSumOfInsolation);
		}

		tempSumOfInsolation -= MAP[row][col].insolation;
		MAP[row][col].isVisit = false;
		elapsed--;
		return;
	}
}

class Block {
	int insolation = 0;
	boolean isVisit = false;
}
