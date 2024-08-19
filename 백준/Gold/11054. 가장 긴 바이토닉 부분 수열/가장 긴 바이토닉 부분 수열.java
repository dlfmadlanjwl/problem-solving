import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = sc.nextInt();
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        lis(dp1, input);
        lds(dp2, input);

        int max = 0;
        for(int i=0;i< dp1.length;i++){
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        System.out.println(max);
    }

    static void lis(int[] dp, int[] input){
        dp[0] = 1;
        for(int i=1;i<input.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(input[i] > input[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }

    static void lds(int[] dp, int[] input){
        dp[dp.length-1] = 1;
        for(int i=dp.length-2;i>=0;i--){
            dp[i] = 1;
            for(int j=i+1;j<dp.length;j++){
                if(input[i] > input[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }
}