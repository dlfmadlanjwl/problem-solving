import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        Long res = (n-1)*(1+(n-1))/2;
        System.out.println(res);
        System.out.print(2);
    }
}