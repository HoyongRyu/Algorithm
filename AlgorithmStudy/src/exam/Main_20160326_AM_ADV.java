package exam;

import java.util.Scanner;
import java.util.TreeSet;

public class Main_20160326_AM_ADV {

    public static TreeSet<Integer> TREE = new TreeSet<Integer>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i = 1; i <= 1000000000; i++){
            if (Integer.bitCount(i) == 5) {
                TREE.add(i);
            }
        }

        int start, end;
        int min;
        long sum;
        for (int TC = 1; TC <= T; TC++) {
            start = sc.nextInt();
            end = sc.nextInt();
            
            sum = 0;
            min = TREE.higher(start);
            for (int i : TREE.subSet(start, end)){
                sum += i;
            }

            System.out.println("#" + TC + " " + sum + " " + min);
        }
        
        sc.close();
    }
}
