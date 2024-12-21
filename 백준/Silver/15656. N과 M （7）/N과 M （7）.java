import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(numbers, new ArrayList<>(), m);
        System.out.print(sb);
    }

    static void dfs(int[] numbers, List<Integer> list, int m){
        if(list.size() == m) {
            for(int x : list) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
            dfs(numbers, list, m);
            list.remove(list.size()-1);
        }
    }
}