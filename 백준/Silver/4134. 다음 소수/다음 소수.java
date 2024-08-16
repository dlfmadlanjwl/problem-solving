import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            long x = Long.parseLong(br.readLine());
            while(true){
                if(isPrime(x)){
                    System.out.println(x);
                    break;
                }
                x++;
            }
        }
    }

    static boolean isPrime(long x){
        if(x == 1 || x == 0) return false;
        for(long i=2;i<=Math.sqrt(x);i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}

