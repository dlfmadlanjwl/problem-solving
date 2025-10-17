import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        int[] lectureMinutes = new int[n];
        for (int i = 0; i < n; i++) {
            lectureMinutes[i] = Integer.parseInt(st.nextToken());
        }
        int answer = binarySearch(lectureMinutes, m);
        System.out.println(answer);
    }

    private static int binarySearch(int[] lectureMinutes, int blueRayCount) {
        int left = Arrays.stream(lectureMinutes).max().getAsInt();
        int right = Arrays.stream(lectureMinutes).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            if (canRecord(lectureMinutes, mid, blueRayCount)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static boolean canRecord(int[] lectureMinutes, int blueRaySize, int blueRayCount) {
        int minuteSum = 0;
        int usedBlueRayCount = 1;
        for (int lectureMinute : lectureMinutes) {
            minuteSum += lectureMinute;
            if (minuteSum > blueRaySize) {
                minuteSum = lectureMinute;
                usedBlueRayCount++;
            }
        }
        return usedBlueRayCount <= blueRayCount;
    }
}