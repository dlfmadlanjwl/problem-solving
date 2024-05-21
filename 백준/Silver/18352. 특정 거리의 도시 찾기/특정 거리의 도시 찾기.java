import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        List<Integer> result = bfs(graph, X, K);
        if(result.isEmpty()) System.out.print(-1);
        else{
            Collections.sort(result);
            result.forEach(System.out::println);
        }
    }
    private static class Node{
        int number;
        int depth;
        Node(int number, int depth){
            this.number = number;
            this.depth = depth;
        }
    }
    private static List<Integer> bfs(List<Integer>[] graph, int X, int K){
        List<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        q.add(new Node(X, 0));
        visited[X] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.depth == K) result.add(now.number);
            for(int n : graph[now.number]){
                if(!visited[n]){
                    q.add(new Node(n, now.depth+1));
                    visited[n] = true;
                }
            }
        }
        return result;
    }
}
