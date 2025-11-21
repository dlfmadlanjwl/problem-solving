import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            sum += input;
            if (Math.abs(sum - 100) < Math.abs(answer - 100)) {
                answer = sum;
            } else if (Math.abs(sum - 100) == Math.abs(answer - 100) && sum > answer) {
                answer = sum;
            }
        }
        System.out.println(answer);
    }
}