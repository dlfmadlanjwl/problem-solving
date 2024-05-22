import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] op = new int[4];
        for(int i=0;i<4;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(numbers,op,0,numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int[] numbers, int[] op, int index, int result){
        if(index == numbers.length-1){
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        }


        for(int i=0;i<op.length;i++){
            if(op[i] > 0) {
                op[i]--;
                switch (i){
                    case 0:
                        dfs(numbers, op, index+1, result + numbers[index+1]);
                        break;
                    case 1:
                        dfs(numbers, op, index+1, result - numbers[index+1]);
                        break;
                    case 2:
                        dfs(numbers, op, index+1, result * numbers[index+1]);
                        break;
                    case 3:
                        dfs(numbers, op, index+1, result / numbers[index+1]);
                        break;
                }
                op[i]++;
            }
        }
    }
}