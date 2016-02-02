package exam;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main_Prof_151107 {

    /** Test Case 수 */
    static int T;
    /** 점의 수 */
    static int N;
    /** 점의 좌표들 */
    static Dot[] DOTS;
    /** 기울기 목록 */
    static List<Dot> GRADIANTS;
    /** 기울기별 카운트 */
    static Map<Dot, Integer> GRADIANT_COUNT;
    /** 점 개수별 결과 */
    static int[] RESULT;
    
    public static void main(String[] args) throws Exception {
//      Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream(new File("d:/download/a.txt")));
        
        T = sc.nextInt();
        
        for (int index=1; index<=T; index++){
            N = sc.nextInt();
            DOTS = new Dot[N+1];
            RESULT = new int[N];
            
            for (int i=1;i<=N;i++){
                DOTS[i] = new Dot(sc.nextInt(),sc.nextInt());
            }
            
            
            
            
            
            
            System.out.print(T);
            for (int i=1;i<=N-1;i++){
                // 결과 찍기
                System.out.print(" " + 1);
            }
        }
        
    }

}

class Dot {
    int x;
    int y;
    
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}