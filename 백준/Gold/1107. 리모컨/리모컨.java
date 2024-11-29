import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if(m > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = Math.abs(n - 100);
        for(int i=0;i<=999999;i++){
            String rawNum = String.valueOf(i);
            boolean check = false;
            for(int j=0;j<rawNum.length();j++){
                if (broken[rawNum.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }
            if(check) continue;

            int count = rawNum.length() + Math.abs(n - i);
            min = Math.min(min, count);
        }

        System.out.print(min);
    }
}