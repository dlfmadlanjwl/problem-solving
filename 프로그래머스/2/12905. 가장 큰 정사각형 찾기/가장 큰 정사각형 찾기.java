class Solution {
    public int solution(int [][]board) {
        int height = board.length;
        int width = board[0].length;
        int result = 0;
        int[][] dp = new int[height][width];
        
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(i==0 || j==0){
                    dp[i][j] = board[i][j];  
                } else if(board[i][j] == 1){
                    dp[i][j] = 
                        Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1; 
                }else{
                    dp[i][j] = 0;
                }
                if(dp[i][j] > result) result = dp[i][j];
            }
        }
        return result * result;
    }
}