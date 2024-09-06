import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int answer = -1;
            int lcm = lcm(m,n);
            for(int i=x;i<=lcm;i+=m){
                int l = i % n;
                if(l == 0) l = n;
                if(l == y){
                    answer = i;
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
}
