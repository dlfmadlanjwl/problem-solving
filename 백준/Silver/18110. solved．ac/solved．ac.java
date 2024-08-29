import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);

        int remove = (int)Math.round((double) n * 3 / 20);
        int sum = 0;
        for(int i=remove;i<n-remove;i++){
            sum += input[i];
        }

        System.out.print(Math.round((double) sum / (n - 2 * remove)));
    }
}
