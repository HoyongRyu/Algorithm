package exam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

public class Main_1008_dijk {
	
	static int N;
	static int T;
	static Blockss[][] MAP;
	static int RESULT = Integer.MAX_VALUE;
	static int[] MIN_INSOLATION;
	
	static int cnt = 1;
	
	static Queue<Blockss> Q = new LinkedList<Blockss>();
//	
//	static FileWriter fw = null;
//	static BufferedWriter bw = null;
//	
	static List<Blockss> TEMP_Q = new ArrayList<Blockss>(){
		private static final long serialVersionUID = 5641446062389532674L;

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[ ");
			Blockss b;
			for (Object o : this){
				b = (Blockss)o;
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
//		try {
//			fw = new FileWriter(new File("d:/downloads/a.log"));
//			bw = new BufferedWriter(fw);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/* 입력 */
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		T = sc.nextInt();
		
		MIN_INSOLATION = new int[T+1];
		for (int i=0;i<=T;i++){
			MIN_INSOLATION[i] = Integer.MAX_VALUE;
		}
		
		MAP = new Blockss[N][N];
		int rowStart = 0;
		int colStart = 0;
		
		for (int i=0;i<N;i++){
			for (int j=0;j<N;j++){
				MAP[i][j] = new Blockss();
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
			next(Q);
		}

		/* 출력 */
		System.out.print("!@# MIN_ISOLATION : ");
		for (int i : MIN_INSOLATION){
			System.out.print(i+", ");
		}
		System.out.println();
		
		if (RESULT == Integer.MAX_VALUE){
			RESULT = -1;
		}
		System.out.println(RESULT);
//		
//		try {
//			bw.close();
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
	}
	
	static void next(Queue<Blockss> mainQ){
		System.out.println("## " + cnt++ + "현재 main Q : " + mainQ.toString());
		Iterator<Blockss> itr = mainQ.iterator();
		Blockss b = null;
		boolean isNext = false;
		while (itr.hasNext()){
			b = itr.next();
			b.isVisit = true;
			isNext = isNext | findNext(b.row+1, b.col, b.elapsed, b.currSum, b);
			isNext = isNext | findNext(b.row, b.col+1, b.elapsed, b.currSum, b);
			isNext = isNext | findNext(b.row-1, b.col, b.elapsed, b.currSum, b);
			isNext = isNext | findNext(b.row, b.col-1, b.elapsed, b.currSum, b);
			mainQ.remove(b);
		}
		
		System.out.println("  ###   Temp Q : " + TEMP_Q.toString());
		if (TEMP_Q.isEmpty()) {
			return;
		}
		
		Collections.sort(TEMP_Q);
		
//		try {
//			bw.write("  ###   Temp Q : " + TEMP_Q.toString());
//			bw.write("\n");
//			bw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println(" === this time min : " + TEMP_Q.toString());
		TEMP_Q.get(0).parent.isVisit = true;
		Q.remove(TEMP_Q.get(0).parent);
		Q.offer(TEMP_Q.get(0));
		if (MIN_INSOLATION[TEMP_Q.get(0).elapsed] > TEMP_Q.get(0).currSum) {
			MIN_INSOLATION[TEMP_Q.get(0).elapsed] = TEMP_Q.get(0).currSum;
		}
		TEMP_Q.remove(0);
	}
	
	static boolean findNext(int row, int col, int elapsed, int prevSum, Blockss parent){
		
		
		if (row < N && row >= 0 
				&& col < N && col >= 0 
				&& MAP[row][col].insolation != 0 
				&& !MAP[row][col].isVisit){
			
			Blockss b = MAP[row][col];
			
			if (TEMP_Q.contains(b)){
				b = new Blockss(b.row, b.col, b.insolation, b.currSum, b.elapsed, parent);
			}
			
			if (elapsed + 2 > T){
				return false;
			}
			
			if (b.insolation == -2){
				System.out.println("     !@#!@#!@#!@ 도착 - " + RESULT + " > " + prevSum + " ? ");
				if (RESULT > prevSum) {
					RESULT = prevSum;
				}
				return false;
			}
			
			if (elapsed+1 > T
					|| prevSum + b.insolation > MIN_INSOLATION[b.elapsed]
							){
				b.isVisit = true;
				return false;
			}
			
			b.elapsed = elapsed+1;
			b.currSum = prevSum + b.insolation;
			b.parent = parent;
			
			TEMP_Q.add(b);
			return true;
		}
		return false;
	}
	
}

class Blockss implements Comparable<Blockss>{
	int row = 0;
	int col = 0;
	int insolation = 0;
	boolean isVisit = false;
	int currSum = 0;
	int elapsed = 0;
	Blockss parent = null;
	
	public Blockss(){
		
	}
	
	public Blockss(int row, int col, int insolation, int currSum, int elapsed, Blockss parent){
		this.row = row;
		this.col = col;
		this.insolation = insolation;
		this.currSum = currSum;
		this.elapsed = elapsed;
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{(");
		sb.append(row).append(",").append(col).append("),").append(insolation)
		  .append(",").append("s:").append(currSum).append(",t:").append(elapsed);
		sb.append("}");
		return sb.toString();
	}

	@Override
	public int compareTo(Blockss o) {
		return Integer.compare(currSum, o.currSum);
	}
}