import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = Long.toBinaryString(Long.parseLong(br.readLine()));

        long sum = 0;
        int position = 0;
        for(int i=N.length()-1;i>=0;i--){
            if(N.charAt(i)=='1'){
                sum += pow(position);
            }
            position++;
        }
        System.out.println(sum);
    }

    static long pow(int n){
        long res = 1;
        for(int i=0;i<n;i++){
            res *= 3;
        }
        return res;
    }
}
