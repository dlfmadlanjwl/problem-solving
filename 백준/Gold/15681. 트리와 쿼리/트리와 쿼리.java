import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Node root = new Node(r);
        createTree(graph, root);

        int[] counts = new int[n+1];
        dfs(root, counts);

        for(int i=0;i<q;i++){
            int u = Integer.parseInt(br.readLine());
            System.out.println(counts[u]);
        }
    }

    static void createTree(List<Integer>[] graph, Node root){
        Queue<Node> q = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];
        q.add(root);
        isVisited[root.number] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<graph[now.number].size();i++){
                int next = graph[now.number].get(i);
                if(isVisited[next]) continue;

                isVisited[next] = true;
                Node child = new Node(next);
                now.child.add(child);
                q.add(child);
            }
        }
    }

    static int dfs(Node root, int[] counts){
        int count = 1;
        for(int i=0;i<root.child.size();i++){
            Node child = root.child.get(i);

            count += dfs(child, counts);
        }

        counts[root.number] = count;
        return count;
    }

    static class Node{
        int number;
        List<Node> child = new ArrayList<>();

        Node(int number){
            this.number = number;
        }
    }
}