import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static boolean answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new List[v];
            for(int j=0;j<graph.length;j++){
                graph[j] = new ArrayList<>();
            }
            for(int j=0;j<e;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[a].add(b);
                graph[b].add(a);
            }

            answer = true;
            int[] color = new int[v];
            boolean[] isVisited = new boolean[v];
            for(int j=0;j<v;j++){
                if(!isVisited[j]){
                    color[j] = 1;
                    dfs(graph, j, isVisited, color);
                }
            }
            if(answer){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void dfs(List<Integer>[] graph, int now, boolean[] isVisited, int[] color){
        for(int i=0;i<graph[now].size();i++){
            int next = graph[now].get(i);
            if(color[next] == color[now]){
                answer = false;
                return;
            }
            if(isVisited[next]) continue;
            isVisited[next] = true;
            color[next] = -color[now];
            dfs(graph, next, isVisited, color);
        }
    }
}