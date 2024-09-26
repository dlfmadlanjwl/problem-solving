import org.w3c.dom.Node;

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
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] air = new int[r][c];

        int a = -1, b = -1;
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                air[i][j] = Integer.parseInt(st.nextToken());
                if(air[i][j] == -1){
                    if(a == -1) a = i;
                    else b = i;
                }
            }
        }

        for(int i=0;i<t;i++){
            int[][] newAir = bfs(air, a, b);
            rotate(newAir, a, b);
            air = newAir;
        }

        int sum = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                if(air[i][j] == -1) continue;
                sum += air[i][j];
            }
        }

        System.out.print(sum);
    }

    static int[][] bfs(int[][] air,int a,int b){
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<air.length;i++){
            for(int j=0;j<air[0].length;j++) {
                if(air[i][j] > 0) q.add(new Node(i, j));
            }
        }

        int[][] newAir = new int[air.length][air[0].length];
        newAir[a][0] = -1;
        newAir[b][0] = -1;

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        while(!q.isEmpty()){
            Node now = q.poll();

            int count = 0;
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];

                if(newY < 0 || newY >= air.length || newX < 0 || newX  >= air[0].length) continue;
                if(air[newY][newX] == -1) continue;

                count++;
                newAir[newY][newX] += air[now.y][now.x]/5;
            }

            newAir[now.y][now.x] += air[now.y][now.x] - air[now.y][now.x]/5 * count;
        }

        return newAir;
    }

    static void rotate(int[][] air, int a, int b){
        for(int i=a-1;i>0;i--){
            air[i][0] = air[i-1][0];
        }
        for(int i=0;i<air[0].length-1;i++){
            air[0][i] = air[0][i+1];
        }
        for(int i=0;i<a;i++){
            air[i][air[0].length-1] = air[i+1][air[0].length-1];
        }
        for(int i=air[0].length-1;i>1;i--){
            air[a][i] = air[a][i-1];
        }
        air[a][1] = 0;

        for(int i=b+1;i<air.length-1;i++){
            air[i][0] = air[i+1][0];
        }
        for(int i=0;i<air[0].length-1;i++){
            air[air.length-1][i] = air[air.length-1][i+1];
        }
        for(int i=air.length-1;i>b;i--){
            air[i][air[0].length-1] = air[i-1][air[0].length-1];
        }
        for(int i=air[0].length-1;i>0;i--){
            air[b][i] = air[b][i-1];
        }
        air[b][1] = 0;
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