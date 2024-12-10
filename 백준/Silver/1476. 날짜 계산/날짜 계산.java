import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int year = 1;
        int a = 1, b = 1, c = 1;
        while(true){
            if(a > 15) a = 1;
            if(b > 28) b = 1;
            if(c > 19) c = 1;

            if(e == a && s == b && m == c){
                break;
            }
            a++;
            b++;
            c++;
            year++;
        }

        System.out.print(year);
    }
}