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
        int k = Integer.parseInt(st.nextToken());

        int answer = bfs(n, k);
        System.out.println(answer);
    }

    static int bfs(int n, int k){
        boolean[] isVisited = new boolean[100001];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));

        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node now = q.poll();
            isVisited[now.position] = true;

            if(now.position == k){
                min = Math.min(min, now.depth);
            }

            int[] move = {now.position - 1, now.position + 1, now.position * 2};
            for(int i=0;i< move.length;i++){
                int newPos = move[i];
                if(newPos < 0 || newPos > 100000) continue;
                if(isVisited[newPos]) continue;

                if(i == 2) q.add(new Node(newPos, now.depth));
                else q.add(new Node(newPos, now.depth+1));
            }
        }

        return min;
    }

    static class Node{
        int position;
        int depth;

        Node(int position, int depth){
            this.position = position;
            this.depth = depth;
        }
    }
}