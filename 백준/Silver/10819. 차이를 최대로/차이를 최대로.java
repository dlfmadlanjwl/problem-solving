import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(dfs(numbers, new ArrayList<>(), new boolean[numbers.length]));
    }

    static int dfs(int[] numbers, List<Integer> list, boolean[] isVisited){
        if(list.size() == numbers.length){
            return calculate(list);
        }
        int max = 0;
        for(int i=0;i<numbers.length;i++){
            if(isVisited[i]) continue;
            list.add(numbers[i]);
            isVisited[i] = true;
            max = Math.max(max, dfs(numbers, list, isVisited));
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }

        return max;
    }

    static int calculate(List<Integer> list){
        int sum = 0;
        for(int i=1;i<list.size();i++){
            sum += Math.abs(list.get(i-1) - list.get(i));
        }

        return sum;
    }
}