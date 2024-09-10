import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new List[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        int[] result = bfs(graph, 1);
        result = bfs(graph, result[1]);

        System.out.print(result[0]);
    }

    static int[] bfs(List<Edge>[] graph, int start){
        int[] distance = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];

        q.add(start);
        isVisited[start] = true;
        distance[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<graph[now].size();i++){
                Edge next = graph[now].get(i);

                if(isVisited[next.dst]) continue;

                q.add(next.dst);
                isVisited[next.dst] = true;
                distance[next.dst] = distance[now] + next.length;
            }
        }

        int max = 0;
        int maxIdx = 0;
        for(int i=0;i<distance.length;i++){
            if(distance[i] > max){
                max = distance[i];
                maxIdx = i;
            }
        }
        return new int[]{max, maxIdx};
    }

    static class Edge{
        int dst;
        int length;

        Edge(int dst, int length){
            this.dst = dst;
            this.length = length;
        }
    }
}