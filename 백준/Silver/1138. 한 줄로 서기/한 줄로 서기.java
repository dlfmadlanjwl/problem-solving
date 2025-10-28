import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] position = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            int countOnLeft = numbers[i];
            int count = 0;
            for (int j = 0; j < position.length; j++) {
                if (position[j] == 0) {
                    if (count == countOnLeft) {
                        position[j] = i + 1;
                        break;
                    }
                    count++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j : position) {
            stringBuilder.append(j).append(" ");
        }
        System.out.print(stringBuilder);
    }
}