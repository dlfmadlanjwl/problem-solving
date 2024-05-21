import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#"+(t+1));
            for(int i=0;i<N;i++){
                for(int j=N-1;j>=0;j--){
                    System.out.print(arr[j][i]);
                }
                System.out.print(" ");
                for(int j=N-1;j>=0;j--){
                    System.out.print(arr[N-i-1][j]);
                }
                System.out.print(" ");
                for(int j=0;j<N;j++){
                    System.out.print(arr[j][N-i-1]);
                }
                System.out.println();
            }
        }
    }
}