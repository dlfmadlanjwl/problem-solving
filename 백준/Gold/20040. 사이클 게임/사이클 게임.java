import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        int answer = 0;
        for(int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a, parents) != find(b, parents)){
                union(a, b, parents);
            } else if(answer == 0) {
                answer = i;
            }
        }

        System.out.print(answer);
    }

    static void union(int a, int b, int[] parents){
        a = find(a, parents);
        b = find(b, parents);

        if(a < b){
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    static int find(int a, int[] parents){
        if(parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a], parents);
    }
}