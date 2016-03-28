package study.ex;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EX_3_1 {

    static int T;
    static int N;
    static Position[][] MAP;
    static int RESULT;
    
    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("d:/downloads/Study/16_02_알고리즘/강의자료/3일차/3_1_말이동시키기/sample_input.txt"));
//        Scanner sc = new Scanner(new File("d:/downloads/Study/16_02_알고리즘/강의자료/3일차/3_1_말이동시키기/sample_input2.txt"));
        
        T = sc.nextInt();
        
        for (int t=1;t<=T;t++){
            //입력부
            N = sc.nextInt();
            MAP = new Position[N+1][N+1];
            for (int nX=1;nX<=N;nX++){
                for (int nY=1;nY<=N;nY++){
                    MAP[nX][nY] = new Position(nX, nY, sc.nextInt(), 0);
                }
            }

            //문제 풀기 시작
            RESULT = Integer.MAX_VALUE;
            Queue<Position> q = new LinkedList<Position>();
            q.offer(MAP[1][1]);
            Position p = null;
            while (!q.isEmpty()){
                p = q.poll();
                
//                System.out.println("("+idxX+","+idxY+") = " + p.enalbleMove + ", move : " + p.moveCount);
                
                if (p.x == N && p.y == N){
                    if (RESULT > p.moveCount){
                        RESULT = p.moveCount;
                    }
                }
                
                if (p.enalbleMove == 0){
                    continue;
                }
                
                for (int move=p.enalbleMove;move>=1;move--){
                    if (p.x + move <= N
                            && (MAP[p.x+move][p.y].moveCount > p.moveCount+1
                            || !MAP[p.x+move][p.y].isVisit)){
                        MAP[p.x+move][p.y].moveCount = p.moveCount+1;
                        MAP[p.x+move][p.y].isVisit = true;
                        q.offer(MAP[p.x+move][p.y]);
                    }
                    if (p.y + move <= N
                            && (MAP[p.x][p.y+move].moveCount > p.moveCount+1
                                    || !MAP[p.x][p.y+move].isVisit)){
                        MAP[p.x][p.y+move].moveCount = p.moveCount+1;
                        MAP[p.x][p.y+move].isVisit = true;
                        q.offer(MAP[p.x][p.y+move]);
                    }
                }
            }
            
            //출력부
            System.out.println("#"+t+" "+RESULT);
        }
        
        sc.close();
    }
    
}

class Position {
    int x;
    int y;
    int enalbleMove;
    int moveCount;
    boolean isVisit;
    
    public Position (int x, int y, int enableMove, int moveCount){
        this.x = x;
        this.y = y;
        this.enalbleMove = enableMove;
        this.moveCount = moveCount;
    }

}
