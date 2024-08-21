import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int seq = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=0;i<=n;i++){
            Collections.sort(graph[i]);
        }

        boolean[] isVisited = new boolean[n+1];
        int[] sequences = new int[n+1];
        dfs(graph, isVisited, sequences, r);

        for(int i=1;i<sequences.length;i++){
            System.out.println(sequences[i]);
        }
    }

    static void dfs(List<Integer>[] graph, boolean[] isVisited, int[] sequences, int node){
        sequences[node] = seq++;
        isVisited[node] = true;
        for(int i=0;i<graph[node].size();i++){
            if(!isVisited[graph[node].get(i)]){
                dfs(graph, isVisited, sequences, graph[node].get(i));
            }
        }
    }
}