import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int answer = bfs(map);

        System.out.println(answer);
    }

    static int bfs(int[][] map){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,1));
        boolean[][][] isVisited = new boolean[map.length][map[0].length][2];
        isVisited[0][0][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.y == map.length-1 && now.x == map[0].length-1) return now.depth;

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for(int i=0;i<dx.length;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];

                if(newY < 0 || newY >= map.length || newX < 0 || newX >= map[0].length) continue;

                if(map[newY][newX] == 1){
                    if(isVisited[now.y][now.x][0] && !isVisited[newY][newX][1]) {
                        q.add(new Node(newY, newX, now.depth + 1));
                        isVisited[newY][newX][1] = true;
                    }
                } else {
                    if (isVisited[now.y][now.x][1] && !isVisited[newY][newX][1]) {
                        q.add(new Node(newY, newX, now.depth + 1));
                        isVisited[newY][newX][1] = true;
                    } else if (isVisited[now.y][now.x][0] && !isVisited[newY][newX][0]) {
                        q.add(new Node(newY, newX, now.depth + 1));
                        isVisited[newY][newX][0] = true;
                    }
                }
            }
        }

        return -1;
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
