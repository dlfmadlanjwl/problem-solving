import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        boolean[][] isVisited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = dfs(arr, isVisited, 0);
        System.out.print(res);
    }

    private static int dfs(int[][] arr, boolean[][] isVisited, int depth){
        int max = -1;
        if(depth == 3){
            return bfs(arr);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!isVisited[i][j] && arr[i][j] == 0){
                    isVisited[i][j] = true;
                    arr[i][j] = 1;
                    int count = dfs(arr, isVisited, depth+1);
                    if(count > max) max = count;
                    arr[i][j] = 0;
                    isVisited[i][j] = false;
                }
            }
        }
        return max;
    }

    private static int bfs(int[][] arr){
        boolean[][] isVisited = new boolean[arr.length][arr[0].length];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == 2){
                    q.add(new Node(i,j));
                    isVisited[i][j] = true;
                }
            }
        }
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int count = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY >= 0 && newY < arr.length && newX >= 0 && newX < arr[0].length){
                    if(arr[newY][newX] == 0 && !isVisited[newY][newX]){
                        q.add(new Node(newY, newX));
                        isVisited[newY][newX] = true;
                    }
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!isVisited[i][j] && arr[i][j] == 0) count++;
            }
        }
        return count;
    }

    private static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
