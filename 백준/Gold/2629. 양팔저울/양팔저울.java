import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weights = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] beads = new int[m];
        int max = 0;
        for(int i=0;i<m;i++){
            beads[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, beads[i]);
        }

        boolean[][] dp = new boolean[n+1][Math.max(max, sum)+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            int weight = weights[i-1];
            for(int bead=0;bead<dp[0].length;bead++){
                if(dp[i-1][bead]) {
                    dp[i][bead] = true;
                    dp[i][bead + weight] = true;
                    dp[i][Math.abs(bead - weight)] = true;
                }
            }
        }

        for(int i=0;i<m;i++){
            if(dp[dp.length-1][beads[i]]){
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}