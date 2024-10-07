import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int[][] dp = new int[arr1.length+1][arr2.length+1];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        int y = dp.length-1, x = dp[0].length-1;
        String answer = "";

        while(y != 0 && x != 0){
            if(arr1[y-1] == arr2[x-1]){
                answer = arr1[y-1] + answer;
                y--;
                x--;
            } else if(dp[y-1][x] >= dp[y][x-1]){
                y--;
            } else {
                x--;
            }
        }

        System.out.println(answer.length());
        System.out.print(answer);
    }
}