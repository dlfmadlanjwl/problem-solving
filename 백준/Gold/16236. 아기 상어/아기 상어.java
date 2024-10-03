import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int sharkY, sharkX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 9) {
                    sharkY = i;
                    sharkX = j;
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = input;
                }
            }
        }

        int count = 0;
        int sharkSize = 2;
        int answer = 0;
        while(true){
            int time = bfs(graph, sharkSize);
            if(time > 0){
                count++;
                answer += time;
            } else {
                break;
            }
            if(count == sharkSize) {
                count = 0;
                sharkSize++;
            }
        }

        System.out.print(answer);
    }

    static int bfs(int[][] graph, int sharkSize){
        Queue<Node> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[graph.length][graph[0].length];
        q.add(new Node(sharkY, sharkX, 0));
        isVisited[sharkY][sharkX] = true;

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        int depth = 0;
        boolean found = false;
        int fishY = graph.length, fishX = graph[0].length;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(found && depth < now.depth) break;
            if(graph[now.y][now.x] < sharkSize && graph[now.y][now.x] > 0) {
                found = true;
                if(fishY > now.y || (fishY == now.y && fishX > now.x)){
                    fishY = now.y;
                    fishX = now.x;
                }
            }
            depth = now.depth;
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];

                if(newY < 0 || newY >= graph.length || newX < 0 || newX >= graph[0].length) continue;
                if(isVisited[newY][newX]) continue;
                if(graph[newY][newX] > sharkSize) continue;

                q.add(new Node(newY, newX, now.depth+1));
                isVisited[newY][newX] = true;
            }
        }
        if(fishY != graph.length && fishX != graph[0].length){
            graph[fishY][fishX] = 0;
            sharkY = fishY;
            sharkX = fishX;
            return depth;
        }

        return 0;
    }

    static class Node{
        int y;
        int x;
        int depth;

        Node(int y, int x, int depth){
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}