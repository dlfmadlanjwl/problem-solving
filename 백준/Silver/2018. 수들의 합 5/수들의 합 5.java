import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int answer = 0;
        int sum = 0;
        int left = 1;
        int right = 0;
        while (right <= n) {
            if (sum < n) {
                sum += ++right;
            } else if (sum == n) {
                answer++;
                sum += ++right;
            } else {
                sum -= left++;
            }
        }
        System.out.println(answer);
    }
}