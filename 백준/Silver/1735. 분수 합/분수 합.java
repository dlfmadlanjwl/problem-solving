import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        long lcm = lcm(a2, b2);

        long son = a1 * lcm / a2 + b1 * lcm / b2;

        long gcd = gcd(lcm, son);
        lcm /= gcd;
        son /= gcd;

        System.out.println(son+" "+lcm);
    }
    static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    static long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
}

