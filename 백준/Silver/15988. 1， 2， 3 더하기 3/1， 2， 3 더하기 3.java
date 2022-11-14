import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static long[] d;
    public static long MOD = 1000000009;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        d = new long[1000001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for(int t= 0 ; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            for(int n =4; n<=N; n++){
                if(d[n]==0){
                    d[n] = d[n-1] + d[n-2] + d[n-3];
                    d[n]  %= MOD;
                }
            }
            bw.write(String.valueOf(d[N])+"\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}