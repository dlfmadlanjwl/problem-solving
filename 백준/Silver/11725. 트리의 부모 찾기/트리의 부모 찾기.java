import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] res;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        res = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        bfs();
        for(int i=2;i<=N;i++){
            System.out.println(res[i]);
        }
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i=0;i<graph[a].size();i++){
                int x = graph[a].get(i);
                if(!visited[x]){
                    queue.add(x);
                    visited[x] = true;
                    res[x] = a;
                }
            }
        }
    }
}