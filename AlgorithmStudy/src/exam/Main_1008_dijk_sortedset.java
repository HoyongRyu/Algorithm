package exam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main_1008_dijk_sortedset {
	
	static int N;
	static int T;
	static Blocks[][] MAP;
	static int RESULT = Integer.MAX_VALUE;
	
	static Queue<Blocks> Q = new LinkedList<Blocks>();
	
	static SortedSet<Blocks> TEMP_Q = new TreeSet<Blocks>(){
		private static final long serialVersionUID = 5641446062389532674L;

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[ ");
			Blocks b;
			for (Object o : this){
				b = (Blocks)o;
				sb.append("(").append(b.row)
				  .append(",").append(b.col)
				  .append(",").append(b.insolation)
				  .append("--").append(b.elapsed)
				  .append("=>").append(b.currSum)
				  .append(")");
			}
			sb.append(" ]");
			return sb.toString();
		};
	};
	
	public static void main(String[] args) {
		/* 입력 */
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		T = sc.nextInt();
		
		MAP = new Blocks[N][N];
		int rowStart = 0;
		int colStart = 0;
		
		for (int i=0;i<N;i++){
			for (int j=0;j<N;j++){
				MAP[i][j] = new Blocks();
				MAP[i][j].row = i;
				MAP[i][j].col = j;
				MAP[i][j].insolation = sc.nextInt();
				if (MAP[i][j].insolation == -1){
					rowStart = i;
					colStart = j;
					MAP[i][j].insolation = 0;
					MAP[i][j].isVisit = true;
				}
			}
		}
		
		sc.close();
		
		/* 자... 시작해볼까 */
		
		//시작점을 일단 큐에 넣고..
		Q.offer(MAP[rowStart][colStart]);
		while (!Q.isEmpty()){
			next();
		}

		/* 출력 */
		if (RESULT == Integer.MAX_VALUE){
			RESULT = -1;
		}
		System.out.println(RESULT);
		
	}
	
	/* 메인큐에 있는 녀석은 이전 타임의 TEMP_Q의 경로 중 최소 값으로 이동한 녀석이다.
	   그 녀석에 대해서만 다음 이동칸을 비교 대상에 추가한다. */
	static void next(){
//		System.out.println("## " + cnt++ + "현재 main Q : " + mainQ.toString());
		Iterator<Blocks> itr = Q.iterator();
		Blocks b = null;
		while (itr.hasNext()){
			b = itr.next();
			b.isVisit = true;
			findNext(b.row+1, b.col, b.elapsed+1, b.currSum);
			findNext(b.row, b.col+1, b.elapsed+1, b.currSum);
			findNext(b.row-1, b.col, b.elapsed+1, b.currSum);
			findNext(b.row, b.col-1, b.elapsed+1, b.currSum);
			
		}
		Q.clear();
		
//		System.out.println("  ###   Temp Q : " + TEMP_Q.toString());
		
		// 다음 이동칸이 다 비었다면 리턴
		if (TEMP_Q.isEmpty()) {
			return;
		}
		
		/* TEMP_Q에서 제일 일사량이 작은 값이 first에서 뽑혀옴
		   first의 이전 칸은 필요없으니 제거하고,
		   first는 메인 큐에 집어 넣음(다음 칸을 뽑기 위해) */
		Q.offer(TEMP_Q.first());
		TEMP_Q.remove(TEMP_Q.first());
	}
	
	static void findNext(int row, int col, int elapsed, int prevSum){
		
		//이동이 가능한 칸이라면
		if (row < N && row >= 0 
				&& col < N && col >= 0 
				&& MAP[row][col].insolation != 0 
				&& !MAP[row][col].isVisit){
		
			Blocks b = MAP[row][col];
			
			//다음 칸 이동 시 T보다 크면 끝
			if (elapsed + 1 > T){
				return;
			}
			
			//도착했으면
			if (b.insolation == -2){
				//이전까지의 결과보다 작으면 일사량합 교체
				if (RESULT > prevSum) {
					RESULT = prevSum;
				}
				return;
			}
			//이전에 다른 경로로 왔던 칸이라면 경로를 구분하기 위해 block을 새로 만듦
			else if (TEMP_Q.contains(b)){
				b = new Blocks(b.row, b.col, b.insolation, b.currSum, b.elapsed);
			}
			
			b.elapsed = elapsed;
			b.currSum = prevSum + b.insolation; //현재 칸의 일사량 더해줌
			
			TEMP_Q.add(b); // TreeSet이므로 add하면서 알아서 sort함
			return;
		}
		return;
	}
}


class Blocks implements Comparable<Blocks>{
	int row = 0;
	int col = 0;
	int insolation = 0;
	boolean isVisit = false;
	int currSum = 0;
	int elapsed = 0;
	
	public Blocks(){
	}
	
	public Blocks(int row, int col, int insolation, int currSum, int elapsed){
		this.row = row;
		this.col = col;
		this.insolation = insolation;
		this.currSum = currSum;
		this.elapsed = elapsed;
	}

	@Override
	public int compareTo(Blocks o) {
//		return Integer.compare(currSum, o.currSum);
		
		/* TreeSet은 comparable로 재정의한 compareTo의 값이 같은 경우 
		 * add 할 때 아예 집어넣질 않음 ㅠㅠ
		 * 그래서 currSum만 비교하지 않고 나머지 값도 비교하도록 추가함 ㅠㅠ 
		 * 
		 * ArrayList로 만들고 sort를 한 경우는 currSum 비교만 넣어도 되나
		 * ArrayList의 경우 sort 의 부하가 TreeSet보다 훨씬 커서 
		 * 같은 100x100 input에서 시간 초과 걸림 */
		
		int result = Integer.compare(currSum, o.currSum);
		if (result == 0){
			result = Integer.compare(elapsed, o.elapsed); 
		}
		if (result == 0){
			result = Integer.compare(insolation, o.insolation);
		}
		if (result == 0){
			result = Integer.compare(row, o.row);
		}
		if (result == 0){
			result = Integer.compare(col, o.col);
		}
		return result;
	}
}