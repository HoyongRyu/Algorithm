package study.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/*
3
4
1 1 2 2 2 4 3 4 1 7 2 1
4
7 2 1 3 4 1 2 2 4 1 1 2
3
4 3 7 1 2 6 6 4 3

출력
#1 2 3 1 4 1
1 2 15
#2 1 1 1
1 3 15
#3 1 3 9
1 2 33
*/

public class Painting {
    
    static int T;
    static int J;
    static int[] RESULT = new int[101];
    static SortedSet<Integer> xset = new TreeSet<>();
    static SortedSet<Integer> yset = new TreeSet<>();
    static List<Block> blist = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        
        int inputX, inputY, inputLength;
        for (int t=1; t<=T; t++) {
            xset.clear();
            yset.clear();
            blist.clear();
            //블럭 수
            J = sc.nextInt();
            //클리어
            for (int i=1; i<=J; i++) {
                RESULT[i] = 0;
            }
            //입력 받기
            for (int j=1; j<=J; j++) {
                inputX = sc.nextInt();
                inputY = sc.nextInt();
                inputLength = sc.nextInt();
                xset.add(inputX); 
                xset.add(inputX+inputLength);
                yset.add(inputY); 
                yset.add(inputY+inputLength);
                blist.add(new Block(inputX, inputY, inputLength, j));
            }
            //Plane Sweeping
            Block b = null;
            Integer[] xarr = new Integer[xset.size()];
            xset.toArray(xarr);
            Integer[] yarr = new Integer[yset.size()];
            yset.toArray(yarr);
            for (int i=0;i<xarr.length-1;i++) {
                for (int j=0;j<yarr.length-1;j++) {
                    for (int bi = blist.size() -1 ; bi >= 0 ; bi-- ) {
                        b = blist.get(bi);
                        if (xarr[i] >= b.minX && yarr[j] >= b.minY
                                && xarr[i] <= b.maxX && yarr[j] <= b.maxY) {
                            RESULT[b.color] = RESULT[b.color] + (xarr[i+1]-xarr[i]) * (yarr[j+1] - yarr[j]);
                            break;
                        }
                    }
                }
            }
            //결과 찍기
            result(t);
        }
        
        sc.close();
    }
    
    private static void result(int t) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        List<Integer> minColor = new ArrayList<>();
        List<Integer> maxColor = new ArrayList<>();
        int i,j,count;
        for (i=1; i<=J ;i++) {
            count = RESULT[i];
            if (count > 0) {
                if (minValue > count) {
                    minColor.clear();
                    minValue = count;
                    minColor.add(i);
                }else if (minValue == count) {
                    minColor.add(i);
                }
                if (maxValue < count) {
                    maxColor.clear();
                    maxValue = count;
                    maxColor.add(i);
                }else if (maxValue == count) {
                    maxColor.add(i);
                }
            }
        }
        
        System.out.print("#"+ t + " ");
        System.out.print(minColor.size());
        for (i=0;i<minColor.size();i++) {
            System.out.print(" " + minColor.get(i) + " "+ minValue);
        }
        System.out.println();
        System.out.print(maxColor.size());
        for (i=0;i<maxColor.size();i++) {
            System.out.print(" " + maxColor.get(i) + " " + maxValue);
        }
        System.out.println();
    }
}

class Block {
    public Block (int x, int y, int length, int color) {
        this.minX = x;
        this.minY = y;
        this.color = color;
        this.maxX = x + length - 1;
        this.maxY = y + length - 1;
    }
    
    int minX;
    int minY;
    int maxX;
    int maxY;
    int color;
}
