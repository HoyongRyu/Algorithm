package study.ex;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ToyCompany {

    static int T;
    static int[] DP;
    static int[] TOY;
    static int MIN_WEIGHT;
    static Set<Integer> PART = new HashSet<Integer>();
    
    public static void main(String[] args) {
        
        int weight;
        
        Scanner sc =  new Scanner(System.in);
        T = sc.nextInt();
        
        for(int t = 1 ; t <= T ; t++){
                        
            int toyCount = sc.nextInt();
            int toyNumCount = sc.nextInt();
            
            DP = new int[toyCount+1];
            TOY = new int[toyCount+1];
            MIN_WEIGHT = 0;
            DP[0] = 0;
            
            for(int i = 1 ; i < toyCount+1 ; i++){
                TOY[i] = sc.nextInt();
                MIN_WEIGHT = DP[i-1] + 1; // newBox일 경우 최소값
                
                // START -20 개까지 제곱승 계산 하면서 최소값                 
                for(int j=i-1 ; j > 0 && j > i-20 ; j--){
                    
                    int partSize=0;
                    PART.clear();
                    
                    for(int k=j; k < toyCount+1;k++){
                        
                        // 기존에 들어온 장난감 여부 확인
                        if(TOY[k] != 0){
                            PART.add(TOY[k]);
                        }                   
                        
                        partSize = PART.size();
                        if(partSize==toyNumCount){
                            break;
                        }
                    }
                    
                    weight = (DP[j-1] + partSize * partSize) ;
                    
                    if(weight < MIN_WEIGHT){
                        MIN_WEIGHT = weight;
                    }
                    
                }
                
                DP[i] = MIN_WEIGHT;
                
            }

            System.out.println("#" + t + " " + DP[toyCount]);     
        }
        sc.close();
      }


}
