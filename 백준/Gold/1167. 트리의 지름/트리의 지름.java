import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Edge>[] graph;
    static int res, maxNode, V, count;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int v=1;v<=V;v++){
            graph[v] = new ArrayList<>();
        }
        for(int v=1;v<=V;v++){
            st = new StringTokenizer(br.readLine());
            int n = (st.countTokens()-2)/2;
            int a = Integer.parseInt(st.nextToken());
            for(int i=0;i<n;i++){
                int b = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());
                graph[a].add(new Edge(b,len));
            }
        }
        count = 0;
        visited = new boolean[V+1];
        dfs(1,0);
        res = 0;
        count = 0;
        visited = new boolean[V+1];
        dfs(maxNode,0);
        System.out.print(res);
    }
    static void dfs(int start, int len){
        count++;
        if(len>res){
            res = len;
            maxNode = start;
        }
        if(count==V)return;
        visited[start] = true;
        for(int i=0;i<graph[start].size();i++){
            Edge edge = graph[start].get(i);
            if(!visited[edge.node]){
                dfs(edge.node, len+edge.length);
            }
        }
    }
}
class Edge{
    int node;
    int length;
    Edge(int node,int length){
        this.node = node;
        this.length = length;
    }
}