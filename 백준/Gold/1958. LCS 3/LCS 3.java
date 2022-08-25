import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();

		int len = LCS(A, B, C);

		System.out.print(len + "\n");
	}

	static int LCS(String A, String B, String C) {

		int[][][] dp = new int[A.length() + 1][B.length() + 1][C.length() + 1];

		for (int i = 1; i <= A.length(); i++) {
			char ch1 = A.charAt(i - 1);

			for (int j = 1; j <= B.length(); j++) {
				char ch2 = B.charAt(j - 1);

				for (int k = 1; k <= C.length(); k++) {
					char ch3 = C.charAt(k - 1);

					if (ch1 == ch2 && ch2 == ch3)
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;

					else
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));

				}
			}
		}
		return dp[A.length()][B.length()][C.length()];
	}
}