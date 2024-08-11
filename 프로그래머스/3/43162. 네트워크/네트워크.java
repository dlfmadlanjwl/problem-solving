import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List[] graph = new List[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[0].length;j++){
                if(computers[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        int count = 0;
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                dfs(graph, isVisited, i);
                count++;
            }
        }
        
        return count;
    }
    
    void dfs(List[] graph, boolean[] isVisited, int now){
        for(int i=0;i<graph[now].size();i++){
            if(!isVisited[(int)graph[now].get(i)]){
                isVisited[(int)graph[now].get(i)] = true;
                dfs(graph, isVisited, (int)graph[now].get(i));
            }
        }
    }
}