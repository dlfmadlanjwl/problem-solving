import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Edge>[] graph;
    static int res;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b,x));
            graph[b].add(new Edge(a,x));
        }
        for(int i=0;i<M;i++){
            visited = new boolean[N+1];
            res = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dfs(a,b,0);
            System.out.println(res);
        }
    }
    static void dfs(int n, int target, int len){
        if(n==target){
            res = len;
        }
        visited[n] = true;
        for(int i=0;i<graph[n].size();i++){
            Edge e = graph[n].get(i);
            if(!visited[e.target]){
                dfs(e.target,target,len+e.length);
            }
        }
    }
}
class Edge{
    int target;
    int length;
    Edge(int target, int length){
        this.target = target;
        this.length = length;
    }
}