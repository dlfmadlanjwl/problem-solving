import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] conditions = new int[n];
        List<Integer>[] nexts = new List[n];
        for(int i=0;i<n;i++){
            nexts[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            conditions[b]++;
            nexts[a].add(b);
        }


        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(conditions[i] == 0) {
                q.add(i);
                isVisited[i] = true;
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.poll();
            answer.add(now);
            for(int i : nexts[now]){
                if(isVisited[i]) continue;
                conditions[i]--;
                if(conditions[i] == 0){
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }

        for(int i : answer){
            System.out.print((i+1) + " ");
        }
    }
}