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

        int[] board = new int[101];
        for(int i=0;i<n+m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        int answer = bfs(board);
        System.out.print(answer);
    }

    static int bfs(int[] board){
        boolean[] isVisited = new boolean[101];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.index == 100) return now.depth;
            for(int i=1;i<=6;i++){
                int next = now.index + i;
                if(next > 100) continue;

                while(board[next] != 0){
                    next = board[next];
                }

                if(!isVisited[next]){
                    isVisited[next] = true;
                    q.add(new Node(next, now.depth+1));
                }
            }
        }

        return 0;
    }
    static class Node{
        int index;
        int depth;

        Node(int index, int depth){
            this.index = index;
            this.depth = depth;
        }
    }
}
