import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static Map<Integer,Integer>[] graph;
    static int[] distance, max;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        graph = new Map[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new HashMap<>();
        }
        distance = new int[N+1];
        max = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            graph[x].put(y,len);
            graph[y].put(x,len);
        }
        bfs(a,b);
        System.out.print(distance[b]-max[b]);
    }
    static void bfs(int start,int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node==end)return;
            for(int i:graph[node].keySet()){
                if(!visited[i]){
                    visited[i] = true;
                    max[i] = Integer.max(max[node], graph[node].get(i));
                    distance[i] = distance[node]+graph[node].get(i);
                    q.add(i);
                }
            }
        }
    }
}