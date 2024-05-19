import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = 0;

            for(int i=0;i<N;i++){
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if(arr[i][j] == 1) count++;
                    else {
                        if(count == K) {
                            res++;
                        }
                        count = 0;
                    }
                }
                if(count == K){
                    res++;
                }
            }

            for(int i=0;i<N;i++){
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if(arr[j][i] == 1) count++;
                    else {
                        if(count == K) {
                            res++;
                        }
                        count = 0;
                    }
                }
                if(count == K){
                    res++;
                }
            }

            System.out.println("#"+(t+1)+" "+res);
        }
    }
}