import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        boolean[] isQueue = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            if(st.nextToken().equals("0")) isQueue[i] = true;
        }
        st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=n-1;i>=0;i--){
            if(isQueue[i]) q.add(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            q.add(Integer.parseInt(st.nextToken()));
            sb.append(q.poll()+" ");
        }
        System.out.print(sb);
    }
}

