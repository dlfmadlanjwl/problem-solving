class Solution {
    int result = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];
        dfs(dungeons, isVisited, k, 0);
        return result;
    }
    
    void dfs(int[][] dungeons, boolean[] isVisited, int k, int cnt){
        result = Math.max(cnt, result);
        for(int i=0;i<dungeons.length;i++){
            if(isVisited[i]) continue;
            if(k >= dungeons[i][0]){
                isVisited[i] = true;
                dfs(dungeons, isVisited, k-dungeons[i][1], cnt+1);
                isVisited[i] = false; 
            }
        }
    }
}