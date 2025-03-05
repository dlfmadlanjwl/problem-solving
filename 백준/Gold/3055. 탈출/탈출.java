import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = input.charAt(j);
            }
        }

        int result = bfs(map);
        if(result == -1){
            System.out.println("KAKTUS");
            return;
        }
        System.out.print(result);
    }
    
    private static int bfs(char[][] map){
        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] == '*'){
                    q.add(new Node(i, j, 0));
                }
            }
        }
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] == 'S'){
                    q.add(new Node(i, j, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY < 0 || newY >= map.length || newX < 0 || newX >= map[0].length) continue;
                if(map[newY][newX] == '*' || map[newY][newX] == 'S'){
                    continue;
                }
                if(map[now.y][now.x] == 'S') {
                    if(map[newY][newX] == '.') {
                        map[newY][newX] = 'S';
                        q.add(new Node(newY, newX, now.depth + 1));
                    }
                    if(map[newY][newX] == 'D') {
                        return now.depth + 1;
                    }
                }
                if(map[now.y][now.x] == '*') {
                    if(map[newY][newX] == '.' || map[newY][newX] == 'S') {
                        map[newY][newX] = '*';
                        q.add(new Node(newY, newX, now.depth + 1));
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

        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}