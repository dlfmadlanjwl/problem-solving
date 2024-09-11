import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static final int MAX_DISTANCE = 10_000 * 100 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Edge>[] graph1 = new List[n+1];
        List<Edge>[] graph2 = new List[n+1];
        for(int i=0;i<=n;i++){
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph1[a].add(new Edge(b, length));
            graph2[b].add(new Edge(a, length));
        }

        int[] distance1 = dijkstra(graph1, x);
        int[] distance2 = dijkstra(graph2, x);

        int max = 0;
        for(int i=1;i<=n;i++){
            max = Math.max(max, distance1[i] + distance2[i]);
        }

        System.out.print(max);
    }

    static class Edge{
        int dst;
        int length;

        Edge(int dst, int length){
            this.dst = dst;
            this.length = length;
        }
    }

    static int[] dijkstra(List<Edge>[] graph, int start){
        int[] distance = new int[graph.length];
        Arrays.fill(distance, MAX_DISTANCE);
        distance[start] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return distance[o1] - distance[o2];
            }
        });
        pq.add(start);

        boolean[] isVisited = new boolean[graph.length];

        while(!pq.isEmpty()){
            int now = pq.poll();
            isVisited[now] = true;

            for(int i=0;i<graph[now].size();i++){
                Edge next = graph[now].get(i);

                if(isVisited[next.dst]) continue;

                if(distance[next.dst] > distance[now] + next.length){
                    distance[next.dst] = distance[now] + next.length;
                    pq.add(next.dst);
                }
            }
        }

        return distance;
    }
}