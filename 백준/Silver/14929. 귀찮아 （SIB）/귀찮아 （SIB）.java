import java.io.*;
import java.util.*;


public class Main {
    static int[] sum;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long res = 0L;
        sum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            int input = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+input;
            res += sum[i-1]*input;
        }
        System.out.print(res);
    }
}