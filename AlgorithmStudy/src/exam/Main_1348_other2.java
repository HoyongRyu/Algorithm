package exam;
import java.util.Scanner;

public class Main_1348_other2 {

    //틀렸던 부분 2
    //int 최대값 : 2147483647
    //long 최대값 : 9223372036854775807

    static int N;
    static int[] TREE;
    static Long RESULT=(long) 1;

    public static void main(String[] args) {

        /**
         * step1. 입력받음
         */
//        System.out.print("Input your value : ");
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        // TREE 배열 설명
        // a. 배열의 각 번지 : 하나의 노드를 의미
        // b. 배열의 번지수 : root노드가 '0'번지, 이렇게 차례대로 하여 말단노드는 'N'번지로 생각   
        // c. 배열의 값 : 해당노드의 자손수 + 1(자기자신)
        TREE = new int[N];

        // 말단 노드부터 root노드까지 돌면서 경우의 수를 계산
        for (int node = N-1; node >= 0; node--) {

            /**
             *  step2. 해당 노드의 왼쪽과 오른쪽 총 자손수를 반환 
             */
            int left = checkLeftDescendant(node);
            int right = checkRightDescendant(node);

            /**
             *  step3. 노드의 값(자손수+자기자신)을 구하고, 경우의 수를 계산해 나감
             */
            // 자식노드가 없다면
            if(left < 0 && right < 0){
                TREE[node]=1;
            }
            // 자식노드가 하나뿐이라면
            else if(left > 0 && right<0){
                TREE[node]=left+1;
            }else if(right > 0 && left<0){
                TREE[node]=right+1;
            }
            // 자식노드가 둘다 있다면
            else if(left > 0 && right>0){
                TREE[node]=left+right+1;
                RESULT*=combination(left, right);

            }
        }

        // 답 출력
        System.out.println(RESULT);

        // 확인용
        /*for (int i = 0; i < N; i++) {
            System.out.println(TREE[i]);
        }*/

    }

    /**
     *  메소드 3개 
     */

    // 1. 왼쪽노드의 전체 자손수를 반환하는 메소드
    public static int checkLeftDescendant(int myNode){

        int result;

        int leftChildNode = myNode*2+1;

        //node가 없다면
        if(leftChildNode>=N){
            result = -1;
        }else{
            result = TREE[leftChildNode];
        }

        return result;

    }

    // 2. 오른쪽노드의 전체 자손수를 반환하는 메소드
    public static int checkRightDescendant(int myNode){

        int result;

        int rightChildNode = myNode*2+2;

        //node가 없다면
        if(rightChildNode>=N){
            result = -1;
        }else{
            result = TREE[rightChildNode];
        }

        return result;

    }

    // 3. combination 값을 계산하는 메소드
    public static int combination(int left, int right){
        int result=1;

        // combination 구현
        int total = left+right;
        for (int i = 0; i < right; i++) {
            result *= total-i;
        }
        for (int i = 1; i <= right; i++) {
            result /= i;
        }

        //틀렸던 부분 1
        //좌우 자식노드의 수가 같다면 반을 나눠준다.
        /*if(left==right){
            result/=2;
            num++;
        }*/

        return result;
    }

}

