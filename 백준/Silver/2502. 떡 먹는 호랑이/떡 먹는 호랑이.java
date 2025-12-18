import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int d = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        for (int first = 1; first <= 100000; first++) {
            for (int second = first; second <= 100000; second++) {
                if (getTotalRiceCake(first, second, d) == k) {
                    System.out.println(first);
                    System.out.println(second);
                    return;
                }
            }
        }
    }

    private static int getTotalRiceCake(int first, int second, int day) {
        int[] sum = new int[day];
        sum[0] = first;
        sum[1] = second;
        for (int i = 2; i < day; i++) {
            sum[i] = sum[i - 2] + sum[i - 1];
        }
        return sum[day - 1];
    }
}