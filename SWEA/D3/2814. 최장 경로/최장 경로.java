import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            List<Integer>[] graph = new List[n+1];
            for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
            int m = sc.nextInt();
            for(int i=0;i<m;i++){
            	int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }
            
            int max = 0;
            for(int i=1;i<=n;i++){
            	int result = dfs(graph, new boolean[n+1], i, 1);
                max = Math.max(max, result);
            }
            System.out.println("#"+test_case+" "+max);
		}
	}
    
    static int dfs(List<Integer>[] graph, boolean[] isVisited, int now, int depth){
        isVisited[now] = true;
        int max = depth;
    	for(int i=0;i<graph[now].size();i++){
        	int node = graph[now].get(i);
            if(!isVisited[node]){
            	int result = dfs(graph, isVisited, node, depth+1);
                max = Math.max(max, result);
            }
        }
        isVisited[now] = false;
        return max;
    }
}