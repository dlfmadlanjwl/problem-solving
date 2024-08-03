class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        dp[x] = 1; 
        for(int i=x+1;i<=y;i++){
            int min = Integer.MAX_VALUE;
            if(i - n >= x && dp[i - n] != 0){
                min = Math.min(dp[i - n] + 1, min);
            }
            if(i % 2 == 0 && dp[i / 2] != 0){
                min = Math.min(dp[i / 2] + 1, min);
            }
            if(i % 3 == 0 && dp[i / 3] != 0){
                min = Math.min(dp[i / 3] + 1, min);
            }
            
            if(min != Integer.MAX_VALUE){
                dp[i] = min;
            }
        }
        
        return dp[y] != 0 ? dp[y]-1 : -1;
    }
}