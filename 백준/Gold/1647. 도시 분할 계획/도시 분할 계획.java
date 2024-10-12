import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            edges.add(new Edge(source, dest, length));
        }

        List<Integer> course = kruskal(edges, n);
        int max = 0, sum = 0;
        for(int length : course) {
            max = Math.max(max, length);
            sum += length;
        }
        System.out.print(sum - max);
    }

    static List<Integer> kruskal(List<Edge> edges, int n){
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.length - o2.length;
            }
        });
        int[] parents = new int[n+1];
        for(int i=0;i<parents.length;i++) parents[i] = i;

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<edges.size();i++){
            Edge edge = edges.get(i);
            int parent1 = find(parents, edge.source);
            int parent2 = find(parents, edge.dest);
            if(parent1 == parent2) continue;
            if(parent1 < parent2){
                parents[parent2] = parent1;
            } else {
                parents[parent1] = parent2;
            }
            list.add(edge.length);
            if(list.size() == n - 1) break;
        }
        return list;
    }

    static int find(int[] parents, int child){
        if(parents[child] == child) return child;
        return find(parents, parents[child]);
    }

    static class Edge{
        int source;
        int dest;
        int length;

        public Edge(int source, int dest, int length) {
            this.source = source;
            this.dest = dest;
            this.length = length;
        }
    }
}