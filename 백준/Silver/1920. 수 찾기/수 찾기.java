import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(bufferedReader.readLine());
        st = new StringTokenizer(bufferedReader.readLine());
        Arrays.sort(numbers);
        for (int i = 0; i < m; i++) {
            int targetNumber = Integer.parseInt(st.nextToken());
            boolean isExist = isExist(numbers, targetNumber);
            stringBuilder.append(isExist ? 1 : 0).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static boolean isExist(int[] numbers, int targetNumber) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < targetNumber) {
                left = mid + 1;
            } else if (numbers[mid] > targetNumber) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}