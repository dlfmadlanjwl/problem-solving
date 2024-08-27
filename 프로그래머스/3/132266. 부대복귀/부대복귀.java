import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List[] graph = new List[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
        
        for(int[] road : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int[] distance = new int[n+1];
        for(int i=1;i<=n;i++) distance[i] = -1;
        bfs(graph, distance, destination);
        
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
    
    void bfs(List[] graph, int[] distance, int start){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        boolean[] isVisited = new boolean[graph.length];
        isVisited[start] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            distance[now.index] = now.depth;
            
            List<Integer> edges = graph[now.index];
            for(int i=0;i<edges.size();i++){
                int node = edges.get(i);
                if(!isVisited[node]){
                    isVisited[node] = true;
                    q.add(new Node(node, now.depth+1));
                }
            }
        }
    }
    
    class Node{
        int index;
        int depth;
        
        Node(int index, int depth){
            this.index = index;
            this.depth = depth;
        }
    }
}