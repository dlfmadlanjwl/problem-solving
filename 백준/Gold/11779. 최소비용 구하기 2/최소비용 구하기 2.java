import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int MAX_LENGTH = 1000 * 100_000 + 1;
    static int[] before;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new List[n+1];
        before = new int[graph.length];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, l));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int answer = dijkstra(graph, start, end);
        String path = String.valueOf(end);
        int tmp = end;
        while(true){
            path = before[tmp] + " " + path;
            if(before[tmp] == start) {
                break;
            }
            tmp = before[tmp];
        }
        System.out.println(answer);
        System.out.println(path.split(" ").length);
        System.out.println(path);
    }

    static int dijkstra(List<Edge>[] list, int start, int end){
        boolean[] isVisited = new boolean[list.length];
        int[] distance = new int[list.length];
        Arrays.fill(distance, MAX_LENGTH);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return distance[o1] - distance[o2];
            }
        });
        pq.add(start);
        distance[start] = 0;
        while(!pq.isEmpty()){
            int now = pq.poll();
            if(now == end) break;
            if(isVisited[now]) continue;
            isVisited[now] = true;

            for(int i=0;i<list[now].size();i++){
                Edge next = list[now].get(i);
                if(isVisited[next.dest]) continue;

                if(distance[next.dest] > distance[now] + next.length) {
                    distance[next.dest] = distance[now] + next.length;
                    before[next.dest] = now;
                    pq.add(next.dest);
                }
            }
        }

        return distance[end];
    }

    static class Edge{
        int dest;
        int length;

        Edge(int dest, int length){
            this.dest = dest;
            this.length = length;
        }
    }
}