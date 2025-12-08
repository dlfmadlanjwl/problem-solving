import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int[] visitCounts = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            visitCounts[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int sum = 0;
        int count = 1;
        for (int i = 0; i < x; i++) {
            sum += visitCounts[i];
        }
        int max = sum;
        for (int i = x; i < n; i++) {
            sum += visitCounts[i];
            sum -= visitCounts[i - x];
            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.print("SAD");
        } else {
            System.out.print(max + "\n" + count);
        }
    }
}