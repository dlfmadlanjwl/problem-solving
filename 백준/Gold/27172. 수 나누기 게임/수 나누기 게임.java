import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        boolean[] exist = new boolean[1000001];
        int max = 0;
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            exist[numbers[i]] = true;
            max = Math.max(max, numbers[i]);
        }

        int[] scores = new int[1000001];

        for(int i=0;i<n;i++){
            int number = numbers[i];
            for(int j=number*2;j<=max;j+=number){
                if(exist[j]){
                    scores[j]--;
                    scores[number]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(scores[numbers[i]] + " ");
        }
    }
}