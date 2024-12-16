import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();

        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, d, l));
        }

        int answer = kruskal(edges, v);
        System.out.print(answer);
    }

    static int kruskal(List<Edge> edges, int v){
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.length - o2.length;
            }
        });

        int[] parents = new int[v+1];
        for(int i=0;i<=v;i++) parents[i] = i;

        int count = 0;
        int len = 0;
        for(int i=0;i<edges.size();i++){
            Edge edge = edges.get(i);
            int root1 = findRoot(parents, edge.source);
            int root2 = findRoot(parents, edge.dest);
            if(root1 != root2){
                if(root1 < root2){
                    parents[root2] = root1;
                } else {
                    parents[root1] = root2;
                }
                count++;
                len += edge.length;
            }
            if(count == v - 1) break;
        }

        return len;
    }

    static int findRoot(int[] parents, int node){
        if(parents[node] == node) return node;
        return parents[node] = findRoot(parents, parents[node]);
    }

    static class Edge{
        int source;
        int dest;
        int length;

        Edge(int source, int dest, int length){
            this.source = source;
            this.dest = dest;
            this.length = length;
        }
    }
}