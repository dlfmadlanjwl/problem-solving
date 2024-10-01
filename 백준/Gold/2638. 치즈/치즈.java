import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while(true){
            boolean[][] isAir = bfs(graph);
            int cnt = melt(graph, isAir);
            if(cnt == 0) break;
            time++;
        }

        System.out.print(time);
    }

    static boolean[][] bfs(int[][] graph){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        boolean[][] isAir = new boolean[graph.length][graph[0].length];
        isAir[0][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];

                if(newY < 0 || newY >= graph.length || newX < 0 || newX >= graph[0].length) continue;
                if(isAir[newY][newX] || graph[newY][newX] != 0) continue;

                q.add(new Node(newY, newX));
                isAir[newY][newX] = true;
            }
        }

        return isAir;
    }

    static int melt(int[][] graph, boolean[][] isAir){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int meltCnt = 0;
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(graph[i][j] != 1) continue;
                int count = 0;
                for(int k=0;k<4;k++){
                    int newY = i + dy[k];
                    int newX = j + dx[k];

                    if(newY < 0 || newY >= graph.length || newX < 0 || newX >= graph[0].length) continue;
                    if(isAir[newY][newX]) count++;
                    if(count >= 2) {
                        meltCnt++;
                        graph[i][j] = 0;
                        break;
                    }
                }
            }
        }

        return meltCnt;
    }

    static class Node{
        int y;
        int x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}