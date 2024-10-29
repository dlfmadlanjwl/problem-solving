import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;
    static boolean[] visited;
    static int[] move;
    static int result;

    private static class Node {
        int val;
        int time;

        public Node(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        f = Integer.parseInt(arr[0]);
        s = Integer.parseInt(arr[1]);
        g = Integer.parseInt(arr[2]);
        u = Integer.parseInt(arr[3]);
        d = Integer.parseInt(arr[4]);

        move = new int[2];
        move[0] = u;
        move[1] = -d;

        if (bfs()){
            System.out.println(result);
        }
        else{
            System.out.println("use the stairs");
        }
    }

    private static boolean bfs(){
        visited = new boolean[f+1];
        visited[s] = true;

        Queue<Node> q = new LinkedList<>();

        Node n = new Node(s, 0);
        q.offer(n);
        while(!q.isEmpty()){
            Node now = q.poll();
            if (now.val == g) {
                result = now.time;
                return true;
            }

            for (int m : move) {
                int next = now.val + m;

                if ((next>=1) && (next<=f) && (!visited[next])){
                    visited[next] = true;
                    q.offer(new Node(next, now.time+1));
                }
            }
        }
        return false;
    }
}