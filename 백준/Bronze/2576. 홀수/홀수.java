import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<7;i++){
            int x = Integer.parseInt(br.readLine().strip());
            if(x % 2 != 0){
                sum += x;
                if(x < min) min = x;
            }
        }
        if(sum == 0) System.out.println(-1);
        else System.out.println(sum + "\n" + min);
    }
}