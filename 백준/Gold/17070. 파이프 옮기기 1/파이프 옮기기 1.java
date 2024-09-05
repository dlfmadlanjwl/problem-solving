import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(arr[n-1][n-1] == 1) System.out.println(0);
        else System.out.print(bfs(arr));
    }

    static int bfs(int[][] arr){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,1,0));

        int count = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.y == arr.length-1 && now.x == arr[0].length-1) {
                count++;
                continue;
            }

            if(now.direction == 0){
                if(now.x+1 < arr[0].length){
                    if(arr[now.y][now.x+1] != 1) q.add(new Node(now.y, now.x+1, now.direction));
                }
                if(now.y+1 < arr.length && now.x+1 < arr[0].length){
                    if(arr[now.y+1][now.x+1] != 1 && arr[now.y][now.x+1] != 1 && arr[now.y+1][now.x] != 1){
                        q.add(new Node(now.y+1, now.x+1, 2));
                    }
                }
            } else if(now.direction == 1){
                if(now.y+1 < arr.length){
                    if(arr[now.y+1][now.x] != 1) q.add(new Node(now.y+1, now.x, now.direction));
                }
                if(now.y+1 < arr.length && now.x+1 < arr[0].length){
                    if(arr[now.y+1][now.x+1] != 1 && arr[now.y][now.x+1] != 1 && arr[now.y+1][now.x] != 1) {
                        q.add(new Node(now.y+1, now.x+1, 2));
                    }
                }
            } else {
                if(now.x+1 < arr[0].length) {
                    if(arr[now.y][now.x+1] != 1) q.add(new Node(now.y, now.x + 1, 0));
                }
                if(now.y+1 < arr.length) {
                    if(arr[now.y+1][now.x] != 1) q.add(new Node(now.y+1, now.x, 1));
                }
                if(now.y+1 < arr.length && now.x+1 < arr[0].length){
                    if(arr[now.y+1][now.x+1] != 1 && arr[now.y][now.x+1] != 1 && arr[now.y+1][now.x] != 1){
                        q.add(new Node(now.y+1, now.x+1, 2));
                    }
                }
            }
        }

        return count;
    }

    static class Node{
        int y;
        int x;
        int direction;
        Node(int y, int x, int direction){
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }
}