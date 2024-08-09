class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        return dfs(users, emoticons, 0, new int[users.length]);
    }
    
    int[] dfs(int[][] users, int[] emoticons, int depth, int[] sum){
        if(depth == emoticons.length){
            int plusCount=0;
            int payTotal=0;
            for(int i=0;i<users.length;i++){
                if(sum[i] >= users[i][1]) plusCount++;
                else payTotal += sum[i];
            }
            return new int[]{plusCount, payTotal};
        }
        
        int maxPlusCount = Integer.MIN_VALUE;
        int maxPayTotal = Integer.MIN_VALUE;
        
        int[] discountRate = {10, 20, 30, 40};
        for(int i=0;i<discountRate.length;i++){
            for(int j=0;j<users.length;j++){
                if(discountRate[i] >= users[j][0]){
                    sum[j] += (100 - discountRate[i]) * emoticons[depth] / 100; 
                }
            }
            int[] result = dfs(users, emoticons, depth+1, sum);
            for(int j=0;j<users.length;j++){
                if(discountRate[i] >= users[j][0]){
                    sum[j] -= (100 - discountRate[i]) * emoticons[depth] / 100; 
                }
            }
            if(result[0] > maxPlusCount){
                maxPlusCount = result[0];
                maxPayTotal = result[1];
            } else if(result[0] == maxPlusCount && result[1] > maxPayTotal){
                maxPayTotal = result[1];
            }
        }
        return new int[]{maxPlusCount, maxPayTotal};
    }
}