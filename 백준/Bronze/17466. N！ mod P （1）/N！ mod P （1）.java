import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());

        long mod = 1;
        for(long i=1;i<=n;i++){
            mod = (mod*(i%p))%p;
        }
        
        System.out.print(mod);
    }
}
