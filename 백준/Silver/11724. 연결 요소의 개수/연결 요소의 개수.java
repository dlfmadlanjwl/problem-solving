import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        int res = 0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                res++;
                dfs(i);
            }
        }
        System.out.print(res);
    }
    static void dfs(int n){
        visited[n] = true;
        for(int i=0;i<graph[n].size();i++){
            int node = graph[n].get(i);
            if(!visited[node]){
                dfs(node);
            }
        }
    }
}