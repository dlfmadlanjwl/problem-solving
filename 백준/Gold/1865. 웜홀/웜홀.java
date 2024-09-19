import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static long MAX_COST = 2500 * 10_000 + 1;
    static int n, m, w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a,b,c));
                edges.add(new Edge(b,a,c));
            }

            for(int i=0;i<w;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a,b,-c));
            }

            long[] distance = new long[n+1];
            for(int i=0;i<=n;i++){
                Arrays.fill(distance, MAX_COST);
            }
            distance[1] = 0;

            if(bf(distance, edges)){
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }

    static boolean bf(long[] distance, List<Edge> edges){
        for(int i=1;i<=n;i++){
            for(Edge e : edges){
                if(distance[e.dest] > distance[e.source] + e.cost){
                    distance[e.dest] = distance[e.source] + e.cost;
                    if(i == n) return true;
                }
            }
        }
        return false;
    }

    static class Edge{
        int source;
        int dest;
        int cost;

        Edge(int source, int dest, int cost){
            this.source = source;
            this.dest = dest;
            this.cost = cost;
        }
    }
}