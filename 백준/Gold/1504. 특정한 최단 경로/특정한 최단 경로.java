import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int MAX_DISTANCE = 200_000 * 1000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Edge>[] graph = new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int sum1 = 0;
        int sum2 = 0;

        int[] distance;
        int[] course1 = {1, v1, v2, n};
        int[] course2 = {1, v2, v1, n};

        for(int i=0;i<3;i++) {
            distance = dijkstra(graph, course1[i]);
            sum1 += distance[course1[i + 1]];

            distance = dijkstra(graph, course2[i]);
            sum2 += distance[course2[i + 1]];
        }

        int answer = Math.min(sum1, sum2);
        if(answer >= MAX_DISTANCE) System.out.print(-1);
        else System.out.print(answer);
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

        boolean[] isVisited = new boolean[graph.length];
        isVisited[start] = true;
        pq.add(start);

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