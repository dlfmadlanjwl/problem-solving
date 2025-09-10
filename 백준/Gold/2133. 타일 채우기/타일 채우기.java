import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 2; i < dp.length; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
