import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];
        sum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            int input = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+input;
        }
        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sum[j]-sum[i-1]+"\n");
        }
        System.out.print(sb);
    }
}