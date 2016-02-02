package leetcode.complete;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray{

	public static void main(String[] args){
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		System.out.println(r.removeDuplicates(new int[]{1,1,2}));
	}

	public int removeDuplicates(int[] A) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		int cnt = 0;
		for (int i=0;i<A.length;i++){
			if (set.contains(A[i])){
				continue;
			}else {
				set.add(A[i]);
				list.add(A[i]);
				A[cnt++] = A[i];
			}
		}
		return list.size();
    }
}
