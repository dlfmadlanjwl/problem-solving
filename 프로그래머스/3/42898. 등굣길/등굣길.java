class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] sum = new int[n+1][m+1];
        boolean[][] water = new boolean[n+1][m+1];
        for(int[] puddle: puddles){
            water[puddle[1]][puddle[0]] = true;
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1) {
                    sum[j][i] = 1;
                    continue;
                }
                if(water[j][i]) continue;
                sum[j][i] = (sum[j-1][i] + sum[j][i-1])%1000000007;
            }
        }
        
        return sum[n][m];
    }
}