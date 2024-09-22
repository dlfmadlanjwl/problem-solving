import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] knowTruth = new boolean[n+1];
        boolean[][] meet = new boolean[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        int knowTruthNum = Integer.parseInt(st.nextToken());
        for(int i=0;i<knowTruthNum;i++){
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        List<Integer>[] parties = new List[m];
        for(int i=0;i<m;i++){
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int memberNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < memberNum; j++) {
                int member = Integer.parseInt(st.nextToken());
                for (int k = 0; k < parties[i].size(); k++) {
                    meet[member][parties[i].get(k)] = true;
                    meet[parties[i].get(k)][member] = true;
                }
                parties[i].add(member);
            }
        }

        bfs(meet, knowTruth);

        int answer = 0;
        for(int i=0;i<m;i++){
            boolean canLie = true;
            for(int member : parties[i]){
                if(knowTruth[member]){
                    canLie = false;
                }
            }
            if(canLie) answer++;
        }

        System.out.print(answer);
    }

    static void bfs(boolean[][] meet, boolean[] knowTruth){
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[knowTruth.length];
        for(int i=0;i<knowTruth.length;i++){
            if(knowTruth[i]) q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            isVisited[now] = true;
            for(int i=0;i<meet[now].length;i++){
                if(!meet[now][i] || isVisited[i]) continue;
                q.add(i);
                knowTruth[i] = true;
            }
        }
    }
}