class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];

        int[] dp = new int[sticker.length];
        
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);
        for(int i=2;i<sticker.length-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }
        int a = dp[dp.length-2];

        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2;i<sticker.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }
        int b = dp[dp.length-1];
        
        return Math.max(a, b);
    }
}