import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            List<Integer>[] graph = new List[101];
            for(int i=0;i<graph.length;i++){
            	graph[i] = new ArrayList<>();
            }
			int len = sc.nextInt();
            int start = sc.nextInt();
            
            for(int i=0;i<len/2;i++){
            	int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a].add(b);
            }
            
            int answer = bfs(graph, start);
            System.out.println("#"+test_case+" "+answer);
		}
	}
    
    static int bfs(List<Integer>[] graph, int start){
    	Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));
        boolean[] isVisited = new boolean[graph.length];
        isVisited[start] = true;
        
        int max = 0;
        int maxDepth = 0;
        while(!q.isEmpty()){
        	Node now = q.poll();
            if(now.depth > maxDepth){
            	maxDepth = now.depth;
                max = 0;
            }
            if(now.value > max){
            	max = now.value;
            }
            for(int i=0;i<graph[now.value].size();i++){
            	int next = graph[now.value].get(i);
                if(isVisited[next]) continue;
                q.add(new Node(next, now.depth+1));
                isVisited[next] = true;
            }
        }
        
        return max;
    }
    
    static class Node{
    	int value;
        int depth;
        
        Node(int value, int depth){
        	this.value = value;
            this.depth = depth;
        }
    }
}