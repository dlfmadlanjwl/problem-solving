import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
            if(input[i] > max) max = input[i];
        }

        boolean[] numbers = new boolean[max+1];
        numbers[0] = true;
        numbers[1] = true;

        for(int i=2;i*i<=max;i++){
            if(numbers[i]) continue;
            for(int j=i*2;j<=max;j+=i){
                numbers[j] = true;
            }
        }

        for(int i=0;i<input.length;i++){
            int x = input[i];
            int count = 0;
            for(int j=0;j<=x/2;j++){
                if(!numbers[x - j] && !numbers[j]) count++;
            }
            System.out.println(count);
        }
    }
}

