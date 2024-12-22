import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = i+1;
        }

        Arrays.sort(numbers);

        dfs(numbers, new ArrayList<>(), n);
        System.out.print(sb);
    }

    static void dfs(int[] numbers, List<Integer> list, int n){
        if(list.size() == n) {
            for(int x : list) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<numbers.length;i++){
            if(list.contains(numbers[i])) continue;
            list.add(numbers[i]);
            dfs(numbers, list, n);
            list.remove(list.size()-1);
        }
    }
}