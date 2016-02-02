package exam;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main_1348_other1 {
	
	private static int size;
    static ArrayList<Integer> picked= new ArrayList<Integer>();
    static HashSet<String> HS=new HashSet<String>();
    static PriorityQueue<Integer> pq = null;
    static boolean[] isPick;
    static int N=0;

    public Main_1348_other1(int size)
    {
        this.size = size;
        isPick= new boolean[this.size+1];
    }

    static void permutation( ArrayList<Integer> picked, boolean isPick[], int pos ){

        if( picked.size() == pos ){

            for(int i=0; i<picked.size(); i++){
                pq.add(picked.get(i));
            }

            HS.add(pq.toString());
            pq.clear();

            return ;
        }

        for(int next = 1; next <= pos; next++){
            if( isPick[next] )
                continue;

            picked.add(next);
            isPick[next] = true;

            permutation( picked, isPick, pos );

            picked.remove(picked.size()-1);
            isPick[next] = false;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.out.println("The Max Heap is ");

        //Scanner scan = new Scanner(System.in);
        //N = scan.nextInt();

        N=5;

        Main_1348_other1 maxHeap = new Main_1348_other1(N);
        pq = new PriorityQueue<Integer>(10,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2-o1;
            }
        });

        permutation(maxHeap.picked, maxHeap.isPick, N);
        System.out.println(HS.size());

    }

}

