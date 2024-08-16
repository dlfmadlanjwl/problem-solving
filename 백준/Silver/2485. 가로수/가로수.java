import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        int gcd = input[1] - input[0];
        for(int i=2;i<n;i++){
            int b = input[i] - input[0];
            gcd = gcd(gcd, b);
        }

        System.out.println((input[n-1] - input[0]) / gcd + 1 - n);
    }

    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}

