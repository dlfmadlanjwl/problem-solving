import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int n = sc.nextInt();
            sb.append("#"+test_case);
            for(int i=0;i<n;i++){
                int command = sc.nextInt();
                if(command == 1){
                    int x = sc.nextInt();
                    pq.add(x);
                } else {
                    if(pq.isEmpty()){
                       sb.append(" "+"-1");
                    } else sb.append(" "+pq.poll());
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}