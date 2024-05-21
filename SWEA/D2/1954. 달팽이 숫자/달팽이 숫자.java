import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int count = 1;
            for(int left = 0; left<N/2;left++){
                int right = N - 1 - left;
                for(int i=left;i<=right;i++){
                    arr[left][i] = count++;
                }
                for(int i=left+1;i<=right;i++){
                    arr[i][right] = count++;
                }
                for(int i=right-1;i>=left;i--){
                    arr[right][i] = count++;
                }
                for(int i=right-1;i>left;i--){
                    arr[i][left] = count++;
                }
            }
            if(N%2 == 1) arr[N/2][N/2] = count;

            System.out.println("#"+(t+1));
            for(int i=0;i<N;i++){
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}