import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static long MAX_COST = 10_000 * 6000 + 1;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long[] distance = new long[n+1];
        Arrays.fill(distance, MAX_COST);
        distance[1] = 0;

        Edge[] edges = new Edge[m];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a,b,c);
        }

        if(bf(distance, edges)){
            System.out.print(-1);
            return;
        }

        for(int i=2;i<=n;i++){
            if(distance[i] == MAX_COST) System.out.println(-1);
            else System.out.println(distance[i]);
        }
    }

    static boolean bf(long[] distance, Edge[] edges){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Edge e = edges[j];
                if(distance[e.source] != MAX_COST && distance[e.dest] > distance[e.source] + e.cost) {
                    distance[e.dest] = distance[e.source] + e.cost;
                    if(i == n-1) return true;
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