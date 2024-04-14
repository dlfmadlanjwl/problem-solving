import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] sum = new int[triangle.length][];
        for(int i=0;i<triangle.length;i++){
            sum[i] = new int[triangle[i].length];
        }
        sum[0][0] = triangle[0][0];
        
        for(int i=0;i<triangle.length-1;i++){
            for(int j=0;j<triangle[i].length;j++){
                sum[i+1][j]
                    = Math.max(triangle[i+1][j] + sum[i][j], sum[i+1][j]);
                sum[i+1][j+1]
                    = Math.max(triangle[i+1][j+1] + sum[i][j], sum[i+1][j+1]);
            }
        }
        Arrays.sort(sum[triangle.length-1]);
        return sum[triangle.length-1][sum[triangle.length-1].length-1];
    }
}