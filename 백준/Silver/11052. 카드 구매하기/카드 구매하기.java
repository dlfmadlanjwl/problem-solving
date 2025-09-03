import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prices.add(Integer.parseInt(st.nextToken()));
        }

        int[][] dp = new int[n][n + 1];
        for (int currPrice = 1; currPrice <= n; currPrice++) {
            dp[0][currPrice] = prices.get(0) * currPrice;
        }
        for (int cardIndex = 1; cardIndex < n; cardIndex++) {
            int cardCount = cardIndex + 1;
            for (int totalCardCount = 1; totalCardCount <= n; totalCardCount++) {
                if (totalCardCount - cardCount < 0) {
                    dp[cardIndex][totalCardCount] = dp[cardIndex - 1][totalCardCount];
                } else {
                    dp[cardIndex][totalCardCount] = Math.max(dp[cardIndex - 1][totalCardCount],
                            dp[cardIndex][totalCardCount - cardCount] + prices.get(cardIndex));
                }
            }
        }

        System.out.println(dp[n - 1][n]);
    }
}
