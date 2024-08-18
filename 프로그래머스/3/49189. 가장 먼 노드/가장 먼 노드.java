import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            if(!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<>());
            if(!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int[] distance = new int[map.size()+1];
        bfs(map, distance);
        
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        int answer = 0;
        for(int i=distance.length-1;i>=0;i--){
            if(max == distance[i]) answer++;
            else break;
        }
        
        return answer;
    }
    
    void bfs(Map<Integer,List<Integer>> map, int[] distance){
        Queue<Node> q = new LinkedList<>();
        boolean[] isVisited = new boolean[map.size()+1];
        q.add(new Node(1, 0));
        isVisited[1] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            distance[now.num] = now.depth;
            for(int i=0;i<map.get(now.num).size();i++){
                int node = map.get(now.num).get(i);
                if(!isVisited[node]){
                    q.add(new Node(node, now.depth+1));
                    isVisited[node] = true;
                }
            }
        }
    }
    class Node{
        int num;
        int depth;
        Node(int num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }
}