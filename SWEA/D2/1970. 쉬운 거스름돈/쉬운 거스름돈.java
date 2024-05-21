import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println("#"+(t+1));
            for(int i=0;i<arr.length;i++){
                System.out.print((N / arr[i])+" ");
                N = N % arr[i];
            }
            System.out.println();
        }
    }
}