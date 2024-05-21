import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for(int offset=0;offset<=Math.abs(N - M);offset++){
                int sum = 0;
                for(int i=0;i<Math.min(N, M);i++){
                    if(N > M){
                        sum += arr1[i+offset] * arr2[i];
                    }else{
                        sum += arr1[i] * arr2[i+offset];
                    }
                }
                if(sum > result) result = sum;
            }
            System.out.println("#"+(t+1)+" "+result);
        }
    }
}