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

        int[] answer = bfs(n, k);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static int[] bfs(int n, int k){
        int[] depths = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        int minDepth = Integer.MAX_VALUE;
        int count = 0;
        while(!q.isEmpty()){
            int now = q.poll();

            if(depths[now] > minDepth) {
                return new int[]{minDepth, count};
            }

            if(now == k){
                if(depths[now] < minDepth) {
                    minDepth = depths[now];
                }
                count++;
            }

            int newPos = now - 1;
            if(newPos >= 0 && (depths[newPos] == 0 ||depths[newPos] >= depths[now] + 1)) {
                q.add(newPos);
                depths[newPos] = depths[now] + 1;
            }

            newPos = now + 1;
            if(newPos <= 100000 && (depths[newPos] == 0 ||depths[newPos] >= depths[now] + 1)) {
                q.add(newPos);
                depths[newPos] = depths[now] + 1;
            }

            newPos = now * 2;
            if(newPos <= 100000 && (depths[newPos] == 0 ||depths[newPos] >= depths[now] + 1)) {
                q.add(newPos);
                depths[newPos] = depths[now] + 1;
            }
        }

        return new int[]{minDepth, count};
    }
}