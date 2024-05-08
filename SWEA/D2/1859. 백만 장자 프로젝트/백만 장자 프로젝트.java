import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            long[] arr = new long[N];
            for(int i=0;i<N;i++){
                arr[i] = sc.nextLong();
            }
            long res = 0;

            int idx = 0;
            while(idx<N){
                int max_idx = idx;
                for(int i=idx+1;i<N;i++){
                    if(arr[i] >= arr[max_idx]) {
                        max_idx = i;
                    }
                }
                for(int i=idx;i<=max_idx;i++){
                    res += arr[max_idx] - arr[i];
                }
                idx = max_idx+1;
            }

            System.out.println("#"+test_case+" "+res);
        }
    }
}
