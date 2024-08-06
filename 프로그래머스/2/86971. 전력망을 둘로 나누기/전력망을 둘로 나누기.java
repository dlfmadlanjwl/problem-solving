import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<wires.length;i++){
            List<Integer>[] graph = new List[n+1];
            for(int j=0;j<=n;j++){
                graph[j] = new ArrayList<>();
            }
            
            for(int j=0;j<wires.length;j++){
                if(i == j) continue;
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            
            boolean[] isVisited = new boolean[n+1];
            int a = dfs(graph, isVisited, wires[i][0]);
            int b = dfs(graph, isVisited, wires[i][1]);
            
            min = Math.min(Math.abs(a - b), min);
        }
        
        return min;
    }
    
    int dfs(List<Integer>[] graph, boolean[] isVisited, int now){
        int count = 1;
        isVisited[now] = true;
        for(int i=0;i<graph[now].size();i++){
            int node = graph[now].get(i);
            if(!isVisited[node]){
                count += dfs(graph, isVisited, node);
            }
        }
        return count;
    }
}