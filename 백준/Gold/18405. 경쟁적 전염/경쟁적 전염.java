import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        List<Node> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0) list.add(new Node(j,i,arr[i][j],0));
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        list.sort((a,b)->a.number - b.number);
        Queue<Node> q = new LinkedList<>(list);

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.depth == S) break;
            for(int i=0;i<4;i++){
                int newY = node.y + dy[i];
                int newX = node.x + dx[i];
                if(newY<N && newY>=0 && newX<N && newX>=0){
                    if(arr[newY][newX] == 0){
                        q.add(new Node(newX, newY, node.number, node.depth+1));
                        arr[newY][newX] = node.number;
                    }
                }
            }
        }
        System.out.println(arr[X-1][Y-1]);
    }

    private static class Node{
        int x;
        int y;
        int number;
        int depth;
        Node(int x, int y, int number,int depth){
            this.x = x;
            this.y = y;
            this.number = number;
            this.depth = depth;
        }
    }
}