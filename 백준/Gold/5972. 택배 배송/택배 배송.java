import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge>[] graph = new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        int answer = dijkstra(graph);

        System.out.print(answer);
    }

    static int dijkstra(List<Edge>[] graph){
        int[] distances = new int[graph.length+1];
        Arrays.fill(distances, 50000 * 1000 + 1);
        distances[1] = 0;
        boolean[] isVisited = new boolean[graph.length+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return distances[o1] - distances[o2];
            }
        });
        pq.add(1);
        isVisited[1] = true;

        while(!pq.isEmpty()){
            int now = pq.poll();
            isVisited[now] = true;
            for(Edge e : graph[now]){
                if(isVisited[e.dst]) continue;

                if(distances[e.dst] > distances[now] + e.length){
                    distances[e.dst] = distances[now] + e.length;
                    pq.add(e.dst);
                }
            }
        }

        return distances[graph.length-1];
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