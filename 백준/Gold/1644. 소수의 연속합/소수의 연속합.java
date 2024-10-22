import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i=1;i<=4000000;i++){
            if (isPrime(i)) primeNumbers.add(i);
        }

        int n = Integer.parseInt(br.readLine());
        int left = -1, right = -1;
        int sum = 0;
        int count = 0;
        while(left <= right){
            if(sum <= n){
                right++;
                if(right >= primeNumbers.size()) break;
                sum += primeNumbers.get(right);
            } else {
                left++;
                sum -= primeNumbers.get(left);
            }

            if(sum == n) count++;
        }

        System.out.print(count);
    }

    private static boolean isPrime(int n){
        if(n == 1) return false;
        for(int i=2;i*i<=n;i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}