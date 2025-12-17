import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            count -= Integer.parseInt(stringTokenizer.nextToken());
            count += Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}