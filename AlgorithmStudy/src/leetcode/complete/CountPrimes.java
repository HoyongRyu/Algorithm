package leetcode.complete;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes c = new CountPrimes();
		System.out.println(c.countPrimes(3));
		System.out.println(c.countPrimes(2));
		System.out.println(c.countPrimes(4));
		System.out.println(c.countPrimes(5));
		System.out.println(c.countPrimes(6));
//		System.out.println(c.countPrimes(0));
//		System.out.println(c.countPrimes(12));
		System.out.println(c.countPrimes(8));
		System.out.println(c.countPrimes(499979));
	}

	
	public int countPrimes(int n) {
        int count = 1;
        boolean primeFlag = false;
        
        if (n==0){
        	return 0;
        }else if (n==1){
        	return 0;
        }else if (n==2){
        	return 0;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        
        int max = (int) Math.sqrt(n);
        
        for (int i=3;i<n;i=i+2){
        	primeFlag = true;
//        	System.out.println("--- 현재 i : " + i);
        	for (int prime : list){
        		if (prime > max){
        			break;
        		}
//        		System.out.println("------ / prime : " + prime);
        		if (i%prime == 0) {
        			primeFlag = false;
        			break;
        		}
        	}
        	if (primeFlag){
        		list.add(i);
        		count++;
        	}
        }
        
        return count;
    }
}
