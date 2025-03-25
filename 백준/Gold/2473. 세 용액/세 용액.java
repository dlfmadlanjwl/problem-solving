import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static long[] answer = new long[3];
    static long result = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            binarySearch(arr, i);
        }

        Arrays.sort(answer);
        for (long l : answer) {
            System.out.print(l + " ");
        }
    }

    static void binarySearch(long[] arr, int index) {
        int left = index + 1;
        int right = arr.length - 1;

        while (left < right) {
            long sum = arr[left] + arr[right] + arr[index];
            if (Math.abs(sum) < result) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                answer[2] = arr[index];
                result = Math.abs(sum);
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}