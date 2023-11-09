import java.io.*;
import java.util.*;


public class Main {
    static int[][] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for(int n=1;n<=N;n++){
            st = new StringTokenizer(br.readLine());
            for(int m=1;m<=M;m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(sum(j,i,y,x)+"\n");
        }
        System.out.print(sb);
    }
    static int sum(int startX,int startY,int endX,int endY){
        int res = 0;
        for(int i=startY;i<=endY;i++){
            for(int j=startX;j<=endX;j++){
                res += arr[i][j];
            }
        }
        return res;
    }
}