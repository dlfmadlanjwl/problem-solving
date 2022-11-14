import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N=Integer.parseInt(br.readLine());

        int[] dp=new int[N+2];
        int[] trace=new int[N+2];

        dp[1]=0;
        trace[1]=-1;

        for(int x=2;x<=N;x++){
            dp[x]=dp[x-1]+1;
            trace[x]=x-1;

            if(x%2==0 && dp[x]>dp[x/2]+1){
                dp[x]=dp[x/2]+1;
                trace[x]=x/2;
            }

            if(x%3==0 && dp[x]>dp[x/3]+1){
                dp[x]=dp[x/3]+1;
                trace[x]=x/3;
            }

        }
        int num=dp[N];
        sb.append(String.valueOf(num)+"\n");
        int index=N;
        for(int x=0;x<=num;x++){
            sb.append(index+" ");
            index=trace[index];
        }

        System.out.print(sb);
    }
}