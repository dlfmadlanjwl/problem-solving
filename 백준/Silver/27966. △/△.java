import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = N*(N-1)-(N-1);
        System.out.println(sum);
        for(int i=2;i<=N;i++){
            System.out.println(1+" "+i);
        }
    }
}