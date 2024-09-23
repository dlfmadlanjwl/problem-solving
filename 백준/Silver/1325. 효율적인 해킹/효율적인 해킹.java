import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        int max = 0;
        int[] counts = new int[n+1];
        boolean[] isVisited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(isVisited, false);

            counts[i] = dfs(i, 1, isVisited);
            max = Math.max(max, counts[i]);
        }

        for(int i=1;i<=n;i++) if(counts[i] == max) System.out.print(i+" ");
    }

    static int dfs(int node, int depth, boolean[] isVisited){
        isVisited[node] = true;
        int count = 1;
        for(int next : graph[node]){
            if(isVisited[next]) continue;

            count += dfs(next, depth+1, isVisited);
        }

        return count;
    }
}