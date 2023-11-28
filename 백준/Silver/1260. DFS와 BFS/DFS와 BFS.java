import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(graph[i]);
        }
        
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);
        System.out.print(sb);
    }
    static void dfs(int n){
        sb.append(n+" ");
        visited[n] = true;
        for(int i=0;i<graph[n].size();i++){
            int node = graph[n].get(i);
            if(!visited[node]){
                dfs(node);
            }
        }
    }

    static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        visited[n] = true;
        queue.add(n);
        while(queue.size()!=0){
            int x = queue.poll();
            sb.append(x+" ");
            for(int i=0;i<graph[x].size();i++){
                int node = graph[x].get(i);
                if(!visited[node]){
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }
}
