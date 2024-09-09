import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];
        maxDp[0] = new int[]{arr[0][0], arr[0][1], arr[0][2]};
        minDp[0] = new int[]{arr[0][0], arr[0][1], arr[0][2]};

        for(int i=1;i<n;i++){
            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + arr[i][0];
            maxDp[i][1] = Math.max(maxDp[i-1][0], Math.max(maxDp[i-1][1], maxDp[i-1][2])) + arr[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + arr[i][2];

            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + arr[i][0];
            minDp[i][1] = Math.min(minDp[i-1][0], Math.min(minDp[i-1][1], minDp[i-1][2])) + arr[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + arr[i][2];
        }

        int max = Math.max(maxDp[n-1][0], Math.max(maxDp[n-1][1], maxDp[n-1][2]));
        int min = Math.min(minDp[n-1][0], Math.min(minDp[n-1][1], minDp[n-1][2]));

        System.out.print(max+" "+min);
    }
}