import java.io.*;
import java.util.*;


public class Main {
    static int[][] sum;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sum = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int input = Integer.parseInt(st.nextToken());
                if(j==1){
                    sum[i][j] = input;
                } else{
                    sum[i][j] = sum[i][j-1]+input;
                }
            }
        }

        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int res = 0;
            for(int i=x1;i<=x2;i++){
                res += calc(y1,y2,i);
            }
            sb.append(res+"\n");
        }
        System.out.print(sb);
    }
    static int calc(int y1,int y2,int x){
        return sum[x][y2]-sum[x][y1-1];
    }
}