import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];
        dp[0] = 1;

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        for(int i=1;i<n;i++){
            int nowA = line[i][0];
            int nowB = line[i][1];
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(line[j][0] < nowA && line[j][1] < nowB){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        System.out.print(n - Arrays.stream(dp).max().getAsInt());
    }
}