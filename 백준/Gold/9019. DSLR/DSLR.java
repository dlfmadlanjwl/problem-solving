import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static String bfs(int a, int b){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, ""));
        boolean[] isVisited = new boolean[10000];
        isVisited[a] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.value == b) return now.command;

            int d = d(now.value);
            int s = s(now.value);
            int l = l(now.value);
            int r = r(now.value);
            if(!isVisited[d]){
                q.add(new Node(d, now.command + 'D'));
                isVisited[d] = true;
            }
            if(!isVisited[s]){
                q.add(new Node(s, now.command + 'S'));
                isVisited[s] = true;
            }
            if(!isVisited[l]){
                q.add(new Node(l, now.command + 'L'));
                isVisited[l] = true;
            }
            if(!isVisited[r]){
                q.add(new Node(r, now.command + 'R'));
                isVisited[r] = true;
            }
        }

        return "";
    }

    static int d(int x){
        return x * 2 % 10000;
    }

    static int s(int x){
        if(x == 0){
            return 9999;
        }
        return x - 1;
    }

    static int l(int x){
        String s = convertToString(x);
        return Integer.parseInt(s.substring(1, 4) + s.charAt(0));
    }

    static int r(int x){
        String s = convertToString(x);
        return Integer.parseInt(s.charAt(3) + s.substring(0, 3));
    }

    static String convertToString(int x){
        String s = String.valueOf(x);
        int len = s.length();
        for(int i=0;i<4-len;i++){
            s = "0" + s;
        }
        return s;
    }

    static class Node{
        int value;
        String command;

        Node(int value, String command){
            this.value = value;
            this.command = command;
        }
    }
}