import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        loop:
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] graph = new int[N+1];
            for(int i=0;i<N-1;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[b] = a;
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = a;
            boolean[] visited = new boolean[N+1];
            while(n!=0){
                visited[n] = true;
                n = graph[n];
            }
            n = b;
            while(n!=0){
                if(visited[n]){
                    sb.append(n+"\n");
                    continue loop;
                }
                n = graph[n];
            }
        }
        System.out.print(sb);
    }
}