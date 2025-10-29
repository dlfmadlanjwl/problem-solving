import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[] numbers = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, numbers[i]);
        }

        Arrays.sort(numbers);
        List<Integer> distances = new ArrayList<>();
        for (int i = 1; i < numbers.length; i++) {
            distances.add(numbers[i] - numbers[i - 1]);
        }
        distances.sort(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += distances.get(i);
        }
        System.out.println(numbers[n - 1] - numbers[0] - sum);
    }
}