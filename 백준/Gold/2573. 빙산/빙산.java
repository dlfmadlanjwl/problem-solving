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
        int[][] heights = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                heights[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true){
            int blockCnt = countBlock(heights);
            if(blockCnt >= 2){
                System.out.print(answer);
                break;
            }
            boolean isAllZero = melt(heights);
            if(isAllZero){
                System.out.println(0);
                break;
            }
            answer++;
        }
    }

    static boolean melt(int[][] heights){
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        int[][] meltCnt = new int[heights.length][heights[0].length];
        boolean isAllZero = true;
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(heights[i][j] != 0) isAllZero = false;
                int count = 0;
                for(int k=0;k<4;k++){
                    int newY = i + dy[k];
                    int newX = j + dx[k];
                    if(newY < 0 || newX < 0 || newY >= heights.length || newX >= heights[0].length) continue;
                    if(heights[newY][newX] == 0) count++;
                }
                meltCnt[i][j] = count;
            }
        }
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                heights[i][j] -= meltCnt[i][j];
                if(heights[i][j] < 0) heights[i][j] = 0;
            }
        }
        return isAllZero;
    }

    static int countBlock(int[][] heights){
        boolean[][] isVisited = new boolean[heights.length][heights[0].length];
        int count = 0;
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(isVisited[i][j] || heights[i][j] == 0) continue;
                bfs(heights, isVisited, i, j);
                count++;
            }
        }

        return count;
    }

    static void bfs(int[][] heights, boolean[][] isVisited, int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        isVisited[y][x] = true;
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY < 0 || newY >= heights.length || newX < 0 || newX >= heights[0].length) continue;
                if(isVisited[newY][newX] || heights[newY][newX] == 0) continue;
                q.add(new Node(newY, newX));
                isVisited[newY][newX] = true;
            }
        }
    }

    static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}